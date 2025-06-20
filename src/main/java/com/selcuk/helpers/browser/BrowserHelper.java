package com.selcuk.helpers.browser;


import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {
    private WebDriver driver;

    public BrowserHelper(WebDriver driver) {
        this.driver = driver;

    }

    public void goBack() {
        driver.navigate().back();

    }

    public void goForward() {
        driver.navigate().forward();

    }

    public void refresh() {
        driver.navigate().refresh();

    }

    public Set<String> getWindowHandlens() {

        return driver.getWindowHandles();
    }

    public void SwitchToWindow(int index) {

        LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());

        if (index < 0 || index > windowsId.size()){
            throw new IllegalArgumentException("Invalid Index : " + index);
        }
        driver.switchTo().window(windowsId.get(index));

    }

    public void switchToParentWindow() {
        LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
        driver.switchTo().window(windowsId.get(0));

    }

    public void switchToParentWithChildClose() {
        LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());

        for (int i = 1; i < windowsId.size(); i++) {

            driver.switchTo().window(windowsId.get(i));
            driver.close();
        }

        switchToParentWindow();
    }



    public void switchToFrame(String nameOrId) {
        driver.switchTo().frame(nameOrId);

    }
}
