package Day9_04302024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_Exception {
    public static void main(String[] args) throws InterruptedException {
        //go on mlcacl, select purchase price, downpayments, click advanced option and then drop down for
        //start month and year

        //declare and define the chrome driver
        ChromeOptions options = new ChromeOptions();
        //add option to start it maximized
        options.addArguments("start-maximized", "incognito");
        //declare webdriver and pass chrome options
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calculator
        driver.navigate().to("https://www.mlcalc.com/");
        //pause for 2 seconds
        Thread.sleep(2000);

        //enter the purchase price
        try{
            WebElement pPrice = driver.findElement(By.xpath("//*[@id='ma']"));
            pPrice.clear();
            pPrice.sendKeys("350000");
        }catch (Exception e){
            System.out.println("Unable to enter value of Purchase Price: " + e);
        }//end of purchase price exception

        //enter down payment
        try{
            WebElement dPayment = driver.findElement(By.xpath("//*[@id='dp']"));
            dPayment.clear();
            dPayment.sendKeys("10");
        }catch (Exception e){
            System.out.println("Unable to enter value of Down Payment: " + e);
        }//end of down payment exception

        //click on show advanced options
        try{
            driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();
        }catch (Exception e){
            System.out.println("Unable to click on Show advanced options: " + e);
        }//end of down payment exception

        //select June from the start month option
        try{
            WebElement homeOwner = driver.findElement(By.xpath("//*[@name='sm']"));
            Select dropdown = new Select(homeOwner);
            dropdown.selectByVisibleText("Jun");
        }catch (Exception e){
            System.out.println("Unable to select a value from Start Month dropdown " + e);
        }//end of start month drop down exception

    }//end of main
}//end of class
