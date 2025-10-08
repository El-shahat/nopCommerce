package org.sessions.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.sessions.StepDefinations.Hooks.driver;
public class cellPhonePage extends  PageBase
{
    public cellPhonePage()
    {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='item-grid']/div[1]//button[@class='button-2 product-box-add-to-cart-button']")
    public WebElement AppleIPhone16128GB;
    @FindBy(xpath = "//div[@class='item-grid']/div[2]//button[@class='button-2 product-box-add-to-cart-button']")
    public WebElement HTCOneMiniBlue;
    @FindBy(xpath = "//div[@class='item-grid']/div[3]//button[@class='button-2 product-box-add-to-cart-button']")
    public WebElement HTCSmartPhone;

}
