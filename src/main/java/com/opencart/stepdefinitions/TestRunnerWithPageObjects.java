package com.opencart.stepdefinitions;

import com.opencart.managers.DataGenerator;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TestRunnerWithPageObjects {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("http://andreisecuqa.host/");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPageFromHeader();

        RegisterPage registerPage = new RegisterPage(driver);




        String firstName = DataGenerator.generateFirstName();
        System.out.println(firstName);



        String lastName = DataGenerator.generateLastName();

        System.out.println(lastName);


        String randomEmail = DataGenerator.generateRandomEmail();
           System.out.println(randomEmail);


        String password = DataGenerator.generatePassword();

        System.out.println(password);

        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, password, true);


        WebElement termsAndConditionsToggleBar = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        termsAndConditionsToggleBar.click();


//        JavascriptExecutor je = (JavascriptExecutor) driver;
//        je.executeScript("arguments[0].scrollIntoView(true);", termsAndConditionsToggleBar);
//        Thread.sleep(1000);
//        termsAndConditionsToggleBar.click();
//
//        WebElement registerBtn = driver.findElement(By.cssSelector("button[type='submit']"));




        registerPage.clickTheContinueBtn();
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
