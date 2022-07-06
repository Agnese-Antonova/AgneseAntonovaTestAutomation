package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    public WebDriver chromedriver;

    public CheckoutPage(WebDriver driver) {

        this.chromedriver = driver;
    }
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");

    private By errorMessage = By.cssSelector("h3[data-test='error']");
   ;

    public void insertFirstNameLastNamePostalCode(String firstName,String lastName, String postalCode){
        getFirstNameField().sendKeys(firstName);
        getLastNameField().sendKeys(lastName);
        getPostalCodeField().sendKeys(postalCode);
    }

    public void deleteInputField(){
        getFirstNameField().sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        getLastNameField().sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        getPostalCodeField().sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
    }


    public void goToCheckoutOverviewPage (){
        getContinueButton().click();
    }

    public WebElement getFirstNameField(){

        return chromedriver.findElement(firstName);
    }
    public WebElement getLastNameField(){

        return chromedriver.findElement(lastName);
    }
    public WebElement getPostalCodeField(){

        return chromedriver.findElement(postalCode);
    }

    public WebElement getContinueButton() {

        return chromedriver.findElement(continueButton);
    }
    public WebElement getErrorMesage(){
        return chromedriver.findElement(errorMessage);
    }

}
