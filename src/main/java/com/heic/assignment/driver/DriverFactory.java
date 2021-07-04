package com.heic.assignment.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static BrowserConfig config;
    private static WebDriver driver;

    public static WebDriver getNewDriver(String os, String browser) {
        setBrowserInfo(os, browser);
        setDriver();
        windowMaximize();
        return driver;
    }

    private static void windowMaximize() {
        driver.manage().window().maximize();
    }

    private static void setDriver() {
        driver = config.getDriver();
    }

    private static void setBrowserInfo(String os, String browser) {
        if ("chrome".equals(browser.toLowerCase())) {
            if (os.equals("linux")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/linux/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/windows/chromedriver.exe");
            }
            config = new ChromeConfig();
        } else if ("firefox".equals(browser.toLowerCase())) {
            if (os.equals("linux")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/linux/geckodriver");
            } else {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/windows/geckodriver.exe");
            }
            config = new FirefoxConfig();
        }
    }
}
