package com.appgate.reqresin.models.enums;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public enum ConnectionInformation {
    API_URL("URL");

    private String value;

    private ConnectionInformation(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return variables.getProperty(value);
    }
}
