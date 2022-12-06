package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopAndNotebookPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    LaptopAndNotebookPage laptopAndNotebookPage = new LaptopAndNotebookPage();
    ComponentsPage componentsPage = new ComponentsPage();
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        homePage.navigateToDesktopPage();
        homePage.selectMenu("Show All Desktops");
        String expectedText = "Desktops";
        Assert.assertEquals(desktopPage.getDesktopText(),expectedText,"Not navigate to Desktop page");
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        homePage.navigateToLaptopAndNotebooksPage();
        homePage.selectMenu("Show All Laptops & Notebooks");
        String expectedText = "Laptops & Notebooks";
        Assert.assertEquals(laptopAndNotebookPage.getLaptopAndNotebookText(),expectedText,"Not navigate to Laptops and Notebooks page");
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.navigateToComponentsPage();
        homePage.selectMenu("Show All Components");
        String expectedText = "Components";
        Assert.assertEquals(componentsPage.getComponentText(),expectedText,"Not navigate to Laptops and Notebooks page");
    }

}
