package testrunner;


import Utils.Utils;
import config.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileReader;
import java.io.IOException;

public class LoginTestRunner extends Setup {

@Test(priority = 1, description = "admin cannot login with wrong cred")
    public void loginWithWrongCreds(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("admin", "lkdfsljlkdfs");
        String text = driver.findElement(By.className("oxd-alert-content-text")).getText();
        Assert.assertEquals(text,"Invalid credentials");


    }
    @Test(priority = 2, groups = "smoke", description = "admin can login wiht valid cred")
    public void doLogin() throws IOException, ParseException {


        LoginPage loginPage = new LoginPage(driver);
//        loginPage.doLogin("admin","admin123");
        String location  = "./src/test/resources/employes.json";
        JSONParser parser = new JSONParser();
        JSONArray employArray= (JSONArray) parser.parse(new FileReader(location));

        JSONObject adminObj= (JSONObject) employArray.get(0);;

        if(System.getProperty("userName")!=null&&System.getProperty("password")!=null){
            loginPage.doLogin(System.getProperty("userName"), System.getProperty("password"));
        }
        else {
            loginPage.doLogin(adminObj.get("userName").toString(), adminObj.get("password").toString());
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
       Boolean isExit=  driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed();
       Assert.assertTrue(isExit);
    }
@Test(priority = 3, description = "admin can log out ")
    public void doLogOut(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogOut();
        String login = driver.findElement(By.className("orangehrm-login-title")).getText();
        Assert.assertEquals(login,"Login");
    }
}
