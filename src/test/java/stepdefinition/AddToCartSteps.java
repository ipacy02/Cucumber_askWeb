package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class AddToCartSteps {

    private WebDriver driver;
    private int selectedIndex;   // shared across steps

    @Given("I am in the home page of the Ask e-commerce Application")
    public void i_am_in_the_home_page_of_the_Ask_e_commerce_Application() {
        driver = new ChromeDriver();
        driver.get("https://askomdch.com/");
    }

    @When("I add the product {int} in the cart")
    public void i_add_product_in_the_cart(int index) {
        this.selectedIndex = index;   // store it

        WebElement product =
                driver.findElements(By.cssSelector(
                        "a.button.product_type_simple.add_to_cart_button.ajax_add_to_cart"
                )).get(index);

        product.click();

        // wait until product is marked as added
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(product, "class", "added"));
    }

    @Then("I should be redirected to the cart page")
    public void i_should_be_redirected_to_the_cart_page() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement viewCart =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View cart")));

        assertTrue("View cart link not displayed", viewCart.isDisplayed());


        viewCart.click();


        driver.quit();
    }
}
