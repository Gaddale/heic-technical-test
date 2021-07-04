package com.heic.assignment.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SignInPage {

    public SelenideElement header = $x("//h1[contains(.,'Sign in')]");

    public SignInPage() {
        header.shouldBe(Condition.visible);
    }

    public static SelenideElement newUser = $x("//span[contains(text(),'NEWBIE? CREATE ACCOUNT')]");

    public static SelenideElement getNewUserBtn() {
        return newUser;
    }

    public CreateAccountPage navigateToCreateAccountPage() {
        getNewUserBtn().click();
        return new CreateAccountPage();
    }
}
