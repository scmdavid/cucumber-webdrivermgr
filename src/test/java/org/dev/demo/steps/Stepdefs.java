package org.dev.demo.steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Stepdefs {
    static ChromeDriver webDriver;

    static private void initChromeLogging() {

        final String rootPath = System.getProperty("user.dir");
        final Path pathToLogDirectory = Path.of(rootPath, "target", "logs");
        final Path pathToLog = Path.of(pathToLogDirectory.toAbsolutePath().toString(), "chromedriver.log");

        try {
            Files.createDirectories(pathToLogDirectory);
            System.setProperty("webdriver.chrome.logfile", pathToLog.toAbsolutePath().toString());
            System.setProperty("webdriver.chrome.verboseLogging", "true");

            System.out.println("Setting log file to " + pathToLog.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeAll
    static public void initWebDriver() {
        initChromeLogging();
        WebDriverManager.chromedriver().setup();
    }

    @AfterAll
    static public void cleanUp() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Before
    public void initTest() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless=new");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        webDriver = new ChromeDriver(options);
    }

    @When("test starts")
    public void testStarts() {
    }

    @Then("browser is ready")
    public void browserIsReady() {
    }
}
