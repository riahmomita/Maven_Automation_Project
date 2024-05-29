package Day6_04222024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T4_XPathContainsFindElements {
    public static void main(String[] args) throws InterruptedException {
        //declare and define chrome options
        ChromeOptions options = new ChromeOptions();

        //add option to start it maximized
        options.addArguments("start-maximized", "incognito");

        //declare webdriver and pass chrome options
        WebDriver driver = new ChromeDriver(options);

        //go to yahoo.com
        driver.navigate().to("https://www.yahoo.com/");

        //click on the finance header
        driver.findElements(By.xpath("//*[contains(@class,'_yb_jujrfs')]")).get(1).click();

        //wait for 2 seconds
        Thread.sleep(2000);

        //quit the browser
        driver.quit();

    }//end of main
}//end of class
