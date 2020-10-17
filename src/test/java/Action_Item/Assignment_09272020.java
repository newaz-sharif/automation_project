package Action_Item;

import Reusable_Library.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Assignment_09272020 {
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
        driver.navigate().to("https://www.uhc.com");
        //delay by 2 seconds
        Thread.sleep(1000);

        //Get real title of the page and see if it matches the expected title
        String realTitle = driver.getTitle();
        if (realTitle.contains("Health insurance plans")) {
            System.out.println("Title matches");
        } else {
            System.out.println("Title does not match, instead title is " + realTitle);
        }// end of else statement

        //locating 'Find a doctor' button and clicking on it
        driver.findElement(By.xpath("//*[text()='Find a Doctor']")).click();
        Thread.sleep(3000);

        // first names that will be entered
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("John");
        firstName.add("Karen");
        firstName.add("Frank");

        // last names that will be entered
        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Doe");
        lastName.add("Smith");
        lastName.add("Jones");

        // birth day that will be entered
        ArrayList<String> birthDay = new ArrayList<>();
        birthDay.add("11");
        birthDay.add("9");
        birthDay.add("27");

        // birth year that will be entered
        ArrayList<String> birthYear = new ArrayList<>();
        birthYear.add("1984");
        birthYear.add("1992");
        birthYear.add("2001");

        //social security number that will be entered
        ArrayList<String> socialSecurity = new ArrayList<>();
        socialSecurity.add("236536");
        socialSecurity.add("891375");
        socialSecurity.add("672783");

        //zip code that will be entered
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11001");
        zipCode.add("11314");
        zipCode.add("11218");

        //birth month that will be entered
        ArrayList<String> birthMonth = new ArrayList<>();
        birthMonth.add("February");
        birthMonth.add("June");
        birthMonth.add("October");


        for (int i = 0; i < firstName.size();i++){

            //locating 'sign in to find a provider' button and clicking on it
            driver.findElement(By.xpath("//*[@href='https://www.myuhc.com']")).click();
            Thread.sleep(2000);

            //need to store get windows handles command in an ArrayList to switch to different tabs
            //must be called everytime after opening a new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to second tab
            driver.switchTo().window(tabs.get(1));

            //locating 'Find a Workshop' button and clicking on it
            driver.findElement(By.xpath("//*[text()='Register Now']")).click();
            //delay 2 seconds
            Thread.sleep(1000);

            //entering first name
            Reusable_Methods.sendKeys(driver, "//*[@id='firstName']", firstName.get(i), "first name");
            Thread.sleep(1000);
            //entering last name
            Reusable_Methods.sendKeys(driver, "//*[@id='lastName']", lastName.get(i), "last name");
            Thread.sleep(1000);
            //Reusable_Methods.select(driver,"//*[@id='dob_month_input']",birthMonth,"birth month");

            //was unable to create a reusable method for dropdown
            //select birth month from drop down menu
            try{
                System.out.println("Selecting birth month");
                WebElement months = driver.findElement(By.xpath("//*[@id='dob_month_input']"));
                Select monthList = new Select(months);
                Thread.sleep(2000);
                monthList.selectByVisibleText(birthMonth.get(i));
                Thread.sleep(2000);
            } catch (Exception err) {
                System.out.println("Unable to select birth month" + err);
            }
            Thread.sleep(500);
            //entering a birth day
            Reusable_Methods.sendKeys(driver, "//*[@id='dob_day']", birthDay.get(i), "birth day");
            Thread.sleep(500);
            //entering a birth year
            Reusable_Methods.sendKeys(driver, "//*[@id='dob_year']", birthYear.get(i), "birth year");
            Thread.sleep(500);
            //clicking on social secuirty option
            Reusable_Methods.click(driver, "//*[@for='ssn']","social security option");
            Thread.sleep(500);
            //clicking on social security character bar first or else will not enter a value
            Reusable_Methods.click(driver, "//*[@id='ssnLastSixDigits']","social security");
            //entering a last 6 digits of social security number
            Reusable_Methods.sendKeys(driver, "//*[@id='ssnLastSixDigits']", socialSecurity.get(i), "social security");
            Thread.sleep(500);
            //entering a zip code
            Reusable_Methods.sendKeys(driver, "//*[@id='zipCode']", zipCode.get(i), "zip code");
            Thread.sleep(500);
            //clicking on submit
            Reusable_Methods.submit(driver, "//*[@id='submitBtn']","Search Field");
            Thread.sleep(500);
            Reusable_Methods.getTxt(driver,"//*[@id='plainText_error']","retrieving feedback");

            driver.switchTo().window(tabs.get(0));

            driver.close();

        }//end of for loop



    }//end of main method
}//end of java class
