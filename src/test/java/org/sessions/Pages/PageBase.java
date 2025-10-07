package org.sessions.Pages;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.sessions.EnvironmentVariable.registerData;
import org.sessions.StepDefinations.Hooks;

import static org.sessions.StepDefinations.Hooks.driver;
public class PageBase {
   public static Scenario currentScenario;

   public PageBase(WebDriver driver)
   {
      PageFactory.initElements(driver,this);
   }

}
