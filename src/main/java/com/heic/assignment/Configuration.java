package com.heic.assignment;

import static java.lang.System.getenv;

// Set As system property or env variable
public enum Configuration {
    BROWSER("BROWSER", "safari"),
    TEST_URL("URL", "https://test.app.upet.co/"),
    OP_SYS("OP_SYS","os_x"),
    ENV("ENV","remote");

    private final String value;

    Configuration(String mode, String defaultValue) {
        if (getenv(mode) != null)
            this.value = getenv(mode);
        else
            this.value = defaultValue;
    }

    public String getValue() {
        return this.value;
    }

}
