package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import utilities.XLUtils;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass{

    @Test(dataProvider = "LoginData")
    public void loginDDT(String username, String password) throws IOException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        lp.setPassword(password);
        lp.clickSubmit();
    }

    @DataProvider (name="LoginData")
    Object[][] getData() throws IOException
    {
        String path = System.getProperty("user.dir") + "/src/test/java/testData/LoginData.xlsx";
        int rowNum= XLUtils.getRowCount(path,"Sheet1");
        int colCount= XLUtils.getCellCount(path,"Sheet1",1);

        String loginData[][] = new String[rowNum][colCount];
        for (int i = 1; i <= rowNum; i++) {     //Start from row 1 to avoid the headers - Row  0 is occupied by deaders
            for (int j = 0; j < colCount; j++) {
                loginData[i-1][j] = XLUtils.getCellData(path,"Sheet1",i,j);
            }
        }
        return loginData;
    }
}
