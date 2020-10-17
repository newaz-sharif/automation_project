package Day5_09132020;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_Options_java {
    public static void main(String[] args) throws InterruptedException {

        //set the chromedriver location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();

        //set the driver to be maximized
        options.addArguments("start-maximized");

        //set the driver to be incognito
        //options.addArguments("incognito");

        //run the driver in headless mode (the browser will not display)
        //options.addArguments("headless");

        //define the web driver you will be using
        WebDriver driver = new ChromeDriver();

        System.out.println("Navigating to google home page");

        //go to google home page
        driver.navigate().to("https://google.com");

        Thread.sleep(2000);

        //capture the homepage title and verify it matches the expected title:GOOGLE
        String actualTitle = driver.getTitle();

        //verify it matches the expected title
        if (actualTitle == "GOOGLE"){
            System.out.println("Title matches");
        } else {
            System.out.println("Title doesn't match. Actual title is " + actualTitle);
        }//end of conditional statement

    }//end of main mehtod

}//end of java class
