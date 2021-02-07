package stepdefinitions;

import commons.EnvironmentHelper;
import commons.TestContext;
import commons.iTestsConfig;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.BasePage;
import pageObjects.MainPage;
import pageObjects.SearchResultsPage;

import java.util.List;


public class WebUiSteps {
    private TestContext testContext;
    BasePage basePage;
    public static iTestsConfig testEnvConfig = EnvironmentHelper.getEnv();

    public WebUiSteps(TestContext testContext) {
        this.testContext = testContext;
        basePage = new BasePage(testContext.getDriver());
    }

    @When("user opens main page and search {string}")
    public void userOpensMainPageAndSearch(String searchedString) {
        basePage.openPage(testEnvConfig.host());
        MainPage mainPage = new MainPage(testContext.getDriver());
        testContext.setContext(Context.SEARCH_RESULT_PAGE, mainPage.searchFor(searchedString));
    }

    @Then("user can click on {string} and filter search results")
    public void userCanClickOnAndFilterSearchResults(String filterOption) {
        SearchResultsPage searchResultsPage = (SearchResultsPage) testContext.getContext(Context.SEARCH_RESULT_PAGE);
        searchResultsPage.filterSearchToBulbapediaOnly();
        testContext.setContext(Context.FOUND_RESULTS_LIST, searchResultsPage.getFoundResults());
    }

    @Then("user see filtered search results")
    @SuppressWarnings("unchecked")
    public void userSeeFilteredSearchResults() {
        List<WebElement> foundResult = (List<WebElement>) testContext.getContext(Context.FOUND_RESULTS_LIST);
        for (WebElement element : foundResult) {
            Assert.assertTrue(element.getText().contains("Bulbapedia:"), "Found result contains not filtered data : '" + element.getText() + "'.");
        }
    }
}
