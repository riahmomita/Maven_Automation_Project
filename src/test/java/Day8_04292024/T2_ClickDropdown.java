package Day8_04292024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class T2_ClickDropdown {
    public static void main(String[] args) throws InterruptedException {
        //click on dropdown by click on the dropdown and select option by its xpath text

        //declare and define the chrome driver
        ChromeOptions options = new ChromeOptions();
        //add option to start it maximized
        options.addArguments("start-maximized", "incognito");
        //declare webdriver and pass chrome options
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calculator
        driver.navigate().to("https://www.mortgagecalculator.org");
        //pause for 2 seconds
        Thread.sleep(2000);

        //enter the home value
        driver.findElement(By.xpath("//*[@id='homeval']")).sendKeys("450000");
        //enter down payment
        driver.findElement(By.xpath("//*[@id='downpayment']")).sendKeys("100000");
        //click on start month drop down
        driver.findElement(By.xpath("//*[@name='param[start_month]']")).click();
        //click on dropdown value by using xpath text()
        driver.findElement(By.xpath("//*[text()='May']")).click();

        //pause for 2 seconds
        Thread.sleep(2000);
        //quit the driver
        driver.quit();
    }//end of main
}//end of class
