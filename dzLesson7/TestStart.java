package dzLesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class TestStart {

    public static void start (Class cl) throws InvocationTargetException, IllegalAccessException {
        Method beforeMethod = null;
        Method afterMethod = null;
        ArrayList<Method> testMethods = new ArrayList<>();

        Object obj = null;
        try {
            obj = cl.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        for (Method m : cl.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                testMethods.add(m);
            } else if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMethod == null) {
                    beforeMethod = m;
                } else {
                    throw new RuntimeException("Не более одного метода @BeforeSuite");
                }
            } if (m.isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod == null) {
                    afterMethod = m;
                } else {
                    throw new RuntimeException("Не более одного метода @AfterSuite");
                }
            }
        }

        if (beforeMethod != null) {
            beforeMethod.invoke(obj);
        }

        testMethods.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority()));
        for (Method m : testMethods) {
            m.invoke(obj);
        }

        if (afterMethod != null) {
            afterMethod.invoke(obj);
        }
    }

}