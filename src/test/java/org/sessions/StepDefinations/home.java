package org.sessions.StepDefinations;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sessions.Pages.Build_Your_own_Computer;
import org.sessions.Pages.homePage;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.function.Function;

import static org.sessions.Pages.PageBase.currentScenario;
import static org.sessions.StepDefinations.Hooks.driver;
public class home extends configuration
{ homePage products =new homePage();
    Build_Your_own_Computer custom = new Build_Your_own_Computer();
   static int index =0;
    @Given("user scroll down to see products")
    public void userScrollDownToSeeProducts()
    {
        JavascriptExecutor js =(JavascriptExecutor) driver ;
        switch(currentScenario.getName())
        {
            case "user could find  some product":
             js.executeScript("arguments[0].scrollIntoView(true);",products.AppleMackBookPro());
             break;
            case "guest user or registered user could add product to his own cart":
                js.executeScript("arguments[0].scrollIntoView(true);",products.AppleMackBookPro());
                break;
            case"guest user could add product to compare list":
                js.executeScript("arguments[0].scrollIntoView(true);",products.AppleMackBookPro());
                break;
            case "guest user could add product to wishlist":
                js.executeScript("arguments[0].scrollIntoView(true);",products.AppleMackBookPro());
                break;
            case "guest user could add build to order product to wish list":
                js.executeScript("arguments[0].scrollIntoView(true);",products.BuildYourOwnComputer());
                break;
            case "guest user could add build to order product to his own cart":
                js.executeScript("arguments[0].scrollIntoView(true);",products.BuildYourOwnComputer());
                break;
            default :break;
        }


    }

    @When("user click on his desired product")
    public void userClickOnHisDesiredProduct()
    {

             products.AppleMackBookPro().click();
    }
    @Then("the product page is displayed")
    public void theProductPageIsDisplayed()
    {
        SoftAssert soft =new SoftAssert();

        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/apple-macbook-pro");
    }

    @When("user click on add to cart button")
    public void userClickOnAddToCartButton()throws InterruptedException
    {   ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        products.HTC_smartPhoneAddCart().click();
    }

    @Then("product successfully added to his own cart")
    public void productSuccessfullyAddedToHisOwnCart()
    {
        SoftAssert soft =new SoftAssert();
        ExplicitWaitUntilElementBeVisible(By.cssSelector("p[class=\"content\"]"));
        soft.assertTrue(products.SuccessfullyAddingProductMessage().isDisplayed());
        soft.assertEquals(products.SuccessfullyAddingProductMessage().getText(),"The product has been added to your shopping cart");
        soft.assertEquals(products.SuccessfullyAddingProductBackGroundColor().getCssValue("background-color"),"rgba(75, 176, 122, 1)");
        soft.assertAll();
    }

    @When("user click on compare list button")
    public void userClickOnCompareListButton() throws InterruptedException
    {   ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        JavascriptExecutor JS =(JavascriptExecutor) driver;
        JS.executeScript("arguments[0].click();",products.CompareListButtonForAppleMacBookPro());

    }

    @Then("product has been added successfully to compare list")
    public void productHasBeenAddedSuccessfullyToCompareList()
    {   SoftAssert soft =new SoftAssert();
        ExplicitWaitUntilElementBeVisible(By.cssSelector("p[class=\"content\"]"));
        soft.assertEquals(products.SuccessfullyAddingProductMessage().getText(),"The product has been added to your product comparison");
        soft.assertTrue(products.SuccessfullyAddingProductMessage().isDisplayed());
        soft.assertEquals(products.SuccessfullyAddingProductBackGroundColor().getCssValue("background-color"),"rgba(75, 176, 122, 1)");
        soft.assertAll();

    }

    @When("user click on wishlist button")
    public void userClickOnWishlistButton()throws InterruptedException //java script code may doesn`t be downloaded so we put unconditional Synchronizational
    { ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
   products.HTC_MobileWishList().click();
    }

    @Then("product has been added successfully to wishlist")
    public void productHasBeenAddedSuccessfullyToWishlist()
    {
        SoftAssert soft =new SoftAssert();
        ExplicitWaitUntilElementBeVisible(By.cssSelector("p[class=\"content\"]"));
        soft.assertEquals(products.SuccessfullyAddingToWishListMessage().getText(),"wishlist");
        soft.assertEquals(products.SuccessfullyAddingProductBackGroundColor().getCssValue("background-color"),"rgba(75, 176, 122, 1)");
        soft.assertAll();
    }

