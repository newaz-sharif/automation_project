package Action_Item;

import Reusable_Library.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class kayak_10_04_2020 {

    //declare all the global variables outside
    WebDriver driver;
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;
    @BeforeSuite
    public void setDriver() throws IOException, BiffException {
        //setting the chrome driver
        driver = Reusable_Methods.getDriver();
        //Step 1: locate the readable excel workbook
        readableFile = Workbook.getWorkbook(new File("src/main/resources/kayak.xls"));
        //Step 2: locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //Step 3: make a copy of readable file to write back to the excel so it doesn't corrupt the original file
        writableFile = Workbook.createWorkbook(new File("src/main/resources/kayak_results.xls"),readableFile);
        //Step 4: define the writable sheet for writable file
        writableSheet = writableFile.getSheet(0);
        //Ste 5: get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();
    }//end of before suite

    @Test
    public void getMonthlyPayment() throws WriteException, InterruptedException {
        //all the test steps have to go inside for loop
        for(int i = 1; i < rowCount; i++) {
            //I need to get the content of the cell
            //column is hard coded and row is dynamic(i)
            String airPort = writableSheet.getCell(0, i).getContents();
            String starDate = writableSheet.getCell(1, i).getContents();
            String startTime = writableSheet.getCell(2, i).getContents();
            String endDate = writableSheet.getCell(3, i).getContents();
            String endTime = writableSheet.getCell(4, i).getContents();
            String carSize = writableSheet.getCell(5, i).getContents();
            //navigate to mortgage home
            driver.navigate().to("https://www.kayak.com");
            Thread.sleep(2000);

            //Get real title of the page and see if it matches the expected title
            String realTitle = driver.getTitle();
            if (realTitle.contains("Kayak")) {
                System.out.println("Title matches");
            } else {
                System.out.println("Title does not match, instead title is " + realTitle);
            }// end of else statement

            /** below code is inspected before you clicking inside the search field
             and I am using contains id property as initial portion of id value
             is changing **/
            //clicking and entering uservalues for airport
            Reusable_Methods.click(driver, "//*[contains(@id,'pickup-display')]", "Pick up Location");
            Reusable_Methods.sendKeys(driver, "//*[@name='pickup']",airPort,"Airport");
            /** click on suggesting link once you type your airport
            or else it will block your calendar so you need to click on suggested link **/
            Reusable_Methods.click(driver, "//*[@class='smarty-item-icon']", "Choose Airport Link");
            //now put like 1 to 2 seconds then click on start date calendar icon
            Thread.sleep(2000);

            //line below is clicking on calendar icon first for start date
            Reusable_Methods.click(driver,"//*[contains(@id,'dateRangeInput-display-start-inner')]","Start Date");
            Reusable_Methods.typeAndSubmit(driver,"//*[contains(@id,'pickup-date-input')]",starDate,"start date");

            //this is to immediately enter end date because the option will already be open from clicking on start date
            Reusable_Methods.click(driver,"//*[contains(@id,'dropoff-date-input')]","End Date");
            Reusable_Methods.typeAndSubmit(driver,"//*[contains(@id,'dropoff-date-input')]",endDate,"end date");

            /** element below is not interactable because you have to close the calendar so click anywhere outside
            like clicking on title search for hundred **/
            Reusable_Methods.mouseClick(driver,"//*[@class='title dark']","Dark Title");
            //put like 1 second
            Thread.sleep(1000);
            //before you select the value from start time you need to click on start time icon first
            Reusable_Methods.click(driver, "//*[contains(@id,'start-time-select-display')]","Start Time");
            /** also before clicking on the value you should put 1.5 to 2 seconds to slow down selenium
             or else you will get element not interactable error **/
            Thread.sleep(2500);
            //now click on start time value
            Reusable_Methods.click(driver, "//*[contains(@id,'start-time-select-option') and @data-title='10:00 am']","Start Time Value");
            //click on end time value
            Reusable_Methods.click(driver, "//*[contains(@id,'end-time-select-display') and @data-title='10:00 am']","End Time Value");

            //click on search button
            Reusable_Methods.click(driver, "//*[@id='c4z_w-submit']","search button");
            Thread.sleep(2500);

            //click on small cars
            Reusable_Methods.clickByIndex(driver,"//*[@class='cars-results-filters-CarTopFilters']",0,"car size");
            Thread.sleep(2500);

            //click on 3rd deal
            //Reusable_Methods.clickByIndex(driver,"//*[xpath]",index,"3rd deal");
            //Thread.sleep(2500);

            //then capture result and print price using reusable method captureResult





        }//end of for loop
    }//end of test

}//end of java class
