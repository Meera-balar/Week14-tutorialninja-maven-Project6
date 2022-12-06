package com.tutorialsninja.pages;

import com.tutorialsninja.utlility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {

    //2.3 Verify the text “Returning Customer”.
    By returningCustomerText = By.xpath("//h2[contains(text(),'Returning Customer')]");
    public String getReturningCustomerTextFromLoginPage(){
        return getTextFromElement(returningCustomerText);
    }
    //4.3 Enter Email address
    By emailField = By.id("input-email");
    public void enterEmail(String email){
        sendTextToElement(emailField,email);

    }
    //4.5 Enter Password
    By passwordField = By.id("input-password");
    public void enterPassword(String password){
        sendTextToElement(passwordField,password);
    }
    //4.6 Click on Login button
    By clickOnLogin = By.xpath("//input[@value='Login']");
    public  void clickOnLoginButton(){
        clickOnElement(clickOnLogin);
    }
    //4.7 Verify text “My Account”
    By myAccountText = By.xpath("//h2[text()='My Account']");
    public String getMyAccountText(){
        return getTextFromElement(myAccountText);
    }



}
