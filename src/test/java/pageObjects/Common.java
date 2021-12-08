//This class contains a mock-up, playing the role of a page object for the common methods. Expand it as needed!
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import dataProviders.ConfigFileReader;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


public class Common {
    WebDriver driver;
    ConfigFileReader configFileReader;

    public Common(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }

  


	public void scrollToTheBottomOfThePage() {

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollToTheTopOfThePage() {

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        
        //Alternatively
        //((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
    }
    
    public void scrollToTheMiddleOfThePage() {
    	
    	((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight / 2)");
    }

    public void scrollToAnElement(String byWhat, String locator) {

        WebElement element = findAnElement(byWhat, locator);
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            
        } catch (RuntimeException e) {
            throw new RuntimeException("Unsuccessful operation: " + e.getMessage());
        }
    }

    public WebElement findAnElement(String byWhat, String locator) {

        WebElement element;
        switch (byWhat) {
            case "id":
                element = driver.findElement(By.id(locator));
                break;
            case "className":
                element = driver.findElement(By.className(locator));
                break;
            case "xpath":
                element = driver.findElement(By.xpath(locator));
                break;
            case "name":
                element = driver.findElement(By.name(locator));
                break;
            case "tagName":
                element = driver.findElement(By.tagName(locator));
                break;
            case "linkText":
                element = driver.findElement(By.linkText(locator));
                break;
            case "cssSelector":
            default:
                element = driver.findElement(By.cssSelector(locator));
                break;
        }
        return element;
    }

    public void findAndClickAnElement(String byWhat, String locator) {

        try {
            WebElement element = findAnElement(byWhat, locator);
            element.click();
            
        } catch (RuntimeException e) {
            throw new RuntimeException("Unsuccessful operation: " + e.getMessage());
        }
    }
    
    public void findAndClickAnElement(WebElement element) {
    	
    	element.click();
    }
    
    public Boolean verifyIfAnElementIsDisplayed(WebElement element) {
    	
    	if (element.isDisplayed())
    		return true;
    	return false;
    }

    public void navigateOnePageForward() {

        driver.navigate().forward();
    }

    public void navigateOnePageBack() {

        driver.navigate().back();
    }
    
    public void refreshThePage() {
    	
    	driver.navigate().refresh();
    }

    public void submitAForm(String byWhat, String locator) {

        try {
            WebElement element = findAnElement(byWhat, locator);
            element.submit();
            
        } catch (RuntimeException e) {
            throw new RuntimeException("The submitting of the form has not been successfull: " + e.getMessage());
        }
    }

    public String getTheTitleOfThePage() {

        return driver.getTitle();
    }

    public Boolean verifyThePageTitle(String expectedPageTitle) {

        String actualPageTitle = getTheTitleOfThePage();
        try {
            if (actualPageTitle.equals(expectedPageTitle))
                return true;

            System.out.println("The title page is not as expected: " + actualPageTitle);
            System.out.println("Instead it is: " + expectedPageTitle);
            return false;
            
        } catch (RuntimeException e) {
            throw new RuntimeException("Cannot retrieve the page title: " + e.getMessage());
        }
    }

    public String getTheValueOfAnAttributeOfAnElement(String attrName, String byWhat, String locator) {

            WebElement element = findAnElement(byWhat, locator);
            String attributeValue = element.getAttribute(attrName);
            return attributeValue;
    }

    public Boolean verifyTheValueOfAnAttribute(String expectedAttrValue, String attrName, String byWhat, String locator) {

        String actualAttrValue;
        try {
            actualAttrValue = getTheValueOfAnAttributeOfAnElement(attrName, byWhat, locator);
            if (actualAttrValue.equals(expectedAttrValue))
                return true;

            System.out.println("The expected value of the attribute '" + expectedAttrValue + "' is not present");
            System.out.println("Insted, '" + actualAttrValue + "' is present");
            return false;
            
        } catch (RuntimeException e) {
            throw new RuntimeException("Unsuccessful operation: " + e.getMessage());
        }
    }

    public String getTheTextOfAnElement(String byWhat, String locator) {

        String elementText = "";
        try {
            elementText = findAnElement(byWhat, locator).getText();
            return elementText;
            
        } catch (RuntimeException e) {
            throw new RuntimeException("Unsuccessful operation: " + e.getMessage());
        }
    }

    public Boolean verifyTheTextOfAnElement(String expectedTextValue, String byWhat, String locator) {

        String actualTextValue = getTheTextOfAnElement(byWhat, locator);
        try {
            if (actualTextValue.equals(expectedTextValue))
                return true;

            System.out.println("The expected text '" + expectedTextValue + "' does not appear as a text to the element");
            System.out.println("Insted, '" + actualTextValue + "' appears");
            return false;

        } catch (RuntimeException e) {
            throw new RuntimeException("Unsuccessful verification operation: " + e.getMessage());
        }
    }

    public void insertTextIntoAnElement(String textToInsert, String byWhat, String locator) {

        try {
            WebElement element = findAnElement(byWhat, locator);
            element.sendKeys(textToInsert);
            
        } catch (RuntimeException e) {
            throw new RuntimeException("Unsuccessful 'insert text' operation: " + e.getMessage());
        }
    }
    
    public void insertTextIntoAnElement(WebElement element, String textToInsert) {
    	
    	element.sendKeys(textToInsert);
    }

    public void clearTheTextOfAnElement(String byWhat, String locator) {

        try {
            WebElement element = findAnElement(byWhat, locator);
            element.clear();
            
        } catch (RuntimeException e) {
            throw new RuntimeException("Unsuccessful clearing opeation: " + e.getMessage());
        }
    }

    public Boolean verifyIfAnElementIsDisplayed(String byWhat, String locator) {

        WebElement element = findAnElement(byWhat, locator);
        try {
            if (element.isDisplayed())
                return true;
            return false;
            
        } catch (RuntimeException e) {
            throw new RuntimeException("Unsuccessful operation: " + e.getMessage());
        }
    }

    public void acceptAnAlert() {

        driver.switchTo().alert().accept();
    }

    public void dismissAnAlert() {

        driver.switchTo().alert().dismiss();
    }
    
    public void populateTextFieldOfAnAlert(String text) {
    	
    	driver.switchTo().alert().sendKeys(text);
    }
    
    public String captureTheTextOfAnAlert() {
    	
    	String alertText = "";
    	try {
    		alertText = driver.switchTo().alert().getText();
    		return alertText;
    		
    	} catch (RuntimeException e) {
    		throw new RuntimeException("Unsuccessful operation: " + e.getMessage());
    	}
    }
    
    public Boolean verifyTheTextOfAnAlert(String textToVerify) {
    	
    	String actualAlertText = captureTheTextOfAnAlert();
    	try {
    		if(actualAlertText.equals(textToVerify))
    			return true;
    		return false;
    		
    	} catch(RuntimeException e) {
    		throw new RuntimeException("Unsuccessful operation: " + e.getMessage());
    	}
    }
    
    public void sendCredentialsToAnAlert(String username, String password) {
    	
    	try {
    	driver.switchTo().alert().sendKeys(username + "" + Keys.TAB + "" + password);
    	acceptAnAlert();
    	
    	} catch (RuntimeException e) {
    		throw new RuntimeException("Unsuccessful operation: " + e.getMessage());
    	}    	
    }
    
    public void deleteACookie(String cookieName) {
    	
    	driver.manage().deleteCookieNamed(cookieName);
    }
    
    public void deleteAllCookies() {
    	
    	driver.manage().deleteAllCookies();
    }
    
    public void addACookie(Cookie cookieName) {
    	
    	driver.manage().addCookie(cookieName);
    }
    
    public Cookie getCookieByName(String cookieName) {
    	
    	return driver.manage().getCookieNamed(cookieName);
    }
    
    public Set<Cookie> getAllCookies() {
    	
    	return driver.manage().getCookies();
    }
    
    public String getPageSource() {
    	
    	return driver.getPageSource();
    }
        
    public void mouseHoverAnElement(String byWhat, String locator) {
    	
    	try {
    	Actions actions = new Actions(driver);   	
    	actions.moveToElement(findAnElement(byWhat, locator)).build().perform();
    	
    	} catch (RuntimeException e) {
    		throw new RuntimeException("Unsuccessful hover operation: " + e.getMessage());
    	}
    }
}