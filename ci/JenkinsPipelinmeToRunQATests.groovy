//Following parameter should be configured on Jenkins in order to use pipelive (cleanWorkspace, branch, tags, tagsToExclude, testEnv, features, browser, testsThreadNumber)
//variable used to check whether to clan jenkins Workspace
Boolean cleanWorkspace = params['cleanWorkspace']
//variable used to get source code from branch
String gitBranch = params['branch']
//variable used to get specific tags to run tests
String tags = params['tags']
//variable used to exclude specific tags to run tests
String tagsExclude = params['tagsToExclude']
//variable used to specify test environment (dev/qa)
String testEnvironment = params['testEnv']
//variable used to get specific features to run tests
String features = params['features']
//variable used to specify browser to run tests
String browser = params['browser']
//variable used to specify number of concurrent tests threads
String testsThreadNumber = params['testsThreadNumber']

pipeline {
    stages {
        //stage where we are retrieving code from GIT (if specified branch does not exist then checkout from master)
        stage('Checkout QA-Tests') {
            steps {
                script {
                    if (cleanWorkspace) {
                        cleanWs()
                    }
                }
                checkout resolveScm(source: [$class: 'GitSCMSource',
                                             remote: 'https://github.com/Rassokha-Iaroslav/intive.git',
                                             traits: [[$class: 'jenkins.plugins.git.traits.BranchDiscoveryTrait']]],
                        targets: [gitBranch, 'master'])

                sh 'git rev-parse --abbrev-ref HEAD'
                sh 'git log -n 10 --graph --pretty=oneline --abbrev-commit --all --decorate=full'
            }
        }
        //Stage where we are runnning tests depending on input values (testEnvironment, features, tags, tagsExclude)
        stage('Executing QA-Tests') {
            steps {
                sh """echo "following parameters were passed by user" """
                sh """echo "Test environment:'$testEnvironment'" """
                sh """echo "Feature file(s):'$features" """
                sh """echo "Tags(s):(include: '$tags' and exclude: '$tagsExclude')" """
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    script {
                        sh """echo "Open qa-test project folder" """
                        sh "pwd"
                        //expected featuresToInsert: 'classpath:features/api/' 'classpath:features/ui/'
                        String featuresToInsert = "'" + features.toString().replace(",-none-", "").replace(",", "' '") + "'"

                        //expected tagsToInsert: --tags '@apiTest or @webTest'
                        String tagsToInsert = String.format(" --tags '%s'", tags.toString().replace(",-none-", "").replace(",", " or "))
                        String tagsToExclude = String.format(" --tags 'not %s'", tagsExclude.toString().replace(",-none-", "").replace(",", " and not "))
                        String allTags = tagsToInsert.replace(" --tags 'null'", "").replace(" --tags ''", "") +
                                tagsToExclude.replace(" --tags 'not null'", "").replace(" --tags 'not '", "")

                        String cmdToRunTestsFormat = """mvn clean install -Dcucumber.options="%s" -Dbrowser=$browser -Denv=$testEnvironment -DtestsThreadNumber=$testsThreadNumber"""

                        if (((tagsExclude?.trim() && tagsExclude != "-none-") || (tags?.trim() && tags != "-none-")) && features?.trim() && features != "-none-") {
                            sh """echo "Feature(s) and Tag(s) were specified" """
                            sh String.format(cmdToRunTestsFormat.toString(), featuresToInsert.toString() + allTags.toString())
                        } else if ((tagsExclude?.trim() && tagsExclude != "-none-") || (tags?.trim() && tags != "-none-")) {
                            sh """echo "Ony Tag(s) were specified" """
                            sh String.format(cmdToRunTestsFormat.toString(), allTags.toString())
                        } else if (features?.trim() && features != "-none-") {
                            sh """echo "Ony Feature(s) were specified" """
                            sh String.format(cmdToRunTestsFormat.toString(), featuresToInsert.toString())
                        } else {
                            sh """echo "Nothing to run. Tags and Features were not specified" """
                        }
                    }
                }
            }
        }
        //stage to automatically rerun failed tests form previous step
        stage('Rerunning failed QA-Tests') {
            steps {
                sh """mvn install -Dcucumber.options="'@target/rerun.txt' --plugin 'html:target/cucumber_rerun' --plugin 'json:target/cucumber_rerun.json' --plugin 'rerun:target/rerun.txt'" -Dbrowser=$browser -Denv=$testEnvironment  -DtestsThreadNumber=$testsThreadNumber"""
            }
            //publish test results with report
            post {
                always {
                    cucumber fileIncludePattern: 'cucumber*.json',
                            jsonReportDirectory: 'target',
                            trendsLimit: 10,
                            sortingMethod: 'ALPHABETICAL',
                            classifications: [
                                    [
                                            'key'  : 'Browser',
                                            'value': browser
                                    ],
                                    [
                                            'key'  : 'Environment under test',
                                            'value': testEnvironment
                                    ],
                                    [
                                            'key'  : 'Branch of tests',
                                            'value': gitBranch
                                    ]
                            ]
                    archiveArtifacts([artifacts: 'target/cucumber*.json', fingerprint: true])
                }
            }
        }
    }
}