package Day12_10102020;

import Day3_09062020.Reusable_Method;
import Reusable_Library.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TstNG_assertions {

    @Test
    public void assertions() throws InterruptedException {

        WebDriver driver = Reusable_Methods.getDriver();
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);

        //verify the google title using hard assert
        //Assert.assertEquals("GOOGLE", driver.getTitle());

        //verify the google title using soft assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"GOOGLE");

        //enter a keyword on search
        Reusable_Methods.sendKeys(driver,"//*[@name='q']","cars","search field");

        //to store all errors coming from soft assert and display it in your console
        softAssert.assertAll();



    }//end of test
}//end of java class
