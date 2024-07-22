import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class SeleniumTest {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        File file = new File("src/main/java/com/revature/index.html");
        String path = "file://" + file.getAbsolutePath();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        webDriver.get(path);
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void testRegistrationForm() {
        webDriver.findElement(By.id("name")).sendKeys("John Doe");
        webDriver.findElement(By.id("email")).sendKeys("john@example.com");
        webDriver.findElement(By.id("password")).sendKeys("password123");

        Select genderSelect = new Select(webDriver.findElement(By.id("gender")));
        genderSelect.selectByValue("male");

        webDriver.findElement(By.id("birthdate")).sendKeys("1990-01-01");
        webDriver.findElement(By.id("terms")).click();
        webDriver.findElement(By.xpath("//button[text()='Register']")).click();

        String successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success-message"))).getText();
        assertEquals("Registration successful!", successMessage);
    }

    @Test
    public void testLoginForm() {
        webDriver.findElement(By.id("loginEmail")).sendKeys("user@example.com");
        webDriver.findElement(By.id("loginPassword")).sendKeys("password123");
        webDriver.findElement(By.xpath("//button[text()='Login']")).click();

        String successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success-message"))).getText();
        assertEquals("Login successful!", successMessage);

        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loggedInUserName")));
        assertEquals("John Doe", userNameElement.getText());
    }

    @Test
    public void testFeedbackForm() {
        webDriver.findElement(By.id("comments")).sendKeys("Great service!");
        webDriver.findElement(By.id("rating")).sendKeys("5");
        webDriver.findElement(By.xpath("//button[text()='Submit Feedback']")).click();

        String successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success-message"))).getText();
        assertEquals("Feedback submitted!", successMessage);

        WebElement submitButton = webDriver.findElement(By.xpath("//button[text()='Submit Feedback']"));
        assertFalse(submitButton.isEnabled());
    }

    @Test
    public void testFormValidation() {
        webDriver.findElement(By.xpath("//button[text()='Register']")).click();
        assertTrue(webDriver.findElement(By.id("name")).getAttribute("validity").contains("valueMissing"));

        webDriver.findElement(By.id("email")).sendKeys("invalid-email");
        webDriver.findElement(By.xpath("//button[text()='Register']")).click();
        assertTrue(webDriver.findElement(By.id("email")).getAttribute("validity").contains("typeMismatch"));

        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.xpath("//button[text()='Register']")).click();
        assertTrue(webDriver.findElement(By.id("password")).getAttribute("validity").contains("valueMissing"));
    }

    @Test
    public void testGenderSelect() {
        Select genderSelect = new Select(webDriver.findElement(By.id("gender")));

        assertEquals("Male", genderSelect.getFirstSelectedOption().getText());

        genderSelect.selectByValue("female");
        assertEquals("Female", genderSelect.getFirstSelectedOption().getText());

        genderSelect.selectByValue("other");
        assertEquals("Other", genderSelect.getFirstSelectedOption().getText());
    }
}
