package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Caminho das features
        glue = "steps", // Pacote com os steps
        tags = "@Athlete",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html" // Gera o HTML na pasta target
        }
)

public class CucumberRun {
}
