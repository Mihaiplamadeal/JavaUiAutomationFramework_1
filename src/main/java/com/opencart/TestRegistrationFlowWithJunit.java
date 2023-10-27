package com.opencart;

import com.opencart.managers.DataGenerator;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestRegistrationFlowWithJunit {

    WebDriver driver;
    HomePage homePage;

    RegisterPage registerPage;

    @BeforeAll

    public static void executeThisMethodBeforeAllTheTests(){
        System.out.println("The execution of the test suit has started");
    }

    @BeforeEach
    public void executeTheCodeBeforeEachTest(){
        System.out.println("The code is executed before each test case");
        driver = DriverManager.getInstance().getDriver();
        driver.get("http://andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.navigateToRegisterPageFromHeader();
    }


    @Test
    @DisplayName("The registration of a new user with valid data redirects to the Account Page")
    public void registerWithValidCredentialsTest() throws InterruptedException {
        System.out.println("This is the test number 1");

        String firstName = DataGenerator.generateFirstName();
        System.out.println(firstName);

        String lastName = DataGenerator.generateLastName();

        System.out.println(lastName);


        String randomEmail = DataGenerator.generateRandomEmail();
        System.out.println(randomEmail);


        String password = DataGenerator.generatePassword();

        System.out.println(password);

        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, password, true);
        registerPage.clickTheContinueBtn();

        Thread.sleep(500);
        String currentUrl = driver.getCurrentUrl();

        boolean doesCurrentUrlContainAccountKeyword = currentUrl.contains("route=account/success");

        Assertions.assertTrue(doesCurrentUrlContainAccountKeyword, "The correct account url is displayed");



    }

    @Test
    @DisplayName("The user is remaining on Register Page when trying to register with invalid password")
    public void registerWithInvalidPasswordTest() throws InterruptedException {
        System.out.println("This is the test number 2");

        String firstName = DataGenerator.generateFirstName();
        System.out.println(firstName);

        String lastName = DataGenerator.generateLastName();

        System.out.println(lastName);


        String randomEmail = DataGenerator.generateRandomEmail();
        System.out.println(randomEmail);


        String password = DataGenerator.generatePassword();

        System.out.println(password);

        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, "123", true);


        registerPage.clickTheContinueBtn();
        Thread.sleep(500);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://andreisecuqa.host/index.php?route=account/register&language=en-gb";
        System.out.println(expectedUrl);
        System.out.println(actualUrl);
        Assertions.assertTrue(actualUrl.contains(expectedUrl), "The message should be equals");
    }

    @AfterEach
    public void afterEachTestCase(){
        DriverManager.getInstance().tearDown();
        System.out.println("The test case execution has been finished");
    }

    @AfterAll
    public static void afterAllMethod(){
        System.out.println("The test suite execution is finished");
    }

    }



