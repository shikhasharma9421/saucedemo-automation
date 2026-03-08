package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    private WebDriver driver;

    private By appLogo = By.cssSelector("div.app_logo");
    private By inventoryTitle = By.cssSelector("span.title");

    private By menuButton = By.id("react-burger-menu-btn");
    private By closeMenuButton = By.id("react-burger-cross-btn");
    private By logoutLink = By.id("logout_sidebar_link");

    private By filterDropdown = By.cssSelector(".product_sort_container");

    private By cartIcon = By.cssSelector("a.shopping_cart_link");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");

    private By addBackpackBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By addBikeLightBtn = By.id("add-to-cart-sauce-labs-bike-light");

    private By removeBackpackBtn = By.id("remove-sauce-labs-backpack");
    private By removeBikeLightBtn = By.id("remove-sauce-labs-bike-light");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(appLogo).isDisplayed();
    }

    public String getLogoText() {
        return driver.findElement(appLogo).getText();
    }

    public String getTitleText() {
        return driver.findElement(inventoryTitle).getText();
    }

    public void openMenu() {
        driver.findElement(menuButton).click();
    }

    public void closeMenu() {
        driver.findElement(closeMenuButton).click();
    }

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }

    public void selectFilterOption(String visibleText) {
        Select select = new Select(driver.findElement(filterDropdown));
        select.selectByVisibleText(visibleText);
    }

    public String getSelectedFilterOption() {
        Select select = new Select(driver.findElement(filterDropdown));
        return select.getFirstSelectedOption().getText();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public boolean isCartBadgeDisplayed() {
        return driver.findElements(cartBadge).size() > 0;
    }

    public String getCartBadgeCount() {
        return driver.findElement(cartBadge).getText();
    }

    public void addBackpackToCart() {
        driver.findElement(addBackpackBtn).click();
    }

    public void removeBackpackFromCart() {
        driver.findElement(removeBackpackBtn).click();
    }

    public void addBikeLightToCart() {
        driver.findElement(addBikeLightBtn).click();
    }

    public void removeBikeLightFromCart() {
        driver.findElement(removeBikeLightBtn).click();
    }
}