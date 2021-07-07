package elpisclothing.testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@CucumberOptions(features = "src/test/java/elpisclothing/Features", 
glue = { "elpisclothing.StepsDefinitions" }, 
tags = { "@login or @search or @add or @edit or @delete" })

@RunWith(CucumberWithSerenity.class)
public class elpisclothingTestRunner {
}
