package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class LaptopAndNotebookPageTest extends BaseTest {
    LaptopAndNotebookPage laptopAndNotebookPage = new LaptopAndNotebookPage();
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder(){
        homePage.navigateToLaptopAndNotebooksPage();
        homePage.clickOnShowAllLaptopAndNoteBook();
        laptopAndNotebookPage.clickOnSortByPosition();
        List<Double> expected = laptopAndNotebookPage.priceHighToLow();
        System.out.println("Expected List : " + expected);
        List<Double> actual = laptopAndNotebookPage.getPriceHighToLow("Price (High > Low)");
        System.out.println("Actual List : " + actual);
        //Assert.assertEquals(Collections.singleton(actual),Collections.singleton(expected),"Product not sorted by price High to Low");
        Assert.assertEquals(actual,expected,"Product not sorted by price High to Low");
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws  InterruptedException {
        homePage.navigateToLaptopAndNotebooksPage();
        homePage.clickOnShowAllLaptopAndNoteBook();
        homePage.clickOnCurrency("£ Pound Sterling");
        laptopAndNotebookPage.selectProductSortedPriceHighToLow("Price (High > Low)");
        laptopAndNotebookPage.clickOnProductMacBook();
        Assert.assertEquals(productPage.getProductMacBookText(),"MacBook","MacBook Product not display");
        productPage.clickOnAddToCartButton();
        Assert.assertEquals(productPage.getSuccessText(),"Success: You have added MacBook to your shopping cart!" + "\n×","Product not added to cart");
        productPage.clickOnShoppingCartButton();
        Assert.assertTrue(shoppingCartPage.getShoppingCartText().contains("Shopping Cart"),"Shopping cart page not opened");
        Assert.assertEquals(shoppingCartPage.getProductText(),"MacBook","Product name not matched");
        shoppingCartPage.changeQuantityForProduct("2");
        shoppingCartPage.clickOnUpdateQuantity();
        Assert.assertTrue(shoppingCartPage.getUpdateSuccessfullyText().contains("Success: You have modified your shopping cart!"),"Cart not modified");
        Assert.assertEquals(shoppingCartPage.getTotalPrice(),"£737.45","Total not matched");
        shoppingCartPage.clickOnCheckoutButton();
        Thread.sleep(1000);
        Assert.assertEquals(checkoutPage.getCheckoutText(),"Checkout","Not Navigate to checkout page");
        Thread.sleep(1000);
        Assert.assertEquals(checkoutPage.getNewCustomerText(),"New Customer","New Customer Text not found");
        checkoutPage.clickOnGuestCheckOutRadioButton();
        checkoutPage.clickOnContinueButton();
        checkoutPage.enterFirstName("Mahi"+getAlphaNumericString(3));
        checkoutPage.enterLastName("Patel"+getAlphaNumericString(2));
        checkoutPage.enterEmailId("mahi"+getAlphaNumericString(3)+"@gmail.com");
        checkoutPage.enterTelephone("07878963869");
        checkoutPage.enterAddressLine1("20,Birmingham road");
        checkoutPage.enterCity("Birmingham");
        checkoutPage.enterPostCode("CV0 10Ol");
        checkoutPage.selectCountry("India");
        checkoutPage.selectRegion("Gujarat");
        checkoutPage.clickOnContinue();
        checkoutPage.addCommentsToTextArea("Happy Christmas!");
        checkoutPage.checkTermsAndConditionCheckBox();
        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.getWarningMessage(),"Warning: Payment method required!" + "\n×","Warning message not displayed");
    }
}
