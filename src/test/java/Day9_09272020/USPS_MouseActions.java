package Day9_09272020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class USPS_MouseActions {
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

        driver.navigate().to("https://www.usps.com");

        //pause after going to website
        Thread.sleep(2000);

        //declare your mouse action command
        Actions actions = new Actions(driver);

        //move your mouse to quick tools to open the dropdown
        WebElement quickTools = driver.findElement(By.xpath("//*[text()='Quick Tools']"));
        actions.moveToElement(quickTools).perform();

        //click on track a package using actions
        WebElement trackPackage = driver.findElement(By.xpath("//*[text()='Track a Package']"));
        actions.moveToElement(trackPackage).click().perform();
        Thread.sleep(2000);

        //enter a tracking number
        WebElement trackingNumber = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        trackingNumber.sendKeys("463134657533");

        /* to submit on to something you can use either of these commands:
        driver.findElement(By.xpath("")).submit();

        */
    }//end of main method
}//end of java class
