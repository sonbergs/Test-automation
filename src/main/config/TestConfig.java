
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;

public class TestConfig {
    @BeforeSuite
    public void setUp() {
        configureAllure();
        configureSelenide();
    }

    private void configureAllure() {
        SelenideLogger.addListener("AllureSelenide", 
            new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    private void configureSelenide() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 20000;
        Configuration.pageLoadTimeout = 30000;
        Configuration.browserSize = "1920x1080";
        
        String defaultPath = System.getProperty("user.dir") + "/resources/chromedriver-mac-arm64/chromedriver";
        String driverPath = System.getProperty("chromedriver.path", defaultPath);
        System.setProperty("webdriver.chrome.driver", driverPath);
    }
}
