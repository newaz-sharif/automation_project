package Day6_09192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class xpath_concepts {

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



        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");
        //delay by 2 seconds
        Thread.sleep(2000);

        //driver.findElement(By.xpath("//*[@id='ybar-sbq' or @name='p'")).sendKeys("cars");

        //driver.navigate().to("https//www.yahoo.com");

        //Thread.sleep(2000);

        //driver.findElement(By.xpath("//*[contains(@id='ybar-sbq' or @name='p)]'")).sendKeys("cars");

        driver.findElements(By.xpath("//*[contains(@class,'_yb_1amly')]")).get(2).click();
    }
}
