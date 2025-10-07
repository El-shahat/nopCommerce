package org.sessions.StepDefinations;

import com.github.javafaker.Faker;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.Node;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

import static org.sessions.StepDefinations.Hooks.driver;
public class configuration
{   public static Faker fake =new Faker();

    protected   void  ExplicitWaitUntilElementBeVisible(By locator)
    {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofMillis(10000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady()
    {
           new WebDriverWait(driver,Duration.ofSeconds(10)).until(driver->((JavascriptExecutor)driver).
            executeScript("return document.readyState").toString().equals("complete"));

    }
    /*
       set value to config.properties
       this method allow to user to set special or general data inside specific file
       if file.properties doesn`t created it may make an error
     */
    protected  void set(String Key,String Value,String file) throws  IOException
    {
        Properties prop =new Properties();
        FileInputStream fis =new FileInputStream(file);
        prop.load(fis);
        prop.setProperty(Key,Value);
        fis.close();
        FileOutputStream fos =new FileOutputStream(file);
        prop.store(fos,"Update opened file");
        fos.close();
    }
   protected String get(String Key,String file) throws IOException
   {  String returned_value;
       Properties prop =new Properties();
       FileInputStream fis =new FileInputStream(file);
       prop.load(fis);
     returned_value= prop.getProperty(Key);
     fis.close();
       return returned_value;
   }







    /*
    this method allow to Tester to test static list by passing cssSelector or xpath of Select tag and the using driver
    this method it is not allowed for dynamic list
    don`t leave the driver parameter empty pass null
    don`t use this method without creating Hooks class with static driver if the driver isn`t passed
     */
    protected  <StaticList> void TestListIsClickableAndEnabledAndDisplayed(By list, WebDriver driver)
   {
       if(driver == null)
   {
       driver =Hooks.driver;
   }
       else{
       SoftAssert soft =new SoftAssert();
       WebElement _list =driver.findElement(list);
       Select staticlist =new Select(_list);
       List<WebElement> elements =staticlist.getOptions();
       boolean isSelected =true;

       for(int i =0;i<staticlist.getOptions().size();i++)
       {
           try
           {
               staticlist.selectByIndex(i);
               isSelected = true;
           }
           catch(Exception expect)
           {   isSelected =false;
               System.out.println(expect.getMessage());
           }
           soft.assertTrue(isSelected);
           soft.assertTrue(elements.get(i).isDisplayed());
           soft.assertTrue(elements.get(i).isEnabled());
       }
       soft.assertAll();

   }
   }
   /*
   note before use this class: don`t use this class before installing faker server or download maven faker dependency
   this class provides many random fake data to use it in unit test or component test
   this class only using on web pages
    */
   protected static class FakeData {

       protected static String randomPassword(int minimum, int maximum, boolean includeUppercase, boolean includeSpecial, boolean includeDigit) {
        return fake.internet().password(minimum, maximum, includeUppercase, includeSpecial, includeDigit);
    }

       protected static String randomPassword() {
        return fake.internet().password();
    }

       protected  static String randomEmail() {
        return fake.internet().emailAddress();
    }

       protected static String randomUsername() {
        return fake.name().username();
    }

       protected static String randomFirstName() {
        return fake.name().firstName();
    }

       protected static String randomLastName() {
        return fake.name().lastName();
    }

       protected static String randomPhoneNo() {
        return fake.phoneNumber().phoneNumber();
    }
    /*
    this method just return fake data for visa and master card
     */
    protected static String randomCreditCard(String CreditType)
    {String chr =null;
        switch (CreditType)
        {
            case "VISA" :chr= fake.dragonBall().character();
                break;
            case "MASTER CARD":chr= fake.dragonBall().character();
                break;
            default:break;
        }
        return chr;
    }

}
}
