package com.tutorialsninja.pages;

import com.tutorialsninja.utlility.Utility;
import org.openqa.selenium.By;

public class CheckoutPage extends Utility {
    //2.16 Verify the text “Checkout”
    By checkOutText = By.xpath("//div[@id='content']/h1");
    public String getCheckoutText(){
        return getTextFromElement(checkOutText);
    }
    //2.17 Verify the Text “New Customer”
    By newCustomerText = By.xpath("//h2[contains(text(),'New Customer')]");
    public String getNewCustomerText(){
        return getTextFromElement(newCustomerText);
    }
    //2.18 Click on “Guest Checkout” radio button
    By guestCheckOut = By.xpath("//input[@value='guest']");
    public void clickOnGuestCheckOutRadioButton(){
        clickOnElement(guestCheckOut);
    }
    //2.19 Click on “Continue” tab
    By continueButton = By.xpath("//input[@id='button-account']");
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
    //2.20******************************Fill All Mandatory Field***********************************************//
    By firstName = By.id("input-payment-firstname");
    public void enterFirstName(String name){
        sendTextToElement(firstName, name);
    }
    By lastName = By.id("input-payment-lastname");
    public void enterLastName(String name){
        sendTextToElement(lastName, name);
    }
    By emailField = By.id("input-payment-email");
    public void enterEmailId(String email){
        sendTextToElement(emailField, email);
    }
    By telephone = By.id("input-payment-telephone");
    public void enterTelephone(String phoneNumber){
        sendTextToElement(telephone, phoneNumber);
    }
    By address = By.id("input-payment-address-1");
    public void enterAddressLine1(String addressLine){
        sendTextToElement(address, addressLine);
    }
    By city = By.id("input-payment-city");
    public void enterCity(String cityName){
        sendTextToElement(city, cityName);
    }
    By postcode = By.id("input-payment-postcode");
    public void enterPostCode(String postCode){
        sendTextToElement(postcode, postCode);
    }
    By country = By.id("input-payment-country");
    public void selectCountry(String countryName){
        selectByVisibleTextFromDropDown(country,countryName);
    }
    By region = By.id("input-payment-zone");
    public void selectRegion(String regionName){
        selectByVisibleTextFromDropDown(region,regionName);
    }
    //2.21 Click on continue button
    By continueButton1 = By.id("button-guest");
    public void clickOnContinue(){
        clickOnElement(continueButton1);
    }
    //2.22 Add Comments About your order into text area
    By textArea = By.xpath("//textarea[@name='comment']");
    public void addCommentsToTextArea(String text){
        sendTextToElement(textArea,text);
    }
    //2.23 Check the Terms & Conditions check box
    By termsCondition = By.xpath("//input[@type='checkbox']");
    public void checkTermsAndConditionCheckBox(){
        clickOnElement(termsCondition);
    }
    //2.24 Click on “Continue” button
    By continueButton2 = By.xpath("//input[@id='button-payment-method']");
    public void clickContinue(){
        clickOnElement(continueButton2);
    }
    //2.25 Verify the message “Warning: Payment method required!”
    By warningMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
    public String getWarningMessage(){
        return getTextFromElement(warningMessage);
    }






}
