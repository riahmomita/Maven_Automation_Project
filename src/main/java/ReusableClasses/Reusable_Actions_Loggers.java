package ReusableClasses;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Actions_Loggers {

    //set static timeout variable so it can cover all explicit for all methods
    static int timeout = 10;

    //reusable functiion  for webdriver as a return method
    public static WebDriver setDriver(){

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //set chrome options arguments.
        ChromeOptions options = new ChromeOptions();

        //set the condition to incognito mode
        options.addArguments("incognito");

        //set the condition to maximize your driver
        options.addArguments("start-maximized");

        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

        return driver;

    } //end of setDriver method

    //create a mouse hover method with 3 parameters in this case
    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Successfully hover over element " + elementName);
        }catch (Exception e){
            System.out.println("Unable to hover on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to hover over element " + elementName + " " + e );

        } //end of hover exception
    } //end of mouseHover method

    //create a click method
    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS, "Successfully clicked on element " + elementName);
        }catch (Exception e){
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element " + elementName + " " + e );

        } //end of click exception
    } //end of clickAction method

    //create a submit method
    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS, "Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL, "Unable to submit on element " + elementName + " " + e );
        }
    }//end of submit

    //create a sendKeys method
    public static void sendKeysAction(WebDriver driver, String xpath, String userValue, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS, "Successfully entered user value on element " + elementName);
        }catch (Exception e){
            System.out.println("Unable to enter value on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter value on element " + elementName + " " + e );

        } //end of sendKeys exception
    } //end of sendKeysAction method

    //create a getText method
    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String result = null;

        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            logger.log(LogStatus.PASS, "Successfully capture text on element " + elementName);
        }catch (Exception e){
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + elementName + " " + e);
        } //end of getText exception
        return result;

    } //end of getTextException method


    //create a click by index method
    public static void clickByIndexAction(WebDriver driver, String xpath, int indexNumber, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            //this changes to visibilityofAllElements... and add .get()
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
            logger.log(LogStatus.PASS, "Successfully clicked on element " + elementName);
        }catch (Exception e){
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " + e);

        } //end of click by index exception
    } //end of clickByIndexAction method

    //create a switchToTabByIndex method
    public static void switchToTabByIndex(WebDriver driver, int value){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(value));

    } //end of switchToTabByIndex method

    //create a verifyTitle method
    public static void verifyTitle(WebDriver driver, String title, ExtentTest logger){
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(title)){
            System.out.println("My title matches");
            logger.log(LogStatus.PASS, "Successfully matched title");
        } else{
            System.out.println("Title doesn't match. Actual Title is " + actualTitle);
            logger.log(LogStatus.FAIL,"Unable to match title");
        } //end of title if statement
    } //end of verifyTitle method

    //create a selectByText method
    public static void selectByText(WebDriver driver, String xpath, String month, ExtentTest logger, String elementName){
        try{
            WebElement startMonth = driver.findElement(By.xpath(xpath));
            Select dropdown = new Select(startMonth);
            dropdown.selectByVisibleText(month);
            logger.log(LogStatus.PASS, "Successfully selected text " + elementName);
        }catch (Exception e){
            //print out the exception
            System.out.println("Unable to select dropdown " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to select text " + elementName + " " + e);
        }//end of month exception
    } //end of selectByText method

    public static void verifyStatusOfElement(WebDriver driver, String xpath, Boolean expectedStatus, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            Boolean actualStatus = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
            if(expectedStatus == actualStatus){
                logger.log(LogStatus.PASS,"Element is selected as expected");
            } else {
                logger.log(LogStatus.FAIL,"Element is not selected");
            }
        } catch (Exception e) {
            //print out the exception
            System.out.println("Unable to select element " + elementName + " " + e);
        }

    }//end of method



} //end of main
