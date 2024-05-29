package Automation_AI06;

import Day11_05072024.ReusableMethods;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import static Day11_05072024.ReusableMethods.setupChromeDriver;

public class WeightWatchersReusable {
    public static void main(String[]args) throws InterruptedException {
        //define the webdriver variable and set up the chrome driver through ResuableMethods
        WebDriver driver = setupChromeDriver();

        //arraylist to store 3 zipcodes
        ArrayList<String> zipCode = new ArrayList<>();
        //add values to zipcode arraylist
        zipCode.add("11530");
        zipCode.add("11414");
        zipCode.add("10001");


        //for loop to iterate through all the zipcodes
        for(int i=0; i<zipCode.size(); i++){
            //navigate to weightwatchers.com/find-a-workshop
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

            //click on find a workshop link on top right side
            ReusableMethods.clickMethod(driver, "//*[text()='Find a Workshop']", "Click Find a Workshop");
            //click on in-person link
            ReusableMethods.clickMethod(driver, "//*[@class='buttonText-0YATk']", "Click on In Person");
            //enter the zipcode
            ReusableMethods.sendKeysMethod(driver, "//*[@class='input input-L1yX_']", zipCode.get(i), "Enter Zipcode");
            //click on the search arrow
            ReusableMethods.clickMethod(driver, "//*[@id='location-search-cta']", "Click Search Arrow");


            //if statements to click on studio links based on i in for loop and send index number
            if(i==0){
                ReusableMethods.clickByIndex(driver, "//*[@class='linkUnderline-XyxpJ']", 1, "Click Second Link");
            }else if(i==1){
                ReusableMethods.clickByIndex(driver, "//*[@class='linkUnderline-XyxpJ']", 2, "Click Third Link");
            }else if(i==2){
                ReusableMethods.clickByIndex(driver, "//*[@class='linkUnderline-XyxpJ']", 0, "Click First Link");
            }//end of if-else

            //capture and store the studio's address in a string variable
            String studioAddress = ReusableMethods.captureText(driver, "//*[@class='address-FnT8k']", "Capture Address");
            //print out the studio address to console
            System.out.println("The studio address is: " + studioAddress);

            //scroll to webelement 'studio workshops schedule (in-person) with jse
            ReusableMethods.scrollByView(driver, "//*[@id='studioWorkshopSchedule']", "Scroll To Workshop Schedule");

            //capture the workshop schedule
            String printSchedule = ReusableMethods.captureText(driver, "//*[@id='studioWorkshopSchedule']", "Capture Workshop Schedule");
            //print out the workshop schedule to console
            System.out.println("The schedule for " + printSchedule + "\n");
            //pause for 1 seconds
            Thread.sleep(1000);

        }//end of for loop for zipcodes

        //quit the driver
        driver.quit();
    }//end of main
}//end of class
