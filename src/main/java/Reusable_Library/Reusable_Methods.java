package Reusable_Library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;

public class Reusable_Methods {

    //reusable method to click on any element on any website
    public static void click(WebDriver driver, String locator, String elementName){

        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            System.out.println("Clicking on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
        } catch (Exception err){
            System.out.println("Unable to click on element " + err);
        }//end of exception

    }//end of click method

    //reusable method to type on any element on any website
    public static void sendKeys(WebDriver driver, String locator, String userValue, String elementName){

        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            System.out.println("typing on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).sendKeys(userValue);
        } catch (Exception err){
            System.out.println("Unable to type on element " + err);
        }//end of exception

    }//end of sendKey method

    //reusable method to submit on any element on any website
    public static void submit(WebDriver driver, String locator, String elementName){

        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            System.out.println("submitting on element " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).submit();
        } catch (Exception err){
            System.out.println("Unable to submit on element " + err);
        }//end of exception

    }//end of submit method

    public static void getTxt(WebDriver driver, String locator, String elementName){

        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            System.out.println("getting text from element " + elementName);
            String txt = driver.findElement(By.xpath(locator)).getText();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
            System.out.println(txt);
        } catch (Exception err){
            System.out.println("Unable to get text from element " + err);
        }//end of exception

    }//end of submit method

    //reusable method to select any element on any website

    /*
    //could not figure out how to make select reusable method***

    public static void select(WebDriver driver, String xpath, String visibleText){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            //System.out.println("selecting on element " + elementName);
            Select dropDown = new Select(driver.findElement(By.xpath(xpath)));
            dropDown.selectByVisibleText(visibleText);
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        }catch (Exception err){
            System.out.println("Unable to select on element");
        }//end of exception
    }//end of select method
    */

    //reusable method to type capture a value/text on any website using return method
    public static String captureResult(WebDriver driver, String locator, String elementName){

        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try{
            System.out.println("capturing text on element " + elementName);
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
        } catch (Exception err){
            System.out.println("Unable to capture text on element " + err);
        }//end of exception
        return result;



    }//end of sendKey method

    public static WebDriver getDriver(){
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

        return driver;
    }//end of get driver method

    //reusable method to type capture a value/text on any website using return method
    public static void dropdownMenu(WebDriver driver, String locator, String userInput, String elementName) {

        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("selecting from element " +userInput + elementName);
            WebElement dropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select selectDropDown = new Select(dropDown);
            selectDropDown.selectByVisibleText(userInput);
        } catch (Exception err) {
            System.out.println("Unable to select from dropdown " + err);
        }//end of exception
    }//end of dropdown method

    //reusable method to type and submit
    public static void typeAndSubmit(WebDriver driver,String locator, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            System.out.println("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            Thread.sleep(1000);
            element.sendKeys(Keys.ENTER); //this is another way to submit to an element using key event
        } catch (Exception e) {
            System.out.println("Unable to enter on element " + elementName + " " + e);
        }//end of exception
    }//end of type and submit method

    //method to click on an element
    public static void mouseClick(WebDriver driver,String locator,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        Actions actions = new Actions(driver);
        try{
            System.out.println("Mouse clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to mouse click element " + elementName + " " + e);
        }
    }//end of click method

    public static void clickByIndex(WebDriver driver,String locator,int index, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            System.out.println("Clicking by index " + index + " on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click by index " + index +  " on element " + elementName + " " + e);
        }
    }//end of click by index method
}//end of java class
