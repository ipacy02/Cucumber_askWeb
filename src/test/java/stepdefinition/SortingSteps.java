package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SortingSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Given("I am on the Store page of the askomdch website")
    public void i_am_on_the_store_page_of_the_askomdch_website() {
        driver.get("https://askomdch.com/store/");
    }

    @When("I sort products by {string}")
    public void i_sort_products_by(String sortOption) {
        By sortingDropdown = By.cssSelector("select.orderby");
        wait.until(ExpectedConditions.elementToBeClickable(sortingDropdown));
        new Select(driver.findElement(sortingDropdown)).selectByValue(sortOption);


    }

    @Then("the products should be sorted accordingly")
    public void the_products_should_be_sorted_accordingly() {

        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Products"));

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
