package classRoomSeven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

import java.time.Duration;
import java.util.List;

public class SwagLabsTest {
    WebDriver driver;
    WebDriverWait wait;

    public final String SAUCELABS_URL = "https://www.saucedemo.com/";
    private final String SWAGLABS_URL = "https://www.saucedemo.com/";
    private final String LOCAL_URL= "file://C:\\Users\\pc\\IdeaProjects\\AgneseAntonovaTestAutomation\\elements.html";

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        //atveram browseri
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //maximizē windows logu
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    //    @Test
//    public void testErrorMessage() throws InterruptedException {
//        //veiksim visas darbibas, lai notestetu error message
//        driver.get(SWAGLABS_URL);
//
//        WebElement userNameInputField =  driver.findElement(By.id("user-name"));
////        WebElement userNameInputField =  driver.findElement(By.cssSelector("input[id='user-name']"));
//        userNameInputField.sendKeys("standard_user");
//
//        //tagad uzrakstam paroles lauku un ievadam tur vertibu
//        WebElement passwordInputField = driver.findElement(By.name("password"));
//        passwordInputField.sendKeys("");
//
//        //atradisim Login pogu
//
//        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
//        loginButton.click();
//
//        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
//        String actualErrorMessage = errorMessage.getText();
//        String expectedErrorMessage = "Epic sadface: Password is required";
//
//        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
//
//        Thread.sleep(5000);
//        System.out.println("Izpildam testu");
//
//    }


    @Test
    public void testSuccessfullLogin() throws InterruptedException {
        //veiksim visas darbības, lai notestētu error message
        driver.get(SWAGLABS_URL);
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");

        //tagad uzrakstam paroles lauku un uevadam tur vertibu
        WebElement userPasswordInputField = driver.findElement(By.id("password"));
        userPasswordInputField.sendKeys("secret_sauce");

        //atradisim login pogu
        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
        loginButton.click();
        WebElement titleText = driver.findElement(By.cssSelector("span[class='title']"));
        Assert.assertEquals(titleText.getText(),"PRODUCTS");
        WebElement linkedInLink = driver.findElement(By.linkText("LinkedIn"));
        // WebElement linkedInLink = driver.findElement(By.cssSelector("li[class='social_linkedin'] > a"));
       // linkedInLink.click();
        Select sortDropDown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropDown.selectByValue("hilo");
        WebElement addFleeceJacketToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
        addFleeceJacketToCartButton.click();

        Thread.sleep(5000);// 5 sek pagaida

    }
    @Test
    public void testErrorMessageWithPOM(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login ("Agnese","");
        loginPage.getUsernameField().sendKeys("standard_user");
        loginPage.getPasswordField().sendKeys("");
        loginPage.getLoginButton().click();
        String actualText = loginPage.getErrorMessageTextField().getText();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualText,expectedErrorMessage);


    }
    @Test
    public void testSuccessLogin(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.getPageTitle().getText(),"PRODUCTS");
    }


    @Test
    public void testSamplePage() throws InterruptedException {
        driver.get(LOCAL_URL);
        WebElement vards = driver.findElement(By.id("fNameID"));
        vards.sendKeys("Agnese");

        WebElement uzvards = driver.findElement(By.id("lNameID"));
        uzvards.sendKeys("Antonova");

        WebElement informacija = driver.findElement(By.name("description"));
        informacija.clear();
        informacija.sendKeys("Šī ir info par mani");

        WebElement studentCheckBox = driver.findElement(By.id("studentID"));
        studentCheckBox.click();

        WebElement radioButtonJava = driver.findElement(By.id("javaID"));
        System.out.println(radioButtonJava.isSelected());
        radioButtonJava.click();
        System.out.println(radioButtonJava.isSelected());

        Select milakaKrasaDropdown = new Select(driver.findElement(By.id("colorsID")));
        milakaKrasaDropdown.selectByIndex(0);
        milakaKrasaDropdown.selectByIndex(1);

        List<WebElement> saraksts = milakaKrasaDropdown.getOptions();
        for (int i = 0; i < saraksts.size(); i++) {
            System.out.println(saraksts.get(i).getText());
        }


        Thread.sleep(5000);// 5 sek pagaida
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        //aizveram browseri
        driver.close();
    }
}
