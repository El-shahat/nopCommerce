package org.sessions.StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sessions.Pages.homePage;
import org.sessions.Pages.myAccountPage;
import org.testng.asserts.SoftAssert;


import java.io.IOException;
import java.util.List;

import static org.sessions.Pages.PageBase.currentScenario;
import static org.sessions.StepDefinations.Hooks.driver;

public class myAccount extends configuration
{
    homePage home =new homePage();

@Given("registered user navigate to myAccountPage")
    public void registeredUserNavigateToMyAccountPage()
    {
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",home.myAccountTab());

       if(currentScenario.getName().contains("(customerInfo)")) {
           myAccountPage.customerInfo.init();
       }


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

    @And("user click on addresses tab")
    public void userClickOnAddressesTab() throws IllegalAccessException {
        myAccountPage.Addresses.init();
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        myAccountPage.Addresses.AddressesTab.click();


    }

    @When("user click on add new")
    public void userClickOnAddNew()
    {
        myAccountPage.Addresses.AddNewButton.click();
    }

    @And("user enter has new first and last name")
    public void userEnterHasNewFirstAndLastName()throws IOException
    {   String fakeFirstName =FakeData.randomFirstName(),fakeLastName =FakeData.randomLastName();
        ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        myAccountPage.Addresses.firstName.sendKeys(fakeFirstName);
        myAccountPage.Addresses.lastName.sendKeys(fakeLastName);
        set("username",fakeFirstName+" "+fakeLastName,"AddressInfo.properties");
    }

    @And("user enter email")
    public void userEnterEmail()throws IOException
    {       String email =FakeData.randomEmail();
            myAccountPage.Addresses.email.sendKeys(email);
            set("email",email,"AddressInfo.properties");
    }

    @And("user enter company name")
    public void userEnterCompanyName()throws IOException
    {    String company=FakeData.randomUsername();
        myAccountPage.Addresses.company.sendKeys(company);
        set("company",company,"AddressInfo.properties");
    }

    @And("user enter country and state and city")
    public void userEnterCountryAndStateAndCity()throws IOException
    {

        Select country =new Select(myAccountPage.Addresses.country);

        Select state =new Select(myAccountPage.Addresses.state);

        int min_country=1,max_country =250 ,min_state=1 ,max_state= state.getOptions().size();

        int countryResult =(int)Math.floor(Math.random() *(max_country-min_country)+ min_country);

        int stateResult =(int)Math.floor(Math.random() *(max_state-min_state)+ min_state);
       country.selectByIndex(countryResult);

       state.selectByIndex(stateResult);

       myAccountPage.Addresses.city.sendKeys("fayoum");

       set("city","fayoum","AddressInfo.properties");

        for(WebElement option: country.getOptions())
        {
            if(option.isSelected())
            {
                set("country",option.getText(),"AddressInfo.properties");
                break;
            }
            else{continue;}

        }
        for(WebElement option: state.getOptions())
        {
            if(option.isSelected())
            {
                set("state",option.getText(),"AddressInfo.properties");
                break;
            }
            else{continue;}
        }
    }

    @And("user enter addresses1 and addresses2")
    public void userEnterAddressesAndAddresses2()throws IOException
    {   String address1="fayoum sgar3 abo baker el sedik",address2="fayoum behind of hospital of nada";
        myAccountPage.Addresses.Addresses1.sendKeys(address1);
        set("address1",address1,"AddressInfo.properties");
        myAccountPage.Addresses.Addresses2.sendKeys(address2);
        set("address2",address2,"AddressInfo.properties");
    }

    @And("user enter postal code and phone number and fax number")
    public void userEnterPostalCodeAndPhoneNumberAndFaxNumber() throws IOException {
        myAccountPage.Addresses.postalCode.sendKeys("62331");
        set("postal","62331","AddressInfo.properties");
        myAccountPage.Addresses.faxNumber.sendKeys("3211");
        set("fax","3211","AddressInfo.properties");
        myAccountPage.Addresses.phoneNo.sendKeys("01012345678");
        set("phone","01012345678","AddressInfo.properties");
    }

    @And("user click on save button")
    public void userClickOnSaveButton()
    {
        myAccountPage.Addresses.saveButton.click();
    }

    @Then("successfully new address message is displayed")
    public void successfullyNewAddressMessageIsDisplayed() throws IOException {   ExplicitWaitUntilAllElementWithItsJavaScriptsBeReady();
        SoftAssert soft =new SoftAssert();
        soft.assertEquals(myAccountPage.Addresses.successMessage.getText(),"The new address has been added successfully.");
        soft.assertEquals(myAccountPage.Addresses.barNotification.getCssValue("background-color"),"rgba(75, 176, 122, 1)");
        soft.assertEquals("Phone number: "+get("phone","AddressInfo.properties"),myAccountPage.Addresses.customerPhone.getText());
        soft.assertEquals(get("company","AddressInfo.properties"),myAccountPage.Addresses.customerCompany.getText());
        soft.assertEquals(get("country","AddressInfo.properties"),myAccountPage.Addresses.customerCountry.getText());
        soft.assertEquals(get("state","AddressInfo.properties"),myAccountPage.Addresses.customerState.getText());
        soft.assertEquals("Email: "+get("email","AddressInfo.properties"),myAccountPage.Addresses.customerEmail.getText());
        soft.assertEquals(get("address1","AddressInfo.properties"),myAccountPage.Addresses.customerAddress1.getText());
        soft.assertEquals(get("address2","AddressInfo.properties"),myAccountPage.Addresses.customerAddress2.getText());
        soft.assertEquals("Fax number: "+get("fax","AddressInfo.properties"),myAccountPage.Addresses.customerFax.getText());
        soft.assertEquals(get("username","AddressInfo.properties"),myAccountPage.Addresses.customerName.getText());

        soft.assertAll();
    }
}
