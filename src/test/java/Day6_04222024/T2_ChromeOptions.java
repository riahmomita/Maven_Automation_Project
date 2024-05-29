package Day6_04222024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_ChromeOptions {
    public static void main(String[]args){

        //declare and define chrome options
        ChromeOptions options = new ChromeOptions();

        //add option to start it maximized
        options.addArguments("start-maximized", "incognito");

//      //to run it headless
//      options.addArguments("headless");

        //declare webdriver and pass chrome options
        WebDriver driver = new ChromeDriver(options);

        //go to yahoo.com
        driver.navigate().to("https://www.yahoo.com/");

        String headerText = driver.findElement(By.xpath("//*[@class = '_yb_jujrfs _yb_126z4i9 _yb_w5chp0 _yb_r25x6s']")).getText();

        //print header to console
        System.out.println("Header is " + headerText);

        //quit the browser
        driver.quit();

    }//end of main
}//end of class
