import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

/**
 * Created by leo on 15/8/31.
 */
public class TestNgSimpleTest {
    @Test
    public void testAdd() {
        String str = "TestNG is working fine";
        assertEquals("TestNG is working fine", str);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    @DataProvider
    public Object[][] addData() {
        return new Object[][] {
                {1,2,3},
                {1,0,1},
                {1,2,3},
                {4,2,6},
                {-1,2,1}
        };
    }

    @DataProvider
    public Object[][] minusData() {
        return new Object[][] {
                {3,7,-4},
                {7,7,0},
                {3,0,3},
                {13,7,6},
        };
    }

    @Test(groups = "add", dataProvider = "addData")
    public void testAdd(int a, int b, int c) {
        assertEquals(add(a,b), c);
    }

    @Test(groups = "minus", dataProvider = "minusData")
    public void testMinus(int a, int b, int c) {
        assertEquals(minus(a, b), c);
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is before class part!");
    }


    @AfterClass
    public void afterClass() {
        System.out.println("This is after class part!");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is before method part!");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is after method part!");
    }
}
