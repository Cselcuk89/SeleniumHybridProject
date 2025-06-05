package com.selcuk.helpers.generic;

import com.selcuk.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class GenericHelper {
    private static final Logger LOGGER = LoggerHelper.getLogger(GenericHelper.class);

    public String readValueFromElement(WebElement element) {

        if (null == element){
            LOGGER.info("weblement is null");
            return null;
        }

        boolean displayed = false;
        try {
            displayed = isDisplayed(element);
        } catch (Exception e) {
            LOGGER.error(e);
            Reporter.log(e.fillInStackTrace().toString());
            return null;
        }

        if (!displayed){
            return null;
        }
        String text = element.getText();
        LOGGER.info("weblement valus is.." + text);
        return text;
    }


    public String readValueFromInput(WebElement element) {
        if (null == element){
            return null;
        }
        if (!isDisplayed(element)){
            return null;
        }
        String value = element.getAttribute("value");
        LOGGER.info("weblement valus is.."+value);
        return value;
    }

    public boolean isDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            LOGGER.info("element is displayed.." + element);
            return true;
        } catch (Exception e) {
            LOGGER.info(e);
            Reporter.log(e.fillInStackTrace().toString());
            return false;
        }
    }

    protected boolean isNotDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            LOGGER.info("element is displayed.." + element);
            return false;
        } catch (Exception e) {
            LOGGER.error(e);
            Reporter.log(e.fillInStackTrace().toString());
            return true;
        }
    }

    protected String getDisplayText(WebElement element) {
        if (null == element){
            return null;
        }
        if (!isDisplayed(element)){
            return null;
        }
        return element.getText();
    }


    public static synchronized String getElementText( WebElement element) {
        if (null == element) {
            LOGGER.info("weblement is null");
            return null;
        }
        String elementText = null;
        try {
            elementText = element.getText();
        } catch (Exception ex) {
            LOGGER.info("Element not found " + ex);
            Reporter.log(ex.fillInStackTrace().toString());
        }
        return elementText;
    }
}
