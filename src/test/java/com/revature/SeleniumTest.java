package com.revature;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


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
        File file = new File("src/main/java/com/example/src/main/java/com/example/comparison_logical_operators.js");
        path = "file://" + file.getAbsolutePath();

        // Create a new ChromeDriver instance
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);
        
        // EdgeOptions options = new EdgeOptions();
        // options.addArguments("headless");
        // webDriver = new EdgeDriver(options);

        // Open the HTML file
        webDriver.get(path);
    }
    
    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }
}

