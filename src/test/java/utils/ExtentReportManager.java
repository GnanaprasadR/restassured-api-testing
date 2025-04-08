package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/extent-report.html");
        reporter.config().setReportName("API Test Report");
        reporter.config().setDocumentTitle("RestAssured API Test Report");

        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "Gnanaprasad");
        extentReports.setSystemInfo("Environment", "QA");

        return extentReports;
    }
}