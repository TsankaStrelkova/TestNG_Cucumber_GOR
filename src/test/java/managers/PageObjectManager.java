package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.*;

public class PageObjectManager {

    private WebDriver driver;
    private ProductListingPage productListingPage;
    private HomePage homePage;
    private CheckoutPage checkoutPage;
    private CartPage cartPage;
    private Common common;
    private GoogleInitialPage googleInitialPage;
    private DodaxHomePage dodaxHomePage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public DodaxHomePage getDodaxHomePage() {

        return (dodaxHomePage == null) ? dodaxHomePage = new DodaxHomePage(driver) : dodaxHomePage;
    }
    public GoogleInitialPage getGoogleInitialPage() {
    	
    	return (googleInitialPage == null) ? googleInitialPage = new GoogleInitialPage(driver) : googleInitialPage;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public ProductListingPage getProductListingPage() {
        return (productListingPage == null) ? productListingPage = new ProductListingPage(driver) : productListingPage;
    }

    public CartPage getCartPage() {
        return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;
    }

    public CheckoutPage getCheckoutPage() {
        return (checkoutPage == null) ? checkoutPage = new CheckoutPage(driver) : checkoutPage;
    }
    
    public Common getCommonPage() {
    	return (common == null) ? common = new Common(driver) : common;
    }
}