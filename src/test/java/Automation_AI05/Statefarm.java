package Automation_AI05;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Statefarm {
    public static void main(String[]args) throws InterruptedException {
        //declare and define the chrome driver
        ChromeOptions options = new ChromeOptions();
        //option to start browser maximized and in incognito mode
        options.addArguments("start-maximized", "incognito");
        //declare webdriver and pass chromeoptions
        WebDriver driver = new ChromeDriver(options);
        //define javascript executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //arraylist for zipcode
        ArrayList<String> zipCode = new ArrayList<>();
        //arraylist for insurance policy start date
        ArrayList<String> policyStart = new ArrayList<>();
        //arraylist for first name
        ArrayList<String> firstName = new ArrayList<>();
        //arraylist for last name
        ArrayList<String> lastName = new ArrayList<>();
        //arraylist for street address
        ArrayList<String> streetAdd = new ArrayList<>();
        //arraylist for date of birth
        ArrayList<String> dob = new ArrayList<>();
        //arraylist for co-applicants first name
        ArrayList<String> coFirstName = new ArrayList<>();
        //arraylist for co-applicants last name
        ArrayList<String> coLastName = new ArrayList<>();
        //arraylist for fire protection area residence
        ArrayList<String> fireArea = new ArrayList<>();

        //zipcode values
        zipCode.add("11530");
        zipCode.add("11218");

        //policy start date values
        policyStart.add("05/05/2024");
        policyStart.add("05/10/2024");

        //first name values
        firstName.add("Dean");
        firstName.add("Chris");

        //last name values
        lastName.add("Ackles");
        lastName.add("Evans");

        //street address values
        streetAdd.add("43 Nassau Boulevard");
        streetAdd.add("502 East 5th Street");

        //date of birth values
        dob.add("01/23/1983");
        dob.add("06/13/1981");

        //co-applicants first name values
        coFirstName.add("Elizabeth");
        coFirstName.add("Tony");

        //co-applicants last name values
        coLastName.add("Keen");
        coLastName.add("Stark");

        //fire protection area values
        fireArea.add("GARDEN CITY VILLAGE");
        fireArea.add("BROOKLYN");

        //for loop to iterate through all variables
        for(int i=0; i<zipCode.size(); i++){

            //navigate to statefarm.com
            driver.navigate().to("https://www.statefarm.com/");

            //click on Get a Quote from the header tabs
            try{
                driver.findElement(By.xpath("//*[text()='Get a Quote']")).click();
            }catch (Exception e){
                System.out.println("Unable to click on Get a Quote: " + e);
            }//end of get a quote exception
            //pause for 2 seconds
            Thread.sleep(2000);

            //select Homeowners from the product dropdown
            try{
                WebElement homeOwner = driver.findElement(By.xpath("//*[@name='productName']"));
                Select dropdown = new Select(homeOwner);
                dropdown.selectByVisibleText("Homeowners");
            }catch (Exception e){
                System.out.println("Unable to select Homeowner from product dropdown: " + e);
            }//end of select homeowners from dropdown exception

            //enter zipcode by passing zipCode value from arraylist
            try{
                WebElement enterZipCode = driver.findElement(By.xpath("//*[@name='zipCode']"));
                enterZipCode.click();
                enterZipCode.clear();
                enterZipCode.sendKeys(zipCode.get(i));
            }catch (Exception e){
                System.out.println("Unable to enter zipcode: " + e);
            }//end of enter zipcode exception

            //click on Start a quote
            try{
                driver.findElement(By.xpath("//*[@id='quote-submit-button1']")).click();
            }catch (Exception e){
                System.out.println("Unable to click on Start a Quote: " + e);
            }//end of click on start a quote exception
            //pause for 3 seconds
            Thread.sleep(3000);

            //enter the policy start date by passing policyStart value from arraylist
            try{
                WebElement pStartDate = driver.findElement(By.xpath("//*[@id='effectiveDate']"));
                pStartDate.clear();
                pStartDate.sendKeys(policyStart.get(i));
            }catch (Exception e){
                System.out.println("Unable to enter Policy Start Date: " + e);
            }//end of policy start date exception

            //enter the first name by passing firstName value from arraylist
            try{
                driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(firstName.get(i));
            }catch (Exception e){
                System.out.println("Unable to enter First Name: " + e);
            }//end of enter first name exception

            //enter the last name by passing lastName value from arraylist
            try{
                driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(lastName.get(i));
            }catch (Exception e){
                System.out.println("Unable to enter Last Name: " + e);
            }//end of enter last name exception

            //enter the street address by passing streetAdd value from arraylist
            try{
                driver.findElement(By.xpath("//*[@id='street']")).sendKeys(streetAdd.get(i));
            }catch (Exception e){
                System.out.println("Unable to enter Street Address: " + e);
            }//end of enter street address

            //enter the date of birth by passing dob value from arraylist
            try{
                driver.findElement(By.xpath("//*[@id='dateOfBirth']")).sendKeys(dob.get(i));
            }catch (Exception e){
                System.out.println("Unable to enter Date of Birth: " + e);
            }//end of enter date of birth exception
            //pause for 3 seconds
            Thread.sleep(3000);

            //scroll into view of continue button on Welcome Homeowners browser
            try{
                WebElement continueButton = driver.findElement(By.xpath("//*[@id='continue']"));
                jse.executeScript("arguments[0].scrollIntoView(true);", continueButton);
            }catch (Exception e){
                System.out.println("Unable to scroll to Continue button" + e);
            }//end of scroll to continue button exception
            //pause for 2 seconds
            Thread.sleep(2000);

            //click on continue button twice on Welcome Homeowners webpage
            try{
                WebElement cContinue = driver.findElement(By.xpath("//*[@name='continue']"));
                cContinue.click();
                cContinue.click();
            }catch (Exception e){
                System.out.println("Unable to click on Continue Button on Welcome Homeowners webpage: " + e);
            }//end of click on continue button exception
            //pause for 3 seconds
            Thread.sleep(3000);

            //select value for Fire Protection from the dropdown
            try{
                WebElement fireProtection = driver.findElement(By.xpath("//*[@id='fireProtectionAreaNameSelectId']"));
                Select dropDown = new Select(fireProtection);
                dropDown.selectByVisibleText(fireArea.get(i));
            }catch (Exception e){
                System.out.println("Unable to select value for Fire Protection: " + e);
            }//end of select value for fire protection from dropdown exception

            //click on continue button on More Details About Your Location webpage
            try{
                driver.findElement(By.xpath("//*[@name='continue']")).click();
            }catch (Exception e){
                System.out.println("Unable to click on continue button on More Details About Your Location webpage: " + e);
            }//end of click on continue button exception
            //pause for 2 seconds
            Thread.sleep(2000);

            //capture personal info message and print it out
            try{
                String personalInfo = driver.findElement(By.xpath("//*[@id='personalInfoPageTitle']")).getText();
                System.out.println("The Personal Info message is: \n" + personalInfo);
            }catch (Exception e){
                System.out.println("Unable to capture and print out Person Info message: " + e);
            }//end of personal info message exception

            //capture email info messages and print it out
            try{
              String emailInfo = driver.findElement(By.xpath("//*[@id='emailAddress']")).getText();
              System.out.println("The Email Info message is: \n" + emailInfo);
            }catch (Exception e){
                System.out.println("Unable to capture and print out Email Info message: " + e);
            }//end of capture email info messages exception

            //capture add an applicant info message and print it out
            try{
                String addApplicant = driver.findElement(By.xpath("//*[@id='addApplicantDescription']")).getText();
                System.out.println("The Add an Applicant info message is: \n" + addApplicant);
            }catch (Exception e){
                System.out.println("Unable to capture and out Add an Applicant info message: " + e);
            }//end of add an applicant info message exception
            //pause for 1.5 seconds
            Thread.sleep(1500);

            //click on Add Co Applicant
            try{
                driver.findElement(By.xpath("//*[text()='Add an applicant']")).click();
            }catch (Exception e){
                System.out.println("Unable to click on Add Co Applicant: " + e);
            }//end of click on add co applicant exception

            //enter co-applicants first name
            try {
                driver.findElement(By.xpath("//*[@name='additionalApplicants[0].client.firstName']")).sendKeys(coFirstName.get(i));
            }catch (Exception e){
                System.out.println("Unable to enter Co-Applicant First Name: " + e);
            }//end of enter co-applicants first name exception

            //enter co-applicants last name
            try{
                driver.findElement(By.xpath("//*[@name='additionalApplicants[0].client.lastName']")).sendKeys(coLastName.get(i));
            }catch (Exception e){
                System.out.println("Unable to enter Co-Applicant Last Name: " + e);
            }//end of enter co-applicant's last name exception
            //pause for 1.5 seconds
            Thread.sleep(1500);

            //scroll to and click on continue button on Person Info webpage
            try{
                WebElement scrollContinue = driver.findElement(By.xpath("//*[text()=' Continue']"));
                jse.executeScript("arguments[0].scrollIntoView(true);", scrollContinue);
                Thread.sleep(2000);
                scrollContinue.click();
            }catch (Exception e){
                System.out.println("Unable to click on Continue Button on Personal Info webpage: " + e);
            }//end of click on continue button exception
            //pause for 3 seconds
            Thread.sleep(3000);

            //capture the error message and print it to console
            try{
                String errorMessage = driver.findElement(By.xpath("//*[@class='alert error alert-error']")).getText();
                System.out.println("Error message is: \n" + errorMessage);
            }catch (Exception e){
                System.out.println("Unable to capture and print Error Message: " + e);
            }//end of capture and print out error message exception
            //pause for 2 seconds
            Thread.sleep(2000);
        }//end of for loop
        //pause for 2 seconds
        Thread.sleep(2000);


        //quit the driver
        driver.quit();

    }//end of main
}//end of class
