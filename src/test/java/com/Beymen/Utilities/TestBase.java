package com.Beymen.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;

    //for starting and building reports
    protected ExtentReports report;
    // to create HTML report file
    protected ExtentHtmlReporter htmlReporter;
    //to define a  test steps
    protected static ExtentTest extentLogger;

    @Before
    public void setUp(){

        driver= Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        report = new ExtentReports();
        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("GittiGidiyor Proje Musa");

        //set environment information
        report.setSystemInfo("Environment","Test");
        report.setSystemInfo("BrowserType", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
    }


    @After
    public void endTest() {
        BrowserUtils.getScreenshot("Test Sonucu");
        Driver.closeDriver();
        report.flush();
    }
}
