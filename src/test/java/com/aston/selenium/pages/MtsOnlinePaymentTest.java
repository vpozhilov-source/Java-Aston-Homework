package com.aston.selenium;

import com.aston.selenium.pages.MtsOnlinePaymentPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MtsOnlinePaymentTest {

    @Test
    public void testOnlinePaymentWithPageObject() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.mts.by");
            Thread.sleep(3000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(2000);

            MtsOnlinePaymentPage paymentPage = new MtsOnlinePaymentPage(driver);

            paymentPage.verifyPaymentBlock();
            paymentPage.verifyPaymentLogos();
            paymentPage.verifyServiceLink();

            paymentPage.verifyMobileServicesTab();

            paymentPage.fillPhoneNumber("297777777");
            paymentPage.fillAmount("10");
            paymentPage.clickContinue();

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}