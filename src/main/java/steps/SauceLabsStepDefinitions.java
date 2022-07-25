package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LoginPage;
import pageObjectsHomework.*;

import java.time.Duration;


public class SauceLabsStepDefinitions {

    WebDriver chromedriver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutSuccessPage checkoutSuccessPage;

    @Before("@browser")
    public void setUp(){
        chromedriver = new ChromeDriver();
        chromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        chromedriver.manage().window().maximize();
        loginPage = new LoginPage(chromedriver);
        inventoryPage = new InventoryPage(chromedriver);
        cartPage = new CartPage(chromedriver);
        checkoutPage = new CheckoutPage(chromedriver);
        checkoutOverviewPage = new CheckoutOverviewPage(chromedriver);
        checkoutSuccessPage = new CheckoutSuccessPage(chromedriver);
    }
    @After("@browser")
    public void closeBrowser(){
        chromedriver.close();
    }

    @Given("user is navigated to {string}")
    public void user_is_navigated_to(String url) {
        chromedriver.get(url);
    }
    @Then("user sees page title {string}")
    public void user_sees_page_title(String pageTitle) {
        Assert.assertEquals(chromedriver.getTitle(),pageTitle);

    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.getUsernameField().sendKeys(username);
        loginPage.getPasswordField().sendKeys(password);
    }
    @And("user clicks login button")
    public void user_clicks_login_button() {
       loginPage.getLoginButton().click();
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");

    }

    @When("user added product to cart")
    public void userAddedProductToCart() {
        inventoryPage.getAddToCart().click();
    }

    @And("user clicks in the shopping cart")
    public void userClicksInTheShoppingCart() {
        inventoryPage.getShoppingCart().click();
    }

    @Then("user check if this product is in the Cart")
    public void userCheckIfThisProductIsInTheCart() {
        Assert.assertEquals(cartPage.getItemName().getText(),"Sauce Labs Backpack");
    }

    @Then("user clicks checkout button")
    public void userClicksCheckoutButton() {
        cartPage.checkoutButton();

    }

    @And("user enters name {string} and password {string}and postal code {string}")
    public void userEntersNameAgneseAndPasswordAntonovaAndPostalCodeLV(String firstName, String lastName, String postalCode) {
    checkoutPage.insertFirstNameLastNamePostalCode("Agnese", "Antonova", "LV-1058");
    }

    @When("user clicks continue button")
    public void user_clicks_continue_button() {
        checkoutPage.goToCheckoutOverviewPage();
    }

    @Then("user check the data")
    public void userCheckTheData() {
        Assert.assertEquals(checkoutOverviewPage.getItemName().getText(),"Sauce Labs Backpack");
    }

    @When("user clicks finish button")
    public void userClicksFinishButton() {
        checkoutOverviewPage.finishButton();
    }

    @And("user check is this on the finish page")
    public void userCheckIsThisOnTheFinishPage() {
        Assert.assertEquals(checkoutSuccessPage.getCheckoutCompleteText().getText(),"CHECKOUT: COMPLETE!");
    }
    @Then("user clicks Back Home button")
    public void userClicksBackHomeButton() {
        checkoutSuccessPage.backHomeButton();

    }

    @When("user enters {string} and {string} and {string}")
    public void userEntersNameAndPasswordAndPostalCode(String firstName,String lastName, String postalCode) {
        checkoutPage.getFirstNameField().sendKeys(firstName);
        checkoutPage.getLastNameField().sendKeys(lastName);
        checkoutPage.getPostalCodeField().sendKeys(postalCode);

    }

    @Then("user sees error message {string}")
    public void userSeesErrorMessageError_text(String errorMessage) {
        Assert.assertEquals(checkoutPage.getErrorMesage().getText(), errorMessage);
    }


    //@Then("user sees error message {string}")
   // public void userSeesErrorMessageErrorMessage(String errorMesage) {
    //    Assert.assertEquals(loginPage.getErrorMessageTextField().getText(), errorMesage);
   // }
}
