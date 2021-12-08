package runners;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/resources/features/DodaxHomePage.feature",
	    glue = {"stepDefinitions"},
	    //tags = "@HomePage",
		//plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"},
	    // this plugin guarantee extent reports use
	    // see details here https://toolsqa.com/extent-report/extent-report-for-cucumber-testng-project
	    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true,
		publish = true
		)

       

public class TestRunner extends AbstractTestNGCucumberTests{

}


