package Automation_AI08;

import Day13_05142024.TestParent;
import Day14_05202024.ReusableMethods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class HumanaForEmployers extends TestParent {

    @Test
    public static void heb001_employersBenefits() {
        //navigate to humana homepage
        driver.navigate().to("https://www.humana.com/");
        //click on more humana on top left tab
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@class='more-humana-text']", "Click More Humana Button");
        //click for employers button
        ReusableMethods_Loggers.clickByIndex(driver, logger, "//*[@class='nc-link nb-link--link header-v3-secondary-link nu-d-flex']", 1, "Click For Employers Button");
        //switch to new tab
        ReusableMethods_Loggers.switchToTabByIndex(driver, logger, 1, "Switch To Employers Tab");

        //click on dental plan
        ReusableMethods_Loggers.clickByIndex(driver, logger, "//*[@href='/employer/dental-plans']", 1, "Click on Dental Plan Button");
        //capture dental plan key benefits
        String keyBenefits = ReusableMethods_Loggers.captureTextByIndex(driver, logger, "//*[@class='category-content-cta-column-span col-12 col-sm-12 col-md-4']", 0, "Capture Key Benefits Text");
        //print key benefits
        System.out.println("Plan Key Benefits: \n" + keyBenefits);
        logger.log(LogStatus.INFO,"Plan Key Benefits: " + keyBenefits);
        //capture access to care message
        String accessToCare = ReusableMethods_Loggers.captureTextByIndex(driver, logger, "//*[@class='category-content-cta-column-span col-12 col-sm-12 col-md-4']", 2, "Capture Key Benefits Text");
        //print access to care message
        System.out.println("\nAccess To Care Message: \n" + accessToCare);
        logger.log(LogStatus.INFO,"Access To Care Message: " + accessToCare);
    }//end of test case 1


    @Test(dependsOnMethods = "heb001_employersBenefits")
    public static void heb002_dentalPlan() {
        //scroll to plans
        ReusableMethods_Loggers.scrollByView(driver, logger, "//*[@class='nb-paragraph']", "Scroll to Plans");
        //capture the plan highlights
        String planHighlights = ReusableMethods_Loggers.captureTextByIndex(driver, logger, "//*[@class='core-table-b-s-cell-content']", 6, "Capture Plan Highlights");
        //print the plan highlights to console
        System.out.println("\nPlan Highlights: \n" + planHighlights);
        logger.log(LogStatus.INFO,"Plan Highlights: " + planHighlights);

        //click on learn more about preventive plus
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[text()='Learn more about Preventive Plus']", "Click Learn More About Preventive Plus Button");
        //click how it works button
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[text()='How it works']", "Click How It Works Button");
        //click dental ppo button
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[text()='Dental PPO']", "Click Dental PPO Button");
        //capture dental ppo info
        String dentalPPO = ReusableMethods_Loggers.captureText(driver, logger, "//*[@class='page-details-tabs core-tabs-hz-iP core-tabs-hz-iP-no-touch']", "Capture Dental PPO Information");
        //print dental ppo info to console
        System.out.println("\nDental PPO Information: \n" + dentalPPO);
        logger.log(LogStatus.INFO,"Dental PPO Information: " + dentalPPO);

        //hover over employer products tab
        ReusableMethods_Loggers.mouseAction(driver, logger, "//*[text()='Employer Products']", "Hover over Employer Products Tab");
        //click register now
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[text()='Register now']", "Click Register Now Button");
    }//end of test case 2


    @Test(dependsOnMethods = "heb002_dentalPlan")
    public static void heb003_employerRegistration() {
        //click 'I am a' field
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@name='UserType']", "Click I Am A Field");
        //click employers option
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[text()='Employer']", "Click Employers Option");
        //click start activation now
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[text()='Start activation now']", "Click Start Activation Now");

        //enter group number
        ReusableMethods_Loggers.sendKeysMethod(driver, logger, "//*[@name='GroupNumber']", "000135", "Enter Group Number");
        //enter zipcode
        ReusableMethods_Loggers.sendKeysMethod(driver, logger, "//*[@name='ZipCode']", "11530", "Enter Zip Code");
        //enter tax identification number
        ReusableMethods_Loggers.sendKeysMethod(driver, logger, "//*[@name='TaxIdNumber']", "123456789", "Enter Tax Identification Number");
        //click activate button
        ReusableMethods_Loggers.clickMethod(driver, logger, "//*[@class='adj-button-primary adj-button-primary-has-icon']", "Click Activate Button");
        //close the browser
        driver.close();
    }//end of test case 3


}//end of class
