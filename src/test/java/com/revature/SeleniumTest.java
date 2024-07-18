package com.revature;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

public class SeleniumTest {
    private WebDriver webDriver;
   // private WebDriverWait wait;
    private String path;
    
    @BeforeEach
    public void setUp() {
     
        
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");//linux_64
       
        // Get file
        File file = new File("src/main/java/com/revature/index.html");
        path = "file://" + file.getAbsolutePath();

        // Create a new ChromeDriver instance
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);

        // Open the HTML file
        webDriver.get(path);
    }
    
    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void testRegistrationForm() {
        driver.findElement(By.id("name")).sendKeys("John Doe");
        driver.findElement(By.id("email")).sendKeys("john@example.com");
        driver.findElement(By.id("password")).sendKeys("password123");

        Select genderSelect = new Select(driver.findElement(By.id("gender")));
        genderSelect.selectByValue("male");

        driver.findElement(By.id("birthdate")).sendKeys("1990-01-01");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.xpath("//button[text()='Register']")).click();

        // Add assertions here to verify successful registration
    }

    @Test
    public void testLoginForm() {
        driver.findElement(By.id("loginEmail")).sendKeys("user@example.com");
        driver.findElement(By.id("loginPassword")).sendKeys("password123");
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        // Add assertions here to verify successful login
    }

    @Test
    public void testFeedbackForm() {
        driver.findElement(By.id("comments")).sendKeys("Great service!");
        driver.findElement(By.id("rating")).sendKeys("5");
        driver.findElement(By.xpath("//button[text()='Submit Feedback']")).click();

        // Add assertions here to verify successful feedback submission
    }

    @Test
    public void testFormValidation() {
        driver.findElement(By.xpath("//button[text()='Register']")).click();
        String nameError = driver.findElement(By.id("name")).getAttribute("validationMessage");
        assertNotEquals("", nameError);

        driver.findElement(By.id("email")).sendKeys("invalid-email");
        driver.findElement(By.xpath("//button[text()='Register']")).click();
        String emailError = driver.findElement(By.id("email")).getAttribute("validationMessage");
        assertNotEquals("", emailError);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.xpath("//button[text()='Register']")).click();
        String passwordError = driver.findElement(By.id("password")).getAttribute("validationMessage");
        assertNotEquals("", passwordError);
    }

    @Test
    public void testGenderSelect() {
        Select genderSelect = new Select(driver.findElement(By.id("gender")));

        assertEquals("Male", genderSelect.getFirstSelectedOption().getText());

        genderSelect.selectByValue("female");
        assertEquals("Female", genderSelect.getFirstSelectedOption().getText());

        genderSelect.selectByValue("other");
        assertEquals("Other", genderSelect.getFirstSelectedOption().getText());
    }
}

