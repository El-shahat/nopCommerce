package org.sessions.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

import static org.sessions.StepDefinations.Hooks.driver;

public class bookPages
{
   public bookPages()
   {
    PageFactory.initElements(driver,this);
   }
@FindBy(xpath = "//div[@class='item-grid']//a[.='First Prize Pies']")
    public WebElement Book_Name_First_Prize_Pies;
   @FindBy(xpath = "//a[.='Fahrenheit 451 by Ray Bradbury']")
    public WebElement Book_Name_Fahrenheit_451_by_Ray_Bradbury;
   @FindBy(xpath = "//a[.='Pride and Prejudice']")
    public WebElement Book_Name_Pride_and_Prejudice;
   @FindBy(xpath = "//span[.='$27.00']")
    public WebElement Book_unitPrice_Fahrenheit_451_by_Ray_Bradbury;
   @FindBy(xpath = "//div[@class='item-grid']//span[.='$51.00']")
    public WebElement Book_unitPrice_First_Prize_Pies;
   @FindBy(xpath = "//a[.='Pride and Prejudice']")
    public WebElement Book_unitPrice_Pride_and_Prejudice;
   @FindBy(xpath = "//div[@class='item-grid']/div[1]//button[@class='button-2 product-box-add-to-cart-button']")
    public WebElement Add_Fahrenheit_451_by_Ray_Bradbury_Book_To_Cart;
   @FindBy(xpath = "//div[@class='item-grid']/div[2]//button[@class='button-2 product-box-add-to-cart-button']")
    public WebElement Add_First_Prize_Pies_Book_To_Cart;
   @FindBy(xpath = "//div[@class='item-grid']/div[3]//button[@class='button-2 product-box-add-to-cart-button']")
    public WebElement Add_Pride_and_Prejudic_To_Cart;

}
