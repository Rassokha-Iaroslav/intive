$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/ui/webUiTesting.feature");
formatter.feature({
  "name": "Verification of search functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verification of search and filtering",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user opens main page and search \"\u003ccommunities and events\u003e\"",
  "keyword": "When "
});
formatter.match({
  "location": "WebUiSteps.userOpensMainPageAndSearch(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user can click on \"\u003cAdvanced\u003e\" and filter search results",
  "keyword": "Then "
});
formatter.match({
  "location": "WebUiSteps.userCanClickOnAndFilterSearchResults(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user see filtered search results",
  "keyword": "Then "
});
formatter.match({
  "location": "WebUiSteps.userSeeFilteredSearchResults()"
});
formatter.result({
  "status": "passed"
});
});