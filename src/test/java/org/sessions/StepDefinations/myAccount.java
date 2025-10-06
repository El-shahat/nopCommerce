package org.sessions.StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.TimeoutException;
import org.sessions.Pages.homePage;
import org.sessions.Pages.myAccountPage;
import org.testng.asserts.SoftAssert;

public class myAccount extends configuration
{
    homePage home =new homePage();

@Given("registered user navigate to myAccountPage")
    public void registeredUserNavigateToMyAccountPage()
    {
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
       home.myAccountTab().click();
       myAccountPage.customerInfo.init();
    }


    @When("registered user edit has gender")
    public void registeredUserEditHasGender()
    {    ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
         if(myAccountPage.customerInfo.genderMale.isSelected())
         {
             myAccountPage.customerInfo.genderFemale.click();
         }
         else
         {
          myAccountPage.customerInfo.genderMale.click();
         }
    }

    @And("registered user edit has first and lastname")
    public void registeredUserEditHasFirstAndLastname()
    {   ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        myAccountPage.customerInfo.firstName.sendKeys(FakeData.randomFirstName());
        myAccountPage.customerInfo.lastName.sendKeys(FakeData.randomLastName());
    }

    @And("registered user edit has email")
    public void registeredUserEditHasEmail()
    {
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        myAccountPage.customerInfo.email.clear();
        myAccountPage.customerInfo.email.sendKeys(FakeData.randomEmail());
    }

    @And("registered user edit has company")
    public void registeredUserEditHasCompany()
    {
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        myAccountPage.customerInfo.company.sendKeys(FakeData.randomUsername());
    }

    @And("registered user clcik on news letter")
    public void registeredUserClcikOnNewsLetter()
    {
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        myAccountPage.customerInfo.checkbox.click();

    }

    @And("registered user click save")
    public void registeredUserClickSave()
    {
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        myAccountPage.customerInfo.saveButton.click();
    }

    @Then("has account details has been successfully edited")
    public void hasAccountDetailsHasBeenSuccessfullyEdited()throws InterruptedException
    {
        Thread.sleep(1000);
        SoftAssert soft =new SoftAssert();
        soft.assertTrue(myAccountPage.customerInfo.successMessage.isDisplayed());
        soft.assertTrue(myAccountPage.customerInfo.successMessage.getText().contains("The customer info has been updated successfully."));
        soft.assertEquals(myAccountPage.customerInfo.SuccessMessageColor.getCssValue("background-color"),"rgba(75, 176, 122, 1)");
        soft.assertAll();
    }
}
