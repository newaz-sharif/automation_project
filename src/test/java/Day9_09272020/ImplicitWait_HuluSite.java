package Day9_09272020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ImplicitWait_HuluSite {
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

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://www.hulu.com");

        //pause after going to website
        Thread.sleep(2000);

        //click on start free trial
        //driver.findElement(By.xpath("//*[text()='START YOUR FREE TRIAL']")).click();
        //the above text property didnt work because the element wasn't interactable
        //if this is the case, then use another unique property
        driver.findElement(By.xpath("//*[@class='button--cta button--white Masthead__input-cta']")).click();

    }//end of main method
}//end of java class
