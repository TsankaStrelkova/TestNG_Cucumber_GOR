package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dataProviders.ConfigFileReader;

public class GoogleInitialPage {
	
	WebDriver driver;
	ConfigFileReader cfr;
	
	public GoogleInitialPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		cfr = new ConfigFileReader();
	}
	
	@FindBy(how = How.CSS, using = "#hplogo")
	private WebElement googleLogo;
	
	@FindBy(how = How.CSS, using = "#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input")
	private WebElement googleSearchBox;
	
	@FindBy(how = How.CSS, using = "#logo > img")
	private WebElement resultsLogo;
	
	@FindBy(how = How.CSS, using = "#resultStats")
	private WebElement resultsMessage;
	
	public void navigateTo() {
		
		driver.get(cfr.getApplicationUrl());
	}
	
	public void verifyTheInitialPageIsFullyOpened() {
		
		try {
		googleLogo.isDisplayed();
		googleSearchBox.isDisplayed();
		} catch (RuntimeException e) {
			throw new RuntimeException("The initial page was not fully opened: " + e.getMessage());
		}
	}
	
	public void sendASearchTerm(String searchTerm) throws Exception{
		googleSearchBox.sendKeys(searchTerm);
		googleSearchBox.sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
	}
	
	public void verifyTheResultPage() {
		
		try {
		resultsLogo.isDisplayed();
		resultsMessage.isDisplayed();
		} catch (RuntimeException e) {
			throw new RuntimeException("The result page was not fully opened: " + e.getMessage());
		}
		
	}
}
