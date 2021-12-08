package stepDefinitions;

import java.util.Set;

import org.openqa.selenium.Cookie;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import pageObjects.Common;

public class CommonMethodsSteps {

    TestContext testContext;
    Common common;

    public CommonMethodsSteps(TestContext context) {
        testContext = context;
        common = testContext.getPageObjectManager().getCommonPage();
    }


    @When("^Scroll to the bottom of the page$")
    public void scrollToTheBottomOfThePage() {
    	
        common.scrollToTheBottomOfThePage();
    }

    @When("^Scroll to the top of the page$")
    public void scrollToTheTopOfThePage() {
    	
        common.scrollToTheTopOfThePage();
    }
    
    @When("^Scroll to the middle of the page$")
    public void scrollToTheMiddleOfThePage() throws InterruptedException {
    	
    	common.scrollToTheMiddleOfThePage();
    	Thread.sleep(3000);
    }

    @When("^Scroll the page to an element found by \"([^\"]*)\", named \"([^\"]*)\"$")
    public void scrollThePageToAnElement(String byWhat, String locator) {
    	
        common.scrollToAnElement(byWhat, locator);
    }

    @When("^Find an element by \"([^\"]*)\", named \"([^\"]*)\"$")
    public void findAnElement(String byWhat, String locator) {
    	
        common.findAnElement(byWhat, locator);
    }

    @When("^Find and click an element by \"([^\"]*)\", named \"([^\"]*)\"$")
    public void findAndClickAnElement(String byWhat, String locator) {
    	
        common.findAndClickAnElement(byWhat, locator);
    }

    @When("^Navigate one page back$")
    public void navigateOnePageBack() {
    	
        common.navigateOnePageBack();
    }

    @When("^Navigate one page forward$")
    public void navigateOnePageForward() {
    	
        common.navigateOnePageForward();
    }
    
    @When("^Refresh the page$")
    public void refreshThePage() {
    	
    	common.refreshThePage();
    }
    
    @When("^Get the page source$")
    public String getPageSource() {
    	
    	return common.getPageSource();
    }

    @When("^Submit a form, found by \"([^\"]*)\", named \"([^\"]*)\"$")
    public void submitAForm(String byWhat, String locator) {

        common.submitAForm(byWhat, locator);
    }

    @When("^Get the title of the page$")
    public String getTheTitleOfThePage() {

        return common.getTheTitleOfThePage();
    }

    @When("^Verify that the title of the page is \"([^\"]*)\"$")
    public Boolean verifyThePageTitle(String expectedPageTitle) {

        return common.verifyThePageTitle(expectedPageTitle);
    }

    @When("^Get the value of an attribute by \"([^\"]*)\", of an element, found by \"([^\"]*)\", named \"([^\"]*)\"$")
    public String getTheValueOfAnAttributeOfAnElement(String attributeName, String byWhat, String locator) {

        return common.getTheValueOfAnAttributeOfAnElement(attributeName, byWhat, locator);
    }

    @When("^Verify the value \"([^\"]*)\" of an attribute by \"([^\"]*)\" of an element, found by \"([^\"]*)\", named \"([^\"]*)\"$")
    public Boolean verifyTheValueOfAnAttribute(String expectedAttrValue, String attrName, String byWhat, String locator) {

        return common.verifyTheValueOfAnAttribute(expectedAttrValue, attrName, byWhat, locator);
    }

    @When("^Get the text of an element, found by \"([^\"]*)\", named \"([^\"]*)\"$")
    public String getTheTextOfAnElement(String byWhat, String locator) {

        return common.getTheTextOfAnElement(byWhat, locator);
    }

    @When("^Verify the text value \"([^\"]*)\" of an element, found by \"([^\"]*)\", named \"([^\"]*)\"$")
    public Boolean verifyTheTextOfAnElement(String expectedTextValue, String byWhat, String locator) {

        return common.verifyTheTextOfAnElement(expectedTextValue, byWhat, locator);
    }

    @When("^Insert \"text\" into an element, found by \"([^\"]*)\", named \"([^\"]*)\"$")
    public void insertTextIntoAnElement(String textToInsert, String byWhat, String locator) {

        common.insertTextIntoAnElement(textToInsert, byWhat, locator);
    }

    @When("^Clear the text of an element, found by \"([^\"]*)\", named \"([^\"]*)\"$")
    public void clearTheTextOfAnElement(String byWhat, String locator) {

        common.clearTheTextOfAnElement(byWhat, locator);
    }

    @When("^Verify if an element, found by \"([^\"]*)\", named \"([^\"]*)\", is displayed$")
    public Boolean verifyIfAnElementIsDisplayed(String byWhat, String locator) {
    	
    	return common.verifyIfAnElementIsDisplayed(byWhat, locator);
    }

    @When("^Accept an alert$")
    public void acceptAnAlert() {

        common.acceptAnAlert();
    }

    @When("^Dismiss an alert$")
    public void dismissAnAlert() {

        common.dismissAnAlert();
    }
    
    @When("^Populate a text field of an alert with \"([^\"]*)\"$")
    public void populateTextFieldOfAnAlert(String text) {
    	
    	common.populateTextFieldOfAnAlert(text);
    }
    
    @When("^Capture the text of an alert$")
    public String captureTheTextOfAnAlert() {
    	
    	return common.captureTheTextOfAnAlert();
    }
    
    @When("^Send credentials to an alert, using \"([^\"]*)\" and \"([^\"]*)\"$")
    public void sendCredentialsToAnAlert(String username, String password) {
    	
    	common.sendCredentialsToAnAlert(username, password);
    }
    
    @When("Verify the \"([^\"]*)\" of an alert")
    public Boolean verifyTheTextOfAnAlert(String textToVerify) {
    	
    	return common.verifyTheTextOfAnAlert(textToVerify);    	
    }
    
    @When("^Delete a cookie, named \"([^\"]*)\"$")
    public void deleteACookie(String cookieName) {
    	
    	common.deleteACookie(cookieName);    	
    }
    
    @When("^Delete all cookies$")
    public void deleteAllCookies() {
    	
    	common.deleteAllCookies();    	
    }
    
    @When("^Add a cookie by name \"([^\"]*)\"$")
    public void addACookie(Cookie cookieName) {
    	
    	common.addACookie(cookieName);
    }
    
    @When("^Get a cookie by name \"([^\"]*)\"$")
    public Cookie getACookie(String cookieName) {
    	
    	return common.getCookieByName(cookieName);
    }
    
    @When("^Get all cookies$")
    public Set<Cookie> getAllCookies() {
    	
    	return common.getAllCookies();
    }
        
    @When("^Mouse hover an element, found by \"([^\"]*)\", named \"([^\"]*)\"$")
    public void mouseHoverAnElement(String byWhat, String locator) {
    	
    	common.mouseHoverAnElement(byWhat, locator);
    }
}