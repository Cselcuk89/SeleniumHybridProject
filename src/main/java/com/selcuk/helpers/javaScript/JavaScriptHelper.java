package com.selcuk.helpers.javaScript;

import com.selcuk.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {
    private WebDriver driver;
    private Logger LOGGER = LoggerHelper.getLogger(JavaScriptHelper.class);

    public JavaScriptHelper(WebDriver driver) {
        this.driver = driver;
        LOGGER.debug("JavaScriptHelper : " + this.driver.hashCode());
    }

    public Object executeScript(String script) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        LOGGER.info("Executing the script -->" + script);
        return exe.executeScript(script);
    }

    public Object executeScript(String script, Object... args) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        LOGGER.info("Executing the script -->" + script);
        return exe.executeScript(script, args);
    }

    public void scrollToElemet(WebElement element) {
        executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
        LOGGER.info("Scrolling to element --->" + element);
    }

    public void scrollToElemetAndClick(WebElement element) {
        scrollToElemet(element);
        element.click();
        LOGGER.info("Scrolling to element and click on ---> " + element);
    }

    public void scrollIntoView(WebElement element) {
        executeScript("arguments[0].scrollIntoView()", element);
        LOGGER.info("Scrolling into view of element ---> " + element);
    }

    public void scrollIntoViewAndClick(WebElement element) {
        scrollIntoView(element);
        element.click();
        LOGGER.info("Scrolling into view of element and clicking on  ---> " + element);
    }

    public void scrollDownVertically() {
        executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollUpVertically() {
        executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    public void scrollDownByPixel() {
        executeScript("window.scrollBy(0,1500)");
    }

    public void scrollUpByPixel() {
        executeScript("window.scrollBy(0,-1500)");
    }

    public void ZoomInBypercentage() {
        executeScript("document.body.style.zoom='40%'");
    }

    public void ZoomBy100percentage() {
        executeScript("document.body.style.zoom='100%'");
    }
}
