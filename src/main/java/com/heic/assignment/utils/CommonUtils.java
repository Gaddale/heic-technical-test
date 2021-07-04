package com.heic.assignment.utils;

import com.heic.assignment.Configuration;

public class CommonUtils {

    public static String setBrowser() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = System.getenv("browser");
            if (browser == null) {
                browser = Configuration.BROWSER.getValue();
            }
        }
        return browser;
    }

    public static String setUrl() {
        String url = System.getProperty("url");
        if (url == null) {
            url = System.getenv("url");
            if (url == null) {
                url = Configuration.TEST_URL.getValue();
            }
        }
        return url;
    }

    public static String setOs() {
        String os = System.getProperty("os");
        if (os == null) {
            os = Configuration.OP_SYS.getValue();
        }
        return os;
    }

    public static String setEnv() {
        String env = System.getProperty("env");
        if (env == null) {
            env = System.getenv("env");
            if (env == null) {
                env = Configuration.ENV.getValue();
            }
        }
        return env;
    }

}
