package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMPage {
    @FindBy(className = "oxd-main-menu-item")
   List<WebElement>  menus;

    @FindBy(className = "oxd-button")
            List<WebElement>  buttons;

    @FindBy(className ="oxd-input")
    List<WebElement> textFields;

    @FindBy(className = "oxd-switch-input")
    WebElement switchButton;


    public PIMPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public void createUser(String firstName,String lastName,String userName,String password, String confirmPassword){
        menus.get(1).click();
        buttons.get(2).click();
        textFields.get(1).sendKeys(firstName);
        textFields.get(3).sendKeys(lastName);
        switchButton.click();
        textFields.get(5).sendKeys(userName);
        textFields.get(6).sendKeys(password);
        textFields.get(7).sendKeys(confirmPassword);
        buttons.get(1).click();
    }
}
