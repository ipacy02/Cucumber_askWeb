package stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import io.cucumber.java.Before;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Map;

public class CheckoutSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By firstName = By.id("billing_first_name");
    private By lastName = By.id("billing_last_name");
    private By company = By.id("billing_company");
    private By country = By.id("billing_country");
    private By street = By.id("billing_address_1");
    private By apartment = By.id("billing_address_2");
    private By town = By.id("billing_city");
    private By state = By.id("billing_state");
    private By zip = By.id("billing_postcode");
    private By phone = By.id("billing_phone");
    private By email = By.id("billing_email");
    private By placeOrder = By.id("place_order");
    private By confirmationMessage = By.cssSelector("h1.has-text-align-center");

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }



    @Given("I have added a product to my cart")
    public void i_have_added_a_product_to_my_cart() {


        // Go to store page
        driver.get("https://askomdch.com/store");
        driver.manage().window().maximize();

        // Add the first product
        By addToCartBtn = By.cssSelector("a.button.product_type_simple.add_to_cart_button.ajax_add_to_cart");
        By viewCart = By.cssSelector("a[title='View cart']");

        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        product.click();

        // Wait until product is added
        wait.until(ExpectedConditions.attributeContains(product, "class", "added"));

        // Go to cart
        wait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();

        // Proceed to checkout
        By proceedToCheckoutBtn = By.cssSelector("a.checkout-button.button.alt.wc-forward");
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", checkoutBtn);
        checkoutBtn.click();

        // Wait for the billing form to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("billing_first_name")));
    }


    @When("I fill in the checkout form with the following details")
    public void i_fill_in_the_checkout_form_with_the_following_details(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        driver.findElement(firstName).sendKeys(data.get("firstName"));
        driver.findElement(lastName).sendKeys(data.get("lastName"));
        driver.findElement(company).sendKeys(data.get("company"));
        new Select(driver.findElement(country)).selectByValue(data.get("country"));
        driver.findElement(street).sendKeys(data.get("street"));
        driver.findElement(apartment).sendKeys(data.get("apartment"));
        driver.findElement(town).sendKeys(data.get("town"));
        new Select(driver.findElement(state)).selectByVisibleText(data.get("state"));
        driver.findElement(zip).sendKeys(data.get("zip"));
        driver.findElement(phone).sendKeys(data.get("phone"));
        driver.findElement(email).sendKeys(data.get("email"));
    }

    @And("I place the order")
    public void i_place_the_order() {
//        WebElement placeOrderBtn = driver.findElement(placeOrder);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", placeOrderBtn);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder)).click();
    }

    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        String expectedResult = "Thank you. Your order has been received.";
        String actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).getText();
        Assert.assertEquals("Order was not placed successfully", actualResult, expectedResult);
    }
}
