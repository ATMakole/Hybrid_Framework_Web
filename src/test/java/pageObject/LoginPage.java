package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver ldriver;

    public LoginPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath ="//*[@id='auth-wrapper']/form/fieldset/div[1]/input")
    @CacheLookup
    WebElement txtUserName;

    @FindBy(xpath="//*[@id='auth-wrapper']/form/fieldset/div[2]/input")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath="//*[@id='auth-wrapper']/form/fieldset/div[4]/button")
    @CacheLookup
    WebElement btnLogin;
//html/body/nav/div/div[3]/ul/li[3]/a
    @FindBy(xpath="//span[contains(text(),'Sign Out')]")
    @CacheLookup
    WebElement linkSignOut;

    public void setUserName(String username)
    {
        txtUserName.sendKeys(username);
    }

    public void setPassword(String pwd)
    {
        txtPassword.sendKeys(pwd);
    }

    public void clickSubmit()
    {
        btnLogin.click();
    }

    public void clickSignOut()
    {
        linkSignOut.click();
    }
}
