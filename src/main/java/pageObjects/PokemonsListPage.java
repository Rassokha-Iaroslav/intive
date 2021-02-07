package pageObjects;

import org.openqa.selenium.By;
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

    private static String templateForListOfPockemonsOnLetterSelector = "//div[@id='mw-content-text']/h3/span[@id=\"letterPlaceholder\"]/../following-sibling::table[1]/tbody/tr/td[2]/a";

    @FindBy(how = How.CSS, using = Y_LIST_OF_POKEMONS)
    public List<WebElement> pokemonsOnLetterY;

    public PokemonsListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        waitABit();
    }

    public List<String> getPockemonsListOnLetter(String startingLetter) {
        List<String> pokemonstList = new ArrayList<>();
        List<WebElement> listOfPokemons = driver.findElements(By.xpath(templateForListOfPockemonsOnLetterSelector.replace("letterPlaceholder", startingLetter)));
        for (WebElement pockemonElement : listOfPokemons) {
            pokemonstList.add(pockemonElement.getText());
        }
        return pokemonstList;
    }

}
