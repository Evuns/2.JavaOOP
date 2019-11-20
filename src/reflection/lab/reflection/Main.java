package reflection.lab.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class reflection = Reflection.class;

        System.out.println(reflection);
        Class superClass = reflection.getSuperclass();
        System.out.println(superClass);
        Arrays.stream(reflection.getInterfaces()).forEach(System.out::println);

        Object ref = reflection.getDeclaredConstructor().newInstance();
        System.out.println(ref);
    }
}