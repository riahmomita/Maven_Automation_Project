package Day4_050722;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver();

        //go to Google home page
        driver.navigate().to("https://www.google.com");

        //navigate to site and pause it for 3 seconds so everything loads
        Thread.sleep(3000);

        //maximize the driver. if you want fullscreen use window().fullScreen();
        driver.manage().window().maximize();

        //locate element for search field and type keyword 'cars' (This is use case)
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");

        //submite on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

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
