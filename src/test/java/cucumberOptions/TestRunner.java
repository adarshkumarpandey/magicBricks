package cucumberOptions;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\ADARSPAN\\eclipse-workspace\\MagicBricks\\Features\\magicBricks.feature", // for all tests which are there in feature
		glue = "stepDefinations",
		tags="@PropertyValuation"
		)


public class TestRunner {

}
