package org.sessions.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v137.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.sessions.StepDefinations.Hooks.driver;
public class RegisterPage
{  //apply pom pattern with pageFactory>>selenium framework
    public RegisterPage()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "gender-male")
    public WebElement genderMale;
    @FindBy(id="gender-female")
    public WebElement genderFemale;
    @FindBy(css ="div[class =\"inputs\"]>input[type=\"text\"][name =\"FirstName\"]")
    public WebElement FirstName;
    @FindBy(id="LastName")
    public WebElement LastName;
    @FindBy(id="Email")
    public WebElement Email;
    @FindBy(id="Company")
    public WebElement Company;
    @FindBy(id="Newsletter")
    public WebElement Newsletter;
    @FindBy(id="Password")
    public WebElement password;
    @FindBy(id="ConfirmPassword")
    public WebElement confirmPassword;
    @FindBy(id="register-button")
    public WebElement registerButton;
    @FindBy(css="div[class=\"result\"]")
    public WebElement SuccessEmail;
    @FindBy(css ="div[class=\"inputs\"]>span>span[id=\"Email-error\"]")
    public WebElement WrongEmailMessage;
    @FindBy(css ="div[class=\"inputs\"]>span>span[id=\"FirstName-error\"]")
    public WebElement WrongFirstNameMessage;
    @FindBy(css ="div[class=\"inputs\"]>span>span[id=\"LastName-error\"]")
    public WebElement WrongLastNameMessage;
    @FindBy(css ="div[class=\"inputs\"]>span>span[id=\"Password-error\"]")
    public WebElement WrongPasswordMessage;
    @FindBy(css ="div[class=\"inputs\"]>span>span[id=\"ConfirmPassword-error\"]")
    public WebElement WrongConfirmPasswordMessage;
}
