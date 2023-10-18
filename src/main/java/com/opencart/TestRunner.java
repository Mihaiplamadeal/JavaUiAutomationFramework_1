package com.opencart;

import com.opencart.managers.DataGenerator;
import com.opencart.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();
//New Window Code
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://opencart.antropy.co.uk/");

        Thread.sleep(1000);
        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        myAccountIcon.click();
        WebElement registerOption = driver.findElement(By.xpath("(//a[normalize-space()='Register'])[1]"));
        registerOption.click();
        System.out.println(driver.getCurrentUrl());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));

        String firstName = DataGenerator.generateFirstName();
        firstNameInput.sendKeys(firstName);
        System.out.println(firstName);


        WebElement lastNameInput = driver.findElement(By.cssSelector("#input-lastname"));

        String lastName = DataGenerator.generateLastName();
        lastNameInput.sendKeys(lastName);
        System.out.println(lastName);

        WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));

        String randomEmail = DataGenerator.generateRandomEmail();
        emailInput.sendKeys(randomEmail);
        System.out.println(randomEmail);

        WebElement phoneInput = driver.findElement(By.cssSelector("#input-telephone"));

        phoneInput.sendKeys(DataGenerator.generatePhoneNumber());

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));

        String password = DataGenerator.generatePassword();
        passwordInput.sendKeys(password);

        WebElement confirmPasswordInput = driver.findElement(By.cssSelector("#input-confirm"));
        confirmPasswordInput.sendKeys(password);
        System.out.println(password);

        WebElement termsAndConditionsCheckBox = driver.findElement(By.xpath("//input[@name='agree']"));
        termsAndConditionsCheckBox.click();

        WebElement registerBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
        registerBtn.click();


        Thread.sleep(5000);

        System.out.println(driver.getTitle());

        driver.close();
        driver.quit();
        System.out.println("The execusion is over");

//        driver.switchTo().window(currentWindowName);
//        driver.get("https://tekwill.md/");
//        Thread.sleep(1000);
//        System.out.println(driver.getTitle());
//        driver.quit();
//        System.out.println("The execusion is over");

        }
    }
