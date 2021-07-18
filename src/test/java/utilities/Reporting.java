package utilities;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import java.text.SimpleDateFormat;

public class Reporting extends TestListenerAdapter {
    public ExtentSparkReporter htmlSparkReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    public void onStart(ITestContext testContext)
    {
        String timeStamp = new SimpleDateFormat(
                "yyyy.MM.dd.HH.mm.ss").format(new Date());
        String repName = "Test-Report-"+timeStamp+".html";
        htmlSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "//test-output//"+ repName );
        try {
            htmlSparkReporter. loadXMLConfig("extent-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }


        extent = new ExtentReports() ;
        extent.attachReporter(htmlSparkReporter);
        extent.setSystemInfo("Host name","localhost");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("user","aaron");

        htmlSparkReporter.config().setDocumentTitle("InetBanking Test Project");
        htmlSparkReporter.config().setReportName("Functional TEst Report");
        htmlSparkReporter.config().setTheme(Theme.DARK);
    }

    public void onTestSuccess(ITestResult tr)
    {
        logger=extent.createTest(tr.getName());//Create new entry in the report
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED) );// send the passed information

        String screenshotPath = System.getProperty("user.dir" + "\\Screenshots\\"+tr.getName()+".png");

        File f = new File(screenshotPath);

        if (f.exists())
        {
            logger.fail("Screenshot is below: "
                    + logger.addScreenCaptureFromPath(screenshotPath));
        }
    }

    public void onTestSkipped(ITestResult tr)
    {
        logger=extent.createTest(tr.getName());//Create new entry in the report
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));// send the passed information
    }

    public void onFinish(ITestContext testContext)
    {
        extent.flush();
    }
}
