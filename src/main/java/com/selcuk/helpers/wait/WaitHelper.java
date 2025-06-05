package com.selcuk.helpers.wait;

import com.selcuk.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WaitHelper {
    private WebDriver driver;
    private Logger LOGGER = LoggerHelper.getLogger(WaitHelper.class);


    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        LOGGER.debug("WaitHelper : " + this.driver.hashCode());
    }

    public void setImplicitWait(long timeout, TimeUnit unit) {
        LOGGER.info("Setting implicit wait --->" + timeout);
        driver.manage().timeouts().implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
    }

    public void setPageLoadTimeout(long timeout, TimeUnit unit) {
        LOGGER.info(timeout);
        driver.manage().timeouts().pageLoadTimeout(timeout, unit == null ? TimeUnit.SECONDS : unit);
    }

    private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
        LOGGER.debug("");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }

    public void waitForElementVisible(WebElement locator, int timeOutInSeconds, int pollingEveryInMiliSec) {
        LOGGER.info(locator);
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void waitForElement(WebDriver driver, WebElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        LOGGER.info("element found..."+element.getText());
    }

    public WebElement waitForElement(WebDriver driver,long time,WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
