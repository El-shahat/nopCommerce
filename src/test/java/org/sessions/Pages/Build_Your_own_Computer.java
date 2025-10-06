package org.sessions.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.sessions.StepDefinations.Hooks.driver;
public class Build_Your_own_Computer
{
    public Build_Your_own_Computer()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="[value='6']")
    public WebElement _320GB;
    @FindBy(css="[value='7']")
    public WebElement _400GB;
    @FindBy(css="[value='8']")
    public WebElement VistaHome;
    @FindBy(css="[value='9']")
    public WebElement VistaPremium;
    @FindBy(css="[value='10']")
    public WebElement MicrosoftOffice;
    @FindBy(css="[value='11']")
    public WebElement AcrobatReader;
    @FindBy(css="[value='12']")
    public WebElement TotalCommander;
    @FindBy(css="button[id=\"add-to-cart-button-1\"]")
    public WebElement AddToCartButton;
    @FindBy(css=".qty-input")
    public WebElement Quantity;
    @FindBy(css=".add-to-wishlist-button")
    public WebElement wishlistbutton;
}
