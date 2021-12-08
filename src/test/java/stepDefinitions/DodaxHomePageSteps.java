package stepDefinitions;



import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;


import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DodaxHomePage;


public class DodaxHomePageSteps {

    TestContext testContext;
    DodaxHomePage dodaxHomePage;
    Set<Cookie> cookiesSetBeforeAccept;
    Set<Cookie> cookiesSetAfterAccept;
    
    public DodaxHomePageSteps(TestContext context) {
        testContext =context;
        dodaxHomePage = testContext.getPageObjectManager().getDodaxHomePage();
    }

    @Given("^The user is on home page of his domain$")
    public void the_user_is_on_home_page_of_his_domain() {
        dodaxHomePage.navigateTo();
        
    }

    @Then("^The reached domain is the right one$")
    public void the_reached_domain_is_the_right_one() throws MalformedURLException {
        String loadedUrl = testContext.getWebDriverManager().getDriver().getCurrentUrl();
        System.out.println("Current url: "+loadedUrl);
        String expectedUrl = "https://www.dodax.ca/en-ca/";
        System.out.println("Expected url: "+expectedUrl);
        Assert.assertEquals(expectedUrl, loadedUrl);
    }

    @When("^The user clicks the link Privacy policy$")
    public void the_user_clicks_the_link_Privacy_policy() throws Throwable {
        dodaxHomePage.clickPrivacyPolicy();
    }

    @Then("^The page for privacy policy loads$")
    public void the_page_for_privacy_policy_loads() throws MalformedURLException {
        String loadedUrl = testContext.getWebDriverManager().getDriver().getCurrentUrl();
        System.out.println("Current url: "+loadedUrl);
        String expectedUrl = "https://www.dodax.ca/en-ca/help/privacy-policy";
        System.out.println("Expected url: "+expectedUrl);
        Assert.assertEquals(expectedUrl, loadedUrl);
    }

    @When("^The user clicks on the button Cookies accept$")
    public void the_user_clicks_on_the_button_Cookies_accept() throws MalformedURLException {
    	cookiesSetBeforeAccept = testContext.getWebDriverManager().getDriver().manage().getCookies();
        dodaxHomePage.clickCookiesAccept();
        cookiesSetAfterAccept = testContext.getWebDriverManager().getDriver().manage().getCookies();
    }

    @Then("^The cookies are set$")
    public void the_cookies_are_set() throws MalformedURLException {
        Assert.assertTrue(!cookiesSetBeforeAccept.equals(cookiesSetAfterAccept));
    }

    @When("^The user type anything \"([^\"]*)\" in the search bar$")
    public void the_user_type_anything_in_the_search_bar(String arg1) throws Exception {
        dodaxHomePage.typeInSearchInput(arg1);
    }

    @Then("^Products with categories are autocompleted$")
    public void products_with_categories_are_autocompleted() {
        Assert.assertTrue(dodaxHomePage.autocompletedIsPopulated());
    }

    @Then("^The user submit the search with \"([^\"]*)\" string$")
    public void the_user_submit_the_search_with_string(String arg1) throws Exception {
        dodaxHomePage.submitSearch(arg1);
    }

    @Then("^The result page for \"([^\"]*)\" is shown$")
    public void the_result_page_for_is_shown(String arg1) throws MalformedURLException {
    	 WebDriverWait wait = new WebDriverWait(testContext.getWebDriverManager().getDriver(),Duration.ofSeconds(2000));
    	 wait.until(ExpectedConditions.urlContains("/search/?s="+arg1));
    	 String loadedUrl = testContext.getWebDriverManager().getDriver().getCurrentUrl();
    	 Assert.assertTrue(loadedUrl.contains("/search/?s="+arg1));
    }

   
    
    @When("^Search bar is displayed on the screen$")
    public void search_bar_is_displayed_on_the_screen() throws Throwable {
        Assert.assertTrue(dodaxHomePage.getSearchBar().isDisplayed(), "Search bar id no displayed");
    }

    @When("^The user clicks on the Back button$")
    public void the_user_clicks_on_the_back_button() throws Throwable {
    	dodaxHomePage.getBackButton().click();
    }

    @Then("^The empty page with Back button, carousel with additional products at the bottom is displayed$")
    public void the_empty_page_with_back_button_carousel_with_additional_products_at_the_bottom_is_displayed() throws Throwable {
    	boolean backButtonDisplayed = dodaxHomePage.getBackButton().isDisplayed();
    	boolean carouselDisplayed = dodaxHomePage.getCarousel().isDisplayed();
    	Assert.assertTrue( backButtonDisplayed&&carouselDisplayed, "Back button or Carousel are not displayed");
    }

    @Then("^The Home page loads$")
    public void the_home_page_loads() throws Throwable {
    	String loadedUrl = testContext.getWebDriverManager().getDriver().getCurrentUrl();
        System.out.println("Current url: "+loadedUrl);
        String expectedUrl = "https://www.dodax.ca/en-ca/";
        System.out.println("Expected url: "+expectedUrl);
        Assert.assertEquals(expectedUrl, loadedUrl);
    }

    @And("^The user type unavailable product \"([^\"]*)\" in the search bar and submit the search$")
    public void the_user_type_unavailable_product_something_in_the_search_bar_and_submit_the_search(String productname) throws Throwable {
    	 dodaxHomePage.submitSearch(productname);
    }

   
    
    @When("^The user clicks on the footer link \"([^\"]*)\"$")
    public void the_user_clicks_on_the_footer_link_something(String link) throws Throwable {
    	dodaxHomePage.clickFooterLink(link);
    }

    @Then("^The right page for the used footer link \"([^\"]*)\" is loaded$")
    public void the_right_page_for_the_used_footer_link_something_is_loaded(String link) throws Throwable {
        Assert.assertTrue(dodaxHomePage.checkIfLinkOpenThjeRightURL(link));
    }

    @And("^The user accepts cookies$")
    public void the_user_accepts_cookies() throws Throwable {
    	dodaxHomePage.clickCookiesAccept();
    }
}