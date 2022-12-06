package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LogoutPage;
import com.tutorialsninja.pages.RegisterPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    LogoutPage logoutPage = new LogoutPage();


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        homePage.clickOnMyAccountLinkAndSelectOption("Register");
        Assert.assertEquals(registerPage.getRegisterText(),"Register Account","Register page not displayed");
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        homePage.clickOnMyAccountLinkAndSelectOption("Register");
        registerPage.enterFirstName("Manisha"+getAlphaNumericString(3));
        registerPage.enterLastName("Mavani"+getAlphaNumericString(3));
        registerPage.enterEmail("prime" + getAlphaNumericString(4) + "@gmail.com");
        registerPage.enterTelephone("07645879809");
        registerPage.enterPassword("test123");
        registerPage.enterConfirmPassword("test123");
        registerPage.clickOnSubscribeRadioButton("Yes");
        registerPage.clickOnPrivacyPolicyCheckBox();
        registerPage.clickOnContinueButton();
        Assert.assertEquals(registerPage.getAccountCreatedMessage(),"Your Account Has Been Created!","Account not created successfully");
        registerPage.clickOnContinue();
        homePage.clickOnMyAccountLinkAndSelectOption("Logout");
        Assert.assertEquals(logoutPage.getAccountLogoutText(),"Account Logout","Not logged out");
        logoutPage.clickOnContinueButton();


    }
}
