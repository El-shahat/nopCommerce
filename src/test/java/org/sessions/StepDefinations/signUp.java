package org.sessions.StepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.sessions.StepDefinations.Hooks.driver;
import  static org.sessions.Pages.PageBase.currentScenario;
import io.cucumber.plugin.event.Node;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v137.indexeddb.model.Key;
import org.sessions.Pages.RegisterPage;
import org.sessions.Pages.homePage;
import org.sessions.StepDefinations.Hooks;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static org.sessions.EnvironmentVariable.registerData.ConfirmPassword;
public class signUp extends configuration {
    homePage home = new homePage();
    RegisterPage register = new RegisterPage();

    @Given("user click on register button")
    public void userClickOnRegisterButton() {
        ExplicitWaitUntilElementBeVisible(By.className("ico-register"));
        home.registerTab().click();
        return;
    }

    @When("user enter genderType {string}")
    public void userEnterGenderType(String type) {
        switch (type) {
            case "male":
                ExplicitWaitUntilElementBeVisible(By.id("gender-male"));
                register.genderMale.click();

                break;
            case "female":
                ExplicitWaitUntilElementBeVisible(By.id("gender-female"));
                register.genderFemale.click();

                break;
            default:
                break;
        }

    }

    @And("user enter first and last name")
    public void userEnterFirstAndLastName() {
        if (currentScenario.getName().contains("P")) {
            ExplicitWaitUntilElementBeVisible(By.cssSelector("div[class =\"inputs\"]>input[type=\"text\"][name =\"FirstName\"]"));
            register.FirstName.sendKeys(FakeData.randomFirstName());
            register.LastName.sendKeys(FakeData.randomLastName());
        } else {
            /*
            leave first and last name empty
        */
            ExplicitWaitUntilElementBeVisible(By.cssSelector("div[class =\"inputs\"]>input[type=\"text\"][name =\"FirstName\"]"));

        }
    }

    @And("user enter an email {string}")
    public void userEnterAnEmail(String arg0)throws IOException
    {   String email;
        if (currentScenario.getName().contains("P")) {
            ExplicitWaitUntilElementBeVisible(By.id("Email"));
            register.Email.sendKeys(email=FakeData.randomEmail());
            set("email",email);
        } else {
            ExplicitWaitUntilElementBeVisible(By.id("Email"));
            register.Email.sendKeys(arg0);
        }
    }

    @And("user enter company name {string}")
    public void userEnterCompanyName(String arg0) {
        switch (arg0) {
            case "AMIT":
                register.Company.sendKeys(arg0);
                break;
            case "":
                break;
            default:
                break;
        }

    }

    @And("user click on Newsletter checkBox {string}")
    public void userClickOnNewsletterCheckBox(String role) {
        switch (role) {
            case "dont click":
                break;
            case "click":
                register.Newsletter.click();
            default:
                break;
        }
    }

    @And("user enter a password")
    public void userEnterAPassword()throws IOException
    {
        String Confirm = "";

        register.password.sendKeys(Confirm = FakeData.randomPassword());
        ConfirmPassword = Confirm;
        set("password",Confirm);

    }

    @And("user enter a confirm password")
    public void userEnterAConfirmPassword() {
        register.confirmPassword.sendKeys(ConfirmPassword);
    }

    @Then("new account is created successfully")
    public void newAccountIsCreatedSuccessfully() {
        String ExpectedMessage = "Your registration completed", ActualMessage;
        ExplicitWaitUntilElementBeVisible(By.cssSelector("div[class=\"result\"]"));
        boolean result = register.SuccessEmail.isDisplayed();
        ActualMessage = register.SuccessEmail.getText();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(result);
        soft.assertEquals(ActualMessage, ExpectedMessage);
        soft.assertAll();


    }


    @And("user enter an invalid password {string}")
    public void userEnterAnInvalidPassword(String arg0) {
        register.password.sendKeys(arg0);
    }

    @And("user enter an invalid confirm password {string}")
    public void userEnterAnInvalidConfirmPassword(String arg0) {
        register.confirmPassword.sendKeys(arg0 + "1");
        register.confirmPassword.sendKeys(Keys.chord(Keys.ENTER));
    }

    @And("user click on SignUp")
    public void userClickOnSignUp() throws InterruptedException {
        register.registerButton.click();
        Thread.sleep(Duration.ofMillis(1000));
    }

    @Then("user couldn`t create an invalid account")
    public void userCouldnTCreateAnInvalidAccount() {
        SoftAssert soft = new SoftAssert();
        String ExpectedEmailErrorMessage = "Please enter a valid email address.", ExpectedPasswordErrorMessage = "Password must meet the following rules: must have at least 6 characters and not greater than 64 characters", ExpectedConfirmPasswordErrorMessage = "The password and confirmation password do not match.", ExpectedFirstNameErrorMessage = "First name is required.", ExpectedLastNameErrorMessage = "Last name is required.";
        String ActualEmailErrorMessage = register.WrongEmailMessage.getText(), ActualPasswordErrorMessage = register.WrongPasswordMessage.getText(), ActualConfirmPasswordErrorMessage = register.WrongConfirmPasswordMessage.getText(), ActualFirstNameErrorMessage = register.FirstName.getText(), ActualLastNameErrorMessage = register.LastName.getText();
        soft.assertEquals(ExpectedEmailErrorMessage, ActualEmailErrorMessage);
        soft.assertEquals(ExpectedConfirmPasswordErrorMessage, ActualConfirmPasswordErrorMessage);
        soft.assertEquals(ExpectedPasswordErrorMessage, ActualPasswordErrorMessage);
        soft.assertEquals(ExpectedLastNameErrorMessage, ActualLastNameErrorMessage);
        soft.assertEquals(ExpectedFirstNameErrorMessage, ActualFirstNameErrorMessage);
        soft.assertAll();
    }


}