package Automation_AI03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bing {
    public static void main(String[]args) throws InterruptedException {
        //define webdriver and set up the chrome driver
        WebDriver driver = new ChromeDriver();

        //go to bing.com
        driver.navigate().to("https://www.bing.com");

        //pause for 2 seconds
        Thread.sleep(2000);

        //enter kayaking on search field
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("kayaking");

        //submit on search icon
        driver.findElement(By.xpath("//*[@id='search_icon']")).submit();

        //pause for 2 seconds
        Thread.sleep(2000);

        //capture and store the search result message
        String message = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();

        //use split to only display the search number
        String[] messageArray = message.split(" ");
        System.out.println("Search number for kayaking is " + messageArray[1]);

        //click on 'more' tab
        driver.findElement(By.xpath("//*[@id='b-scopeListItem-menu']")).click();

        //click 'mybing' from dropdown menu
        driver.findElement(By.xpath("//*[@id='b-scopeListItem-bingpages']")).click();

        //pause for 2 seconds
        Thread.sleep(2000);

        //capture and print out my profile message
        String profileMessage = driver.findElement(By.xpath("//*[@class='myprofile-see-profile']")).getText();
        System.out.println(profileMessage);

        //quit the driver
        driver.quit();

    }//end of main
}//end of class
