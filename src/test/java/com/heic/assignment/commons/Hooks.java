package com.heic.assignment.commons;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.heic.assignment.driver.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.heic.assignment.utils.CommonUtils.*;

public class Hooks {
    public static final String USERNAME = "taeupwork_qSwAs8";
    public static final String ACCESSKEY = "JQCA46mFEp1A6bjRJxQz";

    @Before
    public void initialiseTest() {
        String url = setUrl();
        String os = setOs();
        Configuration.browser = setBrowser();
        if (setEnv().equals("local")) {
            WebDriver driver = DriverFactory.getNewDriver(os, setBrowser());
            WebDriverRunner.setWebDriver(driver);
        }
        if (setEnv().equals("remote")) {
            Configuration.driverManagerEnabled = true;
            Configuration.remote = "https://" + USERNAME + ":" + ACCESSKEY + "@hub.browserstack.com/wd/hub";
            if (os.equals("os_x") && (Configuration.browser.equals("safari") || Configuration.browser.equals("chrome") || Configuration.browser.equals("firefox"))){
                Configuration.browserCapabilities = osXSetCapabilities();
            }
            if (os.equals("windows") && (Configuration.browser.equals("firefox") || Configuration.browser.equals("chrome"))){
                Configuration.browserCapabilities = osWindowsSetCapabilities();
            }
            Configuration.startMaximized = true;
        }
        open(url);
        Configuration.timeout = 20000;
    }

    public DesiredCapabilities osXSetCapabilities() {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("os", "OS X");
        capability.setCapability("os_version", "Big Sur");
        capability.setCapability("browser", Configuration.browser);
        capability.setCapability("name", "heic-technical-test");
        return capability;
    }

    public DesiredCapabilities osWindowsSetCapabilities() {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("os", "Windows");
        capability.setCapability("os_version", "10");
        capability.setCapability("browser", Configuration.browser);
        capability.setCapability("browser_version", "latest");
        capability.setCapability("name", "heic-technical-test");
        return capability;
    }

    @After
    public void endTest(Scenario scenario) {
        $("#settings").click();
        $("#logout").click();
        WebDriverRunner.closeWindow();
        WebDriverRunner.closeWebDriver();
    }
}
