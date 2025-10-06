package org.sessions.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(

        features = "D:\\java course\\nopCommerce\\src\\main\\resources\\Features",

        glue ="org.sessions.StepDefinations",
        tags="@signUp or @login or @myaccount",
        plugin =
        {
                "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cuckes.xml",
                "rerun:target/rerun.txt"

        }
)
public class runners extends AbstractTestNGCucumberTests
{
        @BeforeClass(alwaysRun = true)
        @Parameters({"featureOrder"})
        public void runInOrder() {
                System.out.println("Running features in defined order...");
        }

}
