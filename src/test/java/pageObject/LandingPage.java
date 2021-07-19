package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage{
    WebDriver lndPagedriver;

    public LandingPage(WebDriver rdriver) {
        lndPagedriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath ="//body/nav/div/div[3]/ul/li[1]/a/i")
    @CacheLookup
    WebElement linkVoucher;
    //Voucher -
    //Profile - //html/body/nav/div/div[3]/ul/li[2]/a[1]
    //Profile  - /html/body/nav/div/div[3]/ul/li[2]/a[2]
    //Sign Out - /html/body/nav/div/div[3]/ul/li[3]/a/span[2]/span

    //Search - //*[@id="nav-search"]/a/i
    //Home Link - /html/body/nav/div/div[2]/a

    //Bread crumps
    //News - //*[@id="subsections-anchor"]
    //Politics - //*[@id="subsections-anchor"]/text()

    public void clickSubmit()
    {
        linkVoucher.click();
    }
}


