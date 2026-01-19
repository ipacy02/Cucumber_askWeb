package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategorySteps {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    @Given("I am on the Store page of the askomdch website on category")
    public void i_am_on_the_store_page_of_the_askomdch_website_on_category() {
        driver.get("https://askomdch.com/store/");
    }

    @When("I browse product by {string}")
    public void i_browse_product_by(String category) {

        By productCategory = By.cssSelector("select[name='product_cat']");
        wait.until(ExpectedConditions.elementToBeClickable(productCategory));
        new Select(driver.findElement(productCategory)).selectByValue(category);

    }
    @Then("I should get products in the category")
    public void i_should_get_products_in_the_category() {

        By categoryTitle = By.cssSelector("h1.woocommerce-products-header__title");

        // Get the text of the H1 element
        String actualHeading = wait
                .until(ExpectedConditions.visibilityOfElementLocated(categoryTitle))
                .getText();  //Men's Jeans

        // Assert against the expected category name

        String pageTitle = driver.getTitle(); //Men's Jeans
        Assert.assertTrue(pageTitle.contains(actualHeading));
    }



    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }




}

