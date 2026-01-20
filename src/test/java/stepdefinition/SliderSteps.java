package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.Assert.assertNotEquals;

public class SliderSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private String priceBeforeSliding; // store initial price range

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I am on the Store page of the askomdch website on Slider")
    public void i_am_on_the_store_page_of_the_askomdch_website_on_slider() {
        driver.get("https://askomdch.com/store/");

        // Capture initial price range before sliding
        By priceLabelLocator = By.cssSelector("div.price_label");
        wait.until(ExpectedConditions.visibilityOfElementLocated(priceLabelLocator));
        priceBeforeSliding = driver.findElement(priceLabelLocator).getText();
        System.out.println("Initial price range: " + priceBeforeSliding);
    }

    @When("I slide the minimum price by {string} pixels")
    public void i_slide_the_minimum_price_by_pixels(String slideMin) {
        int xOffset = Integer.parseInt(slideMin);
        Actions action = new Actions(driver);
        By minSliderLocator = By.xpath("//*[@id=\"woocommerce_price_filter-3\"]/form/div/div[1]/span[1]");
        WebElement minSlider = driver.findElement(minSliderLocator);
        action.dragAndDropBy(minSlider, xOffset, 0).perform();
    }

    @When("I slide the maximum price by {string} pixels")
    public void i_slide_the_maximum_price_by_pixels(String slideMax) {
        int xOffset = Integer.parseInt(slideMax);
        Actions action = new Actions(driver);
        By maxSliderLocator = By.xpath("//*[@id=\"woocommerce_price_filter-3\"]/form/div/div[1]/span[2]");
        WebElement maxSlider = driver.findElement(maxSliderLocator);
        action.dragAndDropBy(maxSlider, xOffset, 0).perform();
    }

    @Then("the price label should be updated")
    public void the_price_label_should_be_updated() {
        By priceLabelLocator = By.cssSelector("div.price_label");
        wait.until(ExpectedConditions.visibilityOfElementLocated(priceLabelLocator));

        String priceAfterSliding = driver.findElement(priceLabelLocator).getText();
        System.out.println("Price range after sliding: " + priceAfterSliding);
        // Assert that the price label actually changed
        assertNotEquals("Price range did not change after sliding!", priceBeforeSliding, priceAfterSliding);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
