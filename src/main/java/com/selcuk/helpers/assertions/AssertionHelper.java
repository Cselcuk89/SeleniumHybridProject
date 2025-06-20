package com.selcuk.helpers.assertions;


import org.openqa.selenium.WebElement;

public class AssertionHelper {


    public static synchronized boolean verifyElementPresent( WebElement element) {
        boolean isDisplayed = false;
        try {
            isDisplayed= element.isDisplayed();

        }
        catch(Exception ex) {

        }

        return isDisplayed;
    }

    public static synchronized boolean verifyElementNotPresent( WebElement element) {
        boolean isDisplayed = false;
        try {
            element.isDisplayed();

        }
        catch(Exception ex) {

            isDisplayed = true;
        }

        return isDisplayed;
    }

    public static synchronized boolean verifyTextEquals( WebElement element,String expectedText) {
        boolean flag = false;
        try {
            String actualText=element.getText();
            if(actualText.equals(expectedText)) {

                return flag=true;
            }
            else {

                return flag;
            }
        }
        catch(Exception ex) {

            return flag;
        }
    }
}
