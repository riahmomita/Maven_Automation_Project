package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class FedilisCare_Tabs {
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

        //navigate to mortgage calculator
        driver.navigate().to("https://www.fideliscare.org");
        Thread.sleep(3000);

        //click on shop for a plan. Use ...elements because theres 2 instances of shop for plan, and we are only interested in the first one
        driver.findElements(By.xpath("//*[text()='Shop For a Plan']")).get(0).click();
        Thread.sleep(1000);

        //click on Medicaid Managed Care
        driver.findElements(By.xpath("//*[text()='Medicaid Managed Care']")).get(0).click();
        Thread.sleep(1000);

        //click on search under find a doctor
        driver.findElement(By.xpath("//*[@href ='/findadoctor']")).click();
        Thread.sleep(1000);

        //store new tabs in an aarray list, we use getWindowHandles method to get list of tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        //switch to new tab, it should be at index 1
        driver.switchTo().window(tabs.get(1));

        //click on new search button
        driver.findElement(By.xpath("//*[@class='fal fa-search-plus']")).click();

        //wait a bit for the click
        Thread.sleep(1000);

        //close the new tab
        driver.close();

        //switch back to the default tab
        driver.switchTo().window(tabs.get(0));

        //then click on the providers card
        driver.findElement(By.xpath("//*[@class='fal fa-stethoscope fa-fw']")).click();

        //wait until provider card is clicked on
        Thread.sleep(3000);

    } //end of main
} //end of class
