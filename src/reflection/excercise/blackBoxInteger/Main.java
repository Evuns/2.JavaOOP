package reflection.excercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        BlackBoxInt box = null;
        Field innerValue = BlackBoxInt.class.getDeclaredField("innerValue");
        innerValue.setAccessible(true);
        try {
            Constructor constr = BlackBoxInt.class.getDeclaredConstructor();
            constr.setAccessible(true);
            box = (BlackBoxInt) constr.newInstance();

        } catch (NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }


        Method[] methods = BlackBoxInt.class.getDeclaredMethods();

        while (!command.equals("END")) {
            String[] inputs = command.split("_");
            String action = inputs[0];
            int number = Integer.parseInt(inputs[1]);

            Method method = Arrays.stream(methods).filter(f -> f.getName().equals(action))
                    .findFirst().orElse(null);
            method.setAccessible(true);
            try {
                method.invoke(box, number);
            } catch (IllegalAccessException
                    | InvocationTargetException e) {
                e.printStackTrace();
            }


            System.out.println(innerValue.getInt(box));


            command = scanner.nextLine();
        }

    }
}
