package com.aston.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsOnlinePaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MtsOnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@class='pay']//h2")
    private WebElement blockTitle;

    @FindBy(xpath = "//div[@class='pay__partners']//img")
    private List<WebElement> paymentLogos;

    @FindBy(xpath = "//section[@class='pay']//a[contains(text(), 'Подробнее о сервисе')]")
    private WebElement serviceDetailsLink;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement connectionPhoneInput;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement connectionSumInput;

    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    private WebElement continueButton;

    public String getBlockTitle() {
        wait.until(ExpectedConditions.visibilityOf(blockTitle));
        return blockTitle.getText();
    }

    public List<WebElement> getPaymentLogos() {
        wait.until(ExpectedConditions.visibilityOfAllElements(paymentLogos));
        return paymentLogos;
    }

    public WebElement getServiceDetailsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(serviceDetailsLink));
        return serviceDetailsLink;
    }

    public void fillConnectionForm(String phone, String amount) {
        wait.until(ExpectedConditions.visibilityOf(connectionPhoneInput));
        connectionPhoneInput.clear();
        connectionPhoneInput.sendKeys(phone);
        connectionSumInput.clear();
        connectionSumInput.sendKeys(amount);
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

    public String getConnectionPhonePlaceholder() {
        wait.until(ExpectedConditions.visibilityOf(connectionPhoneInput));
        return connectionPhoneInput.getAttribute("placeholder");
    }

    public String getConnectionSumPlaceholder() {
        wait.until(ExpectedConditions.visibilityOf(connectionSumInput));
        return connectionSumInput.getAttribute("placeholder");
    }
}