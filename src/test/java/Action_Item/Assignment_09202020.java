package Action_Item;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Assignment_09202020 {
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
        driver.navigate().to("https://www.weightwatchers.com");
        //delay by 2 seconds
        Thread.sleep(2000);

        //Get real title of the page and see if it matches the expected title
        String realTitle = driver.getTitle();
        if (realTitle == "Weight Watchers: Weight loss & Welness Help") {
            System.out.println("Title matches");
        } else {
            System.out.println("Title does not match, instead title is " + realTitle);
        }// end of else statement

        //locating 'Find a Workshop' button and clicking on it
        driver.findElement(By.xpath("//*[text()='Find a Workshop']")).click();
        //delay 2 seconds
        Thread.sleep(2000);

        // zipcodes that will be entered
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11210");
        zipCode.add("11310");
        zipCode.add("11410");

        //call the for loop to iterate through the array list
        for (int i=0; i < zipCode.size(); i++) {

            //entering zipcodes
            try {
                System.out.println("Entering zipcode " + zipCode.get(i));
                WebElement zipcodeList = driver.findElement(By.id("location-search"));
                zipcodeList.clear();
                zipcodeList.sendKeys(zipCode.get(i));
                zipcodeList.submit();
                Thread.sleep(2000);
            } catch (Exception err) {
                System.out.println("Unable to enter a zip code");
            }//end of enter a zipcode exception

            //clicking on a studio
            try {
                System.out.println("Clicking on a studio in " +zipCode.get(0));
                driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(i).click();
                Thread.sleep(2000);
            } catch (Exception err) {
                System.out.println("Unable to choose a studio");
            }//end of clicking a studio exception

            //capturing the address for the zipcode
            try{
                String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                System.out.println("This is the address for a location near " +zipCode.get(i)+ " : " +address);
                Thread.sleep(2000);
            } catch (Exception err){
                System.out.println("Unable to capture the address for the studio");
            }

            //locating the schedule and printing it
            try {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("scroll(0,900)");
                Thread.sleep(2000);
                String hours = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                System.out.println("This is the schedule for the location in " + zipCode.get(i));
                System.out.println(" " + hours);
            }catch (Exception err){
                System.out.println("Unable to locate the schedule for the studio near " +zipCode.get(i));
            }

            //going back and clicking on the 'Find a Workshop' button
            try {
                System.out.println("End of schedule for this studio");
                driver.findElement(By.xpath("//*[text()='Find a Workshop']")).click();
            } catch (Exception err){
                System.out.println("Unable to click on the 'Find a Workshop button");
            }//end of try and catch with find a workshop
        }//end of for loop

        //close the driver
        driver.quit();
    }//end of main method
}//end of java class
