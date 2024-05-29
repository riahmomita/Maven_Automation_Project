package Day11_05072024;

import org.openqa.selenium.WebDriver;
import static Day11_05072024.ReusableMethods.setupChromeDriver;

public class T1_GoogleReusable {
    public static void main(String[] args) {
        //define the webdriver variable and set up the chrome driver through ResuableMethods
        WebDriver driver = setupChromeDriver();
        //go to google.com
        driver.navigate().to("https://www.google.com");
        //search for cars through sendkeys method from reusable methods
        ReusableMethods.sendKeysMethod(driver, "//*[@name = 'q']", "bmw", "Google Search");
        //submit using reusable methods
        ReusableMethods.submitMethod(driver, "//*[@name = 'btnK']", "Submit Button");
        // click on the tools button
        ReusableMethods.clickMethod(driver,"//*[@id = 'hdtb-tls']","Tools Button");
        //store the search result into a string variable
        String searchResult = ReusableMethods.captureText(driver,"//*[@id = 'result-stats']", "Search Result" );
        //print out the result stats
        System.out.println("Search Result is " + searchResult);
        //quit the chrome browser
        driver.quit();
    }//end of main
}//end of class
