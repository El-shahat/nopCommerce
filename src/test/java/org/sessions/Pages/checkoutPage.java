package org.sessions.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.sessions.StepDefinations.Hooks.driver;

public class checkoutPage extends PageBase{
    public checkoutPage()
    {
        super(driver);
    }
    @FindBy(xpath = "//div[.='1Billing address']")
    public WebElement BillingAddress;
    @FindBy(xpath = "//div[.='2Shipping address']")
    public WebElement ShippingAddress;
    @FindBy(xpath = "//h2[.='Shipping method']")
    public WebElement ShippingMethod;
    @FindBy(xpath = "//h2[.='Payment method']")
    public WebElement paymentMethod;
    @FindBy(xpath = "//h2[.='Payment information']")
    public WebElement paymentInformation;
    @FindBy(xpath = "//h2[.='Confirm order']")
    public WebElement ConfirmOrder;
    public static class billingAddress extends PageBase
    {
        public billingAddress()
        {
            super(driver);
        }
      @FindBy(xpath = "//input[@id='BillingNewAddress_FirstName']")
      public static WebElement firstName;
      @FindBy(xpath = "//input[@id='BillingNewAddress_LastName']")
      public static WebElement lastName;
      @FindBy(xpath =   "//input[@id='BillingNewAddress_Email']")
      public static WebElement email;
      @FindBy(xpath =  "//input[@id='BillingNewAddress_Company']")
      public static WebElement company;
     @FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
     public static WebElement country;
      @FindBy(xpath = " //select[@id='BillingNewAddress_StateProvinceId']")
      public static WebElement state;
        @FindBy(xpath =  "//input[@id='BillingNewAddress_City']")
        public static WebElement city;
      @FindBy(xpath = "//div[@class='edit-address']/div[8]/input[1]")
      public static WebElement add1;
      @FindBy(css = "div[class=\"inputs\"] > input[type=\"text\"][id=\"BillingNewAddress_Address2\"]")
      public static WebElement add2;
      @FindBy(xpath =" //input[@id='BillingNewAddress_ZipPostalCode']")
      public static WebElement postal;
      @FindBy(xpath = "//input[@id='BillingNewAddress_PhoneNumber']")
        public static WebElement phone;
      @FindBy(xpath = "//input[@id='BillingNewAddress_FaxNumber']")
        public static WebElement fax;
      @FindBy(xpath = "//button[@id='save-billing-address-button']")
      public static WebElement saveButton;
      @FindBy(xpath = "//div[@id='billing-buttons-container']/button[@name='save']")
        public static WebElement continueButton;

      public static void init() throws IllegalAccessException
      {     billingAddress temp =new billingAddress();
          for(Field f:billingAddress.class.getDeclaredFields())
          {
              if(Modifier.isStatic(f.getModifiers()) && f.getType() ==WebElement.class)
              {
                  f.set(null,f.get(temp));
              }
          }
      }
    }
    public static class shippingAddress extends PageBase
    {
        public shippingAddress()
        {
            super(driver);
        }
        @FindBy(xpath = "//div[@id='shipping-buttons-container']//a[.='« Back']")
        public static WebElement backButton;
        @FindBy(xpath = "//div[@id='shipping-buttons-container']/button[@class='button-1 new-address-next-step-button']")
        public static WebElement continueButton;
        public static void init() throws IllegalAccessException
        {     shippingAddress temp =new shippingAddress();
            for(Field f:shippingAddress.class.getDeclaredFields())
            {
                if(Modifier.isStatic(f.getModifiers()) && f.getType() ==WebElement.class)
                {
                    f.set(null,f.get(temp));
                }
            }
        }
    }
    public static class shippingMethod extends PageBase
    {
        public  shippingMethod()
        {
            super(driver);
        }
        @FindBy(xpath = "//label[.='Ground ($0.00)']")
        public static WebElement Ground;
        @FindBy(xpath = "//label[.='Next Day Air ($0.00)']")
        public static WebElement NextDayAir;
        @FindBy(xpath = "//label[.='2nd Day Air ($0.00)']")
        public static WebElement secondDayAir;
        @FindBy(xpath = "//div[@id='shipping-method-buttons-container']//a[.='« Back']")
        public static WebElement backButton;
        @FindBy(xpath = "//button[@class='button-1 shipping-method-next-step-button']")
        public static WebElement continueButton;
        public static void init() throws IllegalAccessException
        {     shippingMethod temp =new shippingMethod();
            for(Field f:shippingMethod.class.getDeclaredFields())
            {
                if(Modifier.isStatic(f.getModifiers()) && f.getType() ==WebElement.class)
                {
                    f.set(null,f.get(temp));
                }
            }
        }
    }
    public static class payment extends PageBase
    {
        public  payment()
    {
        super(driver);
    }
    @FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
    public static WebElement continueButton;
   @FindBy(xpath = "//input[@value='Payments.CheckMoneyOrder']")
        public static WebElement moneyOrder;
   @FindBy(xpath = "//input[@value='Payments.Manual']")
        public static WebElement creditCard;

    }
    public static class paymentInfo extends PageBase
    {     public paymentInfo()
    {
        super(driver);
    }
        @FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
        public static WebElement continueButton;
    }
    public static class confirmOrder extends PageBase
    {
        public confirmOrder()
        {
            super(driver);
        }
        @FindBy(xpath="//button[@class='button-1 confirm-order-next-step-button']")
        public static WebElement confirmButton;
    }
    public static class completedMessage extends PageBase {
        public completedMessage()
        {
            super(driver);
        }
        @FindBy(xpath = "//strong[.='Your order has been successfully processed!']")
        public static WebElement message;
        @FindBy(xpath = "//div[@class=\"details\"]//strong")
        public static WebElement ordernumber;
        @FindBy(xpath = "//button[@class='button-1 order-completed-continue-button']")
        public static  WebElement continueButton;
    }

}
