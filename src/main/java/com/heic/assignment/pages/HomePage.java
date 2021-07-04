package com.heic.assignment.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.heic.assignment.utils.CommonUtils.setEnv;
import static com.heic.assignment.utils.CommonUtils.setOs;

public class HomePage {

    public SelenideElement userProfile = $("#currentUser");
    public SelenideElement UploadedProfilePhoto = $x("//img[@alt='profile image']");

    public HomePage() {
        userProfile.shouldBe(Condition.visible);
    }

    public static SelenideElement uploadSnap = $("#uploadPhoto"),
            saveButton = $x("//span[contains(text(),'Save')]");

    public SelenideElement getUserProfile() {
        return userProfile;
    }

    public static SelenideElement getUploadSnap() {
        return uploadSnap;
    }

    public static SelenideElement getSaveButton() {
        return saveButton;
    }

    public HomePage uploadProfilePhoto() {
        getUserProfile().click();
        //On windows os, upload of .HEIC is not working, alternative I have used .jpg file
        if (setEnv().equals("local") || (setEnv().equals("remote") && (setOs().equals("windows")))) {
            getUploadSnap().uploadFile(new File(System.getProperty("user.dir") + "\\" + "heic-image.jpg"));
        }
        if (setEnv().equals("remote") && (setOs().equals("os_x"))) {
            getUploadSnap().uploadFile(new File(System.getProperty("user.dir") + "\\" + "heic-image.HEIC"));
        }
        getSaveButton().click();
        return this;
    }
}
