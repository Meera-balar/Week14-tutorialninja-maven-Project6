package com.tutorialsninja.pages;

import com.tutorialsninja.utlility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends Utility {
    //******************************Desktop**********************//
    //2.5 Verify the Text "HP LP3065"
    By productTextHPLP3065 = By.xpath("//a[contains(text(),'HP LP3065')]");

    public String getProductHPLP3065(){
        return getTextFromElement(productTextHPLP3065);
    }
    //2.6 Select Delivery Date "2022-11-30"
    By calenderButton = By.xpath("//div[@class = 'input-group date']//button");
    By monthYearText = By.xpath("//div[@class='datepicker-days']//table//th[@class='picker-switch']");

    By nextButtonOfCalender = By.xpath("//div[@class='datepicker']/div[1]//table//th[normalize-space()='›']");
    By dayText = By.xpath("//div[@class='datepicker']//table//td");

    public void selectDate(String year,String month, String date) {
        clickOnElement(calenderButton);
        while (true) {
            String monthAndYear = driver.findElement(monthYearText).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButtonOfCalender);
            }
        }
        List<WebElement> allDates = driver.findElements(dayText);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }

    }
    //2.7.Enter Qty "1” using Select class.
    By quantityField = By.xpath("//input[@id='input-quantity']");
    public void addQuantityForProduct(String text){
        clearElement(quantityField);
        sendTextToElement(quantityField,text);
    }
    //2.8 Click on “Add to Cart” button
    By addToCartButton = By.xpath("//button[@id='button-cart']");
    public void clickOnAddToCartButton(){
        try{
            Thread.sleep(500);
            clickOnElement(addToCartButton);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
    By getSuccessText = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    public String getSuccessText(){
        return getTextFromElement(getSuccessText);

    }
    //2.10 Click on link “shopping cart” display into success message
    By shoppingCartButton = By.xpath("//a[contains(text(),'shopping cart')]");
    public void clickOnShoppingCartButton(){
        try{
            Thread.sleep(500);
            clickOnElement(shoppingCartButton);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    //****************************************Laptop***********************//
   //Verify text MacBook
    By macBookText = By.xpath("//h1[contains(text(),'MacBook')]");
    public String getProductMacBookText(){
        return getTextFromElement(macBookText);
    }
}
