package com.aston.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

@Epic("MTS Online Services")
@Feature("Online Payment")
public class MtsOnlinePaymentTest {

    @Test
    @Story("User can make online payment")
    @Description("Test verifies that online payment block is available and functional")
    @Severity(SeverityLevel.CRITICAL)
    public void testOnlinePaymentBlock() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            stepOpenMtsWebsite(driver);
            stepScrollToFooter(driver);
            stepVerifyPaymentBlock(driver);
            stepVerifyLogos(driver);
            stepVerifyServiceLink(driver);
            stepEnterPhoneNumber(driver);
            stepVerifyContinueButton(driver);

        } catch (Exception e) {
            e.printStackTrace();
            fail("Test failed with exception: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @Step("Open MTS website")
    private void stepOpenMtsWebsite(WebDriver driver) throws InterruptedException {
        driver.get("https://www.mts.by");
        Thread.sleep(3000);
        Allure.addAttachment("Page URL", driver.getCurrentUrl());
    }

    @Step("Scroll to footer")
    private void stepScrollToFooter(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
    }

    @Step("Verify payment block text")
    private void stepVerifyPaymentBlock(WebDriver driver) {
        WebElement paymentBlock = driver.findElement(By.xpath("//*[contains(text(), 'Онлайн пополнение')]"));
        String actualText = paymentBlock.getText();
        assertTrue(actualText.contains("Онлайн пополнение"));
        assertTrue(actualText.contains("без комиссии"));
        Allure.addAttachment("Payment Block Text", actualText);
    }

    @Step("Verify logos presence")
    private void stepVerifyLogos(WebDriver driver) {
        List<WebElement> logos = driver.findElements(By.xpath("//footer//img"));
        assertTrue(logos.size() > 0);
        Allure.addAttachment("Logos Count", String.valueOf(logos.size()));
    }

    @Step("Verify service link")
    private void stepVerifyServiceLink(WebDriver driver) {
        WebElement serviceLink = driver.findElement(By.xpath("//a[contains(text(), 'Сервисы для жизни')]"));
        assertTrue(serviceLink.isDisplayed());
    }

    @Step("Enter phone number")
    private void stepEnterPhoneNumber(WebDriver driver) {
        List<WebElement> inputs = driver.findElements(By.xpath("//input[contains(@placeholder, 'номер') or contains(@placeholder, 'Номер')]"));
        WebElement phoneInput = inputs.get(0);
        phoneInput.sendKeys("297777777");
        Allure.addAttachment("Entered Phone", "297777777");
    }

    @Step("Verify continue button is enabled")
    private void stepVerifyContinueButton(WebDriver driver) {
        List<WebElement> buttons = driver.findElements(By.xpath("//button[contains(text(), 'Продолжить')]"));
        WebElement continueButton = buttons.get(0);
        assertTrue(continueButton.isEnabled());
        Allure.addAttachment("Button Status", "Enabled");
    }
}