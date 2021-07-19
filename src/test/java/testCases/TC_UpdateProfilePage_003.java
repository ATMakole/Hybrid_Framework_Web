package testCases;

import org.testng.annotations.Test;
import pageObject.LoginPage;
import pageObject.UpdateProfilePage;

import java.io.IOException;

public class TC_UpdateProfilePage_003 extends BaseClass{

    @Test
    public void updateProfile() throws IOException, InterruptedException {
        driver.get(baseURL);                    //Loggging scenarios
                                                logger.info("URL is opened");
        //Executing the steps
        LoginPage lp = new LoginPage(driver);
        lp.clickSignInLink();                   logger.info("Enter username");
        lp.setUserName(username);               logger.info("Enter username");
        lp.setPassword(password);               logger.info("Enter password");
        lp.clickLoginButton();                  logger.info("Submit button clicked");
                                                //Taking screenshot
                                                captureScreen(driver, "LoginButtonclicked");

        UpdateProfilePage pd = new UpdateProfilePage(driver);
        driver.navigate().to("https://www.businesslive.co.za/u/profile/");  logger.info("Navigate to Profile page");

       // String str = driver.findElement(By.xpath("//*[text()='Your profile']")).getText().toString() ;
        //Assert.assertEquals(str,"Your profile","Invalid test");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3_000);

        //driver.findElement(By.xpath("//*[@id='subscriptions]/a/button")).click();

        lp.clickSignOutLink();                  logger.info("Click Sign Out button.");
    }

}
