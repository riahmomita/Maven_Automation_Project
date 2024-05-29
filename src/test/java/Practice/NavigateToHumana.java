package Practice;

import Day14_05202024.ReusableMethods_Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class NavigateToHumana {
    public static void main(String[]args) throws InterruptedException {

        //declare and define chrome options
        ChromeOptions options = new ChromeOptions();
        //option to start maximized and go in incognito mode
        options.addArguments("start-maximized", "incognito");
        //declare webdriver and pass chrome options
        WebDriver driver = new ChromeDriver(options);

    }//end of main
}//end of class
