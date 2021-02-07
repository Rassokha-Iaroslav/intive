package commons;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:${env}.properties"
})


public interface iTestsConfig extends Config {

    @Key("mainPage")
    String host();

    @Key("testRunType")
    @DefaultValue("regular")
    String getTestRunType();

    @Key("browser")
    @DefaultValue("Firefox")
    String getBrowser();

    @Key("pokemonsListPage")
    String getPokemonsListPageUrl();

    @Key("apiBaseHost")
    String getApiHost();

}
