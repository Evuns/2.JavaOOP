package reflection.excercise.harvestingFields2;

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
            if("all".equals(modifierToPrint)){
                    Arrays.stream(allFields).forEach(f ->
                            System.out.println(String.format(
                                    "%s %s %s", Modifier.toString(f.getModifiers()),
                                    f.getType().getSimpleName(), f.getName())
                            ));
            } else{
                String finalModifierToPrint = modifierToPrint;
                Arrays.stream(allFields).filter(mod -> Modifier.toString(mod.getModifiers()).equals(finalModifierToPrint)).forEach(f ->
                        System.out.println(String.format(
                                "%s %s %s", Modifier.toString(f.getModifiers()),
                                f.getType().getSimpleName(), f.getName())
                        ));
            }

            modifierToPrint = bf.readLine();
        }

    }
}
