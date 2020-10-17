package Day9_09272020;

import Day3_09062020.Reusable_Method;
import Reusable_Library.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethod_AppleSite {
    public static void main(String[] args) {

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

        //navigate to your website
        driver.navigate().to("https://www.apple.com");

        //calling the reusable click method for clicking on mac link
        Reusable_Methods.click(driver, "//*[@data-analytics-title='mac']","Mac Link");

        //click on mac book air
        Reusable_Methods.click(driver, "//*[text()='MacBook Air']","Mac Book Air");

        //click on search icon
        Reusable_Methods.click(driver, "//*[@id='ac-gn-link-search']","Search Icon");

        //entering a keyword on search field
        Reusable_Methods.sendKeys(driver, "//*[@placeholder='Search apple.com']","iphone","Search Field");

        //click on submit
        Reusable_Methods.submit(driver, "//*[@placeholder='Search apple.com']","Search Field");



    }//end of main method
}//end of java class
