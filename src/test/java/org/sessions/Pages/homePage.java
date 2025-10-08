package org.sessions.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.sessions.StepDefinations.Hooks.driver;


public class homePage
{
    //simple way
    public WebElement registerTab()

    {
        return driver.findElement(By.className("ico-register"));
    }
    public WebElement loginTab()
    {

        return driver.findElement(By.className("ico-login"));
    }

   public WebElement logoutTab()
   {
       return driver.findElement(By.className("ico-logout"));
   }
   public WebElement AppleMackBookPro()
   {
       return driver.findElement(By.linkText("Apple MacBook Pro"));
   }
   public WebElement BuildYourOwnComputer()
    {
        return driver.findElement(By.linkText("Build your own computer"));
    }
   public WebElement AppleMacBookProAddToCartButton()
   {
       return driver.findElement(By.cssSelector("[data-productid='4'] .product-box-add-to-cart-button"));
   }
   public WebElement SuccessfullyAddingProductMessage()
   {
       return driver.findElement(By.cssSelector("p[class=\"content\"]"));
   }
   public WebElement CompareListButtonForAppleMacBookPro()
   {
       return driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']/div[@class='item-grid']/div[2]//button[@class='button-2 add-to-compare-list-button']"));
   }
   public WebElement HTC_smartPhoneAddCart()
   {
       return driver.findElement(By.cssSelector("[data-productid='18'] .product-box-add-to-cart-button"));
   }
   public WebElement AppleMackBookProWishList()
   {
       return driver.findElement(By.cssSelector("[data-productid=\"4\"] .add-to-wishlist-button"));
   }
   public WebElement SuccessfullyAddingToWishListMessage()
   {
       return driver.findElement(By.linkText("wishlist"));
   }
   public WebElement AddToCartBuildToOrderButton()
   {
       return driver.findElement(By.cssSelector("[data-productid='1'] .product-box-add-to-cart-button"));
   }
   public WebElement SuccessfullyAddingProductBackGroundColor()
   {
       return  driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
   }
   public WebElement HTC_MobileWishList()
   {
       return  driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']/div[@class='item-grid']/div[3]//button[@class='button-2 add-to-wishlist-button']"));
   }
   public WebElement ComputersItem()
   {
       return driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(.,'Computers')]"));
   }
   public WebElement ElectronicsItem()
   {
       return  driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(.,'Electronics')]"));
   }
   public WebElement ApparelItem()
   {
       return driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(.,'Apparel')]"));
   }
   public WebElement DigitalDownloadsItem()
   {
       return driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(.,'Digital downloads')]"));
   }
   public  WebElement BooksItem()
   {
       return driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(.,'Books')]"));
   }
   public WebElement JewelryItem()
   {
       return driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(.,'Jewelry')]"));
   }
   public WebElement GiftCardsItem()
   {
       return driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(.,'Gift Cards')]"));
   }
   public WebElement subDesktopsItem()
   {
       return driver.findElement(By.linkText("Desktops"));
   }
   public WebElement subNotebooksItem()
   {
       return driver.findElement(By.linkText("Notebooks"));
   }
   public WebElement subSoftwareItem()
   {
       return  driver.findElement(By.linkText("Software"));
   }
   public WebElement ShoppingCartButton()
   {
       return driver.findElement(By.xpath("//span[@class='cart-label']"));
   }
   public WebElement myAccountTab()
   {
       return driver.findElement(By.xpath("//div[@class='header-links']//a[.='My account']"));
   }
   public WebElement subItemCellPhone()
   {
       return driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(.,'Cell phones')]"));
   }
}
