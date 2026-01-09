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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private WebDriver driver;

    @Given("I am in the login page of the Ask e-commerce Application")
    public void i_am_in_the_login_page_of_the_Ask_e_commerce_Application() {
        driver = new ChromeDriver();
        driver.get("https://askomdch.com/");
        driver.findElement(By.linkText("Account")).click();
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        driver.findElement(By.name("username")).sendKeys("mugisha");
        driver.findElement(By.name("password")).sendKeys("mugisha");
        driver.findElement(By.name("login")).click();
    }

    @Then("I should be taken to the Account page")
    public void i_should_be_taken_to_the_account_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the main account content div is visible
        WebElement accountContent = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-MyAccount-content"))
        );

        // Get the text from the account content
        String pageText = accountContent.getText();


        assertTrue(pageText.contains("shipping and billing addresses"));

        // Close the browser
        driver.quit();
    }

}
