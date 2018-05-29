package com.boomi.flow.services.lotsatypes;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.configuration.Configuration;

public class ApplicationConfiguration implements Configuration {
    @Configuration.Setting(name = "# of Properties", contentType = ContentType.Number)
    private int numberOfProperties = 60;

    @Configuration.Setting(name = "# of Types", contentType = ContentType.Number)
    private int numberOfTypes = 400;

    public int getNumberOfProperties() {
        return numberOfProperties;
    }

    public int getNumberOfTypes() {
        return numberOfTypes;
    }
}
