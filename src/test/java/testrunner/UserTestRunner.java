package testrunner;

import Utils.Utils;
import config.Setup;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class UserTestRunner extends Setup {
    @Test(priority = 1)
    public void loginWithWrongCreds() throws IOException, ParseException {
       JSONObject user =  Utils.readUser();
       String userName = (String) user.get("userName");
       String password = (String) user.get("password");


        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(userName, password);
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        Boolean isExit=  driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed();
        Assert.assertTrue(isExit);


    }
}
