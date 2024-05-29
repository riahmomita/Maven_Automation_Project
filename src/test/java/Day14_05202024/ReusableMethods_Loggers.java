package Day14_05202024;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;


public class ReusableMethods_Loggers {
    public static void clickMethod(WebDriver driver, ExtentTest logger, String xpathValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).click();
            logger.log(LogStatus.PASS,"Successfully clicked on " + elementName);
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to click on " + elementName + " due to exception " + e);
            logger.log(LogStatus.FAIL,"Unable to click on " + elementName);
            getScreenShot(driver,elementName,logger);
        }//end of catch block
    }//end of click method

    public static String captureText(WebDriver driver, ExtentTest logger, String xpathValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String result ="";
        try {
            result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue))).getText();
            logger.log(LogStatus.PASS,"Successfully captured text from " + elementName);
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to capture text " + elementName + " due to exception " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text from " + elementName);
            getScreenShot(driver,elementName,logger);
        }//end of catch block
        return result;
    }//end of capture text method


    public static String captureTextByIndex(WebDriver driver, ExtentTest logger, String xpathValue, int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String result = "";
        try{
            result = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue))).get(indexNumber).getText();
            logger.log(LogStatus.PASS,"Successfully captured text by index from " + elementName);
        }//end of try block
        catch (Exception e){
            System.out.println("Unable to capture text " + elementName + " due to exception " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text by index from " + elementName);
            getScreenShot(driver,elementName,logger);
        }//end of catch block
        return result;
    }//end of captureText method

    public static WebDriver setupChromeDriver(){
        //declare and define chrome options
        ChromeOptions options = new ChromeOptions();
        //add option to start it maximized
        options.addArguments("start-maximized","incognito");
        //pass the chrome options to the driver
        WebDriver driver = new ChromeDriver(options);
        //return driver
        return driver;
    }//end of setupdriver method

    public static void submitMethod(WebDriver driver, ExtentTest logger, String xpathValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).submit();
            logger.log(LogStatus.PASS,"Successfully submitted " + elementName);
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to submit on " + elementName + " due to exception " + e);
            logger.log(LogStatus.FAIL,"Unable to submit " + elementName);
            getScreenShot(driver,elementName,logger);
        }//end of catch block
    }//end of submit method

    public static void sendKeysMethod(WebDriver driver, ExtentTest logger, String xpathValue, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).clear();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).sendKeys(userInput);
            logger.log(LogStatus.PASS,"Successfully send keys on " + elementName);
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to send keys on " + elementName + " due to exception " + e);
            logger.log(LogStatus.FAIL,"Unable to send keys on " + elementName);
            getScreenShot(driver,elementName,logger);
        }//end of catch block
    }//end of send keys method

    public static void clickByIndex(WebDriver driver, ExtentTest logger, String xpathValue, int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue))).get(indexNumber).click();
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpathValue))).get(indexNumber).click();
            logger.log(LogStatus.PASS,"Successfully clicked by index on " + elementName);
        }//end of try block
        catch (Exception e){
            System.out.println("Unable to click by index " + elementName + " due to exception " + e);
            logger.log(LogStatus.FAIL,"Unable to click by index on " + elementName);
            getScreenShot(driver,elementName,logger);
        }//end of catch block
    }//end of clickByIndex


    public static void scrollByView(WebDriver driver, ExtentTest logger, String xpathValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try{
            WebElement scrollElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
            jse.executeScript("arguments[0].scrollIntoView(true);", scrollElement);
            logger.log(LogStatus.PASS,"Successfully scrolled to " + elementName);
        }//end of try block
        catch (Exception e){
            System.out.println("Unable to scroll to " + elementName + " due to exception " + e);
            logger.log(LogStatus.FAIL,"Unable to scroll to " + elementName);
            getScreenShot(driver,elementName,logger);
        }//end of catch block
    }//end of scrollByView


    public static void switchToTabByIndex(WebDriver driver, ExtentTest logger, int indexNumber, String elementName){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        try{
            driver.switchTo().window(tabs.get(indexNumber));
            logger.log(LogStatus.PASS,"Successfully switched to tab on " + elementName);
        }//end of try block
        catch (Exception e){
            System.out.println("Unable to switch to tab " + elementName + " due to exception " + e);
            logger.log(LogStatus.FAIL,"Unable to switch to tab on " + elementName);
            getScreenShot(driver,elementName,logger);
        }//end of catch block
    }//end of switchToTabByIndex


    public static void scrollByPixel(WebDriver driver, ExtentTest logger, int x, int y, String elementName){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try{
            jse.executeScript("scroll("+x+", "+y+");");
            logger.log(LogStatus.PASS,"Successfully scrolled to " + elementName);
        }//end of try block
        catch (Exception e){
            System.out.println("Unable to scroll to " + elementName + " due to exception " + e);
            logger.log(LogStatus.FAIL,"Unable to scroll to " + elementName);
            getScreenShot(driver,elementName,logger);
        }//end of catch block
    }//end of scrollByView


    public static void mouseAction(WebDriver driver, ExtentTest logger, String xpathValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions mouseAction = new Actions(driver);
        try{
            WebElement sendTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
            mouseAction.moveToElement(sendTab).perform();
            logger.log(LogStatus.PASS,"Successfully hovered to " + elementName);
        }//end of try block
        catch (Exception e){
            System.out.println("Unable to hover to " + elementName + " due to exception " + e);
            logger.log(LogStatus.FAIL,"Unable to hover to " + elementName);
            getScreenShot(driver,elementName,logger);
        }//end of catch block
    }//end of mouseAction


    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occurred while taking SCREENSHOT!!! " + e);
        }//end of exception
    }//end of get screenshot method


    public static void clearMethod(WebDriver driver, ExtentTest logger, String xpathValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).clear();
            logger.log(LogStatus.PASS,"Successfully cleared " + elementName);
        }//end of try block
        catch (Exception e) {
            System.out.println("Unable to clear " + elementName + " due to exception " + e);
            logger.log(LogStatus.FAIL,"Unable to clear " + elementName);
            getScreenShot(driver,elementName,logger);
        }//end of catch block
    }//end of click method


    public static void selectByVisibleText(WebDriver driver, ExtentTest logger, String xpathValue, String dropdownText, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            //select a start month from the start month dropdown
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
            //call the select function to select the start month
            Select dropDown = new Select(element);
            //select May by visible text
            dropDown.selectByVisibleText(dropdownText);
            logger.log(LogStatus.PASS,"Successfully selected " + elementName);
        }//end of try block
        catch (Exception e){
            System.out.println("Unable to select " + elementName + " due to exception " + e);
            logger.log(LogStatus.FAIL,"Unable to select " + elementName);
            getScreenShot(driver,elementName,logger);
        }//end of catch block
    }//end of select method



}//end of class
