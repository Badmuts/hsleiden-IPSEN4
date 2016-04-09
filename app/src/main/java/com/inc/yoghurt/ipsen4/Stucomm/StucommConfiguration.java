package com.inc.yoghurt.ipsen4.Stucomm;

import android.content.Context;

import com.inc.yoghurt.ipsen4.App;
import com.inc.yoghurt.ipsen4.ForApp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.inject.Inject;

/**
 * Created by daan on 08/04/16.
 */
public class StucommConfiguration {

    private final App context;
    private final Properties configFile;

    @Inject
    public StucommConfiguration(@ForApp App context) {
        this.context = context;
        configFile = new Properties();
        try {
            configFile.load(this.context.getAssets().open("stucomm.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getClientToken() throws NullPointerException {
        if (configFile.getProperty("clientToken") == null) {
            throw new NullPointerException("Make sure the ClientToken is set in the Properties file.");
        }
        return configFile.getProperty("clientToken");
    }

    public String getAccessToken() throws NullPointerException {
        if (configFile.getProperty("accessToken") == null) {
            throw new NullPointerException("Make sure the AccessToken is set in the Properties file.");
        }
        return configFile.getProperty("accessToken");
    }

    public String getBaseUrl() throws NullPointerException {
        if (configFile.getProperty("baseUrl") == null) {
            throw new NullPointerException("Make sure the BaseUrl is set in the Properties file.");
        }
        return configFile.getProperty("baseUrl");
    }
}
