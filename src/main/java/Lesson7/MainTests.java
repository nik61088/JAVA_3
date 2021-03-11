package Lesson7;

import Practice.Lesson7.hib.Column;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainTests<T> {

    static void start(Class<?> a) throws InvocationTargetException, IllegalAccessException {
        List<Method> methods = new ArrayList<>();
        Method[] declaredMethods =a.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(BeforeSuite.class)) {
                if (methods.size() > 0 && methods.get(0).isAnnotationPresent(BeforeSuite.class)) {
                    throw new RuntimeException();
                }
                methods.add(0, declaredMethod);
            }
            if (declaredMethod.isAnnotationPresent(Test.class)) {
                methods.add(declaredMethod);
            }
            if (declaredMethod.isAnnotationPresent(AfterSuite.class)) {
                if (methods.size() > 0 && methods.get(methods.size() - 1).isAnnotationPresent(AfterSuite.class)) {
                    throw new RuntimeException();
                }
                methods.add(declaredMethod);
            }
        }
        methods.sort(Comparator.comparingInt((Method m) -> m.getAnnotation(Test.class).priority()).reversed());
        for (Method method:declaredMethods){
            method.invoke(null);
        }

    }

}
