package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        stepNotifications = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true,
        plugin = {
                "html:target/cucumber-reports/html-report.html"
        },
        tags = "@basePage"
)
public class MainRunner {
}
