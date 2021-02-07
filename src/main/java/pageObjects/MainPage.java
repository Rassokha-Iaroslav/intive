package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    private WebDriver driver;
    private static final String SEARCH_INPUT = ".bg-global-nav-search-input";
    private static final String BANNER = "div.banner_consent--2qj6F:nth-child(2) > a";

    @FindBy(how = How.CSS, using = SEARCH_INPUT)
    public WebElement searchInputField;
    @FindBy(how = How.CSS, using = BANNER)
    public WebElement bannerCloseButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        waitABit();
        closeBanner();
    }

    private void closeBanner() {
        if (driver.findElements(By.cssSelector(BANNER)).size() > 0) {
            bannerCloseButton.click();
            waitABit();
        }
    }

    public SearchResultsPage searchFor(String searchedPhrase) {
        searchInputField.sendKeys(searchedPhrase);
        searchInputField.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }
}
