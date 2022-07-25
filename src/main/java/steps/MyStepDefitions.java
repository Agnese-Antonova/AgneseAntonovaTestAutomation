package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MyStepDefitions {
    private int appleCount;
    private int eatAppleCount;
    @Given("I have {int} apples")
    public void i_have_apples(int a) {
        System.out.println("I have" + a + "apples");
        appleCount = a;
    }
    @When("I eat {int} apples")
    public void i_eat_apples(int b) {
        System.out.println("I eat" + b + "aplles");
        eatAppleCount = b;

    }
    @Then("I have {int} apples left")
    public void i_have_apples_left(int c) {
        System.out.println("I have" + c + "apples left");
        int applesLeft = appleCount - eatAppleCount;
        Assert.assertEquals(applesLeft,c);

    }
}
