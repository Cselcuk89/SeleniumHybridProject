package com.selcuk.pageObjects;

import com.selcuk.helpers.logger.LoggerHelper;
import com.selcuk.helpers.wait.WaitHelper;
import com.selcuk.testBase.Config;
import com.selcuk.testBase.TestBase;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    private final Logger LOGGER = LoggerHelper.getLogger(HomePage.class);
    WaitHelper waitHelper;

    @FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/a")
    public WebElement womenMenu;

    @FindBy(xpath="//*[@id='block_top_menu']/ul/li[2]/a")
    public WebElement dressesMenu;


    @FindBy(xpath="//*[@id='block_top_menu']/ul/li[3]/a")
    public WebElement tshirtsMenu;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        waitHelper = new WaitHelper(driver);
        TestBase testBase = new TestBase();
        waitHelper.waitForElement(driver,womenMenu,new Config(TestBase.PROPERTIES).getExplicitWait());
    }
    public void mouseOver(String data){
        LOGGER.info("performing mouse over to --->" + data);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'"+ data +"')]"))).build().perform();
    }
    public ProductCategoryPage clickOnIntem(String data){
        LOGGER.info("clickin on :" + data);
        driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]")).click();
        return new ProductCategoryPage(driver);
    }

    public ProductCategoryPage clickOnMenu(WebElement element){
        LOGGER.info("clickin on : " + element.getText());
        element.click();
        return new ProductCategoryPage(driver);
    }

}
