package testCases;

import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.LoginPage;

import java.io.IOException;

public class TC_LandingPage_001 extends BaseClass{
    @Test
    public void goToVoucherPage() throws IOException {

        LandingPage lndp = new LandingPage(driver);
        lndp.clickSubmit();
        //lp.clickSubmit();       logger.info("Submit button clicked");
        logger.info("Voucher Page Open");
    }
}
