package com.tutorialsninja.pages;

import com.tutorialsninja.utlility.Utility;
import org.openqa.selenium.By;

public class ComponentsPage extends Utility {
    //3.3 Verify the text ‘Components’
    By componentText = By.xpath("//h2[contains(text(),'Components')]");

    public String getComponentText(){
        return getTextFromElement(componentText);
    }
}
