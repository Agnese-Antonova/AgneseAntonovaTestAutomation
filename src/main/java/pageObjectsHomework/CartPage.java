package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    public WebDriver chromedriver;

    public CartPage(WebDriver driver) {

        this.chromedriver = driver;
    }

    private By itemName = By.id("item_4_title_link");
    private By checkoutButton = By.id("checkout");


    public void checkoutButton (){
        getCheckoutButton().click();
    }

    public WebElement getItemName(){
        return chromedriver.findElement(itemName);
    }

    public WebElement getCheckoutButton(){
        return chromedriver.findElement(checkoutButton);
    }

}
