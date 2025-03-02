package com.example.demo.Selenium_Webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverTest {
    ChromeDriver chromeDriver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
    }

    @Test
    public void TestDangNhap() throws InterruptedException {
        chromeDriver.get("https://vitimex.com.vn/");
        WebElement nutDangKy = chromeDriver.findElement(By.xpath("//div[@class='li_log']//a[@data-bs-toggle='modal']//*[name()='svg']"));
        nutDangKy.click();
        Thread.sleep(4000);

        WebElement inputEmailHoacSDT = chromeDriver.findElement(By.xpath("//input[@id='account']"));
        inputEmailHoacSDT.sendKeys("0987654321");

        WebElement inputMatKhau = chromeDriver.findElement(By.xpath("//input[@id='pass']"));
        inputMatKhau.sendKeys("Viet123");

        WebElement nutDangNhap = chromeDriver.findElement(By.xpath("//a[@id='signin-btn']"));
        nutDangNhap.click();
        Thread.sleep(4000);
    }
    @Test
    public void TestDangKy() throws InterruptedException{
        chromeDriver.get("https://vitimex.com.vn/");
        WebElement nutDangKy = chromeDriver.findElement(By.xpath("//div[@class='li_log']//a[@data-bs-toggle='modal']//*[name()='svg']"));
        nutDangKy.click();
        Thread.sleep(4000);

        WebElement DangKyTaiKhoanMoi = chromeDriver.findElement(By.xpath("//a[contains(text(),'Đăng ký tài khoản mới')]"));
        DangKyTaiKhoanMoi.click();
        Thread.sleep(4000);

        WebElement NhapHoTen = chromeDriver.findElement(By.xpath("//input[@id='name']"));
        NhapHoTen.sendKeys("Nguyễn Đức Việt");

        WebElement  NhapSdt= chromeDriver.findElement(By.xpath("//input[@id='phone']"));
        NhapSdt.sendKeys("0987654321");

        WebElement Nhapemail = chromeDriver.findElement(By.xpath("//input[@id='email']"));
        Nhapemail.sendKeys("vietndph52199999@gamil.com");

        WebElement NhapMK = chromeDriver.findElement(By.xpath("//input[@id='pass-regis']"));
        NhapMK.sendKeys("Viet124");

        WebElement NhapLaiMK = chromeDriver.findElement(By.xpath("//input[@id='pass-confirm']"));
        NhapLaiMK.sendKeys("Viet124");

        WebElement nutDangKyMoi = chromeDriver.findElement(By.xpath("//a[@id='register-btn']"));
        nutDangKyMoi.click();
        Thread.sleep(4000);
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        if (chromeDriver != null) {
            Thread.sleep(7000);
            chromeDriver.quit();
        }
    }
}
