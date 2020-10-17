package Day8_09262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class metlife_switchtabs {
    public static void main(String[] args) throws InterruptedException {
        //set the chromedriver location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();

        //set the driver to be maximized
        options.addArguments("start-maximized");

        //set the driver to be incognito
        options.addArguments("incognito");

        //define the web driver you will be using
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.metlife.com");

        //pause after going to website
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@aria-label='SOLUTIONS']")).click();
        Thread.sleep(1500);

        //click on take along dental link
        //dont use @ for text
        driver.findElement(By.xpath("//*[text()='MetLife TakeAlong Dental']")).click();
        Thread.sleep(1500);

        //click on enroll now button
        //use contains when you want to match a unique keyword or want to ignore whitespace
        driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();

        //need to store get windows handles command in an ArrayList to switch to different tabs
        //must be called everytime after opening a new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        //switch to second tab
        driver.switchTo().window(tabs.get(1));

        //enter the zipcode
        driver.findElement(By.xpath("//*[@name='txtZipCode']")).sendKeys("11218");
        Thread.sleep(1500);

        //close the current tab. Do not use the driver.quit function which closes all tabs
        driver.close();

        //switch back to previous tab
        driver.switchTo().window(tabs.get(0));

        //navigate back to metlife
        driver.navigate().to("https://metlife.com");


    }//end of main method
}//end of java class
