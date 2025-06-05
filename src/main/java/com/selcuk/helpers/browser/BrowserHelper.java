package com.selcuk.helpers.browser;

import com.selcuk.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {
    private WebDriver driver;
    private Logger LOGGER = LoggerHelper.getLogger(BrowserHelper.class);
    public BrowserHelper(WebDriver driver) {
        this.driver = driver;
        LOGGER.debug("BrowserHelper : " + this.driver.hashCode());
    }

    public void goBack() {
        driver.navigate().back();
        LOGGER.info("----> Going back to previous page");
    }

    public void goForward() {
        driver.navigate().forward();
        LOGGER.info("----> Going to next page");
    }

    public void refresh() {
        driver.navigate().refresh();
        LOGGER.info("----> Refreshing page");
    }

    public Set<String> getWindowHandlens() {
        LOGGER.info("----> Getting window handles...");
        return driver.getWindowHandles();
    }

    public void SwitchToWindow(int index) {

        LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());

        if (index < 0 || index > windowsId.size()){
            throw new IllegalArgumentException("Invalid Index : " + index);
        }
        driver.switchTo().window(windowsId.get(index));
        LOGGER.info(index);
    }

    public void switchToParentWindow() {
        LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
        driver.switchTo().window(windowsId.get(0));
        LOGGER.info("----> Switching to the parent window ....");
    }

    public void switchToParentWithChildClose() {
        LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());

        for (int i = 1; i < windowsId.size(); i++) {
            LOGGER.info(windowsId.get(i));
            driver.switchTo().window(windowsId.get(i));
            driver.close();
        }

        switchToParentWindow();
    }



    public void switchToFrame(String nameOrId) {
        driver.switchTo().frame(nameOrId);
        LOGGER.info(nameOrId);
    }
}
