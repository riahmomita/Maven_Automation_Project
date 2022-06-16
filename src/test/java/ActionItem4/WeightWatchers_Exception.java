package ActionItem4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class WeightWatchers_Exception {
    public static void main(String[] args) throws InterruptedException {

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //chrome option goes between these two
        //set chrome options arguments.
        ChromeOptions options = new ChromeOptions();

        //set the condition to incognito mode
        options.addArguments("incognito");

        //set the condition to maximize your driver
        options.addArguments("start-maximized");

        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

        //used to scroll
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //List of arrays to input zipcode
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("10001");
        zipCodes.add("11414");
        zipCodes.add("10128");

        //for loop to iterate through the website with different zipcodes and capture each locations address and schedule with try and catch
        for(int i = 0; i < zipCodes.size(); i++) {

            //navigate to weight watchers website
            driver.navigate().to("https://www.weightwatchers.com");
            Thread.sleep(1000);

            //handle exception for "Attend" dropdown
            try {
                driver.findElements(By.xpath("//*[text()='Attend']")).get(0).click();
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println("Unable to locate attend dropdown " + e);
            } //end of attend dropdown exception

            //handle exception for unlimited workshops
            try {
                driver.findElement(By.xpath("//*[@class='Button_button__KL9SJ MenuItem_menu-item__link__wdunp SecondaryMenu_subMenuItem__YUEeZ Button_button--no-style__N0tw6']")).click();
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println("Unable to locate unlimited workshops");
            }//end of unlimited workshop exception

            //handle exception for studio
            try {
                driver.findElements(By.xpath("//*[@class='buttonText-3DCCO']")).get(1).click();
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println("Unable to locate studio ");
            }//end of studio exception

            //handle exception for location
            try {
                    WebElement lLocation = driver.findElement(By.xpath("//*[@id='location-search']"));
                    lLocation.clear();
                    lLocation.sendKeys(zipCodes.get(i));

            } catch (Exception e) {
                System.out.println("Unable to locate enter location ");
            } //end of location exception

            //handle exception for search arrow
            try {
                driver.findElement(By.xpath("//*[@id='location-search-cta']")).submit();
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println("Unable to locate search arrow ");
            } //end of search arrow exception

            //handle exception for clicking link
            try {
                if (i == 0) {
                    driver.findElement(By.xpath("//*[@href='/us/find-a-workshop/1252089/ww-studio--chelsea-new-york-ny']")).click();
                } else if (i == 1) {
                    driver.findElement(By.xpath("//*[@href='/us/find-a-workshop/1252589/ww-studio--american-legion-queens-forest-hills-ny']")).click();
                }else{
                    driver.findElement(By.xpath("//*[@href='/us/find-a-workshop/1252099/ww-studio--loews-regency-hotel-upper-east-side-new-york-ny']")).click();
                }

            } catch (Exception e) {
                System.out.println("Unable to locate link ");
            }//end of clicking link exception

            //handle exception to capture and print address
            try {
                if (i == 0) {
                    String searchAddress1 = driver.findElement(By.xpath("//*[text()='675 Avenue of the Americas 3rd Floor']")).getText();
                    String searchAddress2 = driver.findElement(By.xpath("//*[text()='NEW YORK, NY 10010']")).getText();
                    System.out.println(searchAddress1 + " " + searchAddress2);
                }else if (i == 1) {
                    String searchAddress1 = driver.findElement(By.xpath("//*[text()='107-15 Metropolitan Avenue']")).getText();
                    String searchAddress2 = driver.findElement(By.xpath("//*[text()='FOREST HILLS, NY 11375']")).getText();
                    System.out.println(searchAddress1 + " " + searchAddress2);
                }else {
                    String searchAddress1 = driver.findElement(By.xpath("//*[text()='540 Park Avenue']")).getText();
                    String searchAddress2 = driver.findElement(By.xpath("//*[text()='NEW YORK, NY 10065']")).getText();
                    System.out.println(searchAddress1 + " " + searchAddress2);
                }

            } catch (Exception e) {
                System.out.println("Unable to locate address");
            } //end of address exception

            //handle exception to scroll
            try {
                //declare a web element variable that we want to scroll into
                WebElement scrollTo = driver.findElement(By.xpath("//*[@id = 'studioWorkshopSchedule']"));

                //scroll into share this calculate button
                jse.executeScript("arguments[0].scrollIntoView(true);", scrollTo);
                Thread.sleep(1000);

            } catch (Exception e) {
                System.out.println("Unable to locate scroll");
            }

            //handle exception to capture entire table
            try {
                String schedule = driver.findElement(By.xpath("//*[@id='virtualWorkshopSchedule']")).getText();
                System.out.println(schedule);

            } catch (Exception e) {
                System.out.println("Unable to locate table");
            } //end of table exception

            System.out.println();

        } //end of for loop

        //quite the driver
        driver.quit();

    } //end of main
} //end of class
