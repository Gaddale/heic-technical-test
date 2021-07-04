package com.heic.assignment.steps;

import com.codeborne.selenide.Condition;
import com.heic.assignment.pages.CreateAccountPage;
import com.heic.assignment.pages.HomePage;
import com.heic.assignment.pages.SignInPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAccount {

    @Given("^a new user to uPet$")
    public void aNewUserToUPet() {
        SignInPage signInPage = new SignInPage();
        signInPage.navigateToCreateAccountPage();
    }

    @When("^user creates an account providing the details$")
    public void theUserCreatesAnAccountProvidingTheDetails() {
        CreateAccountPage createAccountPage = new CreateAccountPage();
        createAccountPage.fillDetails().submitCreateAccount();
    }

    @Then("^user should be able create new account successfully and upload his profile photo$")
    public void userShouldBeAbleToUploadTheProfileSnap() {
        HomePage homePage = new HomePage();
        homePage.uploadProfilePhoto().UploadedProfilePhoto.shouldBe(Condition.visible);
    }
}
