package org.sessions.StepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.types.Feature;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.sessions.Pages.PageBase.currentScenario;
import java.io.IOException;
import java.time.Duration;

public class Hooks extends configuration
{
   public static WebDriver driver ;
    static String BrowserType ="Edge";

    @Before
    public void openBrowser(Scenario scenario)throws IOException
    {   currentScenario =scenario;

        String url = get("url","config.properties");

        if(!scenario.getName().contains("(customerInfo)")&&!scenario.getName().contains("(addresses)"))
        {
        switch(BrowserType)
        {
        case "Edge":System.setProperty("webdriver.edge.driver", "D:\\java course\\edgedriver_win64\\msedgedriver.exe");
        EdgeOptions options1 = new EdgeOptions();
        options1.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options1);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.navigate().to(url);
       break;

            case "Chrome":

        System.setProperty("webdriver.chrome.driver", "D:\\java course\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options2 = new ChromeOptions();
        options2.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options2);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.navigate().to(url);

        break;
            case "Firefox":
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.navigate().to(url);

        break;
        default:break;

    }}
    }
    @After
    public void quitBrowser(Scenario scenario)
    {

        if(driver!=null)
        {
            if(!scenario.getName().contains("login")&&!scenario.getName().contains("(customerInfo)")&&!scenario.getName().contains("(addresses)")) {

                driver.quit();
                driver = null;
            }

        }

    }
}
