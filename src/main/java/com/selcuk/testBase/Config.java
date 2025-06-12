package com.selcuk.testBase;

import java.util.Properties;

public class Config extends TestBase {
    private Properties PROPERTIES;

    public Config(Properties OR){
        this.PROPERTIES = PROPERTIES;
    }
    public String getUserName() {
        return PROPERTIES.getProperty("Username");
    }

    public String getPassword() {
        return PROPERTIES.getProperty("Password");
    }

    public String getWebsite() {
        return PROPERTIES.getProperty("Website");
    }

    public int getPageLoadTimeOut() {
        return Integer.parseInt(PROPERTIES.getProperty("PageLoadTimeOut"));
    }

    public int getImplicitWait() {
        return Integer.parseInt(PROPERTIES.getProperty("ImplcitWait"));
    }

    public int getExplicitWait() {
        return Integer.parseInt(PROPERTIES.getProperty("ExplicitWait"));
    }

    public String getDbType() {
        return PROPERTIES.getProperty("DataBase.Type");
    }

    public String getDbConnStr() {
        return PROPERTIES.getProperty("DtaBase.ConnectionStr");
    }
    public String getBrowser() {
        return PROPERTIES.getProperty("Browser");
    }
}
