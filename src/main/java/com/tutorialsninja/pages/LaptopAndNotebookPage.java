package com.tutorialsninja.pages;

import com.tutorialsninja.utlility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopAndNotebookPage extends Utility {
    //2.3 Verify the text ‘Laptops & Notebooks’
    By laptopAndNotebookText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    public String getLaptopAndNotebookText(){
        return getTextFromElement(laptopAndNotebookText);
    }
    By clickOnSortBy = By.id("input-sort");
    public void clickOnSortByPosition() {
        clickOnElement(clickOnSortBy);
    }
    //1.3 Select Price(High>Low) option from drop down
    public void selectProductSortedPriceHighToLow(String text) {
        selectByVisibleTextFromDropDown(clickOnSortBy, text);
    }
    // verify Product sorted  price High to low
    By productPriceList = By.xpath("//p[@class ='price']");
    public List<Double> priceHighToLow() {
        // Get all the products price and stored into array list
        List<WebElement> products = driver.findElements(productPriceList);
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        return originalProductsPrice;
    }
    public List<Double> getPriceHighToLow(String text){
        // Get all the products price and stored into array list
        List<WebElement> products = driver.findElements(productPriceList);
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(clickOnSortBy, text);
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(productPriceList);
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }

        return afterSortByPrice;
    }

    //2.4Select product MacBook
    By productMacBook = By.linkText("MacBook");
    public void clickOnProductMacBook() {
        clickOnElement(productMacBook);
    }
}
