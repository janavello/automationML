package runner;
import org.junit.AfterClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import pages.WebBasePage;


@RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/features",
            glue = "stepsDefinition",
            tags = "@MercadoLibre"

    )


    public class runner {
        @AfterClass
        public static void cleanDriver() {
            WebBasePage.closeBrowser();
        }
    }
