package qa.guru.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;
import java.util.function.Supplier;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;


public class WebDriverProvider implements Supplier<WebDriver> {

    private final WebDriverConfig config;

    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    }

    @Override
    public WebDriver get() {
        WebDriver driver = createDriver();
        driver.get(config.getBaseUrl());
        return driver;
    }
    private WebDriver createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (Objects.isNull(config.getRemoteUrl())) {
            switch (config.getBrowser()) {
                case CHROME: {
                    WebDriverManager.chromedriver().setup();
                    capabilities.setVersion(config.getBrowserVersion());
                    return new ChromeDriver();
                }
                case FIREFOX: {
                    WebDriverManager.firefoxdriver().setup();
                    capabilities.setVersion(config.getBrowserVersion());
                    return new FirefoxDriver();
                }
                default: {
                    throw new RuntimeException("No such driver");
                }
            }
        } else {
            switch (config.getBrowser()) {
                case CHROME: {
                    capabilities.setVersion(config.getBrowserVersion());
                    return new RemoteWebDriver(config.getRemoteUrl(), new ChromeOptions());
                }
                case FIREFOX: {
                    capabilities.setVersion(config.getBrowserVersion());
                    return new RemoteWebDriver(config.getRemoteUrl(), new FirefoxOptions());
                }
                default: {
                    throw new RuntimeException("No such driver");
                }
            }
        }
    }
}