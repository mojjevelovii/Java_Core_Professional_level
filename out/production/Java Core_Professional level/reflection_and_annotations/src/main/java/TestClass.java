public class TestClass {

    @Test(priority = 2)
    public static void test1() {
        System.out.println("test1, priority 2");
    }

    @Test(priority = 10)
    public static void test2() {
        System.out.println("test2, priority 10");
    }

    @Test(priority = 8)
    public static void test3() {
        System.out.println("test3, priority 8");
    }

    @BeforeSuite()
    public static void beforeSuite() {
        System.out.println("BeforeSuite");
    }

    @AfterSuite()
    public static void afterSuite() {
        System.out.println("AfterSuite");
    }

}
