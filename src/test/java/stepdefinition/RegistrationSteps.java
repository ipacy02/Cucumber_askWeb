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

public class RegistrationSteps {

    private WebDriver driver;

    @Given("I am in the registration page of the Ask e-commerce Application")
    public void i_am_in_the_registration_page_of_the_Ask_e_commerce_Application() {
        // Initialize Chrome driver
        driver = new ChromeDriver();

        driver.get("https://askomdch.com/");

        // Navigate to the account/registration page
        driver.findElement(By.linkText("Account")).click();
    }

    @When("I enter username {string}, email {string} and password {string}")
    public void i_enter_username_email_and_password(String username, String email, String password) {
        driver.findElement(By.id("reg_username")).sendKeys(username);
        driver.findElement(By.id("reg_email")).sendKeys(email);
        driver.findElement(By.id("reg_password")).sendKeys(password);
        driver.findElement(By.name("register")).click();
    }


    @Then("I should be redirected to the registration page")
    public void i_should_be_taken_to_the_account_registration_page() {
        // Wait until the account content is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountContent = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-MyAccount-content"))
        );

        // Check if registration was successful
        String pageText = accountContent.getText();
        assertTrue(pageText.contains("edit your password and account details"));

        System.out.println("Registration successful!");

        // Close browser
        driver.quit();
    }

    @Then("I should see a registration error message")
    public void i_should_see_a_registration_error_message() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".woocommerce-error")
                )
        );

        String errorText = error.getText();
        System.out.println("Error message: " + errorText);

        assertTrue(errorText.contains("Error") || errorText.contains("required"));

        driver.quit();
    }

}
