
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    @Step("Get page title")
    public String getPageTitle() {
        return $("title").getAttribute("text");
    }

    protected void logStep(String message) {
        System.out.println(message);
    }
}
