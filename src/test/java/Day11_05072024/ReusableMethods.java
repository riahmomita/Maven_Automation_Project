package Day11_05072024;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class ReusableMethods {


    public static void clickMethod(WebDriver driver, String xpathValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue))).click();
        }catch (Exception e){
            System.out.println("Unable to click on " + elementName + " due to exception " + e);
        }//end of exception
    }//end of clickMethod

    public static String captureText(WebDriver driver, String xpathValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String result = "";
        try{
            result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue))).getText();
        }catch (Exception e){
            System.out.println("Unable to capture text " + elementName + " due to exception " + e);
        }//end of exception
        return result;
    }//end of captureText method

    public static String captureTextByIndex(WebDriver driver, String xpathValue, int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String result = "";
        try{
            result = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue))).get(indexNumber).getText();
        }catch (Exception e){
            System.out.println("Unable to capture text " + elementName + " due to exception " + e);
        }//end of exception
        return result;
    }//end of captureText method

    public static WebDriver setupChromeDriver(){
        //declare and define chrome options
        ChromeOptions options = new ChromeOptions();
        //option to start maximized and go in incognito mode
        options.addArguments("start-maximized");
        //declare webdriver and pass chrome options
        WebDriver driver = new ChromeDriver(options);
        //return driver
        return driver;
    }//end of setupChromeDriver method

    public static void submitMethod(WebDriver driver, String xpathValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).submit();
        }catch (Exception e){
            System.out.println("Unable to submit on " + elementName + " due to exception " + e);
        }//end of exception
    }//end of submitMethod

    public static void sendKeysMethod(WebDriver driver, String xpathValue, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
            element.clear();
            element.sendKeys(userInput);
        }catch (Exception e){
            System.out.println("Unable to send keys on " + elementName + " due to exception " + e);
        }//end of exception
    }//end of sendKeysMethod

    public static void clickByIndex(WebDriver driver, String xpathValue, int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement clickElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathValue))).get(indexNumber);
            clickElement.click();
        }catch (Exception e){
            System.out.println("Unable to click by index " + elementName + " due to exception " + e);
        }//end of exception
    }//end of clickByIndex


    public static void scrollByView(WebDriver driver, String xpathValue, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try{
            WebElement scrollElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
            jse.executeScript("arguments[0].scrollIntoView(true);", scrollElement);
        }catch (Exception e){
            System.out.println("Unable to scroll to " + elementName + " due to exception " + e);
        }//end of exception
    }//end of scrollByView


    public static void switchToTabByIndex(WebDriver driver, int indexNumber, String elementName){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        try{
            driver.switchTo().window(tabs.get(indexNumber));
        }catch (Exception e){
            System.out.println("Unable to switch to tab " + elementName + " due to exception " + e);
        }//end of exception
    }//end of switchToTabByIndex


    public static void scrollByPixel(WebDriver driver, int x, int y, String elementName){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try{
            jse.executeScript("scroll("+x+", "+y+");");
        }catch (Exception e){
            System.out.println("Unable to scroll to " + elementName + " due to exception " + e);
        }//end of exception
    }//end of scrollByView


}//end of class
