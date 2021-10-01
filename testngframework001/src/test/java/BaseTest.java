package test.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Constants;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public static WebDriver driver;
    public static ExtentReports extentReports;
    public static ExtentTest logger;
    public static ExtentHtmlReporter extentHtmlReporter;


    @BeforeTest
    public void beforeTestMethod(){
        extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ File.separator + "reports" + File.separator + "AutomationReport.html");
        extentHtmlReporter.config().setEncoding("utf-8");
        extentHtmlReporter.config().setDocumentTitle("Automation TestNG Report");
        extentHtmlReporter.config().setReportName("Automation TestNG Tests Results");
        extentHtmlReporter.config().setTheme(Theme.DARK);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Automation Tester","RAjan Velayautham" );

    }


    @BeforeMethod
    @Parameters(value={"browserName"})
    public void beforeTestMethodMethod(String browserName, Method testMethod){
        logger= extentReports.createTest(testMethod.getName());
        setupDriver(browserName);
        driver.manage().window().maximize();
        driver.get(Constants.url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }

    @AfterMethod
    public void afterTestMethodMethod(ITestResult result){
        if(result.getStatus()==ITestResult.SUCCESS){
            String methodName= result.getMethod().getMethodName();
            String logText = "Test Cases: " + methodName + "Passed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.FAIL,m);

        }
        else if(result.getStatus()==ITestResult.FAILURE){
            String methodName= result.getMethod().getMethodName();
            String logText = "Test Cases: " + methodName + "Failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL,m);

        }
        driver.quit();

    }


    @AfterTest
    public void afterTestMethod(){
        extentReports.flush();

    }

    public void setupDriver(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Rajan\\Office\\Automation\\testngframework001\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:\\Rajan\\Office\\Automation\\testngframework001\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else{
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ File.separator + "drivers" + File.separator + "chromedriver");
            driver = new ChromeDriver();

        }

    }

}
