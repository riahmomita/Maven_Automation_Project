package Automation_AI04;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class WeightWatchers {
    public static void main(String[]args) throws InterruptedException {
        //arraylist to store 3 zipcodes
        ArrayList<String> zipCode = new ArrayList<>();
        //add values to zipcode arraylist
        zipCode.add("11530");
        zipCode.add("11414");
        zipCode.add("10001");

        //declare and define chrome options
        ChromeOptions options = new ChromeOptions();
        //option to maximize screen and go in incognito mode
        options.addArguments("start-maximized", "incognito");
        //declare webdriver and pass chrome options
        WebDriver driver = new ChromeDriver(options);
        //define javascriptexecutor
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //for loop to iterate through all the zipcodes
        for(int i=0; i<zipCode.size(); i++){
            //navigate to weightwatchers.com/find-a-workshop
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            //pause for 2 seconds
            Thread.sleep(2000);

            //click on find a workshop link on top right side
            driver.findElements(By.xpath("//*[text()='Find a Workshop']")).get(0).click();
            //click on in-person link
            driver.findElements(By.xpath("//*[@class='buttonText-0YATk']")).get(0).click();
            //pause for 2 seconds
            Thread.sleep(2000);

            //webelement to store search field property
            WebElement searchField = driver.findElement(By.xpath("//*[@class='input input-L1yX_']"));
            //clear the search field
            searchField.clear();
            //enter the zipcode into the search field
            searchField.sendKeys(zipCode.get(i));

            //click on the search arrow
            driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();
            //pause for 2 seconds
            Thread.sleep(2000);

            //store studio links in an arraylist of webelements
            ArrayList<WebElement> studioLinks = new ArrayList<>(driver.findElements(By.xpath("//*[@class='linkUnderline-XyxpJ']")));

            //if statements to click on studio links based on i in for loop
            if(i==0) {
                //click on second studio link
                studioLinks.get(1).click();
            }else if(i==1){
                //click on the third studio link
                studioLinks.get(2).click();
            }else if(i==2){
                //click on the first studio link
                studioLinks.get(0).click();
            }//end of if-else

            //pause for 2 seconds
            Thread.sleep(2000);

            //capture and store the studio's address in a string variable
            String studioAddress = driver.findElement(By.xpath("//*[@class='address-FnT8k']")).getText();
            //print out the studio address to console
            System.out.println("The studio address is: " + studioAddress);

            //scroll to webelement 'studio workshops schedule (in-person) with jse
            WebElement schedule = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']"));
            jse.executeScript("arguments[0].scrollIntoView(true);", schedule);

            //capture the workshop schedule
            String printSchedule = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']")).getText();
            //print out the workshop schedule to console
            System.out.println("The schedule for " + printSchedule + "\n");
            //pause for 2 seconds
            Thread.sleep(2000);

        }//end of for loop for zipcodes

        //quit the driver
        driver.quit();
    }//end of main
}//end of class
