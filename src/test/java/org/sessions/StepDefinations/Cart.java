package org.sessions.StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.sessions.Pages.CartPage;
import org.sessions.Pages.homePage;
import org.sessions.Pages.bookPages;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Cart extends configuration
{   homePage home =new homePage();
    CartPage cartPage =new CartPage();
    bookPages book =new bookPages();
    static String arrowType =null;
    static int removeButtons =0;
    @Given("user click on book item in main menu")
    public void userClickOnBookItemInMainMenu()
    {   ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        home.BooksItem().click();
    }

    @When("user click on first prize pies book")
    public void userClickOnFirstPrizePiesBook() throws IOException {
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
       set("FirstPrizePies", book.Book_Name_First_Prize_Pies.getText());
       set("FirstPrizePiesPrice",book.Book_unitPrice_First_Prize_Pies.getText());
       System.out.printf("price:%s \n book name:%s",book.Book_Name_First_Prize_Pies.getText(),book.Book_unitPrice_First_Prize_Pies.getText());

       book.Add_First_Prize_Pies_Book_To_Cart.click();

    }

    @And("navigate to cart page")
    public void navigateToCartPage()
    {
    ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
    home.ShoppingCartButton().click();
    }

    @Then("the product has been added successfully in the cart")
    public void theProductHasBeenAddedSuccessfullyInTheCart()throws IOException
    {

        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();


                SoftAssert soft =new SoftAssert();
                soft.assertEquals(cartPage.unitPrice.getText(),get("FirstPrizePiesPrice"));
                soft.assertEquals(cartPage.productName.getText(),get("FirstPrizePies") );


                soft.assertAll();


    }

    @And("user click on increase and decrease arrow of quantity{string}")
    public void userClickOnIncreaseAndDecreaseArrowOfQuantity(String role)throws IOException
    {
         ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
         switch(role) {
             case "up" :    cartPage.upArrow.click();
             ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
             set("quantity", cartPage.productQuantity.getAttribute("value"));
             System.out.println("price:"+cartPage.productQuantity.getAttribute("value"));
             arrowType ="up";
             break;
             case "down":cartPage.downArrow.click();

             arrowType ="down";
             break;
             default:break;
         }
    }

    @Then("the quantity of product and total price is changed")
    public void theQuantityOfProductAndTotalPriceIsChanged() throws IOException{
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        SoftAssert soft= new SoftAssert();
        if(arrowType.equals("up")){
        soft.assertEquals(get("quantity"),"2");
        soft.assertAll();
        }
        else{
            soft.assertEquals(cartPage.emptyCartMessage.getText(),"Your Shopping Cart is empty!");
            soft.assertAll();

        }
    }

    @And("click on another book item")
    public void clickOnAnotherBookItem()
    {
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        book.Add_Pride_and_Prejudic_To_Cart.click();
    }

    @And("click on remove button")
    public void clickOnRemoveButton() {
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        removeButtons =cartPage.removeButtons.size();
        cartPage.removeButtons.getFirst().click();
    }

    @Then("item is deleted from the cart")
    public void itemIsDeletedFromTheCart() {
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        SoftAssert soft =new SoftAssert();
        soft.assertTrue(cartPage.removeButtons.size()<removeButtons);
        soft.assertAll();

    }
}
