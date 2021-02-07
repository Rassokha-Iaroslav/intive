package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage extends BasePage {

    private WebDriver driver;
    private static final String ADVANCE_SEARCH_BUTTON = "a[title=\"Search in custom namespaces\"]";
    private static final String BULBAPEDIA_FILTER = "#mw-search-ns4";
    private static final String NONE_FILTER = "#mw-search-togglenone";
    private static final String SEARCH_BUTTON = "button.oo-ui-inputWidget-input";
    private static final String FOUND_RESULTS = ".mw-search-results > li > div.mw-search-result-heading";

    @FindBy(how = How.CSS, using = ADVANCE_SEARCH_BUTTON)
    public WebElement advanceSearch;

    @FindBy(how = How.CSS, using = BULBAPEDIA_FILTER)
    public WebElement bulbapediaFilterCheckbox;

    @FindBy(how = How.CSS, using = NONE_FILTER)
    public WebElement noneFilterBtn;

    @FindBy(how = How.CSS, using = SEARCH_BUTTON)
    public WebElement searchFilterBtn;

    @FindBy(how = How.CSS, using = FOUND_RESULTS)
    public List<WebElement> foundResults;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        waitVisibility(By.cssSelector(ADVANCE_SEARCH_BUTTON));
    }

    public SearchResultsPage filterSearchToBulbapediaOnly() {
        advanceSearch.click();
        noneFilterBtn.click();
        bulbapediaFilterCheckbox.click();
        searchFilterBtn.click();
        return new SearchResultsPage(driver);
    }

    public List<WebElement> getFoundResults() {
        return foundResults;
    }
}
