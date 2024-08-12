package pages;

import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class UserInfoUpdate {
    @FindBy(className = "oxd-main-menu-item")
    List<WebElement> menus;
    //user menu list myinfo page
    @FindBy(className = "oxd-main-menu-item--name")
    List<WebElement> userMenuList;

    //gender selection and other lebel selection male at 12 index and female at 12 index
    @FindBy(tagName = "label")
    List<WebElement> genderSelection;
    //edit user save button
    @FindBy(className = "oxd-button")
    List<WebElement> savebutton;

    //blood group selection
    @FindBy(className = "oxd-select-text-input")
    public List<WebElement> bloodgroup;



//table cell action buttons 1.delete button 2.edit button
    @FindBy(className = "oxd-table-cell-action-space")
    List<WebElement> tableActionButton;
    //edit user filed username
    @FindBy(className = "oxd-input")
    public List<WebElement> editUserField;
    public UserInfoUpdate(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void updateUsername () throws InterruptedException, IOException, ParseException {
        Thread.sleep(2000);
        //clicking on edit button in users table
        tableActionButton.get(1).click();
        Thread.sleep(2000);
        //keeping the old username for future use
        String oldusername = editUserField.get(1).getAttribute("value");
        //generating newusername
        String randomNewUsername = "Test" + Utils.randomNumber();
        Thread.sleep(1000);
        //clearing the username field
        editUserField.get(1).sendKeys(Keys.UP, Keys.CONTROL, "A", Keys.BACK_SPACE, Keys.DOWN);
        Thread.sleep(500);
        //sending the new generated username
        editUserField.get(1).sendKeys(randomNewUsername);

        Thread.sleep(1000);
        savebutton.get(1).click();

        Thread.sleep(2000);
        Utils.updateJSONFileObjectProperty(2, "username", randomNewUsername);


    }

    public void userContactOtherInfoUpdate (WebDriver driver) throws InterruptedException {
        //clicking on My Info tab
        userMenuList.get(2).click();
        Thread.sleep(7000);
        //clicking on blood group
        genderSelection.get(12).click();
        Thread.sleep(3000);
        savebutton.get(0).click();
        Thread.sleep(1000);
        Utils.doScroll(driver, 550);
        Thread.sleep(3000);
        bloodgroup.get(2).click();
        Thread.sleep(5000);

        bloodgroup.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        bloodgroup.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        bloodgroup.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        bloodgroup.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        bloodgroup.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(500);
        bloodgroup.get(2).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        savebutton.get(1).click();
//        driver.findElement(By.className("oxd-select-dropdown")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);

    }

}
