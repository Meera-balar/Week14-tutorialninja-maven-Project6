package com.tutorialsninja.pages;

import com.tutorialsninja.utlility.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {
    //2.11 Verify the text "Shopping Cart"
    By shoppingCartText = By.xpath("//div[@id='content']//h1");

    public String getShoppingCartText(){
        return getTextFromElement(shoppingCartText);
    }
    //2.12 Verify the Product name "HP LP3065"
    By productText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    public String getProductText(){
        return getTextFromElement(productText);
    }
    //2.13 Verify the Delivery Date "2022-11-30"
    By deliveryDate = By.xpath("//small[contains(text(),'Delivery Date: 2022-11-30')]");
    public String getDeliveryDateOfProduct(){
        return getTextFromElement(deliveryDate);
    }
    //2.14 Verify the Model "Product21"
    By productDesktopModel = By.xpath("//td[contains(text(),'Product 21')]");
    public String getProductModel(){
        return getTextFromElement(productDesktopModel);
    }
    //2.15 Verify the Todat "£74.73"
    By totalPrice = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");
    public String getTotalPrice(){
        return getTextFromElement(totalPrice);
    }

    //*************************************Laptop*******************************//
    //2.11 Change Quantity "2"
    By quantityField = By.xpath("//div[@class='input-group btn-block']/input");
    public void changeQuantityForProduct(String text){
        clearElement(quantityField);
        sendTextToElement(quantityField,text);
    }
    //2.12 Click on “Update” Tab
    By updateButton = By.xpath("//button[@type='submit']");
    public void clickOnUpdateQuantity(){
        clickOnElement(updateButton);
    }
    //2.13 Verify the message “Success: You have modified your shopping cart!”
    By updateSuccessText = By.xpath("//div[@id='checkout-cart']/div[1]");
    public String getUpdateSuccessfullyText(){
        return getTextFromElement(updateSuccessText);
    }
   // 2.15 Click on “Checkout” button
    By checkoutButton = By.xpath("//a[contains(text(),'Checkout')]");
    public void clickOnCheckoutButton(){
        clickOnElement(checkoutButton);
    }
}
