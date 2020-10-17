package Day6_09192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.*;

public class yahoo_with_findElements {
    public static void main(String[] args) throws InterruptedException {

        //set the chromedriver location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();

        //set the driver to be maximized
        options.addArguments("start-maximized");

        //define the web driver you will be using
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");
        //delay by 2 seconds
        Thread.sleep(2000);

        //store search field locator as webElement so you can reuse locator more than once
        WebElement searchField = driver.findElement(By.xpath("//*[@name='p']"));
        //clear any pre defined value on the field
        searchField.clear();
        //enter your new keyword
        searchField.sendKeys("cars");
        //submit on the same field after the value
        searchField.submit();
    }
}
