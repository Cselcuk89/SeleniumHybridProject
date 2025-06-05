package com.selcuk.helpers.assertions;

import com.selcuk.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class AssertionHelper {
    private static final Logger LOGGER = LoggerHelper.getLogger(AssertionHelper.class);

    public static synchronized boolean verifyElementPresent( WebElement element) {
        boolean isDisplayed = false;
        try {
            isDisplayed= element.isDisplayed();
            LOGGER.info(element.getText()+" is dispalyed");
        }
        catch(Exception ex) {
            LOGGER.error("Element not found " + ex);
        }

        return isDisplayed;
    }

    public static synchronized boolean verifyElementNotPresent( WebElement element) {
        boolean isDisplayed = false;
        try {
            element.isDisplayed();
            LOGGER.info(element.getText()+" is dispalyed");
        }
        catch(Exception ex) {
            LOGGER.error("Element not found " + ex);
            isDisplayed = true;
        }

        return isDisplayed;
    }

    public static synchronized boolean verifyTextEquals( WebElement element,String expectedText) {
        boolean flag = false;
        try {
            String actualText=element.getText();
            if(actualText.equals(expectedText)) {
                LOGGER.info("actualText is :" + actualText +" expected text is: " + expectedText);
                return flag=true;
            }
            else {
                LOGGER.error("actualText is :"+actualText+" expected text is: "+expectedText);
                return flag;
            }
        }
        catch(Exception ex) {
            LOGGER.error("actualText is :" +element.getText()+ " expected text is: " + expectedText);
            LOGGER.info("text not matching" + ex);
            return flag;
        }
    }
}
