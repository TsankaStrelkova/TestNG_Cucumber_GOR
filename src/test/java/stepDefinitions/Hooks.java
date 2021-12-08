package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

    TestContext testContext;
    public static String nameOfScenario;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setUp(Scenario scenario) {
    	  nameOfScenario = scenario.getName();
    }

   
//    @After
//    public void tearDown() {
//        testContext.getWebDriverManager().closeDriver();
//    }
//    
   
    @After
   	public void addScreenshot(Scenario scenario) throws IOException {
   		  File screenshot = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
   		  byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
   		  scenario.attach(fileContent, "image/png", "screenshot");
   		  
   		  testContext.getWebDriverManager().closeDriver();
   		
   	}
	
}