package com.selcuk.pageObjects;

import com.selcuk.helpers.assertions.AssertionHelper;
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

import java.util.Iterator;
import java.util.List;

public class ShoppinCartSummaryPage {
    WebDriver driver;
    private final Logger LOGGER = LoggerHelper.getLogger(ShoppinCartSummaryPage.class);
    WaitHelper waitHelper;

    @FindBy(xpath="//*[@id='columns']/div[1]/span[2]")
    WebElement yourShoppingCart;

    @FindBy(xpath="//*[@id='columns']/div[1]/span[2]")
    List<WebElement> quantity_delete;

    @FindBy(xpath="//*[contains(text(),'Your shopping cart is empty')]")
    WebElement emptyShoppingCartMsg;

    public ShoppinCartSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(driver, yourShoppingCart,new Config(TestBase.PROPERTIES).getExplicitWait());
    }

    public boolean verifyProduct(String prod){
        LOGGER.info("selecting product.."+prod);
        WebElement product = driver.findElement(By.xpath("//*[contains(text(),'"+prod+"')]"));
        return AssertionHelper.verifyElementPresent(product);
    }

    public void delectProductFromShoppingCart() throws InterruptedException {
        // Delete all items from cart
        LOGGER.info("Deleting all products from cart..");
        List<WebElement> deletes = quantity_delete;
        Iterator<WebElement> itr = deletes.iterator();
        while (itr.hasNext()) {
            itr.next().click();
            Thread.sleep(2000);
        }
    }

    public boolean verifyEmptyShoppingCartMesssage(){
        try {
            LOGGER.info("verifying deleted Shopping Cart Messsage..");
            emptyShoppingCartMsg.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
