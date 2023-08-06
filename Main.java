package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\MyTools\\chromedriver.exe");// ada 2 parameter
        WebDriver driver = new ChromeDriver();
        driver.get("https://shop.demoqa.com/my-account/");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        System.out.println("Open Browser");
        driver.findElement(By.id("username")).sendKeys("Asran");
        driver.findElement(By.id("password")).sendKeys("Makassar@2023");
        System.out.println("input username dan password");
        driver.findElement(By.name("login")).click();
        System.out.println("Berhasil Login");
        driver.findElement(By.className("home")).click();
        System.out.println("Tampilan Home");
        js.executeScript("window.scrollBy(0,1000)");
        driver.get("https://shop.demoqa.com/product/pink-drop-shoulder-oversized-t-shirt/");
//      driver.findElement(By.cssSelector("a[href='https://shop.demoqa.com/product/pink-drop-shoulder-oversized-t-shirt/']")).click();
        System.out.println("Tampilan item to cart");
        js.executeScript("window.scrollBy(0,1000)");
        Select colorSelect = new Select(driver.findElement(By.id("pa_color")));
        colorSelect.selectByValue("pink");
        Select sizeSelect = new Select(driver.findElement(By.id("pa_size")));
        sizeSelect.selectByValue("36");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.findElement(By.id("nav-menu-item-cart")).click();
        System.out.println("Tampilan Cart");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tutup browser setelah selesai
        driver.quit();

    }
}