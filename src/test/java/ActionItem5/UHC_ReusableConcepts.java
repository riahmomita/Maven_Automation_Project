package ActionItem5;

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class UHC_ReusableConcepts {
    public static void main(String[] args) throws InterruptedException {

        //array for first names
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("John");
        firstName.add("Harry");
        firstName.add("Ron");

        //array for last names
        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Doe");
        lastName.add("Potter");
        lastName.add("Weasley");

        //aray for birth month
        ArrayList<String> birthMonth = new ArrayList<>();
        birthMonth.add("March");
        birthMonth.add("July");
        birthMonth.add("October");

        //array for birth day
        ArrayList<String> birthDay = new ArrayList<>();
        birthDay.add("23");
        birthDay.add("31");
        birthDay.add("5");

        //array for birth year
        ArrayList<String> birthYear = new ArrayList<>();
        birthYear.add("1988");
        birthYear.add("1986");
        birthYear.add("1990");

        //array for zip codes
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("10001");
        zipCode.add("11414");
        zipCode.add("11218");

        //array for health memeber id
        ArrayList<String> memberId = new ArrayList<>();
        memberId.add("334568");
        memberId.add("637385");
        memberId.add("923495");

        //setting the local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

        //for loop to iterate through uhc.com and register for medicare plan
        for(int i = 0; i < firstName.size(); i++) {
            //go to www.uhc.com
            driver.navigate().to("https://www.uhc.com");

            //verify homepage contains title Health Insurance Plans
            Reusable_Actions.verifyTitle(driver, "Health insurance plans");

            //click on find a doctor
            Reusable_Actions.clickAction(driver, "//*[@aria-label= 'Find a doctor']", "Find a Doctor");

            //click on sign in
            Reusable_Actions.clickAction(driver, "//*[@class= 'mr-4']", "Sign In");

            //click on medicare plan
            Reusable_Actions.clickAction(driver, "//span[text()= 'Medicare plan?']", "Medicare Plan");

            //switch to new tab
            Reusable_Actions.switchToTabByIndex(driver, 1);

            //click on register now
            Reusable_Actions.clickByIndexAction(driver, "//*[@ng-if='!registrationCTA']", 3, "Register Now");

            //enter first name
            Reusable_Actions.sendKeysAction(driver, "//*[@id='firstName']", firstName.get(i), "First Name");

            //enter last name
            Reusable_Actions.sendKeysAction(driver, "//*[@id='lastName']", lastName.get(i), "Last Name");

            //select birth month
            Reusable_Actions.selectByText(driver, "//*[@name='dob_month']", birthMonth.get(i), "Birth Month");

            //enter birth day
            Reusable_Actions.sendKeysAction(driver, "//*[@id='dob_day']", birthDay.get(i), "Birth Day");

            //enter birth year
            Reusable_Actions.sendKeysAction(driver, "//*[@id='dob_year']", birthYear.get(i), "Birth Year");

            //enter zip code
            Reusable_Actions.sendKeysAction(driver, "//*[@id='zipCode']", zipCode.get(i), "Zipcode");

            //enter member id
            Reusable_Actions.sendKeysAction(driver, "//*[@id='memberId']", memberId.get(i), "Member ID");

            //click continue
            Reusable_Actions.clickAction(driver, "//*[@id='submitBtn']", "Continue Button");

            //capture error
            String result = Reusable_Actions.getTextAction(driver, "//*[@id='plainText_error']", "Error Code");
            System.out.println("Message: " + result);

            //close the driver
            driver.close();

            //switch back to default tab
            Reusable_Actions.switchToTabByIndex(driver, 0);

        } //end of for loop

        //quit the driver
        driver.quit();
    } //end of main
} //end of class
