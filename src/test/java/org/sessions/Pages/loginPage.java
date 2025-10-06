package org.sessions.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.sessions.StepDefinations.Hooks.driver;
public class loginPage
{
    public loginPage()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css ="input[class=\"email\"]")
    public WebElement EmailField;
    @FindBy(css="input[class=\"password\"]")
    public WebElement PasswordField;
    @FindBy(css="input[type=\"checkbox\"]")
    public WebElement CheckboxField;
    @FindBy(linkText = "Forgot password?")
    public WebElement ForgetPssword;
    @FindBy(css="button[type=\"submit\" ][class=\"button-1 login-button\"]")
    public WebElement loginButton;
    @FindBy(css="button[type=\"button\"][class=\"button-1 register-button\"]")
    public WebElement registerbutton;
    @FindBy(css="h1[data--h-bstatus=\"0OBSERVED\"]")
    public WebElement successfullyMessage;
    @FindBy(css="span[class=\"password-eye]")
    public WebElement passwordEye;
    @FindBy(xpath = "//div[@class=\"returning-wrapper fieldset\"]//strong")
    public WebElement loginLabel;
    @FindBy(xpath = "//div[@class=\"new-wrapper register-block\"]//strong")
    public WebElement NewCustomerLabel;
    @FindBy(css="div[class=\"text\"]")
    public WebElement text;
    @FindBy(css="h2[data--h-bstatus=\"0OBSERVED\"]")
    public WebElement About_login_registration_label;


}
