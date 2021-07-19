package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pageObject.LoginPage;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException, InterruptedException {
        driver.get(baseURL);
        logger.info("URL is opened");

        LoginPage lp = new LoginPage(driver);
        lp.clickSignInLink();
        lp.setUserName(username);logger.info("Enter username");
        lp.setPassword(password);logger.info("Enter password");
        //Taking screenshot
        captureScreen(driver, "LoginButtonclicked");
        lp.clickLoginButton();       logger.info("Submit button clicked");
        lp.clickSignOutLink();logger.info("Click Sign Out button.");
    }
}
