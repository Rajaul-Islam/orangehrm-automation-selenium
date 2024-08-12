package pages;


import Utils.Utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class SearchEmployee {
    @FindBy(className = "oxd-main-menu-item")
    List<WebElement> menuItem;

    @FindBy(css = "input")
    List<WebElement> inputField;


    @FindBy(className = "oxd-button")
    List<WebElement> buttons;
    @FindBy(css = "input")
    List<WebElement> input;

    @FindBy(css = "[role='listbox']")
     WebElement selectRole;








    public SearchEmployee(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchByUserName(String firstName) throws IOException, ParseException, InterruptedException {
        menuItem.get(8).click();
        JSONObject empObj = Utils.readUser();
        Thread.sleep(1000);
//        String userName = empObj.get("userName").toString();

        inputField.get(1).sendKeys(firstName);
        Thread.sleep(5000);
        selectRole.click();

        buttons.get(1).click();

    }
}





