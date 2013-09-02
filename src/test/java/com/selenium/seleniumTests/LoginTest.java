package com.selenium.seleniumTests;


import com.csg.core.pages.SiteHomePage;
import com.csg.core.pages.SiteLoginPage;
import com.csg.utils.ConfigProperties;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.openqa.selenium.support.PageFactory;

public class LoginTest extends BasicTestCase{
    private SiteLoginPage siteLoginPage = PageFactory.initElements(getWebDriver(), SiteLoginPage.class);
    private SiteHomePage siteHomePage;

    @Test
    public void loginPositiveTest() {
        //логика теста
        siteLoginPage.open();
        siteHomePage = siteLoginPage.loginSuccess(ConfigProperties.getProperty("login"), ConfigProperties.getProperty("password"));
        assertTrue(siteHomePage.isLoggedIn());
        siteHomePage.logOut();
    }

    @Test
    public void loginNegativeTest() {
        //логика теста
        siteLoginPage.open();
        siteLoginPage = siteLoginPage.loginFail(ConfigProperties.getProperty("login"), "");
        assertTrue(siteLoginPage.isErrorLogin());
    }
}
