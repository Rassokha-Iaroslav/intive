package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PokemonsListPage extends BasePage {
    private WebDriver driver;

    private static final String Y_LIST_OF_POKEMONS = "table.roundy:nth-child(102) > tbody:nth-child(1) > tr > td:nth-child(3) > a";

    @FindBy(how = How.CSS, using = Y_LIST_OF_POKEMONS)
    public List<WebElement> pokemonsOnLetterY;

    public PokemonsListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        waitABit();
    }

    public List<String> getPockemonsListOnLetterY() {
        List<String> pokemonstList = new ArrayList<>();

        for (WebElement pockemonElement : pokemonsOnLetterY) {
            pokemonstList.add(pockemonElement.getText());
        }
        return pokemonstList;
    }
}
