package com.tutorialsninja.pages;

import com.google.common.base.Verify;
import com.tutorialsninja.utlility.Utility;
import org.openqa.selenium.By;

public class LogoutPage extends Utility {
    //3.16 Verify the text “Account Logout”
    By getLogoutText = By.xpath("//h1[text()='Account Logout']");

    public String getAccountLogoutText(){
        return getTextFromElement(getLogoutText);
    }
    //3.17 Click on Continue button
    By clickContinueButton = By.xpath("//a[contains(text(),'Continue')]");
    public void clickOnContinueButton(){
        clickOnElement(clickContinueButton);
    }
}
