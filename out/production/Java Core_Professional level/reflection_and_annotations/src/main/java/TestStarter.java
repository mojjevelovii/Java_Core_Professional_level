import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class TestStarter {
    public static void start(Class c) throws Exception {
        Method[] methods = c.getDeclaredMethods();
        Comparator<Method> methodComparator;
        methodComparator = new Comparator<Method>() {
            int countBefore = 0;
            int countAfter = 0;

            @Override
            public int compare(Method o1, Method o2) {
                int p1 = getPriority(o1);
                int p2 = getPriority(o2);

                return p1 - p2;
            }

            private int getPriority(Method method) {
                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    if (countBefore > 0) {
                        throw new RuntimeException("@BeforeSuite должен присутствовать в одном экземпляре.");
                    }
                    countBefore++;
                    return BeforeSuite.priority;
                } else if (method.isAnnotationPresent(AfterSuite.class)) {
                    if (countAfter > 0) {
                        throw new RuntimeException("@AfterSuite должен присутствовать в одном экземпляре.");
                    }
                    countAfter++;
                    return AfterSuite.priority;
                } else if (method.isAnnotationPresent(Test.class)) {
                    int priority = method.getAnnotation(Test.class).priority();
                    if (priority < 1 || priority > 10) {
                        throw new RuntimeException("Приоритет должен находиться в пределах от 1 до 10.");
                    }
                    return priority;
                }
                throw new RuntimeException("Аннотация неизвестна.");
            }
        };
        Arrays.sort(methods, methodComparator);
        for (Method m : methods) {
            m.invoke(null);
        }

    }

    public static void main(String[] args) throws Exception {
        start(TestClass.class);

    }
}
