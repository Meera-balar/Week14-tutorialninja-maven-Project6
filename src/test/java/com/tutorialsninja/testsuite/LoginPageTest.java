package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.LogoutPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyAccountLinkAndSelectOption("Login");
        Assert.assertEquals(loginPage.getReturningCustomerTextFromLoginPage(), "Returning Customer", "Login page not displayed");
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        homePage.clickOnMyAccountLinkAndSelectOption("Login");
        loginPage.enterEmail("prime123@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getMyAccountText(),"My Account","Login not success");
       homePage.clickOnMyAccountLinkAndSelectOption("Logout");
        Assert.assertEquals(logoutPage.getAccountLogoutText(),"Account Logout","Not Log out");
        logoutPage.clickOnContinueButton();
    }
}
