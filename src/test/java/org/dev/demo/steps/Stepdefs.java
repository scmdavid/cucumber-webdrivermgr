package org.dev.demo.steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Stepdefs {
    static ChromeDriver webDriver;

    @BeforeAll
    static public void initWebDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void initTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        webDriver = new ChromeDriver(options);
    }

    @When("test starts")
    public void testStarts() {
    }

    @Then("browser is ready")
    public void browserIsReady() {
    }

    @AfterAll
    static public void cleanUp(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
