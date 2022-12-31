package curso.bdd.cucumber.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/java/curso/bdd/cucumber/features/Login.feature"}, 
                     glue="curso/bdd/cucumber",
                  plugin = {"json:target/jsonReports/cucumber.json","html:target/site/cucumber-pretty"})
public class LoginRunner extends AbstractTestNGCucumberTests {
}
