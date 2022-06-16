package ReusableLibraries;

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

public class Reusable_Actions {

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
    public static void mouseHover(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        }catch (Exception e){
            System.out.println("Unable to hover on element " + elementName + " " + e);

        } //end of hover exception
    } //end of mouseHover method

    //create a click method
    public static void clickAction(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
        }catch (Exception e){
            System.out.println("Unable to click on element " + elementName + " " + e);

        } //end of click exception
    } //end of clickAction method

    //create a submit method
    public static void submitAction(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
        }
    }//end of submit

    //create a sendKeys method
    public static void sendKeysAction(WebDriver driver, String xpath, String userValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userValue);
        }catch (Exception e){
            System.out.println("Unable to click on element " + elementName + " " + e);

        } //end of sendKeys exception
    } //end of sendKeysAction method

    //create a getText method
    public static String getTextAction(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String result = null;

        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
        }catch (Exception e){
            System.out.println("Unable to capture text on element " + elementName + " " + e);

        } //end of getText exception
        return result;

    } //end of getTextException method


    //create a click by index method
    public static void clickByIndexAction(WebDriver driver, String xpath, int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            //this changes to visibilityofAllElements... and add .get()
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
        }catch (Exception e){
            System.out.println("Unable to click on element " + elementName + " " + e);

        } //end of click by index exception
    } //end of clickByIndexAction method

    //create a switchToTabByIndex method
    public static void switchToTabByIndex(WebDriver driver, int value){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(value));

    } //end of switchToTabByIndex method

    //create a verifyTitle method
    public static void verifyTitle(WebDriver driver, String title){
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(title)){
            System.out.println("My title matches");
        } else{
            System.out.println("Title doesn't match. Actual Title is " + actualTitle);
        } //end of title if statement
    } //end of verifyTitle method

    //create a selectByText method
    public static void selectByText(WebDriver driver, String xpath, String month, String elementName){
        try{
            WebElement startMonth = driver.findElement(By.xpath(xpath));
            Select dropdown = new Select(startMonth);
            dropdown.selectByVisibleText(month);
        }catch (Exception e){
            //print out the exception
            System.out.println("Unable to select dropdown " + elementName + " " + e);
        }//end of month exception
    }



} //end of main
