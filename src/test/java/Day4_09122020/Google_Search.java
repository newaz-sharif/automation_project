package Day4_09122020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Search {
    public static void main(String[] args) throws InterruptedException {

        //set the chromedriver location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //define the web driver you will be using
        WebDriver driver = new ChromeDriver();

        //go to google home page
        driver.navigate().to("https://google.com");

        //maximize browser size
        driver.manage().window().maximize();

        //locate search field by name and enter a keyword on the field
        driver.findElement(By.name("q")).sendKeys("cars");

        //click on google search:
        // driver.findElement(By.name("btnk")).click();

        Thread.sleep(2000);

        //this is like hitting enter on the keyboard
        driver.findElement(By.name("btnK")).submit();

        //put 3 second delay
        Thread.sleep(3000);

        //to close the driver, use: driver.close();

        //quit session fully instead of just closing the driver
        driver.quit();

    }//end of main method
}//end of java class
