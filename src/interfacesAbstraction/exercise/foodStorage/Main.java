package interfacesAbstraction.exercise.foodStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPeople = Integer.parseInt(bf.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] data = bf.readLine().split("\\s+");
            switch (data.length) {
                case 4:
                    Person citizen = new Citizen(data[0], Integer.parseInt(data[1]), data[2], data[3]);
                    people.add(citizen);
                    break;
                case 3:
                    Person rebel = new Rebel(data[0], Integer.parseInt(data[1]), data[2]);
                    people.add(rebel);
                    break;
            }
        }
        String buyerName;

        while (!"end".equalsIgnoreCase(buyerName = bf.readLine())) {
            for (Person buyer : people) {
                if (buyer.getName().equals(buyerName)) {
                    buyer.buyFood();

                }
            }
        }

        int amount = 0;

        for (Person buy : people) {
            amount += buy.getFood();
        }
        System.out.println(amount);
    }


}
