
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.$$;
import pages.BasePage;

public class SearchResultsPage extends BasePage {
    private final ElementsCollection peopleResults = 
        $$("section[data-testid='find-results-section-name'] a.ipc-metadata-list-summary-item__t");

    @Step("Get top {count} people from search results")
    public List<String> getTopPeopleResults(int count) {
        List<String> results = new ArrayList<>();
        logStep("Found " + peopleResults.size() + " results");
        
        System.out.println("\n=== Top People with 'QA' in their profiles ===");
        for (int i = 0; i < Math.min(count, peopleResults.size()); i++) {
            String name = peopleResults.get(i).getText();
            String entry = (i + 1) + ". " + name;
            results.add(entry);
            System.out.println(entry);
        }
        System.out.println("========================================");
        
        logStep("Successfully extracted top " + Math.min(count, peopleResults.size()) + " results");
        return results;
    }
}
