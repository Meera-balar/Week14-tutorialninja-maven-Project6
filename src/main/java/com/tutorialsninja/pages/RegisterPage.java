package com.tutorialsninja.pages;

import com.tutorialsninja.utlility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends Utility {
    //1.3 Verify the text “Register Account”.
    By registerText = By.xpath("//h1[contains(text(),'Register Account')]");
    public String getRegisterText(){
        return getTextFromElement(registerText);
    }

    //3.3 Enter Firstname
    By firstNameField = By.id("input-firstname");
    public void enterFirstName(String firstName){
        sendTextToElement(firstNameField,firstName);
    }
    //3.4 Enter Lastname
    By lastNameField = By.id("input-lastname");
    public void enterLastName(String lastName){
        sendTextToElement(lastNameField,lastName);
    }
    //3.5 Enter Email
    By emailField = By.id("input-email");
    public void enterEmail(String email){
        sendTextToElement(emailField,email);
    }
    //3.6 Enter Telephone
    By telephoneField = By.id("input-telephone");
    public void enterTelephone(String telephone){
        sendTextToElement(telephoneField,telephone);
    }
    //3.7 Enter Password
    By passwordField = By.id("input-password");
    public void enterPassword(String password){
        sendTextToElement(passwordField,password);
    }
    //3.8 Enter ConfirmPassword
    By confirmPasswordField = By.id("input-confirm");
    public void enterConfirmPassword(String confirmPassword){
        sendTextToElement(confirmPasswordField,confirmPassword);
    }
    //3.9 Select Subscribe Yes radio button
    By subscribeButton = By.xpath("//fieldset[3]//input");
    public void clickOnSubscribeRadioButton(String text){
        List<WebElement> radioButtons = driver.findElements(subscribeButton);
        for (WebElement e : radioButtons) {
            if (e.getText().equals(text)) {
                e.click();
                break;
            }
        }
    }
    //3.10 Click on Privacy Policy check box
    By privacyPolicyCheckBox = By.xpath("//input[@name='agree']");
    public void clickOnPrivacyPolicyCheckBox(){
        clickOnElement(privacyPolicyCheckBox);
    }
    //3.11 Click on Continue button
    By continueButton = By.xpath("//input[@type='submit']");
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
    //3.12 Verify the message “Your Account Has Been Created!”
    By accountCreatedMessage = By.xpath("//h1[text()='Your Account Has Been Created!']");
    public String getAccountCreatedMessage(){
        return getTextFromElement(accountCreatedMessage);
    }
    //3.13 Click on Continue button
    By continueButton1 = By.xpath("//a[text()='Continue']");
    public void clickOnContinue(){
        clickOnElement(continueButton1);
    }




}
