package Day4_04152024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[]args) throws InterruptedException {

        //define the webdriver
        WebDriver driver = new ChromeDriver();

        //navigate to googlepage
        driver.navigate().to("https://www.google.com");

        //maximize the chrome window
        driver.manage().window().maximize();

        //pause the code for 3 secs
        Thread.sleep(3000);

        //quit the chrome browser
        driver.quit();

    }//end of main
}//end of class
