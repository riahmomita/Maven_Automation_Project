package Day8_04292024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_SelectMethod {
    public static void main(String[] args) throws InterruptedException {
        //select start month from the dropdown on mortgage calculator website

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

        //select a start month from the start month dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));

        //call the select function to select the start month
        Select startMonthDropdown = new Select(startMonth);
        //select May by visible text
        startMonthDropdown.selectByVisibleText("May");

//      //select May by index
//      startMonthDropdown.selectByIndex(4);

//      //select May by value
//      startMonthDropdown.selectByValue("5");

        //pause for 2 seconds
        Thread.sleep(2000);
        //quit the driver
        driver.quit();
    }//end of main
}//end of class
