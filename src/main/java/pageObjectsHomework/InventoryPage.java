package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
    public WebDriver chromedriver;

    public InventoryPage(WebDriver driver) {

        this.chromedriver = driver;
    }

    private By pageTitle = By.cssSelector("span[class='title']");
    private By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    private By shoppingCart = By.className("shopping_cart_link");

    public void addToCart (){
        getAddToCart().click();
    }
    public void shoppingCart (){
        getShoppingCart().click();
    }

    public WebElement getPageTitle(){
        return chromedriver.findElement(pageTitle);
    }

  public WebElement getAddToCart(){
        return chromedriver.findElement(addToCart);
  }

    public WebElement getShoppingCart(){
        return chromedriver.findElement(shoppingCart);
    }
}
