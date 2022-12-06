package com.tutorialsninja.pages;

import com.tutorialsninja.utlility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {
    //1.3 Verify the text ‘Desktops’
    By desktopText = By.xpath("//h2[contains(text(),'Desktops')]");
    public String getDesktopText() {
        return getTextFromElement(desktopText);
    }

    //1.2 Click on Show All Desktops link
    By clickOnSortBy = By.id("input-sort");
    public void clickOnSortByPosition() {
        clickOnElement(clickOnSortBy);
    }

    //1.4 Verify product sorted Z-A
    By productsList = By.xpath("//h4/a");
    public ArrayList<String> expectedList(String text) {
        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(productsList);
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        return originalProductsName;
    }

    public ArrayList<String> getSortedProductList(String text) {
        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(productsList);

        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        //Select sort by Name Z - A
        selectByVisibleTextFromDropDown(clickOnSortBy, text);
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(productsList);
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        return afterSortByZToAProductsName;
    }

    //1.3 Select option product sorted by name Z -A
    public void selectProductSortedNameAToZ(String text) {
        selectByVisibleTextFromDropDown(clickOnSortBy, text);
    }
    //2.4 click the Product HPLP3065
    By productTextHPLP3065 = By.xpath("//a[contains(text(),'HP LP3065')]");
    public void clickOnProductHPLP3065() {
        clickOnElement(productTextHPLP3065);
    }
}

