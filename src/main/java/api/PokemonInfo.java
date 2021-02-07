package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class PokemonInfo {
    private static final String badgesUrl = "pokemon/";

    public static Response getPokemonInfo(String pokemonName) {
        Response response = RestAssured.given()
                .get(badgesUrl + pokemonName);
        Assert.assertEquals(response.getStatusCode(), 200, "Response code is not 200");
        return response;
    }
}
