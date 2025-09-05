
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;
import pages.BasePage;
import pages.SearchResultsPage;

public class ImdbHomePage extends BasePage {
    private final SelenideElement searchContainer = $(".searchform__inputContainer");
    private final SelenideElement searchInput = $("#suggestion-search");
    private final SelenideElement acceptCookiesButton = $$("button").findBy(text("Accept all"));

    @Step("Open IMDb home page")
    public ImdbHomePage open() {
        Selenide.open("https://www.imdb.com/");
        logStep("Opened IMDb homepage");
        return this;
    }

    @Step("Accept cookies if present")
    public ImdbHomePage acceptCookiesIfPresent() {
        if (acceptCookiesButton.exists()) {
            acceptCookiesButton.click();
            logStep("Clicked 'Accept all' button");
        }
        return this;
    }

    @Step("Search for: {query}")
    public SearchResultsPage searchFor(String query) {
        searchContainer.shouldBe(Condition.visible);
        logStep("Search container is visible");

        searchInput.shouldBe(Condition.visible);
        searchInput.setValue(query);
        logStep("Entered '" + query + "' and pressed Enter");
        
        return new SearchResultsPage();
    }
}
