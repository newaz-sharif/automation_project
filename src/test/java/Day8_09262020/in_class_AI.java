package Day8_09262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class in_class_AI {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver to be maximized
        //options.addArguments("start-maximized");
        //set the driver to be incognito mode(private)
        options.addArguments("incognito");
        //run the driver in headless mode
        //options.addArguments("headless");

        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options); //options variable should be passed here

        //navigate to hotels
        driver.navigate().to("https://www.hotels.com");
        Thread.sleep(2000);


        //Destination
        try
        {
            System.out.println("Entering a new on Destination:");
            WebElement destination = driver.findElement(By.xpath("//*[@id='qf-0q-destination']"));
            //destination.clear();
            Thread.sleep(2000);
            destination.sendKeys("Bali, Indonesia");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@class='autosuggest-category-result']")).click();
            Thread.sleep(2000);
        } catch (Exception err)
        {
            System.out.println("Unable to enter a new on Destination\n " + err);
        }


        //CheckIn
        try
        {
            System.out.println("Entering a new date on check in:");
            WebElement checkIn = driver.findElement(By.xpath("//*[@id='qf-0q-localised-check-in']"));
            checkIn.clear();
            Thread.sleep(2000);
            checkIn.sendKeys("10/28/20");
            Thread.sleep(2000);

        } catch (Exception err)
        {
            System.out.println("Unable to enter a new date on check in\n " + err);
        }

        //CheckOut
        try
        {
            System.out.println("Entering a new date on check out:");
            WebElement checkIn = driver.findElement(By.xpath("//*[@id='qf-0q-localised-check-out']"));
            checkIn.clear();
            Thread.sleep(2000);
            checkIn.sendKeys("11/03/20");
            Thread.sleep(2000);

        } catch (Exception err)
        {
            System.out.println("Unable to enter a new date on check out " + err);
        }

        //Rooms
        try{
            System.out.println("Selecting number of rooms");
            WebElement Room1 = driver.findElement(By.xpath("//*[@id='qf-0q-rooms']"));
            Select roomList = new Select(Room1);
            Thread.sleep(2000);
            roomList.selectByVisibleText("1");
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println("Unable to select number of rooms" + err);
        }

        //Adults
        try{
            System.out.println("Selecting number of adults");
            WebElement Adults = driver.findElement(By.xpath("//*[@id='qf-0q-room-0-adults']"));
            Select roomList = new Select(Adults);
            Thread.sleep(2000);
            roomList.selectByVisibleText("6");
            Thread.sleep(2000);
        } catch (Exception err) {
            System.out.println("Unable to select number of adults " + err);
        }

        //Search
        driver.findElement(By.xpath("//*[@class='cta cta-strong']")).click();
        Thread.sleep(5000);







        Thread.sleep(5000);
        driver.close();


        }//end of main method
}//end of java class
