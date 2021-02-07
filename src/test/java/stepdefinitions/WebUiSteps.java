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
import pageObjects.PokemonsListPage;
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

    @When("user opens page with list of Pokemons")
    public void userOpensPageWithListOfPokemons() {
        basePage.openPage(testEnvConfig.host());
        MainPage mainPage = new MainPage(testContext.getDriver());
        mainPage.searchFor("List_of_Pokémon_by_name");
        testContext.setContext(Context.POKEMONS_LIST_PAGE, new PokemonsListPage(testContext.getDriver()));
    }

    @Then("users see in section {string} only Pokemons with name starting with this letter")
    public void usersSeeInSectionOnlyPokemonsWithNameStartingWithThisLetter(String sectionLetter) {
        PokemonsListPage pokemonsListPage = (PokemonsListPage) testContext.getContext(Context.POKEMONS_LIST_PAGE);
        for (String name : pokemonsListPage.getPockemonsListOnLetter(sectionLetter)) {
            Assert.assertTrue(name.matches("^" + sectionLetter + ".*"), "Following pokemon name is not starting on 'Y' :'" + name + "'.");
        }
    }
}
