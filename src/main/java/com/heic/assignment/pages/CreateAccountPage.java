package com.heic.assignment.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class CreateAccountPage {

    public static String first_name = "UpetUserFN";
    public static String last_name = "UpetUserLN";
    public static String pwd = "PASSWORD1234";

    public SelenideElement header = $x("//h1[contains(.,'Create account')]");

    public CreateAccountPage() {
        header.shouldBe(Condition.visible);
    }

    public static SelenideElement firstName = $(By.name("name")),
            lastName = $(By.name("lastName")),
            email = $(By.name("email")),
            password = $(By.name("password")),
            createAccountBtn = $("[type='submit']");

    public static SelenideElement getFirstName() {
        return firstName;
    }

    public static SelenideElement getLastName() {
        return lastName;
    }

    public static SelenideElement getEmail() {
        return email;
    }

    public static SelenideElement getPassword() {
        return password;
    }

    public static SelenideElement getCreateAccountBtn() {
        return createAccountBtn;
    }

    public CreateAccountPage fillDetails() {
        getFirstName().setValue(first_name);
        getLastName().setValue(last_name);
        getEmail().setValue("email" + new Random().nextLong() + "@uPet.com");
        getPassword().setValue(pwd);
        return this;
    }

    public HomePage submitCreateAccount() {
        getCreateAccountBtn().click();
        return new HomePage();
    }


}
