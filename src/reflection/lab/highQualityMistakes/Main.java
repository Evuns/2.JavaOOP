package reflection.lab.highQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class reflection = Reflection.class;
        Method[] allMethods = reflection.getDeclaredMethods();

        Arrays.stream(reflection.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.println(
                        String.format("%s must be private!", field.getName())));

        Method[] getters = filterMethods(allMethods, "get");
        Method[] setters = filterMethods(allMethods, "set");

        Arrays.stream(getters).filter(g -> !Modifier.isPublic(g.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(getter -> System.out.println(String.format(
                        "%s have to be public!",getter.getName()
                )));
        Arrays.stream(setters).filter(s -> !Modifier.isPrivate(s.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(setter -> System.out.println(String.format(
                        "%s have to be private!",setter.getName()
                )));
    }

    private static Method[] filterMethods(Method[] allMethods, String beginsWith) {
        return Arrays.stream(allMethods).filter(m -> m.getName().startsWith(beginsWith))
                .toArray(Method[]::new);
    }
}