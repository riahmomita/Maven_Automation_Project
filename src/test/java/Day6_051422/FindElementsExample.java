package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElementsExample {
    public static void main(String[] args) throws InterruptedException {

        //go to bing, click on second element of the links by using class and index

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

        //navigate to bing home
        driver.navigate().to("https://www.bing.com");

        //give time for page to load
        Thread.sleep(3000);

        //click on Images using class property with index of 1
        //to ignore white space in the property calue we can use contains command in xpath
        //use the tag name as well, for this one its li
        driver.findElements(By.xpath("//li[contains(@class,'scope')]")).get(0).click();

    } //end of main
} //end of class
