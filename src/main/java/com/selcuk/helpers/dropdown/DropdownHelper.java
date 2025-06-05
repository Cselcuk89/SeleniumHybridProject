package com.selcuk.helpers.dropdown;

import com.selcuk.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;

public class DropdownHelper {
    private WebDriver driver;
    private Logger LOGGER = LoggerHelper.getLogger(DropdownHelper.class);

    public DropdownHelper(WebDriver driver) {
        this.driver = driver;
        LOGGER.debug("DropDownHelper : " + this.driver.hashCode());
    }


    public void SelectUsingVisibleValue(WebElement element, String visibleValue) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleValue);
        LOGGER.info("Locator : " + element + " Value : " + visibleValue);
    }

    public String getSelectedValue(WebElement element) {
        String value = new Select(element).getFirstSelectedOption().getText();
        LOGGER.info("WebELement : " + element + " Value : "+ value);
        return value;
    }

    public void SelectUsingIndex(WebElement element,int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
        LOGGER.info("Locator : " + element + " Value : " + index);
    }

    public void SelectUsingVisibleText(WebElement element,String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
        LOGGER.info("Locator : " + element + " Value : " + text);
    }


    public List<String> getAllDropDownValues(WebElement locator) {
        Select select = new Select(locator);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();

        for (WebElement element : elementList) {
            LOGGER.info("Getting the element text ---> " + element.getText());
            valueList.add(element.getText());
        }
        return valueList;
    }
}
