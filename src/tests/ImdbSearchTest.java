import com.codeborne.selenide.Selenide;
import config.TestConfig;
import pages.ImdbHomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class ImdbSearchTest extends TestConfig {

    @Test(description = "Search for QA on IMDb")
    @Severity(SeverityLevel.NORMAL)
    @Description("Search for 'QA' on imdb.com and extract top 5 people from search results")
    public void testImdbSearch() {
        ImdbHomePage homePage = new ImdbHomePage();
        
        homePage.open()
            .acceptCookiesIfPresent()
            .searchFor("QA")
            .getTopPeopleResults(5);

        // Take screenshot of the results
        Selenide.screenshot("searchResults" + System.currentTimeMillis());
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
