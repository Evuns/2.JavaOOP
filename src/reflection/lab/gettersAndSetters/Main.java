package reflection.lab.gettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class reflection = Reflection.class;
        Method[] methods = reflection.getDeclaredMethods();
        Method[] getters = methodsSeparation("get", methods);
        Method[] setters = methodsSeparation("set", methods);

        Arrays.stream(getters).forEach(get ->
                System.out.println(String.format("%s will return class %s",
                        get.getName(), get.getReturnType().getName())));

        Arrays.stream(setters).forEach(set ->
                System.out.println(String.format("%s and will set field of class %s",
                        set.getName(), set.getParameterTypes()[0].getName())));
    }

    private static Method[] methodsSeparation(String beginsWith, Method[] allMethods) {
        return Arrays.stream(allMethods).filter(method -> method.getName()
                .startsWith(beginsWith))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
    }
}
