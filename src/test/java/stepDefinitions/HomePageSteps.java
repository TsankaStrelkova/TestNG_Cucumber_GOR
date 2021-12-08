package stepDefinitions;


import cucumber.TestContext;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class HomePageSteps {

    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("^The user is on Home Page$")
    public void the_user_is_on_Home_Page() {
        homePage.navigateTo_HomePage();
    }

    @When("^They search for \"([^\"]*)\"$")
    public void they_search_for(String product) {
        homePage.perform_Search(product);
    }
    
   
}