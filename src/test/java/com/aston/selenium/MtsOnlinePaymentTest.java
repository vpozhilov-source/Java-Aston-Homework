package com.aston.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

public class MtsOnlinePaymentTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by");

        WebElement rejectButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Отклонить')]")
        ));
        rejectButton.click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testBlockTitle() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[@class='pay']//h2")
        ));

        String actualTitle = titleElement.getText();
        assertTrue(actualTitle.contains("Онлайн пополнение") && actualTitle.contains("без комиссии"));
    }

    @Test
    public void testPaymentSystemLogos() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        List<WebElement> logos = driver.findElements(By.xpath(
                "//div[@class='pay__partners']//img"
        ));

        assertTrue(logos.size() >= 3);

        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed());
        }
    }

    @Test
    public void testServiceDetailsLink() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebElement detailsLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//section[@class='pay']//a[contains(text(), 'Подробнее о сервисе')]")
        ));

        String originalUrl = driver.getCurrentUrl();
        detailsLink.click();

        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(originalUrl)));

        String currentUrl = driver.getCurrentUrl();
        String pageTitle = driver.getTitle();

        assertNotEquals(currentUrl, originalUrl);
        assertFalse(pageTitle.isEmpty());
    }

    @Test
    public void testContinueButtonFunctionality() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='connection-phone']")
        ));
        phoneInput.sendKeys("297777777");

        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='connection-sum']")
        ));
        amountInput.sendKeys("1");

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//form[@id='pay-connection']//button[@type='submit']")
        ));
        continueButton.click();

        assertTrue(true);
    }
}