package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class NavigationSteps {

    private WebDriver driver;

    @Given("I am on the home page of the Ask e-commerce application")
    public void i_am_on_home_page() {
        driver = new ChromeDriver();
        driver.get("https://askomdch.com/"); // <-- Replace with your actual URL
    }

    @When("I click on the {string} link")
    public void i_click_on_navigation_link(String navigation) {
        // Click the link by visible text (matches exactly the Examples table)
        driver.findElement(By.linkText(navigation)).click();
    }

    @Then("I should be redirected to the {string} page")
    public void i_should_be_redirected_to_page(String navigation) {
        // Check that the page title contains the link name
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        assertTrue("Page title does not contain: " + navigation, pageTitle.contains(navigation));

        // Close browser
        driver.quit();
    }
}
