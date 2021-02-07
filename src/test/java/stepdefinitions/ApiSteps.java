package stepdefinitions;

import api.PokemonInfo;
import commons.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;

public class ApiSteps {
    private TestContext testContext;

    public ApiSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("user calls get {string} info Api")
    public void userCallsGetInfoApi(String pockemonName) {
        Response pokemonInfoResponse = PokemonInfo.getPokemonInfo(pockemonName);
        testContext.setContext(Context.POKEMON_INFO, pokemonInfoResponse);
    }

    @Then("user see that pokemon has move {string}")
    public void userSeeThatPokemonHasMove(String pokemonMove) {
        boolean moveIsPresent = false;
        Response pokemonInfo = (Response) testContext.getContext(Context.POKEMON_INFO);
        ArrayList<HashMap<String, HashMap<String, String>>> movesList = pokemonInfo.jsonPath().getJsonObject("moves");
        for (HashMap<String, HashMap<String, String>> move : movesList) {
            if (pokemonMove.equals(move.get("move").get("name"))) {
                moveIsPresent = true;
                break;
            }
        }
        Assert.assertTrue(moveIsPresent, "Following move are not present: '" + pokemonMove + "'.");
    }

    @Then("user see that pokemon could be received as gift in yellow game version of the Pokemon game")
    public void userSeeThatPokemonCouldBeReceivedAsGiftInYellowGameVersionOfThePokemonGame() {
        Response pokemonInfo = (Response) testContext.getContext(Context.POKEMON_INFO);
//        TODO: implement check that pokemon could be received as gift in yellow game version of the Pokemon game
    }
}

