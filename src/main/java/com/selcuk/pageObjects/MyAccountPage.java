package com.selcuk.pageObjects;

import com.selcuk.helpers.assertions.AssertionHelper;
import com.selcuk.helpers.logger.LoggerHelper;
import com.selcuk.helpers.wait.WaitHelper;
import com.selcuk.testBase.Config;
import com.selcuk.testBase.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    WebDriver driver;
    private final Logger LOGGER = LoggerHelper.getLogger(MyAccountPage.class);
    WaitHelper waitHelper;

    @FindBy(xpath="//*[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]")
    WebElement successRegistrationMsg;

    @FindBy(xpath="//*[contains(text(),'Order history and details')]")
    WebElement OrderHistoryAndDetails;

    @FindBy(xpath="//*[contains(text(),'My personal information')]")
    WebElement MyPersonalInformation;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(driver, OrderHistoryAndDetails,new Config(TestBase.PROPERTIES).getExplicitWait());
    }

    public boolean verifySuccessRegistrationMsg(){
        return AssertionHelper.verifyElementPresent(successRegistrationMsg);
    }
}
