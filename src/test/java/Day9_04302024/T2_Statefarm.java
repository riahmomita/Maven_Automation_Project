//this assignment was continued and finished on Automation_AI05

package Day9_04302024;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T2_Statefarm {
    public static void main(String[] args) throws InterruptedException {
        //declare and define the chrome driver
        ChromeOptions options = new ChromeOptions();
        //add option to start it maximized
        options.addArguments("start-maximized", "incognito");
        //declare webdriver and pass chrome options
        WebDriver driver = new ChromeDriver(options);
        //define javascript executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //navigate to statefarm
        driver.navigate().to("https://www.statefarm.com/");
        //pause for 2 seconds
        Thread.sleep(2000);

        //click on get a quote
            driver.findElement(By.xpath("//*[text()='Get a Quote']")).click();

        //select HomeOwners from Product dropdown
            WebElement homeOwner = driver.findElement(By.xpath("//*[@name='productName']"));
            Select dropdown = new Select(homeOwner);
            dropdown.selectByVisibleText("Homeowners");

        //enter zipcode
            driver.findElement(By.xpath("//*[@name='zipCode']")).sendKeys("11530");

        //click Start a quote
            driver.findElement(By.xpath("//*[@id='quote-submit-button1']")).click();

        //pause for 2 seconds
        Thread.sleep(2000);

        //enter the policy start date by passing policyStart value from arraylist
        WebElement pStartDate = driver.findElement(By.xpath("//*[@id='effectiveDate']"));
        pStartDate.clear();
        pStartDate.sendKeys("05/03/2024");

        //enter the first name by passing firstName value from arraylist
        driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Damien");

        //enter the last name by passing lastName value from arraylist
        driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Salvatore");

        //enter the street address by passing streetAdd value from arraylist
         driver.findElement(By.xpath("//*[@id='street']")).sendKeys("43 Nassau Boulevard");

        //enter the date of birth by passing dob value from arraylist
        driver.findElement(By.xpath("//*[@id='dateOfBirth']")).sendKeys("04/23/1980");

        //pause for 3 seconds
        Thread.sleep(3000);

        //scroll into view of continue button on Welcome Homeowners browser
         WebElement continueButton = driver.findElement(By.xpath("//*[@id='continue']"));
         jse.executeScript("arguments[0].scrollIntoView(true);", continueButton);

        //pause for 2 seconds
        Thread.sleep(2000);

        //click on continue button twice on Welcome Homeowners webpage
            WebElement cContinue = driver.findElement(By.xpath("//*[@name='continue']"));
            cContinue.click();
            cContinue.click();


//        //pause for 2 seconds
//        Thread.sleep(2000);
//        //quit the driver
//        driver.quit();

    }//end of main
}//end of class
