package com.selcuk.helpers.Alert;

import com.selcuk.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHelper {
    private WebDriver driver;
    private Logger LOGGER = LoggerHelper.getLogger(AlertHelper.class);
    // constructor to initialize this class
    public AlertHelper(WebDriver driver){
        this.driver = driver;
        LOGGER.debug("AlertHelper : " + this.driver.hashCode());
    }
    public Alert getAlert(){
        LOGGER.debug("-----> GetAlert method is being used");
        return driver.switchTo().alert();
    }
    public void AcceptAlert() {
        LOGGER.info("");
        getAlert().accept();
    }

    public void DismissAlert() {
        LOGGER.info("");
        getAlert().dismiss();
    }

    public String getAlertText() {
        String text = getAlert().getText();
        LOGGER.info(text);
        return text;
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            LOGGER.info("true");
            return true;
        } catch (NoAlertPresentException e) {
            // Ignore
            LOGGER.info("false");
            return false;
        }
    }

    public void AcceptAlertIfPresent() {
        if (!isAlertPresent())
            return;
        AcceptAlert();
        LOGGER.info("");
    }

    public void DismissAlertIfPresent() {

        if (!isAlertPresent())
            return;
        DismissAlert();
        LOGGER.info("");
    }

    public void AcceptPrompt(String text) {

        if (!isAlertPresent())
            return;

        Alert alert = getAlert();
        alert.sendKeys(text);
        alert.accept();
        LOGGER.info(text);
    }


}
