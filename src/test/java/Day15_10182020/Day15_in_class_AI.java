package Day15_10182020;

import Reusable_Library.Abstract_Class;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Day15_in_class_AI extends Abstract_Class {

    @Test
    public void yahoo_AI() throws InterruptedException {
        logger.log(LogStatus.INFO, "Navigating to yahoo home page");
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);

        //verify the google title using soft assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"Yahoo");
        //to store all errors coming from soft assert and display it in your console
        softAssert.assertAll();

        //get the count of all links in yahoo home page
        List<WebElement> linkcount = driver.findElements(By.xpath("//*[@class='_yb_o44lu ']"));
        //print out the link count
        System.out.println("Link count is " + linkcount.size());

        //searching a keyword
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='p']","Nutrition",logger,"Search Field");
        //clicking on enter
        Reusable_Methods_Loggers.mouseClick(driver,"//*[@value='Search']","search");
        Thread.sleep(2000);

        //scroll down to bottom of the page
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,5000)");
        Thread.sleep(2000);

        //capture search result numbers
        String result = Reusable_Methods_Loggers.captureResult(driver,"//*[@class='compPagination']",logger,"result");
        String [] arrayResult = result.split(" ");
        System.out.println("total is " + result);

        //print out the search number
        //System.out.println("My search number for Nutrition is " + arrayResult[1]);

        //scroll back up to top
        jse.executeScript("scroll(0,-5000)");
        Thread.sleep(2000);

        //click on images
        Reusable_Methods_Loggers.mouseClick(driver,"//*[contains(@href,'https://images.search.yahoo.com/search/images')]","images");

        //get the image count in yahoo image page
        List<WebElement> imagecount = driver.findElements(By.xpath("//*[@data-bns='API']"));
        //print out the image count
        System.out.println("image count is " + imagecount.size());

        //click on sign in
        Reusable_Methods_Loggers.mouseClick(driver,"//*[@class='text signin']","sign in");
        //verify that checkbox is clicked
        Boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //expecting the checkbox to be selected
        if (checkboxState == true){
            System.out.println("Checkbox is selected as expected");
        }else{
            System.out.println("checkbox is not selected by default");
        }//end of boolean checkbox

        //enter fake username
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@id='login-username']","qwertyuiop@asdf.cone",logger,"user info");
        //click on sign in
        Reusable_Methods_Loggers.mouseClick(driver,"//*[@id='login-signin']","log in");

        //capture search result numbers
        String result1 = Reusable_Methods_Loggers.captureResult(driver,"//*[@='']",logger,"error");
        System.out.println("error: " + result1);

    }//end of test

}//end of java class
