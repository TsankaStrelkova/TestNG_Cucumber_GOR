package pageObjects;

import dataProviders.ConfigFileReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class DodaxHomePage  {
    

	WebDriver driver;
    ConfigFileReader cfr;
    String parentHandle;
    


    public DodaxHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        cfr = new ConfigFileReader();
    }
    
    

    @FindBy(how = How.CSS, using = "div[data-qa='cookiesAgreementText'] a")
    private WebElement cookieNoticeTextLink;

    @FindBy(how = How.CSS, using = "[data-qa='cookiesAgreementAcceptBtn']")
    private WebElement cookieNoticeButton;

    @FindBy(how = How.CSS, using = "[data-qa^='headerSearchBarListItemSearchTerm']")
    private List < WebElement > autocomplete;

    @FindBy(how = How.CSS, using = "[data-qa='headerSearchBarInput']")
    private WebElement searchInput;

    @FindBy(how = How.CSS, using = "[data-qa='emptySearchResultPageGoBackBtn']")
    private WebElement backButton;

    @FindBy(how = How.CSS, using = "[data-qa='searchResultPageContentDiv']")
    private WebElement searchResult;

    @FindBy(how = How.CSS, using = "[data-qa='searchResultPageProductLink']")
    private WebElement productsInSearchResultList;

    @FindBy(how = How.CSS, using = "[data-qa='emptySearchResultPageTextMessage']")
    private WebElement message;

    @FindBy(how = How.CSS, using = "[data-qa='advertisingCarouselSection']")
    private WebElement carousel;

    @FindBy(how = How.CSS, using = "[class*='swiper-container-initialized']")
    private WebElement carouselOnHome;

    @FindBy(how = How.CSS, using = "a[data-qa='searchResultPageProductLink']")
    private WebElement products;

    @FindBy(how = How.CSS, using = "[data-qa='pdpItemUnavailableTitle']")
    private WebElement itemUnavailable;

    @FindBy(how = How.CSS, using = "[data-qa='productQtyLeftInStock']")
    private WebElement itemsLeftInStock;

    @FindBy(how = How.CSS, using = "[data-qa='footerStaticPageLink']")
    private List <WebElement> footerLinks;
    
    public WebElement getCarousel()
    {
    	return carousel;
    }

    public WebElement getSearchBar()
    {
    	return  searchInput;
    }
    
    public WebElement getBackButton()
    {
    	
    	return backButton;
    }
    
    public void navigateTo() {
        try{
            driver.manage().deleteAllCookies();
            driver.get(cfr.getApplicationUrl());
            driver.manage().window().maximize();
        } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }

   public void clickFooterLink(String link) throws InterruptedException {
       try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    	    for (int i=0;i<footerLinks.size();i++) 
    	    {
    	    	parentHandle = driver.getWindowHandle();
    	    	WebElement currentEl = footerLinks.get(i);
    	    	if (footerLinks.get(i).getAttribute("href").contains(link)) 
    	    		{currentEl.click();
    	    	     break;
    	    		}
    	    }
    	    Set<String> allWindowHandles = driver.getWindowHandles();
            Iterator<String> iterator = allWindowHandles.iterator();

            // Here we will check if child window has other child windows and will fetch the heading of the child window
            while (iterator.hasNext()) {
                String ChildWindow = iterator.next();
                    if (!parentHandle.equalsIgnoreCase(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);

                }
            }
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2000));
            wait.until(ExpectedConditions.urlContains(link));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
   }
   
    public boolean checkIfLinkOpenThjeRightURL(String link)
    {
    	return driver.getCurrentUrl().contains(link);
    }

    public void clickCookiesAccept() {
        try {
            //System.out.println("Current window before switch to parent:" + driver.getCurrentUrl());
            driver.switchTo().window(parentHandle);
            //System.out.println("Current window:" + driver.getCurrentUrl());

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
            if (cookieNoticeButton.isDisplayed()) {
                wait.until(ExpectedConditions.elementToBeClickable(cookieNoticeButton));
                cookieNoticeButton.click();
                wait.until(ExpectedConditions.invisibilityOf(cookieNoticeButton));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void typeInSearchInput (String input) {
        try {
            searchInput.sendKeys(input);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
            wait.until(ExpectedConditions.visibilityOf(autocomplete.get(0)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void submitSearch (String input) {
        try {
            searchInput.clear();
            searchInput.sendKeys(input);
            searchInput.sendKeys(Keys.ENTER);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
            wait.until(ExpectedConditions.urlContains("search/?s="));
            wait.until(ExpectedConditions.visibilityOf(searchResult));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean autocompletedIsPopulated () {
        boolean showedAutocomplete = false;
        if (autocomplete.size() > 0) {
            showedAutocomplete = true;
        }
        return showedAutocomplete;
    }
    
    
    public void clickPrivacyPolicy() throws InterruptedException {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
     	   if (cookieNoticeTextLink.isDisplayed()) {
                 cookieNoticeTextLink.click();

                 parentHandle = driver.getWindowHandle();
                 //switch to a new window
                 //Set<String> handles = driver.getWindowHandles();
                 //System.out.println(handles);
                 for (String handle1 : driver.getWindowHandles()) {
                     driver.switchTo().window(handle1);
                 }
             }

         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.urlContains("/help/privacy-policy"));
    }
   
    
}
