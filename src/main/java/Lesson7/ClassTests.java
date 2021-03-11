package Lesson7;

public class ClassTests{

    @Test(priority = 5)
    public void testMethod1(Class<?> a){
        System.out.println("testMethod 1 / priority 5 "+a.toString());
    }

    @Test(priority = 4)
    public void testMethod2(Class<?> a){
        System.out.println("testMethod 2 / priority 4 "+a.getName());
    }

    @Test(priority = 2)
    public void testMethod3(Class<?> a){
        System.out.println("testMethod 3 / priority 2 "+a.getTypeName());
    }

    @Test(priority = 6)
    public void testMethod4(Class<?> a){
        System.out.println("testMethod 4 / priority 6 "+a.getSimpleName());
    }
    @Test()
    public void testMethod5(Class<?> a){
        System.out.println("testMethod 5 / priority default "+a.toGenericString());
    }
    @Test(priority = 3)
    public void testMethod6(Class<?> a){
        System.out.println("testMethod 6 / priority 3 "+a.getCanonicalName());
    }
    @BeforeSuite
    public void beforeMethod(Class<?> a){
        System.out.println("beforeMethod "+a.getAnnotations());
    }
    @AfterSuite
    public void afterMethod(Class<?> a){
        System.out.println("AfterSuite "+a.getDeclaredMethods());
    }


}
