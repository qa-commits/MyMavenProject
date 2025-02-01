package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.HomePage;
import utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class FlipkartTest extends BaseClass {

    @DataProvider(name = "flipkartUrls")
    public Object[][] getFlipkartUrls() {
        return new Object[][]{
                {"chrome", "https://www.flipkart.com/"},
                {"edge", "https://www.flipkart.com/"}
        };
    }

    @Test(dataProvider = "flipkartUrls")
    public void verifyElectronicsMenu(String browser, String url) {
        setup(browser, url); //  I'll call the BaseClass setup() method dynamically

        ExtentReports report = ExtentReportManager.getReportInstance();
        ExtentTest test = report.createTest("Verify Electronics Menu on " + browser);

        HomePage homePage = new HomePage(driver);
        homePage.hoverOverElectronics();

        Assert.assertTrue(driver.getTitle().contains("Flipkart"), "Page title mismatch!");
        test.pass("Page title verified successfully.");

        homePage.printSubMenus();
        test.pass("Submenus printed successfully.");

        report.flush();

        tearDown(); // Close the browser after test execution
    }
}
