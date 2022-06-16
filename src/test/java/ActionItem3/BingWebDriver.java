package ActionItem3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class BingWebDriver {
    public static void main(String[] args) throws InterruptedException {

        //setting up chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();

        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();

        //set condition to incognito mode
        options.addArguments("incognito");

        //condition to maximize the driver
        options.addArguments("start-maximized");

        //defining the webdriver thats being used
        WebDriver driver = new ChromeDriver(options);

        //using arraylist and for loop to search and print the list of hobbies
        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("Swimming");
        hobbies.add("Dancing");
        hobbies.add("Rollerblading");
        hobbies.add("Skiing");
        hobbies.add("Badminton");

        //for loop to continuously search and print the result for the hobbies in the arraylist
        for(int i = 0; i < hobbies.size(); i++) {

            //go to bing homepage
            driver.navigate().to("https://www.bing.com");

            //navigate to site and pause for 3 seconds so everything can load
            Thread.sleep(3000);

            //locate element for search field and send they array as the key
            driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys(hobbies.get(i));

            //submit on bing search button
            driver.findElement(By.xpath("//*[@id='search_icon']")).submit();

            //pause for 2.5 seconds to let each result load
            Thread.sleep(2500);

            //capture the bing search result, store it in a string and print it
            String searchResult = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();

            //extract the number from the result and print that only using split
            String[] arrayResult = searchResult.split(" ");
            System.out.println("My search number for hobby " + hobbies.get(i) + " is " + arrayResult[0]);


        } //end of for loop

        //quit the driver
        driver.quit();

    } //end of main
} //end of class
