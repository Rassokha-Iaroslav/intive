package stepdefinitions;

import commons.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class WebUiSteps {
    private TestContext testContext;

    public WebUiSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("user opens main page and search {string}")
    public void userOpensMainPageAndSearch(String searchedString) {
    }

    @Then("user can click on {string} and filter search results")
    public void userCanClickOnAndFilterSearchResults(String filterOption) {
    }

    @Then("user see filtered search results")
    public void userSeeFilteredSearchResults() {
    }
}
