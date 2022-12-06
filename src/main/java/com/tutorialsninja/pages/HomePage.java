package com.tutorialsninja.pages;

import com.tutorialsninja.utlility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {




    By topMenuTabs = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");

    //This method will check whatever parameter is passed it click on it
    public void selectMenu(String menu){
        List<WebElement> topMenuList = driver.findElements(topMenuTabs);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(topMenuTabs);
        }
    }
    // 1.1 Mouse hover on “Desktops” Tab and click
    By desktopTab = By.linkText("Desktops");
    public void navigateToDesktopPage(){
        mouseHoverToElementAndClick(desktopTab);
    }
    //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
    By laptopAndNotebookTab = By.linkText("Laptops & Notebooks");
    public void navigateToLaptopAndNotebooksPage(){
        mouseHoverToElementAndClick(laptopAndNotebookTab);
    }
    // 3.1 Mouse hover on “Components” Tab and click
    By componentsTab = By.linkText("Components");
    public void navigateToComponentsPage(){
        mouseHoverToElementAndClick(componentsTab);
    }
    By showAllDesktopTab = By.linkText("Show All Desktops");
    public void clickOnShowAllDesktop(){
        clickOnElement(showAllDesktopTab);
    }
    By showAllLaptopAndNotebookTab = By.linkText("Show All Laptops & Notebooks");
    public void clickOnShowAllLaptopAndNoteBook(){
        clickOnElement(showAllLaptopAndNotebookTab);
    }
    //This method will select currency from drop down
    By currencyLink = By.xpath("//span[contains(text(),'Currency')]");
    By currencyList1 = By.xpath("//ul[@class = 'dropdown-menu']/li");
    public void clickOnCurrency(String text) {
        clickOnElement(currencyLink);
        List<WebElement> currencyList = driver.findElements(currencyList1);
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase(text)) {
                e.click();
                break;
            }
        }
    }

    By myAccountOptions = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li");
    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(myAccountOptions);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(myAccountOptions);
        }
    }
    //1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully
    //1.1 Click on My Account Link.
    By myAccountLink = By.xpath("//span[contains(text(),'My Account')]");
    public void clickOnMyAccountLinkAndSelectOption(String text){
        clickOnElement(myAccountLink);
        selectMyAccountOptions(text);
    }


}