    @And("select configuration of product {string} {string} {string}")
    public void selectConfigurationOfProduct(String RAM, String PROCESSOR, String HDD)
    {
        if (RAM.equals("2") && PROCESSOR.equals("2.2 GHz Intel Pentium Dual-Core E2200") && HDD.equals("320"))
        {   ExplicitWaitUntilElementBeVisible(By.cssSelector("select[name=\"product_attribute_1\"]"));
            Select processor =new Select(driver.findElement(By.cssSelector("select[name=\"product_attribute_1\"]")));
            Select ram =new Select(driver.findElement(By.cssSelector("select[name=\"product_attribute_2\"]")));
            processor.selectByIndex(1);
            ram.selectByIndex(1);
            custom._320GB.click();
            custom.AcrobatReader.click();
            custom.VistaHome.click();
            custom.MicrosoftOffice.click();
            custom.TotalCommander.click();
        }
        else if(RAM.equals("4") && PROCESSOR.equals("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]") && HDD.equals("400"))
        {    ExplicitWaitUntilElementBeVisible(By.cssSelector("select[name=\"product_attribute_1\"]"));
            Select processor =new Select(driver.findElement(By.cssSelector("select[name=\"product_attribute_1\"]")));
            Select ram =new Select(driver.findElement(By.cssSelector("select[name=\"product_attribute_2\"]")));
            processor.selectByIndex(2);
            ram.selectByIndex(2);
            custom._400GB.click();
            custom.AcrobatReader.click();
            custom.VistaPremium.click();
            custom.MicrosoftOffice.click();
            custom.TotalCommander.click();
        }
        else
        { ExplicitWaitUntilElementBeVisible(By.cssSelector("select[name=\"product_attribute_1\"]"));
            Select processor =new Select(driver.findElement(By.cssSelector("select[name=\"product_attribute_1\"]")));
            Select ram =new Select(driver.findElement(By.cssSelector("select[name=\"product_attribute_2\"]")));
            processor.selectByIndex(1);
            ram.selectByIndex(3);
            custom._320GB.click();
            custom.AcrobatReader.click();
            custom.VistaPremium.click();
            custom.MicrosoftOffice.click();
            custom.TotalCommander.click();
        }
    }

    @And("click add to wish list")
    public void clickAddToWishList()
    {
       custom.wishlistbutton.click();
    }

    @Then("the product has been added successfully")
    public void theProductHasBeenAddedSuccessfully()
    {
        SoftAssert soft =new SoftAssert();
        ExplicitWaitUntilElementBeVisible(By.cssSelector("p[class=\"content\"]"));
        soft.assertTrue(products.SuccessfullyAddingProductMessage().isDisplayed());
        soft.assertEquals(products.SuccessfullyAddingProductMessage().getText(),"The product has been added to your shopping cart");
        soft.assertEquals(products.SuccessfullyAddingProductBackGroundColor().getCssValue("background-color"),"rgba(75, 176, 122, 1)");
        soft.assertAll();
    }

    @When("user click on add to cart  button")
    public void userClickOnAddToCartButtonButton()throws InterruptedException
    {     ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
           products.AddToCartBuildToOrderButton().click();

    }

    @And("user click on add to cart")
    public void userClickOnAddToCart()
    {   ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        custom.AddToCartButton.click();
    }

    @Given("user navigate to nopCommerce")
    public void userNavigateToNopCommerce()
    {
        //it done from before
    }

    @Then("Main Menu is displayed")
    public void mainMenuIsDisplayed()
    {
        SoftAssert soft =new SoftAssert();
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        soft.assertTrue(products.ComputersItem().isDisplayed());
        soft.assertTrue(products.ApparelItem().isDisplayed());
        soft.assertTrue(products.BooksItem().isDisplayed());
        soft.assertTrue(products.GiftCardsItem().isDisplayed());
        soft.assertTrue(products.DigitalDownloadsItem().isDisplayed());
        soft.assertTrue(products.ElectronicsItem().isDisplayed());
        soft.assertTrue(products.JewelryItem().isDisplayed());
        soft.assertTrue(products.ComputersItem().isEnabled());
        soft.assertTrue(products.ApparelItem().isEnabled());
        soft.assertTrue(products.BooksItem().isEnabled());
        soft.assertTrue(products.GiftCardsItem().isEnabled());
        soft.assertTrue(products.DigitalDownloadsItem().isEnabled());
        soft.assertTrue(products.ElectronicsItem().isEnabled());
        soft.assertTrue(products.JewelryItem().isEnabled());
        soft.assertAll();
    }

    @When("user click on menu item {string}")
    public void userClickOnMenuItem(String menuItem)
    {
        List<WebElement> MainMenu = List.of(new WebElement[]{products.ElectronicsItem()
                , products.DigitalDownloadsItem()
                ,products.ComputersItem(),
                products.GiftCardsItem()
                ,products.BooksItem()
                ,products.ApparelItem()
                ,products.JewelryItem()});

        MainMenu.get(index).click();

    }

    @Then("related page is displayed")
    public void relatedPageIsDisplayed()
    {
        String[] ExpectedURL ={"https://demo.nopcommerce.com/electronics",
                "https://demo.nopcommerce.com/digital-downloads",
                "https://demo.nopcommerce.com/computers",
                "https://demo.nopcommerce.com/gift-cards",
                "https://demo.nopcommerce.com/books",
                "https://demo.nopcommerce.com/apparel",
                "https://demo.nopcommerce.com/jewelry"
                };
        SoftAssert soft =new SoftAssert();
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        soft.assertEquals(driver.getCurrentUrl(),ExpectedURL[index]);
        soft.assertAll();
            index++;


    }
}
