package Action_Item;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment_09132020 {
    public static void main(String[] args) throws InterruptedException {

        //set the chromedriver location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();

        //define the web driver you will be using
        WebDriver driver = new ChromeDriver();

        //lets create a dynamic array to handle multiple boroughs on google search
        String[] hobbies = new String[5];

        hobbies[0] = "sports";
        hobbies[1] = "drawing";
        hobbies[2] = "videogames";
        hobbies[3] = "music";
        hobbies[4] = "writing";

        for (int i = 0; i < hobbies.length; i++) {

            //maximize browser size
            driver.manage().window().maximize();

            //pause before going to website
            Thread.sleep(2000);

            //go to google home page
            driver.navigate().to("https://bing.com");

            //pause before typing keyword
            Thread.sleep(2000);

            //locate search field by name and enter a keyword on the field
            driver.findElement(By.name("q")).sendKeys(hobbies[i]);

            //pause before hitting enter
            Thread.sleep(2000);

            //this is like hitting enter on the keyboard
            driver.findElement(By.name("q")).submit();

            //capture the search result text
            String result = driver.findElement(By.className("sb_count")).getText();

            //count words based on spaces
            String [] arrayResult = result.split(" ");

            //print out the search number
            System.out.println("My search number for " + hobbies[i] + " is " + arrayResult[0]);

        }//end of for loop

        //quit session fully instead of just closing the driver
        driver.quit();

    }//end of main method
}//end of java class
