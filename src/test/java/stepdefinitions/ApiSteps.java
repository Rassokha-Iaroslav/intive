package stepdefinitions;

import api.PokemonInfo;
import commons.TestContext;
import dto.MoveDto;
import dto.PokemonDto;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ApiSteps {
    private TestContext testContext;

    public ApiSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("user calls get {string} info Api")
    public void userCallsGetInfoApi(String pockemonName) {
        PokemonDto pokemonDto = PokemonInfo.getPokemonInfo(pockemonName);
        testContext.setContext(Context.POKEMON_DTO, pokemonDto);
    }

    @Then("user see that pokemon has move {string}")
    public void userSeeThatPokemonHasMove(String pokemonMove) {
        boolean moveIsPresent = false;
        PokemonDto pokemonDto = (PokemonDto) testContext.getContext(Context.POKEMON_DTO);
        for (MoveDto move : pokemonDto.getMoves()) {
            if (pokemonMove.equals(move.getMove().getName())) {
                moveIsPresent = true;
                break;
            }
        }
        Assert.assertTrue(moveIsPresent, "Following move are not present: '" + pokemonMove + "'.");
    }

    @Then("user see that pokemon could be received as gift in yellow game version of the Pokemon game")
    public void userSeeThatPokemonCouldBeReceivedAsGiftInYellowGameVersionOfThePokemonGame() {
        PokemonDto pokemonDto = (PokemonDto) testContext.getContext(Context.POKEMON_DTO);
//        TODO: implement check that pokemon could be received as gift in yellow game version of the Pokemon game
    }
}

