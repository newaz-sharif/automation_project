package Day5_09132020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Google_Array_Results {
    public static void main(String[] args) throws InterruptedException {

        //set the chromedriver location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();

        //set the driver to be maximized
        options.addArguments("start-maximized");

        //set the driver to be incognito
        options.addArguments("incognito");

        //run the driver in headless mode (the browser will not display)
        //options.addArguments("headless");

        //define the web driver you will be using
        WebDriver driver = new ChromeDriver();

        //lets create a dynamic array to handle multiple boroughs on google search
        String[] boroughs = new String[5];

        boroughs[0] = "Brooklyn";
        boroughs[1] = "Queens";
        boroughs[2] = "Manhattan";
        boroughs[3] = "Bronx";
        boroughs[4] = "Staten Island";

        for (int i = 0; i < boroughs.length; i++){
            //go to google home page
            driver.navigate().to("https://google.com");

            //maximize browser size
            //driver.manage().window().maximize();
            Thread.sleep(2000);

            //locate search field by name and enter a keyword on the field
            driver.findElement(By.name("q")).sendKeys(boroughs[i]);

            Thread.sleep(2000);

            //click on google search:
            driver.findElement(By.name("btnk")).click();

            Thread.sleep(2000);

            //this is like hitting enter on the keyboard
            driver.findElement(By.name("btnK")).submit();

            //put 3 second delay
            Thread.sleep(3000);

            //capture the search result text
            String result = driver.findElement(By.id("result-stats")).getText();
            String [] arrayResult = result.split(" ");

            //print out the search number
            System.out.println("My search number for " + boroughs[i] + "is " + arrayResult[1]);

        }//end of for loop

        //quit session fully instead of just closing the driver
        driver.quit();

    }//end of main mehtod
}//end of java class
