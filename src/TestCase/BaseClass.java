package TestCase;

import org.testng.annotations.AfterSuite;
import java.time.Duration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentTest;
import Utilities.ReadConfig;

public class BaseClass {

    ReadConfig readconfig=new ReadConfig();
    public String baseURL=readconfig.getApplicationURL();

    public static WebDriver driver;

    public static Logger logger;
    public ExtentTest test;

    @BeforeSuite
    @Parameters("browser")
    public void setup(String br) throws InterruptedException
    {

        logger = Logger.getLogger("cog");
        PropertyConfigurator.configure("log4j.properties");

        if(br.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver=new ChromeDriver();
        }
        else if(br.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }
        else if(br.equals("edge"))
        {
            System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
            driver = new EdgeDriver();
        }
        
        Thread.sleep(3000);
        driver.get(baseURL);
        driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();

    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
	
	@AfterSuite
    public void tearDown()
    {
        driver.quit();
    }

}
