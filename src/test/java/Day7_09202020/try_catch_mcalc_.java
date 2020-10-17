package Day7_09202020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;

public class try_catch_mcalc_ {
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

        driver.navigate().to("https://www.mlcalc.com");

        //pause after going to website
        Thread.sleep(2000);

        //clear and enter purchase price
        try {
            WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
            pPrice.clear();
            pPrice.sendKeys("400000");
        } catch (Exception err){
            System.out.println("unable to enter value on purchase price " + err);
        }//end of purchase price exception


        //clear and enter down payment
        try {
            WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
            dPayment.clear();
            dPayment.sendKeys("40");
        } catch (Exception err){
            System.out.println("unable to enter value on down payment " + err);
        }//end of down payment exception


        //select start month
        try {
            WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
            Select smList = new Select(startMonth);
            smList.selectByVisibleText("Feb");
        } catch (Exception err){
            System.out.println("unable to select start month " + err);
        }//end of start month exception

        //click on calculate
        try {
            driver.findElement(By.xpath("//*[@alt='Calculate']")).click();
        } catch (Exception err) {
            System.out.println("Unable to click on calculate button");
        }

    }
}
