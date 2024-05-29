package Automation_AI08;

import Day13_05142024.TestParent;
import Day14_05202024.ReusableMethods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Humana_HelpChoosePlan extends TestParent {

    @Test
    public static void sfm001_helpChooseAPlan() {
        //navigate to humana homepage
        driver.navigate().to("https://www.humana.com/");
        //hover to insurance plans tab
        ReusableMethods_Loggers.mouseAction(driver, logger, "//*[text()='Insurance Plans']", "Hover to Insurance Plans Tab");
        //click let us help you choose a plan
        ReusableMethods_Loggers.clickByIndex(driver, logger, "//*[text()='Let us help you choose a plan']", 1, "Click Let Us Help You Choose A Plan");
        //switch to plans tab
        ReusableMethods_Loggers.switchToTabByIndex(driver, logger, 1, "Switch to Plans Tab");

        //enter the zipcode
        ReusableMethods_Loggers.sendKeysMethod(driver, logger, "//*[@id='ZIP Code']", "11530", "Enter Zip Code");
        //click get started
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[text()='Get started']", "Click Get Started");
        //select medicare advantage plan
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@id='nucleus-radio-button-7']", "Select Medicare Advantage Plan");
        //click next on plans module
        ReusableMethods_Loggers.clickByIndex(driver, logger, "//*[text()='Next']", 0, "Click Next on Plans Module");
        //select none of these apply to me option
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@id='nucleus-checkbox-16-label']", "Select None of these Apply to Me Option");
        //click next personal info module
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@class='nb-btn nb-btn--primary next']", "Select Next on Tell Us About You Module");
        //select all plan networks
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@id='nucleus-radio-button-18']", "Select I Am Open To All Plan Networks");
        //click next on provider network module
        ReusableMethods_Loggers.clickByIndex(driver, logger, "//*[text()='Next']", 0, "Click Next on Provider Module");
    }//end of test case 1


    @Test(dependsOnMethods = "sfm001_helpChooseAPlan")
    public static void sfm002_addADoctor(){
        //enter doctors name
        ReusableMethods_Loggers.sendKeysMethod(driver, logger, "//*[@class='cobrowse-masked']", "Arielle Freilich", "Enter Doctor's Name");
        //clear the zipcode field
        ReusableMethods_Loggers.clearMethod(driver, logger, "//*[@id='ZIP Code']", "Clear Zipcode Field");
        //enter zipcode
        ReusableMethods_Loggers.sendKeysMethod(driver, logger, "//*[@id='ZIP Code']", "11530", "Enter zipcode");
        //click the distance dropdown
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@class='input-wrapper cobrowse-masked']", "Click Distance Dropdown");
        //click 15 miles option
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@class='cobrowse-masked selected']", "Click 15 Miles");
        //click search button
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@type='submit']", "Click the Search Button on Add a Doctor Module");
        //capture provider info
        String providerInfo = ReusableMethods_Loggers.captureText(driver, logger, "//*[@class='provider-class']", "Capture Provider Info");
        //print provider info
        System.out.println("The Provider Info is: \n" + providerInfo);
        logger.log(LogStatus.INFO,"The Provider Info is: " + providerInfo);

        //click add on add doctor module
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@class='nb-btn nb-btn--secondary']", "Click Add on Add a Doctor Module");
        //click on next step on add another provider module
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[text()='List complete / Next step']", "Click Next Step on Add Another Provider Module");
    }//end of test case 2


    @Test(dependsOnMethods = "sfm002_addADoctor")
    public static void sfm003_addDrugsInfo(){
        //click enter a list of drugs you take now
        ReusableMethods_Loggers.clickByIndex(driver, logger, "//*[@class='is-selection-card nu-p-2 selection-card']", 1, "Click Enter List of Drugs");
        //click next on prescriptions module
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[text()='Next']", "Click Next on Prescriptions Module");

        //enter prescription drug name
        ReusableMethods_Loggers.sendKeysMethod(driver, logger, "//*[@id='Prescription drug name']", "Metformin", "Enter Prescription Drug Name");
        //click the drug name
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@class='cobrowse-masked selected']", "Click the Prescription Drug");
        //click the dosage field
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@class='input-wrapper cobrowse-masked']", "Click the Dosage Field");
        //click the dosage amount 500 mg
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@class='cobrowse-masked selected']", "Click the Dosage Amount, 500mg");

        //clear the quantity field
        ReusableMethods_Loggers.clearMethod(driver, logger, "//*[@id='Quantity']", "Clear the Quantity Field");
        //enter 30 in the quantity field
        ReusableMethods_Loggers.sendKeysMethod(driver, logger, "//*[@id='Quantity']", "30", "Enter Dosage Amount in Quantity Field");
        //click the time period field to open options
        ReusableMethods_Loggers.clickByIndex(driver, logger, "//*[@class='input-wrapper cobrowse-masked']", 1, "Click the Time Period Module");
        //click the month option
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@class='cobrowse-masked selected']", "Click the Month Option");

        //click the refill frequency
        ReusableMethods_Loggers.clickByIndex(driver, logger, "//*[@class='input-wrapper cobrowse-masked']", 2, "Click the Refill Frequency Field");
        //click every 90 days for refill frequency
        ReusableMethods_Loggers.clickByIndex(driver, logger, "//*[@class='cobrowse-masked']", 1, "Click Every 90 Days Refill Frequency");

        //click add to my list
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@class='nb-btn nb-btn--primary']", "Click Add to My List");
        //click list complete/finish
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@class='nb-btn nb-btn--primary next']", "Click List Complete/Finish Button");
        //click yes on popup to share information
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[text()='Yes']", "Click Yes Button on Pop Up to Share Information");
        //close current tab
        driver.close();
    }//end of test case 3

}//end of class
