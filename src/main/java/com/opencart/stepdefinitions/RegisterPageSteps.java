package com.opencart.stepdefinitions;

import com.opencart.managers.DataGenerator;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    RegisterPage registerPage = new RegisterPage(driver);

    @When("the register form is populated with valid random data")
    public void theRegisterFormIsPopulatedWithValidRandomData() {


        String firstName = DataGenerator.generateFirstName();
        System.out.println(firstName);

        String lastName = DataGenerator.generateLastName();

        System.out.println(lastName);


        String randomEmail = DataGenerator.generateRandomEmail();
        System.out.println(randomEmail);


        String password = DataGenerator.generatePassword();

        System.out.println(password);

        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, password, true);
        System.out.println("The register form is populated with valid random data");
    }

    @And("Continue button is clicked")
    public void continueButtonIsClicked() {
        registerPage.clickTheContinueBtn();
        System.out.println("The continue button has been clicked");
    }

    @When("the register form is populated with the following data:")
    public void theRegisterFormIsPopulatedWithTheFollowingData(Map<String,String> formDataMap) {
        String firstNameValue = formDataMap.get("firstName");
        if(firstNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")){
            firstNameValue = DataGenerator.generateFirstName();
        }
        String lastNameValue = formDataMap.get("lastName");
        if (lastNameValue != null && lastNameValue.toUpperCase().equals("RANDOM")){
            lastNameValue = DataGenerator.generateLastName();
        }
        String emailImput = formDataMap.get("email");
        if (emailImput != null && emailImput.toUpperCase().equals("RANDOM")){
            emailImput = DataGenerator.generateRandomEmail();
        }
        String password = formDataMap.get("password");
        if (password != null && password.toUpperCase().equals("RANDOM")){
            password = DataGenerator.generatePassword();
        }

        registerPage.fillInTheRegisterForm(firstNameValue, lastNameValue, emailImput, password, true);
    }
}
