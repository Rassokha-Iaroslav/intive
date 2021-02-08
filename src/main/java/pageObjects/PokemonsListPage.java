package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PokemonsListPage extends BasePage {
    private WebDriver driver;

    private static String templateForListOfPockemonsOnLetterSelector = "//div[@id='mw-content-text']/h3/span[@id=\"%s\"]/../following-sibling::table[1]/tbody/tr/td[2]/a";

    public PokemonsListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        waitABit();
    }

    public List<String> getPockemonsListOnLetter(String startingLetter) {
        List<String> pokemonstList = new ArrayList<>();
        List<WebElement> listOfPokemons = driver.findElements(By.xpath(String.format(templateForListOfPockemonsOnLetterSelector, startingLetter)));
        for (WebElement pockemonElement : listOfPokemons) {
            pokemonstList.add(pockemonElement.getText());
        }
        return pokemonstList;
    }

}
