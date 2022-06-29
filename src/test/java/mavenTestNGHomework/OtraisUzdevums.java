package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OtraisUzdevums {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver(); //atvert parlukprogrammu
    }
    @Test
    public void verifyHomepageTitle(){
        driver.navigate().to ("https://discord.com/");
        driver.manage().window().maximize();
        String expectedTitle = "Discord | Ваше место для общения и отдыха";
        String actualTitle  = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void verifyHomepageTitleTwo(){
        driver.navigate().to ("https://github.com/");
        driver.manage().window().maximize();
        String expectedTitle = "GitHub: Where the world builds software · GitHub";
        String actualTitle  = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}

