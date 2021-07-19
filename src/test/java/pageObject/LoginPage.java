package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.lang.model.element.Element;
import java.util.List;

public class LoginPage {
    WebDriver ldriver;

    public LoginPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath ="//div[2]/span/a[2]")
    @CacheLookup
    WebElement linkSignIn;
    @FindBy(xpath ="//*[@id='auth-wrapper']/form/fieldset/div[1]/input")
    @CacheLookup
    WebElement txtUserName;

    @FindBy(xpath="//*[@id='auth-wrapper']/form/fieldset/div[2]/input")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath="//fieldset/div[4]/button")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(xpath="//*[@id='auth-wrapper']/form/fieldset/div[4]/button")
    @CacheLookup
    WebElement linkSignOut;

    @FindBy(xpath="//")
    @CacheLookup
    WebElement linkVoucher;

    public void setUserName(String username)
    {
        txtUserName.sendKeys(username);
    }

    public void setPassword(String pwd)
    {
        txtPassword.sendKeys(pwd);
    }

    public void clickLoginButton()
    {
        btnLogin.click();
    }

    public void clickSignInLink(){ linkSignIn.click(); }

    public void clickSignOutLink(){ linkSignOut.click(); }

    public void clickVoucherLink(){ linkVoucher.click(); }

}
