package com.selcuk.pageObjects;

import com.selcuk.helpers.generic.GenericHelper;
import com.selcuk.helpers.javaScript.JavaScriptHelper;
import com.selcuk.helpers.logger.LoggerHelper;
import com.selcuk.helpers.wait.WaitHelper;
import com.selcuk.testBase.Config;
import com.selcuk.testBase.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    private final Logger LOGGER = LoggerHelper.getLogger(LoginPage.class);
    WaitHelper waitHelper;

    @FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    WebElement signin;

    @FindBy(xpath="//*[@id='email']")
    WebElement emailAddress;

    @FindBy(xpath="//*[@id='passwd']")
    WebElement password;

    @FindBy(xpath="//*[@id='SubmitLogin']")
    WebElement submitLogin;

    @FindBy(xpath="//*[@id='center_column']/p")
    WebElement successMsgObject;

    @FindBy(xpath="//*[@id='email_create']")
    WebElement registration;

    @FindBy(xpath="//*[@id='SubmitCreate']")
    WebElement createAnAccount;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(driver, signin,new Config(TestBase.PROPERTIES).getExplicitWait());
    }

    public void clickOnSignInLink(){
        LOGGER.info("clicked on sign in link...");
        signin.click();
    }

    public void enterEmailAddress(String emailAddress){
        LOGGER.info("entering email address...." + emailAddress);
        this.emailAddress.sendKeys(emailAddress);
    }

    public void enterPassword(String password){
        LOGGER.info("entering password...." + password);
        this.password.sendKeys(password);
    }

    public HomePage clickOnSubmitButton(){
        LOGGER.info("clicking on submit button...");
        new JavaScriptHelper(driver).scrollDownVertically();
        submitLogin.click();
        return new HomePage(driver);
    }

    public boolean verifySuccessLoginMsg(){
        return new GenericHelper().isDisplayed(successMsgObject);
    }

    public void enterRegistrationEmail(){
        String email = System.currentTimeMillis()+"@gmail.com";
        LOGGER.info("entering registration email.."+email);
        registration.sendKeys(email);
    }

    public RegistrationPage clickOnCreateAnAccount(){
        createAnAccount.click();
        return new RegistrationPage(driver);
    }

    public void loginToApplication(String emailAddress, String password){
        clickOnSignInLink();
        enterEmailAddress(emailAddress);
        enterPassword(password);
        clickOnSubmitButton();
    }
}
