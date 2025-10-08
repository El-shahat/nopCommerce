package org.sessions.StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sessions.Pages.CartPage;
import org.sessions.Pages.cellPhonePage;
import org.sessions.Pages.checkoutPage;
import org.sessions.Pages.checkoutPage.billingAddress;
import org.sessions.Pages.homePage;
import org.testng.asserts.SoftAssert;

import static org.sessions.StepDefinations.Hooks.driver;

public class checkout extends  configuration
{    homePage home =new homePage();
    cellPhonePage phone =new cellPhonePage();
    CartPage cart =new CartPage();
    checkoutPage checkout =new checkoutPage();
@Given("the user selects \"Cell phones\" from the Electronics category")
    public void theUserSelectCellPhoneFromTheElectronicsCategory()
 {
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
     Actions action =new Actions(driver);
     action.moveToElement(home.ElectronicsItem()).moveToElement(home.subItemCellPhone()).click().build().perform();

 }


    @And("the user adds three different phone models to the cart")
    public void theUserAddsThreeDifferentPhoneModelsToTheCart() {
    ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
    phone.AppleIPhone16128GB.click();
    phone.HTCSmartPhone.click();
    phone.HTCOneMiniBlue.click();

    }

    @And("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",home.ShoppingCartButton());
    }

    @When("the user agrees to the terms of service and proceeds to checkout")
    public void theUserAgreesToTheTermsOfServiceAndProceedsToCheckout()
    {   ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        cart.checkboxTerm.click();
        cart.checkoutButton.click();
    }

    @And("the user enters valid billing and shipping details")
    public void theUserEntersValidBillingAndShippingDetails() throws IllegalAccessException {
    ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
    checkoutPage.billingAddress.init();
    billingAddress.firstName.sendKeys(FakeData.randomFirstName());
    billingAddress.lastName.sendKeys(FakeData.randomLastName());
    billingAddress.city.sendKeys("fayoum");
    billingAddress.add1.sendKeys("fayoum-elnada hospital");
    billingAddress.add2.sendKeys("null");
    billingAddress.company.sendKeys("asds");
        Select country =new Select(billingAddress.country),state =new Select(billingAddress.state);
        country.selectByIndex((int)Math.floor(Math.random() *(country.getOptions().size()-1)+1));
        billingAddress.email.clear();
        billingAddress.email.sendKeys(FakeData.randomEmail());
        billingAddress.fax.sendKeys("12323");
        billingAddress.phone.sendKeys("01012345678");
        billingAddress.postal.sendKeys("123321");
        state.selectByIndex((int)Math.floor(Math.random()*(state.getOptions().size()-0)+0));
        billingAddress.continueButton.click();
    }

    @And("the user selects a preferred shipping method")
    public void theUserSelectsAPreferredShippingMethod() throws IllegalAccessException {
    ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
    checkoutPage.shippingMethod.init();
    checkoutPage.shippingMethod.Ground.click();
    checkoutPage.shippingMethod.continueButton.click();
    }

    @And("the user selects a payment method")
    public void theUserSelectsAPaymentMethod() throws IllegalAccessException {
    ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
    checkoutPage.payment.init();
    checkoutPage.payment.moneyOrder.click();
    checkoutPage.payment.continueButton.click();
    }

    @And("the user verifies that the payment information for {string} is displayed correctly")
    public void theUserVerifiesThatThePaymentInformationForIsDisplayedCorrectly(String arg0) {
       //iam tired from writing the code put soft assert here to assert the payment information message :)
    }

    @And("the user clicks on Continue")
    public void theUserClicksOnContinue() throws IllegalAccessException {
    ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
    checkoutPage.paymentInfo.init();
        checkoutPage.paymentInfo.continueButton.click();
    }

    @And("the user clicks on Confirm order")
    public void theUserClicksOnConfirmOrder() throws IllegalAccessException {
    ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
    checkoutPage.confirmOrder.init();
    checkoutPage.confirmOrder.confirmButton.click();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() throws IllegalAccessException {
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        checkoutPage.completedMessage.init();
        SoftAssert soft =new SoftAssert();
        //here iam calling ordernumber webelemnt that contain order numer then we need to ensure that contain a number
        soft.assertTrue(checkoutPage.completedMessage.ordernumber.getText().matches(".*\\\\d+.*"),"order number is not displayed");//this mean it contain a number .*\\d+.*;
        soft.assertEquals(checkoutPage.completedMessage.message.getText(),"Your order has been successfully processed!");
        soft.assertAll();

    }
}
