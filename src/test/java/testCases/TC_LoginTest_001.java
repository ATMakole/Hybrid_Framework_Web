package testCases;

import org.testng.annotations.Test;
import pageObject.LoginPage;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException, InterruptedException {
        driver.get(baseURL);
        logger.info("URL is opened");

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);logger.info("Enter username");
        lp.setPassword(password);logger.info("Enter password");
        //Taking screenshot
        captureScreen(driver, "LoginButtonclicked");
        lp.clickSubmit();       logger.info("Submit button clicked");
       // lp.clickSignOut();
        Thread.sleep(3000);
    }
}
