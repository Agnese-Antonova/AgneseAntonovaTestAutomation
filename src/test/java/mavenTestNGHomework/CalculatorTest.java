package mavenTestNGHomework;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CalculatorTest {

    private Calculator calculatorTest;

    @BeforeClass
    public void beforeClass() {
        this.calculatorTest = new Calculator();
    }
    @BeforeMethod
    public void izvaditUzEkrana() {
        System.out.println("Tests ir sācies!");
    }

    @Test
    public void testAddition(){
        Assert.assertEquals(calculatorTest.add(3,0),3);
        Assert.assertEquals(calculatorTest.add(-3,-5),8);
    }

    @Test
    public void testSubstract(){
        Assert.assertEquals(calculatorTest.substract(3,0),3);
        Assert.assertEquals(calculatorTest.substract(-3,-5),8);
    }

    @Test
    public void testMultiply(){
        Assert.assertEquals(calculatorTest.multiply(3,0),3);
        Assert.assertEquals(calculatorTest.multiply(-3,-5),8);
    }

    @Test
    public void testDivide(){
        Assert.assertEquals(calculatorTest.divide(8,2),4);
        Assert.assertEquals(calculatorTest.divide(10,2),5);
    }

}







