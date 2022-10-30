package qa.guru;


import qa.guru.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest {

    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = new WebDriverProvider().get();
    }

    @Test
    public void testDns() {
        String title = driver.getTitle();
        assertEquals("DNS – интернет магазин цифровой и бытовой техники по доступным ценам.", title);
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }

}
