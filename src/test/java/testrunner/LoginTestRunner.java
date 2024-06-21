package testrunner;


import config.Setup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTestRunner extends Setup {

@Test(priority = 1)
    public void loginWithWrongCreds(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("admin", "lkdfsljlkdfs");
        String text = driver.findElement(By.className("oxd-alert-content-text")).getText();
        Assert.assertEquals(text,"Invalid credentials");


    }
    @Test(priority = 2)
    public void doLogin(){


        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("admin","admin123");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
       Boolean isExit=  driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed();
       Assert.assertTrue(isExit);
    }
@Test(priority = 3)
    public void doLogOut(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogOut();
        String login = driver.findElement(By.className("orangehrm-login-title")).getText();
        Assert.assertEquals(login,"Login");
    }
}
