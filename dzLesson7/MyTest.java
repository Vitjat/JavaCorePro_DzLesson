package dzLesson7;

public class MyTest {

    @BeforeSuite
    public static void beforeSuite() {
        System.out.println("Before Suite");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("Test 1");
    }

    @Test(priority = 2)
    public void test2A() {
        System.out.println("Test 2a");
    }

    @Test(priority = 2)
    public void test2B() {
        System.out.println("Test 2b");
    }

    @Test(priority = 3)
    public void test3() {
        System.out.println("Test 3");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

}