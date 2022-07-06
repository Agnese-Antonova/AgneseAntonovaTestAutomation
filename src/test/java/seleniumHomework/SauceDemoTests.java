package seleniumHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjectsHomework.*;

import java.time.Duration;

public class SauceDemoTests {
    WebDriver chromedriver;


   private final String SAUCEDEMO_URL = "https://www.saucedemo.com/";

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        //atveram browseri
        chromedriver = new ChromeDriver();
        chromedriver.manage().window().maximize(); //maximizē windows logu
    }

    @Test
    public void testFirstScenario() throws InterruptedException {
        //2. Ielogoties ar pareizu lietotāja vārdu/paroli
        chromedriver.get(SAUCEDEMO_URL);
        LoginPage loginPage = new LoginPage(chromedriver);
        loginPage.login("standard_user","secret_sauce");
        //3. Pārbaudīt, ka lietotājs ir ielogojies
        InventoryPage inventoryPage = new InventoryPage(chromedriver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(),"PRODUCTS");
        //4. Ievietot Grozā 1 produktu I
        inventoryPage.addToCart();
        // 5.Doties uz grozu
        inventoryPage.shoppingCart();
        //6. Pārbaudīt, kā šī prece ir grozā
        CartPage cartPage = new CartPage(chromedriver);
        String actualItemName = cartPage.getItemName().getText();
        String expectedItemName = "Sauce Labs Backpack";
        Assert.assertEquals(actualItemName,expectedItemName);
        //7. Doties uz Checkout CART PAGE
        cartPage.checkoutButton();
        //8. Ievadīt vārdu/uzvārdu/pasta indeksu
        CheckoutPage checkoutPage = new CheckoutPage(chromedriver);
        checkoutPage.insertFirstNameLastNamePostalCode("Agnese","Antonova", "LV-1058");
        //9. Doties uz Checkout overview lapu, pārbaudīt datus
        checkoutPage.goToCheckoutOverviewPage();
        Thread.sleep(1000);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(chromedriver);
        actualItemName = checkoutOverviewPage.getItemName().getText();
        expectedItemName = "Sauce Labs Backpack";
        Assert.assertEquals(actualItemName,expectedItemName);
        //10. Doties uz finish lapu un pārbaudīt vai viss bija veiksmīgi
        checkoutOverviewPage.finishButton();
        Thread.sleep(1000);
        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(chromedriver);
        String actualCheckoutCompleteText = checkoutSuccessPage.getCheckoutCompleteText().getText();
        String expectedCheckoutCompleteText = "CHECKOUT: COMPLETE!";
        Assert.assertEquals(actualCheckoutCompleteText,expectedCheckoutCompleteText);
        //11. Doties atpakaļ uz pirmo lapu ar pogu 'Back Home'
        checkoutSuccessPage.backHomeButton();
        Thread.sleep(2000);// 2 sek pagaida
    }

    @Test
    public void testSecondScenario() throws InterruptedException {
        //2. Ielogoties ar pareizu lietotāja vārdu/paroli
        chromedriver.get(SAUCEDEMO_URL);
        LoginPage loginPage = new LoginPage(chromedriver);
        loginPage.login("standard_user","secret_sauce");
        //3. Doties uz grozu
        InventoryPage inventoryPage = new InventoryPage(chromedriver);
        inventoryPage.shoppingCart();
        //4. Doties uz Checkout
        CartPage cartPage = new CartPage(chromedriver);
        cartPage.checkoutButton();
        //5. Pārbaudīt, ka FirstName/LastName/Zip code ir obligāts
        CheckoutPage checkoutPage = new CheckoutPage(chromedriver);
        checkoutPage.insertFirstNameLastNamePostalCode("","Antonova","LV-1058");
        checkoutPage.goToCheckoutOverviewPage();
        Assert.assertEquals(checkoutPage.getErrorMesage().getText(),"Error: First Name is required");
        checkoutPage.deleteInputField();
        Thread.sleep(2000);// 2 sek pagaida

        checkoutPage.insertFirstNameLastNamePostalCode("Agnese", "","LV-1058");
        Thread.sleep(2000);// 2 sek pagaida
        checkoutPage.goToCheckoutOverviewPage();
        Assert.assertEquals(checkoutPage.getErrorMesage().getText(),"Error: Last Name is required");
        checkoutPage.deleteInputField();
        Thread.sleep(2000);// 2 sek pagaida

        checkoutPage.insertFirstNameLastNamePostalCode("Agnese", "Antonova","");
        Thread.sleep(2000);// 2 sek pagaida
        checkoutPage.goToCheckoutOverviewPage();
        Assert.assertEquals(checkoutPage.getErrorMesage().getText(),"Error: Postal Code is required");
        Thread.sleep(2000);// 2 sek pagaida
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        //aizveram browseri
        chromedriver.close();
    }
}
