package com.selcuk.pageObjects;

import com.selcuk.helpers.logger.LoggerHelper;
import com.selcuk.helpers.wait.WaitHelper;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {

    @FindBy(css = "h2[class='title text-center'] b")
    private WebElement testCases;

    private WebDriver driver;

    public TestCasesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getTestCases() {

        WaitHelper.waitForElementToBeVisible(driver, testCases);
        return testCases;
    }
}
