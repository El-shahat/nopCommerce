package org.sessions.Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.sessions.StepDefinations.Hooks.driver;
public class CartPage
{
   public CartPage()
   {
       PageFactory.initElements(driver,this);
   }
    @FindBy(css="span[class=\"product-unit-price\"]")
    public WebElement unitPrice;
    @FindBy(css="a[class=\"product-name\"]")
    public WebElement productName;
    @FindBy(xpath="//input[@class='qty-input']")
    public WebElement productQuantity;
    @FindBy(css="button[name=\"updatecart\"][type=\"button\"]")
    public List<WebElement> removeButtons;
    @FindBy(css="div[class=\"quantity up\"]")
    public WebElement upArrow;
    @FindBy(css="div[class=\"quantity down\"]")
    public WebElement downArrow;
    @FindBy(css="div[class=\"no-data\"]")
    public WebElement emptyCartMessage;
    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement checkoutButton;
    @FindBy(xpath = "//input[@id='termsofservice']")
    public WebElement checkboxTerm;
}
