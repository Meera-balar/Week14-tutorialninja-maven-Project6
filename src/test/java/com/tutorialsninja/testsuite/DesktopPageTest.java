package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.ProductPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DesktopPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    ProductPage productPage= new ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        homePage.navigateToDesktopPage();
        homePage.clickOnShowAllDesktop();
        desktopPage.clickOnSortByPosition();
        List<String> expected = desktopPage.expectedList("Name (Z - A)");
        List<String> actual = desktopPage.getSortedProductList("Name (Z - A)");
        Assert.assertEquals(actual, expected, "Products not sorted as expected.");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        homePage.navigateToDesktopPage();
        homePage.clickOnShowAllDesktop();
        homePage.clickOnCurrency("£ Pound Sterling");
        desktopPage.selectProductSortedNameAToZ("Name (Z - A)");
        desktopPage.clickOnProductHPLP3065();
        Assert.assertEquals(productPage.getProductHPLP3065(), "HP LP3065", "HP LP3065 Product not display");
        productPage.selectDate("2022", "November", "30");
        productPage.addQuantityForProduct("1");
        productPage.clickOnAddToCartButton();
        Assert.assertEquals(productPage.getSuccessText(), "Success: You have added HP LP3065 to your shopping cart!" + "\n×", "Product not added to cart");
        productPage.clickOnShoppingCartButton();
        Assert.assertTrue(shoppingCartPage.getShoppingCartText().contains("Shopping Cart"), "Shopping cart page not opened");
        Assert.assertEquals(shoppingCartPage.getProductText(), "HP LP3065", "Product name not matched");
        Assert.assertTrue(shoppingCartPage.getDeliveryDateOfProduct().contains("2022-11-30"), "Delivery date not matched");
        Assert.assertEquals(shoppingCartPage.getProductModel(), "Product 21", "Model not matched");
        Assert.assertEquals(shoppingCartPage.getTotalPrice(), "£74.73", "Total not matched");
    }
}
