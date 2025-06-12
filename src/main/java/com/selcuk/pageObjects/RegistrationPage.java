package com.selcuk.pageObjects;

import com.selcuk.helpers.logger.LoggerHelper;
import com.selcuk.helpers.wait.WaitHelper;
import com.selcuk.testBase.Config;
import com.selcuk.testBase.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class RegistrationPage {
    WebDriver driver;
    private final Logger LOGGER = LoggerHelper.getLogger(RegistrationPage.class);
    WaitHelper waitHelper;

    @FindBy(xpath = "//*[@id='id_gender1']")
    public WebElement mrRadioButton;

    @FindBy(xpath = ".//*[@id='id_gender2']")
    WebElement mrsRadioButton;

    @FindBy(xpath = "//*[@id='customer_firstname']")
    WebElement firstName;

    @FindBy(xpath = "//*[@id='customer_lastname']")
    WebElement lastname;

    @FindBy(xpath = "//*[@id='email']")
    WebElement emailAddress;

    @FindBy(xpath = "//*[@id='passwd']")
    WebElement password;

    @FindBy(xpath = "//*[@id='days']")
    WebElement days;

    @FindBy(xpath = "//*[@id='months']")
    WebElement month;

    @FindBy(xpath = "//*[@id='years']")
    WebElement year;

    @FindBy(xpath = "//*[@id='firstname']")
    WebElement yourAddressFirstName;

    @FindBy(xpath = "//*[@id='lastname']")
    WebElement yourAddressLastName;

    @FindBy(xpath = "//*[@id='company']")
    WebElement yourAddressCompany;

    @FindBy(xpath = "//*[@id='address1']")
    WebElement address;

    @FindBy(xpath = "//*[@id='address2']")
    WebElement address2;

    @FindBy(xpath = "//*[@id='city']")
    WebElement yourAddressCity;

    @FindBy(xpath = "//*[@id='id_state']")
    WebElement yourAddressState;

    @FindBy(xpath = "//*[@id='postcode']")
    WebElement yourAddressPostCode;

    @FindBy(xpath = "//*[@id='id_country']")
    WebElement additionalInformation;

    @FindBy(xpath = "//*[@id='phone']")
    WebElement homePhone;

    @FindBy(xpath = "//*[@id='phone_mobile']")
    WebElement mobilePhone;

    @FindBy(xpath = "//*[@id='alias']")
    WebElement addressAlias;

    @FindBy(xpath = "//*[@id='submitAccount']")
    WebElement registration;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(driver, mrRadioButton,new Config(TestBase.PROPERTIES).getExplicitWait());
    }

    public void setMrRadioButton() {
        LOGGER.info("selecting mr checkbox..");
        this.mrRadioButton.click();
    }

    public void setMrsRadioButton() {
        LOGGER.info("selecting mrs checkbox..");
        this.mrsRadioButton.click();
    }

    public void setFirstName(String firstName) {
        LOGGER.info("entering firstName.." + firstName);
        this.firstName.sendKeys(firstName);
    }

    public void setLastname(String lastname) {
        LOGGER.info("entering lastname.." + lastname);
        this.lastname.sendKeys(lastname);
    }

    public void setEmailAddress(String emailAddress) {
        LOGGER.info("entering emailAddress.." + emailAddress);
        this.emailAddress.sendKeys(emailAddress);
    }

    public void setPassword(String password) {
        LOGGER.info("entering password.." + password);
        this.password.sendKeys(password);
    }

    public void setDay(String day) {
        List<WebElement> days = driver.findElements(By.xpath("//*[@id='days']/option"));
        Iterator<WebElement> itr = days.iterator();
        while (itr.hasNext()) {
            WebElement c = itr.next();
            String text = c.getText().trim().toString();
            if (text.equals(day)) {
                System.out.println(day);
                c.click();
                break;
            }
        }
    }

    public void setMonth(String month) {

        List<WebElement> days = driver.findElements(By.xpath("//*[@id='months']/option"));
        Iterator<WebElement> itr = days.iterator();
        while (itr.hasNext()) {
            WebElement click = itr.next();
            String text = click.getText().trim();
            if (text.equals(month)) {
                click.click();
                break;
            }
        }
    }

    public void setYear(String year) {

        List<WebElement> days = driver.findElements(By.xpath("//*[@id='years']/option"));
        Iterator<WebElement> itr = days.iterator();
        while (itr.hasNext()) {
            WebElement click = itr.next();
            String text = click.getText().trim();
            if (text.equals(year)) {
                click.click();
                break;
            }
        }

    }

    public void setYourAddressFirstName(String yourAddressFirstName) {
        LOGGER.info("entering yourAddressFirstName.." + yourAddressFirstName);
        this.yourAddressFirstName.sendKeys(yourAddressFirstName);
    }

    public void setYourAddressLastName(String yourAddressLastName) {
        LOGGER.info("entering yourAddressLastName.." + yourAddressLastName);
        this.yourAddressLastName.sendKeys(yourAddressLastName);
    }

    public void setYourAddressCompany(String yourAddressCompany) {
        LOGGER.info("entering yourAddressCompany.." + yourAddressCompany);
        this.yourAddressCompany.sendKeys(yourAddressCompany);
    }

    public void setAddress(String address) {
        LOGGER.info("entering address.." + address);
        this.address.sendKeys(address);
    }

    public void setAddress2(String address2) {
        LOGGER.info("entering address2.." + address2);
        this.address2.sendKeys(address2);
    }

    public void setYourAddressCity(String yourAddressCity) {
        LOGGER.info("entering yourAddressCity.." + yourAddressCity);
        this.yourAddressCity.sendKeys(yourAddressCity);
    }

    public void setYourAddressState(String yourAddressState) {
        LOGGER.info("entering yourAddressState.." + yourAddressState);
        new Select(this.yourAddressState).selectByVisibleText(yourAddressState);
    }

    public void setYourAddressPostCode(String yourAddressPostCode) {
        LOGGER.info("entering yourAddressPostCode.." + yourAddressPostCode);
        this.yourAddressPostCode.sendKeys(yourAddressPostCode);
    }

    public void setAdditionalInformation(String additionalInformation) {
        LOGGER.info("entering additionalInformation.." + additionalInformation);
        this.additionalInformation.sendKeys(additionalInformation);
    }

    public void setHomePhone(String homePhone) {
        LOGGER.info("entering homePhone.." + homePhone);
        this.homePhone.sendKeys(homePhone);
    }

    public void setMobilePhone(String mobilePhone) {
        LOGGER.info("entering mobilePhone.." + mobilePhone);
        this.mobilePhone.sendKeys(mobilePhone);
    }

    public void setAddressAlias(String addressAlias) {
        LOGGER.info("entering addressAlias.." + addressAlias);
        this.addressAlias.sendKeys(addressAlias);
    }

    public void clickRegistration() {
        LOGGER.info("clicked on registration.." + registration);
        this.registration.click();
    }
}
