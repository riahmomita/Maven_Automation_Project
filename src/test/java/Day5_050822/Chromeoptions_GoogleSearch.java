package Day5_050822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chromeoptions_GoogleSearch {
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

        //setting your driver as headless (running on background)
        //options.addArguments("headless");

        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

        //go to Google home page
        driver.navigate().to("https://www.google.com");

        //navigate to site and pause it for 3 seconds so everything loads
        Thread.sleep(3000);

        //maximize the driver. if you want fullscreen use window().fullScreen();
        //don't need to use this with chromeoptions
        //driver.manage().window().maximize();

        //locate element for search field and type keyword 'cars' (This is use case)
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");

        //submite on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        Thread.sleep(2500);

        //capture the google search result and store it in a string and print it
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //System.out.println("Result is " + searchResult);

        //extract the number from the result and print that only using split
        String[] arrayResult = searchResult.split(" ");
        System.out.println("My search number is " + arrayResult[1]);

        //quite the driver
        driver.quit();

    } //end of main
} //end of class
