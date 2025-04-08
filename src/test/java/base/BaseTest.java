package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ExtentReportManager;

public class BaseTest {

    protected static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getExtentReports();
    }

    @BeforeMethod
    public void registerTest(java.lang.reflect.Method method) {
        ExtentTest extentTest = extent.createTest(method.getName());
        test.set(extentTest);
    }
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.useRelaxedHTTPSValidation();
        System.out.println("Starting tests...");
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }

    protected ExtentTest getTest() {
        return test.get();
    }
}