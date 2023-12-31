package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    @Then("The current url contains {string} keyword")
    public void theCurrentUrlContainsKeyword(String keywordFromTheUrl) throws InterruptedException {
        Thread.sleep(500);
        String currentUrl = driver.getCurrentUrl();
        boolean currentUrlContainsKeyword = currentUrl.contains(keywordFromTheUrl);
        Assertions.assertTrue(currentUrlContainsKeyword, "The keyword: " + keywordFromTheUrl + "is present in " + currentUrl);


    }

    @Given("{string} endpoint is accesed")
    public void endpointIsAccesed(String endpointValue) {
        driver.get("http://andreisecuqa.host" + endpointValue);
    }

    @Given("{string} endpoint is accessed")
    public void endpointIsAccessed(String endpointValue) {
        driver.get("https://andreisecuqa.host" + endpointValue);
    }

    @Then("the following list of error messages is displayed")
    public void theFollowingListOfErrorMessagesIsDisplayed(List<String> errorMessagesList) throws InterruptedException {
        Thread.sleep(1000);
        errorMessagesList.forEach(errorMessage ->{
            boolean errorMessageIsDisplayed = driver.findElement(By.xpath( "//*[contains(text(),'"+ errorMessage+"')]")).isDisplayed();
            Assertions.assertTrue(errorMessageIsDisplayed, "The error message: " + errorMessage +  "is displayed");
                });
    }
}
