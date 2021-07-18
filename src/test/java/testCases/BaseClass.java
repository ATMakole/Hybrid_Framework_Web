package testCases;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.bouncycastle.jcajce.provider.symmetric.ARC4;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.ReadConfig;

import java.io.*;
import java.io.IOException;
import java.util.logging.Logger;

public class BaseClass {
    ReadConfig readConfig = new ReadConfig();

    public String baseURL = readConfig.getApplicationURL();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String br)
    {
        //System.getProperty("user.dir") + -> Can only be used in java class
        // ./ -> in java classes and properties
        logger = Logger.getLogger(BaseClass.class.getName());
        PropertyConfigurator.configure("Log4j.properties");

        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver",readConfig.getFireFoxPath());
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        else if (br.equals("edge")) {
            System.setProperty("webdriver.edge.driver",readConfig.getEdgePath());
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        else {
            System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
        }//IE browser
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
    public void captureScreen(WebDriver driver, String tname)throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.id")+ "/ScreenShots/"+ tname + ".png");
        FileUtils.copyFile(source,target);
        System.out.println("Screenshot taken");
    }
}
