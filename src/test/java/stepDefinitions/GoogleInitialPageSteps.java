package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GoogleInitialPage;

public class GoogleInitialPageSteps {
	
	TestContext testContext;
	GoogleInitialPage googleInitialPage;
	
	public GoogleInitialPageSteps (TestContext context) {
		testContext = context;
		googleInitialPage = testContext.getPageObjectManager().getGoogleInitialPage();
}
	
	@Given("^The user is on the google site$")
	public void the_user_is_on_the_google_site() {
		
		googleInitialPage.navigateTo();
		googleInitialPage.verifyTheInitialPageIsFullyOpened();
		
	}

	@When("^They enter the search term (.*) in the search field$")
	public void they_enter_the_search_term_in_the_search_field(String searchTerm) throws Exception {
		
		googleInitialPage.sendASearchTerm(searchTerm);		
	}

	@Then("^They should see the results$")
	public void they_should_see_the_results() {

		googleInitialPage.verifyTheResultPage();
	}
}
