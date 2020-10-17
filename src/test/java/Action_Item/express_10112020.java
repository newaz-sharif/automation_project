package Action_Item;

import Reusable_Library.Abstract_Class;
import Reusable_Library.Reusable_Methods;
import Reusable_Library.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.jsoup.Connection;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class express_10112020 extends Abstract_Class {

    //declare all the global variables outside
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;


    @BeforeSuite
    public void workbook() throws IOException, BiffException {
        //Step 1: locate the readable excel workbook
        readableFile = Workbook.getWorkbook(new File("src/main/resources/express.xls"));
        //Step 2: locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //Step 3: make a copy of readable file to write back to the excel so it doesn't corrupt the original file
        writableFile = Workbook.createWorkbook(new File("src/main/resources/express_results.xls"),readableFile);
        //Step 4: define the writable sheet for writable file
        writableSheet = writableFile.getSheet(0);
        //Ste 5: get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();

    }//end of before suite


    @Test
    public void express() throws InterruptedException, WriteException {


        driver.manage().deleteAllCookies();

        for (int i = 1; i < rowCount; i++) {

            //I need to get the content of the cell
            //column is hard coded and row is dynamic(i)
            String size = writableSheet.getCell(0, i).getContents();
            String quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            String address = writableSheet.getCell(6, i).getContents();
            String zipCode = writableSheet.getCell(7, i).getContents();
            String city = writableSheet.getCell(8, i).getContents();
            String state = writableSheet.getCell(9, i).getContents();
            String cardNumber = writableSheet.getCell(10, i).getContents();
            String expirationMonth = writableSheet.getCell(11, i).getContents();
            String expirationYear = writableSheet.getCell(12, i).getContents();
            String ccv = writableSheet.getCell(13, i).getContents();


            logger.log(LogStatus.INFO, "Navigating to express home page");
            driver.navigate().to("https://www.express.com");
            Thread.sleep(2000);

            //Get real title of the page and see if it matches the expected title
            String realTitle = driver.getTitle();
            if (realTitle.contains("Men's and Women's Clothing")) {
                System.out.println("Title matches");
            } else {
                System.out.println("Title does not match, instead title is " + realTitle);
            }// end of else statement

            //hover over mens section
            Reusable_Methods_Loggers.mouseHover(driver, "//*[@href='/mens-clothing']", "Men's clothing");
            Thread.sleep(2000);
            //click on shirts
            Reusable_Methods_Loggers.mouseClick(driver, "//*[@href='/mens-clothing/shirts/cat410008']", "Shirts");
            Thread.sleep(2000);

            //scroll down a bit
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0,400)");
            Thread.sleep(2000);

            //click on third option for shirts
            Reusable_Methods_Loggers.clickByIndex(driver, "//*[@class='_3TJgM']", 2, "3rd option");
            Thread.sleep(1500);
            //scroll down to size options
            jse.executeScript("scroll(0,300)");
            Thread.sleep(2000);
            //click on size
            Reusable_Methods_Loggers.clickByIndex(driver, "//*[@class='_3OQxl' or @class='_2ZSXl']", 1, "size");
            Thread.sleep(2000);
            //add to cart
            Reusable_Methods_Loggers.mouseClick(driver, "//*[@class='YaSAE' or @class='btn _9yfmt _194FD _2tFXQ _3yOD6 _1Qp1L _2veMA']", "add to cart");
            Thread.sleep(2000);

            driver.navigate().to("https://www.express.com/bag");
            Thread.sleep(2000);
            //scroll up to hover cart
            jse.executeScript("scroll(0,100)");
            Thread.sleep(1000);
            //Thread.sleep(2000);
            //hover over cart
            //Reusable_Methods_Loggers.mouseClick(driver, "//*[@class='BagIcon_bagIconButton__1Kdj-' or @class='_2CsVP svg-icon--shopping-bag']", "hover cart");
            //click on view cart
            //Reusable_Methods_Loggers.mouseClick(driver, "//*[@class,'HoverableSlideOutModal_modal__2xYUD DesktopHeader_modalContainer__8Q61X']", "view cart");
            //Thread.sleep(2000);

            //type and enter quantity
            Reusable_Methods_Loggers.mouseClick(driver,"//*[@class='dropdown']","Quantity");
            Reusable_Methods_Loggers.typeAndSubmit(driver, "//*[@class='dropdown']",quantity,"quantity");

            jse.executeScript("scroll(0,250)");
            Thread.sleep(1000);

            //click on checkout
            Reusable_Methods_Loggers.mouseClick(driver,"//*[@id='continue-to-checkout' or @class='granify-cta-message']","Checkout");
            //continue as guest
            Reusable_Methods_Loggers.mouseClick(driver,"//*[@class='_1UFak _2YpK4 _1f9t- _2yrqS']","guest checkout");

            //enter first name
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='firstname']",firstName,logger,"first name");
            //enter last name
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='lastname']",lastName,logger,"last name");
            //enter email
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='email']",email,logger,"email");
            //confirm email
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='confirmEmail']",email,logger,"confirm email");
            //enter phone number
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='phone']",phoneNumber,logger,"phone number");
            //click on continue
            Reusable_Methods_Loggers.mouseClick(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']","continue");
            Thread.sleep(2000);

            //enter street address
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='shipping.line1']",address,logger,"address");
            //enter zipcode
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='shipping.postalCode']",zipCode,logger,"zipcode");
            //enter city
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='shipping.city']",city,logger,"city");
            //enter state
            Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@id='rvndd--shipping.state--3']",state,"state");
            //click on continue to shipping method
            Reusable_Methods_Loggers.mouseClick(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']","continue");
            Thread.sleep(2000);
            //click on continue to billing info
            Reusable_Methods_Loggers.mouseClick(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']","continue");
            Thread.sleep(2000);

            //enter credit card info
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='creditCardNumber']",cardNumber,logger,"card number");
            //enter expiration month
            Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@name='expMonth']",expirationMonth,"expiration month");
            //enter expiration year
            Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@name='expYear']",expirationYear,"expiration year");
            //enter ccv number
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='ccv']",ccv,logger,"ccv");
            //click on place order
            Reusable_Methods_Loggers.mouseClick(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']","continue");
            Thread.sleep(2000);

            //capture error message
            String result = Reusable_Methods_Loggers.captureResult(driver,"//*[@class='_13uVj jwBXt']",logger,"error message");
            System.out.println("Error: " + result);

            //store and send it to the empty column in excel writable file
            Label label = new Label(14, i, result);
            //adding this label to the writable sheet
            writableSheet.addCell(label);



        }//end of for loop


    }//end of test

    @AfterSuite
    public void closingInfo() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        driver.quit();
    }//end of after suite
}//end of class
