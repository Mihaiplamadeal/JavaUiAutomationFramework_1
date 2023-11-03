package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.LoginPage;
import io.cucumber.java.en.When;

import java.util.List;

public class LoginPageSteps {

    private LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
    @When("the logic form is populated with following details:")
    public void theLogicFormIsPopulatedWithFollowingDetails(List<String> loginCredentials) {
        loginPage.fillInTheLoginForm(loginCredentials.get(0), loginCredentials.get(1));
    }
}
