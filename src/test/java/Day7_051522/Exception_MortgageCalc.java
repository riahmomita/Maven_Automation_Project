package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Exception_MortgageCalc {
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
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);

        //handle exception for home value
        try{
            WebElement homeVal = driver.findElement(By.xpath("//*[@id='homeval']"));
            homeVal.clear();
            homeVal.sendKeys("450000");
        }catch(Exception e){
            //print out the exeception
            System.out.println("Unable to locate home value " + e);
        } //end of home value exception

        //handle exception for start month drop fown
        try{
            WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
            Select dropdown = new Select(startMonth);
            dropdown.selectByVisibleText("Jun");
        }catch(Exception e){
            //print out the exeception
            System.out.println("Unable to locate Start Month dropdown" + e);
        } //end of home value exception

        //handle exception for calculate button
        try{
            driver.findElement(By.xpath("//*[@value='Calculate']")).click();
        }catch(Exception e){
            //print out the exeception
            System.out.println("Unable to locate calculate button " + e);
        } //end of calculate exception

    } //end of main
} //end of class
