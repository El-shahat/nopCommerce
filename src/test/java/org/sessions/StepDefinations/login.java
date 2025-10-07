package org.sessions.StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.sessions.Pages.loginPage;
import org.sessions.Pages.homePage;
import org.testng.asserts.SoftAssert;

import java.io.IOException;


public class login extends configuration
{   homePage home =new homePage();
    loginPage login =new loginPage();
   final String ExpectedLoginLabelMessage ="Returning Customer",
                ExpectedRegisterLabelMessage="New Customer",
                ExpectedTextMessage="By creating an account on our website, you will be able to shop faster, be up to date on an order's status, and keep track of the orders you have previously made.",
                ExpectedSuccessfullyLoginMessage="Welcome, Please Sign In!",ExpectedAboutLoginRegisterMessage="About login / registration";
    @Given("user click on login button")
    public void userClickOnLoginButton()
    {
      home.loginTab().click();
    }

    @When("user enter a valid email")
    public void userEnterAValidEmail()throws IOException
    {
        login.EmailField.sendKeys(get("email","config.properties"));
    }

    @And("user enter a valid password")
    public void userEnterAValidPassword() throws IOException
    {
        login.PasswordField.sendKeys(get("password","config.properties"));
    }

    @And("click on remember me checkbox{string}")
    public void clickOnRememberMeCheckbox(String arg0)
    {   switch(arg0)
    {
        case "click" :  login.CheckboxField.click();
        break;
        case "don`t click":break;
        default:break;
    }
    }

    @And("click on login button")
    public void clickOnLoginButton()
    {
        login.loginButton.click();
    }

    @Then("user could login successfully")
    public void userCouldLoginSuccessfully()
    { SoftAssert soft =new SoftAssert();
        soft.assertTrue(home.logoutTab().isDisplayed());
        soft.assertTrue(home.logoutTab().isEnabled());

    }
}
