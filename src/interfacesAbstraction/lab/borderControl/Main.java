package interfacesAbstraction.lab.borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String command;

        List<Identifiable> entersInCity = new ArrayList<>();


        while(!"End".equalsIgnoreCase(command = bf.readLine())){
            String [] data = command.split("\\s+");
            switch (data.length){
                case 2:
                    String model = data[0];
                    String id = data[1];
                    Identifiable robot = new Robot(model,id);
                    entersInCity.add(robot);
                    break;
                case 3:
                    String name = data[0];
                    int age = Integer.parseInt(data[1]);
                    id = data[2];
                    Identifiable citizen = new Citizen(name,age,id);
                    entersInCity.add(citizen);
                    break;
            }

        }
        List<Identifiable> detained = new ArrayList<>();

        String fakeId = bf.readLine();
        for (Identifiable intruder:entersInCity) {

            if(intruder.getId().endsWith(fakeId)){
                detained.add(intruder);
            }
        }

        for (Identifiable caught:detained) {
            System.out.println(caught.getId());
        }

    }
}
