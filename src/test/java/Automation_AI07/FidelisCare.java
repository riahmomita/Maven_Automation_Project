package Automation_AI07;

import Day11_05072024.ReusableMethods;
import Day13_05142024.TestParent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FidelisCare extends TestParent {

    @Test(priority = 1)
    public static void tc01_searchForCareMember(){
        //navigate to fideliscare homepage
        driver.navigate().to("https://www.fideliscare.org/");

        //click on search element on top right
        ReusableMethods.clickMethod(driver, "//*[@class='fal fa-search']", "Click Search Element");
        //enter fidelis care member on search field
        ReusableMethods.sendKeysMethod(driver, "//*[@class='form-control search-input']", "Fidelis Care Member", "Enter value on Search Field");
        //click on search icon
        ReusableMethods.clickMethod(driver, "//*[@class='input-group-btn']", "Click Search Icon");

        //capture the search result
        String searchResult = ReusableMethods.captureText(driver, "//*[@id='resInfo-0']", "Capture Search Result");
        //split search result and only retain the number
        String[] searchResultArray = searchResult.split(" ");
        //print the number value to the console
        System.out.println("The search number is: " + searchResultArray[1]);

        //click on fidelis care memebers link
        ReusableMethods.clickMethod(driver, "//*[text()='Fidelis Care Members']", "Click Fidelis Care Member Link");
    }//end of test case 1


    @Test(dependsOnMethods = "tc01_searchForCareMember")
    public static void tc02_renewCoverage() throws InterruptedException {
        //switch to fidelis care member tab
        ReusableMethods.switchToTabByIndex(driver, 1, "Switch to Care Member Tab");
        //click renew help
        ReusableMethods.clickByIndex(driver, "//*[@class='btn btn-outline-primary btn-show']", 2, "Click Renew Help");

        //pause for 2 seconds
        Thread.sleep(2000);
        //scroll down to renew coverage
        ReusableMethods.scrollByPixel(driver, 0, 400, "Scroll by Pixel");

        //click when to renew coverage
        ReusableMethods.clickByIndex(driver, "//*[@class='accordion-title']", 0, "Click When to Renew Coverage");
        //capture the text and print to console
        String whenToRenew = ReusableMethods.captureText(driver, "//*[@style='display: block;']", "Capture When to Renew Coverage");
        System.out.println("\nWhen to Renew Coverage Message: " + whenToRenew);
        //close the renew coverage dropdown
        ReusableMethods.clickByIndex(driver, "//*[@class='accordion-title']", 0, "Click to close When to Renew Coverage");

        //click information needed to renew coverage
        ReusableMethods.clickByIndex(driver, "//*[@class='accordion-title']", 1, "Click Information Needed To Renew");
        //pause for 2 seconds
        Thread.sleep(2000);
        //capture the text and print to console
        String infoToRenew = ReusableMethods.captureText(driver, "//*[@style='display: block;']", "Capture Information to Renew Coverage");
        System.out.println("\nInformation Needed to Renew Coverage Message: " + infoToRenew);
        //pause for 2 seconds
        Thread.sleep(2000);

        //close current tab
        driver.close();
    }//end of test case 2

    @Test(dependsOnMethods = "tc02_renewCoverage")
    public static void tc03_memberLogin() throws InterruptedException {
        //switch back to default tab
        ReusableMethods.switchToTabByIndex(driver, 0, "Switch to Default Tab");

        //click login
        ReusableMethods.clickMethod(driver, "//*[@class='tool dropdown login']", "Click Login");
        //click member online portal
        ReusableMethods.clickMethod(driver, "//*[@class='link-external']", "Click Member Portal");

        //switch to members portal tab
        ReusableMethods.switchToTabByIndex(driver, 1, "Switch to Member Portal Tab");

        //capture the helpful hints body text and print to console
        String helpfulHints = ReusableMethods.captureTextByIndex(driver, "//*[@class='flex mb-6']", 2, "Capture Helpful Hints");
        System.out.println("\nHelpful Hints Message: " + helpfulHints);
        //pause for 2 seconds
        Thread.sleep(2000);

        //close the current tab
        driver.close();
    }//end of test case 3

}//end of class




