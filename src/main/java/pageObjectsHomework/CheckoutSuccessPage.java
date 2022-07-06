package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {
    public WebDriver chromedriver;

    public CheckoutSuccessPage(WebDriver driver) {

        this.chromedriver = driver;
    }

    private By checkoutCompleteText = By.cssSelector("span[class='title']");
    private By backHomeButton = By.id("back-to-products");


    public void backHomeButton (){
        getBackHomeButton().click();
    }

    public WebElement getCheckoutCompleteText(){

        return chromedriver.findElement(checkoutCompleteText);
    }

    public WebElement getBackHomeButton(){

        return chromedriver.findElement(backHomeButton);
    }
}
