package pages;

import net.bytebuddy.implementation.bytecode.ShiftRight;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    @FindBy(name="username")
    WebElement txtUsername;

    @FindBy(name="password")
    WebElement textPassword;

    @FindBy(className = "oxd-button")
    WebElement btnLogin;

    @FindBy(className = "oxd-userdropdown-tab")
    WebElement userNameBtn;

    @FindBy(css = "[role=\"menuitem\"]")
   List <WebElement> userMenu;


    public LoginPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    public void doLogin(String username, String password){
        txtUsername.sendKeys(username);
        textPassword.sendKeys(password);
        btnLogin.click();
    }

    public void doLogOut(){
        userNameBtn.click();
        userMenu.get(3).click();
    }

}
