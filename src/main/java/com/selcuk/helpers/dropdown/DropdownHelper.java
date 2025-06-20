package com.selcuk.helpers.dropdown;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;

public class DropdownHelper {
    private WebDriver driver;


    public DropdownHelper(WebDriver driver) {
        this.driver = driver;

    }


    public void SelectUsingVisibleValue(WebElement element, String visibleValue) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleValue);

    }

    public String getSelectedValue(WebElement element) {
        String value = new Select(element).getFirstSelectedOption().getText();

        return value;
    }

    public void SelectUsingIndex(WebElement element,int index) {
        Select select = new Select(element);
        select.selectByIndex(index);

    }

    public void SelectUsingVisibleText(WebElement element,String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);

    }


    public List<String> getAllDropDownValues(WebElement locator) {
        Select select = new Select(locator);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();

        for (WebElement element : elementList) {

            valueList.add(element.getText());
        }
        return valueList;
    }
}
