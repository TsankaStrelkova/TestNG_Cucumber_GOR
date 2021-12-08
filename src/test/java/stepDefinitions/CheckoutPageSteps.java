package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;

public class CheckoutPageSteps {

    TestContext testContext;
    CheckoutPage checkoutPage;

    public CheckoutPageSteps(TestContext context) {
        testContext = context;
        checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
    }

    @When("^Enter personal details on checkout page$")
    public void enter_personal_details_on_checkout_page() {
        checkoutPage.fill_PersonalDetails();
    }

    @When("^Selects the same delivery address$")
    public void select_same_delivery_address() {
        checkoutPage.check_ShipToDifferentAddress();
    }

    @When("^Selects payment method as \"([^\"]*)\" payment$")
    public void select_payment_method_as_payment(String arg1) {
        checkoutPage.select_PaymentMethod("CheckPayment");
    }

    @When("^Places the order$")
    public void place_the_order() throws InterruptedException {
        checkoutPage.check_TermsAndCondition();
        checkoutPage.clickOn_PlaceOrder();
    }
}