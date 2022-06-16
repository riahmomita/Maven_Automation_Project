package ActionItem4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class WeightWatchersUpdate {
    public static void main(String[] args) throws InterruptedException {

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

        //jse to scroll
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //array for list of zipcodes
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("10023");
        zipCodes.add("11228");
        zipCodes.add("10001");

        //for loop to iterate through weightwatchers.com with multiple zipcodes
        for (int i = 0; i < zipCodes.size(); i++) {

            //navigate to weight watchers website
            driver.navigate().to("https://www.weightwatchers.com");

            //click on "find a workshop"
            try {
                WebElement attendButton = driver.findElement(By.xpath("//*[@data-e2e-name='find_a workshop']"));
                attendButton.click();

            } catch (Exception e) {
                System.out.println("Unable to click " + e);
            }//end of find a workshop exception

            //click on studio
            try {
                WebElement studioButton = driver.findElement(By.xpath("//span[text()='Studio']"));
                studioButton.click();
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println("Unable to locate studio " + e);
            }//end of studio exception

            //clear the field and enter zipcode
            try {
                WebElement lLocation = driver.findElement(By.xpath("//*[@id='location-search']"));
                lLocation.clear();
                lLocation.sendKeys(zipCodes.get(i));

            } catch (Exception e){
                System.out.println("Unable to locate zipcode " + e);
            }//end of zipcode exception

            //click the search button
            try {
                driver.findElement(By.xpath("//*[@id='location-search-cta']")).submit();
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println("Unable to locate search button " + e);
            }//end of search exception

            //click on studio link
            try {
                ArrayList<WebElement> studioLinks = new ArrayList<>(driver.findElements(By.xpath("//*[@class='linkContainer-1NkqM']")));
                if(i==0){
                    studioLinks.get(1).click();
                }else if(i==1){
                    studioLinks.get(2).click();
                } else if (i==2){
                    studioLinks.get(0).click();
                }

            } catch (Exception e) {
                System.out.println("Unable to locate studio link " + e );
            }//end of studio links exception

            //capture the address of the studio
            try{
                String studioAddress = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                System.out.println("The studio address is: " + studioAddress);

            } catch (Exception e) {
                System.out.println("Unable to locate studio address " + e);
            }//end of address exception

            //scroll down to the virtual workshops schedule
            try {
                //declare a web element variable that we want to scroll into
                WebElement scrollTo = driver.findElement(By.xpath("//*[@class='info-1Kgur']"));

                //scroll into virtual workshop info
                jse.executeScript("arguments[0].scrollIntoView(true);", scrollTo);
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println("Unable to locate scroll");
            }//end of scroll exception

            //capture and print the virtual workshop schedule
            try{
                String schedule = driver.findElement(By.xpath("//*[@id='virtualWorkshopSchedule']")).getText();
                System.out.println(schedule + "\n");

            } catch (Exception e) {
                System.out.println("Unable to capture workshop schedule " + e);
            }//end of print schedule exception

        } //end of for loop

        //quit the driver
        driver.quit();

    } //end of main
} //end of class
