package Day10_05062024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class T1_MouseAction {
    public static void main(String[] args) throws InterruptedException {
        //declare and define chrome options
        ChromeOptions options = new ChromeOptions();
        //option to start maximized and go in incognito mode
        options.addArguments("start-maximized", "incognito");
        //declare webdriver and pass chrome options
        WebDriver driver = new ChromeDriver(options);

        //navigate to usps.com
        driver.navigate().to("https://www.usps.com/");
        //pause for 2 seconds
        Thread.sleep(2000);

        //define action command
        Actions mouseAction = new Actions(driver);

        //hover over the send tab to open the dropdown list
        try{
            WebElement sendTab = driver.findElement(By.xpath("//*[text()='Send']"));
            mouseAction.moveToElement(sendTab).perform();
        }catch (Exception e){
            System.out.println("Unable to hover over Send Tab: " + e);
        }//end of hover over send tab exception

        //click on look up a zipcode from the dropdown list
        try{
            WebElement zipCodeLookUp = driver.findElement(By.xpath("//*[text()='Look Up a ZIP Code']"));
            mouseAction.moveToElement(zipCodeLookUp).click().perform();
        }catch (Exception e){
            System.out.println("Unable to click on Look Up a Zipcode: " + e);
        }//end of look up a zipcode exception
        //pause for 2 seconds
        Thread.sleep(2000);

        //click on find cities by zip
        try{
            WebElement findCitiesByZipCode = driver.findElement(By.xpath("//*[text()='Find Cities by ZIP']"));
            mouseAction.moveToElement(findCitiesByZipCode).click().perform();
        }catch (Exception e){
            System.out.println("Unable to click on Find Cities by Zipcode: " + e);
        }//end of find cities by zipcode exception
        //pause for 2 seconds
        Thread.sleep(2000);

        //enter a zipcode
        try{
            WebElement zipCode = driver.findElement(By.xpath("//*[@id='tZip']"));
            mouseAction.moveToElement(zipCode).click().sendKeys("11221").perform();
        }catch (Exception e){
            System.out.println("Unable to enter Zipcode: " + e);
        }//end of find cities by zipcode exception

    }//end of main
}//end of class
