package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import pageObjects.ProductListingPage;

public class ProductPageSteps {

    TestContext testContext;
    ProductListingPage productListingPage;

    public ProductPageSteps(TestContext context) {
        testContext = context;
        productListingPage = testContext.getPageObjectManager().getProductListingPage();
    }

    @When("^Choose to buy an item$")
    public void choose_to_buy_the_first_item() {
        productListingPage.select_Product(12);
        productListingPage.clickOn_AddToCart();
    }

}