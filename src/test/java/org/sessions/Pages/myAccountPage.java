package org.sessions.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

import java.util.List;

import static  org.sessions.StepDefinations.Hooks.driver;
public class myAccountPage {
    public myAccountPage()
    {
        PageFactory.initElements(driver,this);
    }
public  static  class customerInfo
 {
      @FindBy(xpath="//input[@id='gender-male']")
      public static WebElement genderMale;
      @FindBy(xpath="//label[.='Female']")
     public static WebElement genderFemale;
      @FindBy(xpath = "//input[@id='FirstName']")
     public static WebElement firstName;
      @FindBy(xpath = "//input[@id='LastName']")
     public static WebElement lastName;
      @FindBy(xpath = "//input[@id='Email']")
     public static WebElement email;
      @FindBy(xpath = "//input[@id='Company']")
     public static WebElement company;
      @FindBy(xpath = "//input[@id='Newsletter']")
     public static WebElement checkbox;
      @FindBy(xpath = "//button[@id='save-info-button']")
     public static WebElement saveButton;
      @FindBy(css="p[class=\"content\"]")
     public static WebElement successMessage;
      @FindBy(css="div[class=\"bar-notification success\"]")
      public static WebElement SuccessMessageColor;
      public static void init()
      {
          customerInfo temp= new customerInfo();
          PageFactory.initElements(driver,temp);
          genderMale = temp.genderMale;
          genderFemale = temp.genderFemale;
          firstName = temp.firstName;
          lastName = temp.lastName;
          saveButton = temp.saveButton;
          email =temp.email;
          company =temp.company;
          checkbox =temp.checkbox;
          successMessage =temp.successMessage;
          SuccessMessageColor=temp.SuccessMessageColor;
      }

 }
public static class Addresses
 {public Addresses()
 {
     PageFactory.initElements(driver,this);
 }
     @FindBy(xpath = "//div[@class='no-data']")
     public static WebElement NoAddressesMessage;
     @FindBy(xpath = "//button[@class='button-1 add-address-button']")
     public  static WebElement AddNewButton;
     @FindBy(xpath = "//h1[.='My account - Addresses']")
     public static WebElement label;
     //-------------------------------------------------------
     @FindBy(xpath = "//input[@id='Address_FirstName']")
     public static WebElement firstName;
     @FindBy(xpath = "//input[@id='Address_LastName']")
     public static WebElement lastName;
     @FindBy(xpath = "//input[@id='Address_Email']")
     public static WebElement email;
     @FindBy(xpath = "//input[@id='Address_Company']")
     public static WebElement company;
     @FindBy(xpath = "//select[@id='Address_CountryId']")
     public static WebElement country;
     @FindBy(xpath = "//select[@id='Address_StateProvinceId']")
     public static WebElement state;
     @FindBy(xpath = "//input[@id='Address_City']")
     public static WebElement city;
     @FindBy(xpath = "//div[@class='edit-address']/div[8]/input[1]")
     public static WebElement Addresses1;
     @FindBy(xpath = "//div[9]/input[1]")
     public static WebElement Addresses2;
     @FindBy(xpath = "//input[@id='Address_ZipPostalCode']")
     public static WebElement postalCode;
     @FindBy(xpath = "//input[@id='Address_PhoneNumber']")
     public static WebElement phoneNo;
     @FindBy(xpath = "//input[@id='Address_FaxNumber']")
     public static WebElement faxNumber;
     @FindBy(xpath = "//button[@class='button-1 save-address-button']")
     public static WebElement saveButton;

     //------------------------------------------------------------------------------
     @FindBy(xpath = "//strong[.='ahmed `shahat']")
     public static WebElement username;
     @FindBy(xpath = "//li[@class='name']")
     public static WebElement customerName;
     @FindBy(xpath = "//li[@class='email']")
     public static WebElement customerEmail;
     @FindBy(xpath = "//li[@class='phone']")
     public static WebElement customerPhone;
     @FindBy(xpath = "//li[@class='fax']")
     public static WebElement customerFax;
     @FindBy(xpath = "//li[@class='country']")
     public static WebElement customerCountry;
     @FindBy(xpath="//li[@class='stateprovince']")
     public  static WebElement customerState;
     @FindBy(xpath = "//li[@class='city']")
     public static WebElement customerCity;
     @FindBy(xpath = "//li[@class='address1']")
     public static WebElement customerAddress1;
     @FindBy(xpath = "//li[@class='address2']")
     public static WebElement customerAddress2;
     //------------------------------------
     @FindBy(xpath = "//button[@class='button-2 edit-address-button']")
     public static WebElement edit;
     @FindBy(xpath = "//button[@class='button-2 delete-address-button']")
     public static WebElement delete;

 }
public static class Orders
 {
     public Orders()
     {
         PageFactory.initElements(driver,this);
     }
@FindBy(xpath = "//div[@class='no-data']")
     public static WebElement noOrderMessage;
@FindBy(xpath = "//h1[.='My account - Orders']")
     public static WebElement label;
@FindBy(css="ul>li>span")
     public static List<WebElement> orderInfo;
@FindBy(xpath = "//strong[.='Order Number: 6']")
public static WebElement orderNo;

 }
  public  static class DownloadableProducts
    {



    }
  public  static class BackInStockSubscription
    {



    }
    public static class RewardPoints
    {



    }
    public  static class ChangePassword
    {



    }
    public  static class MyProductReviews
    {



    }
}
