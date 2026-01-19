package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartSteps {

    private WebDriver driver;

    @Given("I am on the Ask e-commerce home page")
    public void i_am_on_the_home_page() {
        driver = DriverFactory.getDriver();
        driver.get("https://askomdch.com/");
    }

    @When("I add the product {int} to the cart")
    public void i_add_the_product_to_the_cart(int index) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement product =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.cssSelector(
                                "a.button.product_type_simple.add_to_cart_button.ajax_add_to_cart"
                        )
                )).get(index);

        product.click();

        // wait until product is marked as added
        wait.until(ExpectedConditions.attributeContains(product, "class", "added"));
    }
}
