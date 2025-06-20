package com.selcuk.helpers.generic;


import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class GenericHelper {


    public String readValueFromElement(WebElement element) {

        if (null == element){

            return null;
        }

        boolean displayed = false;
        try {
            displayed = isDisplayed(element);
        } catch (Exception e) {

            Reporter.log(e.fillInStackTrace().toString());
            return null;
        }

        if (!displayed){
            return null;
        }
        String text = element.getText();

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

        return value;
    }

    public boolean isDisplayed(WebElement element) {
        try {
            element.isDisplayed();

            return true;
        } catch (Exception e) {

            Reporter.log(e.fillInStackTrace().toString());
            return false;
        }
    }

    protected boolean isNotDisplayed(WebElement element) {
        try {
            element.isDisplayed();

            return false;
        } catch (Exception e) {

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

            return null;
        }
        String elementText = null;
        try {
            elementText = element.getText();
        } catch (Exception ex) {

            Reporter.log(ex.fillInStackTrace().toString());
        }
        return elementText;
    }
}
