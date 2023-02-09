package Utilities;

//Listener class used to generate Extent reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class generateReport extends TestListenerAdapter
{
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;


    public void onStart(ITestContext testContext)
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
        String repName="Test-Report-"+timeStamp+".html";

        htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report
        
        htmlReporter.config().setDocumentTitle("Amazon"); // Tile of report
        htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
       

        extent=new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        extent.setSystemInfo("Host name","localhost");
        extent.setSystemInfo("Environemnt","QA");
        extent.setSystemInfo("user","Kishome");

        
    }

    public void onTestSuccess(ITestResult tr)
    {
        logger=extent.createTest(tr.getName()); // create new entry in th report
        logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
        
    }
    
	public static String getCurrentTimeStamp() 
	{
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY_MM_dd_HH_mm_ss");
		Date date = new Date();
		String getDate = formatter.format(date);
		return getDate;

	}

    public void onTestFailure(ITestResult tr)
    {
        logger=extent.createTest(tr.getName()); // create new entry in th report
        logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
        
        String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+getCurrentTimeStamp()+".png";
  
        logger.log(Status.FAIL, MarkupHelper.createLabel("TEST CASE FAILED, BECAUSE - " +
       	tr.getThrowable(),ExtentColor.RED)); // to add error/exception in extent
        
        File f = new File(screenshotPath);

        if(f.exists())
        {
            try {
                logger.fail("Screenshot is below:" +logger.addScreenCaptureFromPath(screenshotPath));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    public void onTestSkipped(ITestResult tr)
    {
        logger=extent.createTest(tr.getName()); // create new entry in th report
        logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
        
        String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+getCurrentTimeStamp()+".png";

        File f = new File(screenshotPath);

        if(f.exists())
        {
            try {
                logger.skip("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void onFinish(ITestContext testContext)
    {
		extent.flush();
        
    }
}
