package Action_Item;

import Reusable_Library.Abstract_Class;
import Reusable_Library.Abstract_Class_Cross_Browser;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Fedex_10_18_2020 extends Abstract_Class_Cross_Browser {
    @Test
    public void fedex() throws InterruptedException {
        //delete all cookies
        driver.manage().deleteAllCookies();

        //navigate to fedex website
        logger.log(LogStatus.INFO, "Navigating to express home page");
        driver.navigate().to("https://www.fedex.com/en-us/home.html");
        Thread.sleep(2000);

        //click on design and print
        Reusable_Methods_Loggers.mouseClick(driver,"//*[@aria-label='Open Design & Print menu']","design and print");
        Thread.sleep(2000);
        //click on upload a print ready file
        Reusable_Methods_Loggers.mouseClick(driver,"//*[@href='https://www.fedex.com/apps/printonline/#!']","upload file");
        Thread.sleep(1000);

        //Get real title of the page and see if it matches the expected title
        String realTitle = driver.getTitle();
        if (realTitle.contains("Fedex Office Print")) {
            logger.log(LogStatus.PASS,"Title matches");

        } else {
            logger.log(LogStatus.FAIL,"Title does not match, instead title is " + realTitle);
        }// end of else statement

        //click on document printing
        Reusable_Methods_Loggers.mouseClick(driver,"//*[@title='Document Printing']","document printing");

        //click on copies and custom projects
        Reusable_Methods_Loggers.mouseClick(driver,"//*[@title='Copies & Custom Projects']","copies");

        //click on upload file
        Reusable_Methods_Loggers.mouseClick(driver,"//*[@name='upload-files-button']","upload file");
        Thread.sleep(2000);

        //upload image
        Reusable_Methods_Loggers.uploadFile("\"C:\\Users\\Newaz Sharif\\Downloads\\warzone.jpg\"");
        Thread.sleep(3000);

        //click on continue
        Reusable_Methods_Loggers.mouseClick(driver,"//*[@id='js-modal__continue-btn_lowResolutionPreview']","continue");
        Thread.sleep(2000);

        //change quantity
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@id='item-quantity']","5",logger,"quantity");
        Thread.sleep(2000);

        //add to cart
        Reusable_Methods_Loggers.mouseClick(driver,"//*[@name='update_quanity-addToCart-lbl']","add to cart");
        Thread.sleep(2000);

        //checkout
        Reusable_Methods_Loggers.mouseClick(driver,"//*[@class='fxg-btn fxg-btn-orange full cart-checkout']","checkout");
        Thread.sleep(1000);

        //checkout as guest
        Reusable_Methods_Loggers.mouseClick(driver,"//*[@id='continueAsGuest']","guest checkout");
        Thread.sleep(1000);

        //enter radius
        Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@class='sel-fedaddaccount-small-1 blue-text font-size-large']","@name=5","distance");
        Thread.sleep(2000);

        //enter location
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@id='loc_seacrh_text']","11218",logger,"zipcode");
        Thread.sleep(1000);

        //click on continue
        Reusable_Methods_Loggers.mouseClick(driver,"//*[@id='saveNContBtn']","continue");
        Thread.sleep(3000);

        //capture nearest location
        String result = Reusable_Methods_Loggers.captureResult(driver,"//*[@class='active']",logger,"nearest location");
        logger.log(LogStatus.INFO,"The nearest location information is: " + result);
        System.out.println(result);



    }//end of test

}//end of class
