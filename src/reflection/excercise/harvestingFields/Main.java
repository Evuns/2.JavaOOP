package reflection.excercise.harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Class land = RichSoilLand.class;

        Field[] allFields = land.getDeclaredFields();
        String modifierToPrint = bf.readLine();

        while (!modifierToPrint.equals("HARVEST")) {
            switch (modifierToPrint) {
                case "private":
                    Arrays.stream(allFields).filter(field ->
                            Modifier.isPrivate(field.getModifiers()))
                            .forEach(f -> System.out.println(String.format(
                                    "private %s %s",
                                    f.getType().getSimpleName(), f.getName())
                            ));
                    break;
                case "protected":
                    Arrays.stream(allFields).filter(field ->
                            Modifier.isProtected(field.getModifiers()))
                            .forEach(f -> System.out.println(String.format(
                                    "protected %s %s",
                                    f.getType().getSimpleName(), f.getName()
                            )));
                    break;
                case "public":
                    Arrays.stream(allFields).filter(field ->
                            Modifier.isPublic(field.getModifiers()))
                            .forEach(f -> System.out.println(String.format(
                                    "public %s %s",
                                    f.getType().getSimpleName(), f.getName())
                            ));
                    break;
                default:
                    Arrays.stream(allFields).forEach(f ->
                            System.out.println(String.format(
                                    "%s %s %s", Modifier.toString(f.getModifiers()),
                                    f.getType().getSimpleName(), f.getName())
                            ));
            }

            modifierToPrint = bf.readLine();
        }

    }
}
