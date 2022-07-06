package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
    public WebDriver chromedriver;

    public CheckoutOverviewPage(WebDriver driver) {

        this.chromedriver = driver;
    }
    private By finishButton = By.id("finish");
    private By itemName = By.id("item_4_title_link");

    public void finishButton (){
        getFinishButton().click();
    }

    public WebElement getFinishButton(){
        return chromedriver.findElement(finishButton);
    }

    public WebElement getItemName(){
        return chromedriver.findElement(itemName);
    }

}
