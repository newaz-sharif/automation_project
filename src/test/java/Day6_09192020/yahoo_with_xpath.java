package Day6_09192020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class yahoo_with_xpath {
    public static void main(String[] args) throws InterruptedException {
        //set the chromedriver location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();

        //set the driver to be maximized
        options.addArguments("start-maximized");

        //define the web driver you will be using
        WebDriver driver = new ChromeDriver(options);

        //pause before going to website
        Thread.sleep(2000);

        //navigate to yahoo.com
        driver.navigate().to("https//www.yahoo.com");
        //delay by 2 seconds
        Thread.sleep(2000);

        //type a keyword on yahoo search field
        driver.findElement(By.xpath("//*[@name='p']")).sendKeys("cars");
        //click on search button
        driver.findElement(By.xpath("//*[@value='search']")).click();

        Thread.sleep(2000);

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeAsyncScript("scroll(0,5000");

        String result = driver.findElement(By.xpath("//*[@class='compPagination']")).getText();

        String[] arrayResult = result.split("Next");

        String[] searchResult = arrayResult[1].split(" ");

        System.out.println("My search result number is " + searchResult[0]);
        Thread.sleep(2000);

        jse.executeAsyncScript("scroll(0,-5000)");


    }//end of main method
}//end of java class
