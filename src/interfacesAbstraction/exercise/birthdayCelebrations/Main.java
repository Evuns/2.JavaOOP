package interfacesAbstraction.exercise.birthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String command;
        List<Birthable> citizensPets = new ArrayList<>();

        while(!"end".equalsIgnoreCase(command = bf.readLine())){
            String [] data = command.split("\\s+");
            switch (data[0]){
                case "interfacesAbstraction.exercise.birthdayCelebrations.interfacesAbstraction.exercise.foodStorage.Citizen":
                    Birthable citizen = new Citizen(data[1], Integer.parseInt(data[2]), data[3],data[4]);
                    citizensPets.add(citizen);
                    break;
                case "interfacesAbstraction.exercise.birthdayCelebrations.Robot":
                    Identifiable robot = new Robot(data[2], data[1]);
                    break;
                case "interfacesAbstraction.exercise.birthdayCelebrations.Pet":
                    Birthable pet = new Pet(data[1],data[2]);
                    citizensPets.add(pet);
                    break;
            }
        }

        String year = bf.readLine();
        for (Birthable born:citizensPets) {
           if(born.getBirthDate().contains(year)){
               System.out.println(born.getBirthDate());
           }
        }
    }


}
