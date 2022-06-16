package ActionItem6;

import ReusableLibraries.Reusable_Actions;
import ReusableClasses.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_NorthWesternMutual {
    //declare the local driver outside so it can be reusable with other annotation methods
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setDriver();

        //define the path to the report
        reports = new ExtentReports("src/main/java/HTML_Report/Automation.html", true);
    } //end of before suite annotation


    //test case 1: navigate to northwesternmutual and hover over the insurance tab
    @Test(priority = 1)
    public void InsuranceTab(){
        logger = reports.startTest("Hover over the Insurance tab");
        driver.navigate().to("https://www.northwesternmutual.com");
        //hover mouse over insurance tab
        Reusable_Actions_Loggers.mouseHover(driver,"//*[@href='/insurance']", logger, "Insurance Tab");
        //end the logger per test
        reports.endTest(logger);
    } //end of test 1

    //test case 2: verify the title of the page
    @Test(dependsOnMethods = "InsuranceTab")
    public void EnterUserAge()  {
        logger = reports.startTest("Verify title");
        Reusable_Actions_Loggers.verifyTitle(driver, "Northwestern Mutual", logger);
        reports.endTest(logger);
    } //end of test 2

    //test case 3: select the life insurance option from the dropdown that appears
    @Test(dependsOnMethods = "InsuranceTab")
    public void SelectLifeInsuranceOption(){
        logger = reports.startTest("Click on Life Insurance");
        //click the life insurance option
        Reusable_Actions_Loggers.clickAction(driver, "//*[@href='/life-insurance']", logger, "Life Insurance");
        reports.endTest(logger);
    } //end of test 3

    //test case 4: capture the brief description about life insurance
    @Test(dependsOnMethods = "SelectLifeInsuranceOption")
    public void CaptureLifeInsuranceDescription(){
        logger = reports.startTest("Capture life insurance text");
        String result = Reusable_Actions_Loggers.getTextAction(driver, "//*[@id='life-insurance-product-intro-section-container']", logger, "Life insurance text");
        System.out.println("Message: " + result);
        logger.log(LogStatus.INFO, "Message: " + result);
        reports.endTest(logger);
    } //end of test 4

    //test case 5: click on connect to an advisor to learn more
    @Test(dependsOnMethods = "CaptureLifeInsuranceDescription")
    public void ConnectToAdvisor(){
        logger = reports.startTest("Click on Connect With An Advisor");
        Reusable_Actions_Loggers.clickAction(driver, "//*[@id='life-insurance-product-intro-cta-fafa']", logger, "Connect to Advisor");
        reports.endTest(logger);
    } //end of test 5

    //test case 6: click on the buy a home option
    @Test(dependsOnMethods = "ConnectToAdvisor")
    public void BuyAHome(){
        logger = reports.startTest("Click on Buy a home");
        Reusable_Actions_Loggers.clickByIndexAction(driver, "//*[@class='sc-fTNIjK hNXDKc']", 0, logger, "Buy a home");
        reports.endTest(logger);
    } //end of test 6

    //test case 7: click on next button to continue to the next page
    @Test(dependsOnMethods = "BuyAHome")
    public void ClickNextButton(){
        logger = reports.startTest("Click on Next button");
        Reusable_Actions_Loggers.clickAction(driver, "//*[text()='Next']", logger, "Next button");
        reports.endTest(logger);
    } //end of test 7


    @AfterSuite
    public void quitSession(){
        driver.quit();
        reports.flush();
    } //end of after suite

} //end of class
