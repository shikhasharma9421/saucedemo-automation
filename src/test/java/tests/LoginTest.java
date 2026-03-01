package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class LoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void verifyInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong_user", "wrong_pass");

        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
        // Optional: Later we will assert error message also
    }

    @Test
    public void endToEndCheckoutTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Inventory
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getTitleText(), "Products");

        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();

        // Cart
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        // Checkout info
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillInfo("Shikha", "Test", "12345");
        checkoutPage.clickContinue();

        // Overview
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
        overviewPage.clickFinish();

        // Complete
        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        Assert.assertEquals(completePage.getSuccessMessage(), "Thank you for your order!");
    }
}