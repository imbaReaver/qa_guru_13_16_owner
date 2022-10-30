package qa.guru.config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources("classpath:${host}.properties")

public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://www.dns-shop.ru/")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("remoteUrl")
    URL getRemoteUrl();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("remoteWebDriver")
    String getRemoteWebDriver();

}
