package Day12_10102020;

import Reusable_Library.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

public class List_Checkbox {

    @Test
    public void verifications() throws InterruptedException {

        WebDriver driver = Reusable_Methods.getDriver();
        driver.navigate().to("https://yahoo.com");
        Thread.sleep(2000);

        //get the count of all links in yahoo home page
        List<WebElement> linkcount = driver.findElements(By.xpath("//*[@class='_yb_5coqv']"));
        //print out the link count
        System.out.println("Link count is " + linkcount.size());

        //click on sign in button
        Reusable_Methods.click(driver,"//*[@class='_yb_687jt']","Sign in button");
        Thread.sleep(2500);

        Boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //expecting the checkbox to be selected
        if (checkboxState == true){
            System.out.println("Checkbox is selected as expected");
        }else{
            System.out.println("checkbox is not selected by default");
        }


    }//end of test

}//end of java class
