package com.csg.core.pages;

import com.csg.utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * User: Grobov
 * Date: 12/07/12
 * Time: 3:31 PM
 */
public class SiteHomeBeforeLoginPage extends Page {
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    private WebElement linkLogIn;

    public SiteHomeBeforeLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedOut() {
        return isElementVisibleOnPage(linkLogIn);
    }

    public SiteLoginPage logIn() {
        linkLogIn.click();
        return PageFactory.initElements(driver, SiteLoginPage.class);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("SiteLogin.url")+"/wiki/Main_Page");
    }
}
