package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateProfilePage {

    WebDriver ldriver;

    public UpdateProfilePage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath ="//span[@class='buttons']/a[2]")
    @CacheLookup
    WebElement linkProfile;

    public void clickProfileLink()
    {
        linkProfile.click();
    }
}
