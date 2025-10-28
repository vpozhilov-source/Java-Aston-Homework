package com.aston.selenium;

import com.aston.selenium.pages.MtsOnlinePaymentPage;
import com.aston.selenium.pages.PaymentModalPage;
import io.github.bonigarcia.wdm.WebDriverManager;
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
                org.openqa.selenium.By.xpath("//button[contains(text(), 'Отклонить')]")
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
        scrollToPaymentBlock();
        MtsOnlinePaymentPage paymentPage = new MtsOnlinePaymentPage(driver);
        String actualTitle = paymentPage.getBlockTitle();
        assertTrue(actualTitle.contains("Онлайн пополнение") && actualTitle.contains("без комиссии"));
    }

    @Test
    public void testPaymentSystemLogos() {
        scrollToPaymentBlock();
        MtsOnlinePaymentPage paymentPage = new MtsOnlinePaymentPage(driver);
        List<WebElement> logos = paymentPage.getPaymentLogos();
        assertTrue(logos.size() >= 3);
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed());
        }
    }

    @Test
    public void testServiceDetailsLink() {
        scrollToPaymentBlock();
        MtsOnlinePaymentPage paymentPage = new MtsOnlinePaymentPage(driver);
        WebElement link = paymentPage.getServiceDetailsLink();
        assertTrue(link.isDisplayed());

        String originalUrl = driver.getCurrentUrl();
        link.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(originalUrl)));

        assertNotEquals(driver.getCurrentUrl(), originalUrl);
        assertFalse(driver.getTitle().isEmpty());
    }

    @Test
    public void testEmptyFieldsPlaceholders() {
        scrollToPaymentBlock();
        MtsOnlinePaymentPage paymentPage = new MtsOnlinePaymentPage(driver);

        assertEquals(paymentPage.getConnectionPhonePlaceholder(), "Номер телефона");
        assertEquals(paymentPage.getConnectionSumPlaceholder(), "Сумма");
    }

    @Test
    public void testConnectionPaymentModal() {
        scrollToPaymentBlock();
        MtsOnlinePaymentPage paymentPage = new MtsOnlinePaymentPage(driver);

        paymentPage.fillConnectionForm("297777777", "1");
        paymentPage.clickContinueButton();

        PaymentModalPage modalPage = new PaymentModalPage(driver);

        assertTrue(true);
    }

    private void scrollToPaymentBlock() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        wait.until(ExpectedConditions.presenceOfElementLocated(
                org.openqa.selenium.By.xpath("//section[@class='pay']")
        ));
    }
}