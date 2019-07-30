package polymorphism.exercise.vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = bf.readLine().split("\\s+");
        String[] truckInfo = bf.readLine().split("\\s+");

        Vehicles car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        Vehicles truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int numberOfCommands = Integer.parseInt(bf.readLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = bf.readLine().split("\\s+");
            double distanceOrLiters = Double.parseDouble(command[2]);
            switch (command[0]) {
                case "Drive":
                    switch (command[1]) {
                        case "polymorphism.exercise.vehicles.Car":
                            System.out.println(car.driving(distanceOrLiters, "polymorphism.exercise.vehicles.Car"));
                            break;
                        case "polymorphism.exercise.vehicles.Truck":
                            System.out.println(truck.driving(distanceOrLiters, "polymorphism.exercise.vehicles.Truck"));
                            break;
                    }
                    break;
                case "Refuel":
                    switch (command[1]) {
                        case "polymorphism.exercise.vehicles.Car":
                            car.refuel(distanceOrLiters);
                            break;
                        case "polymorphism.exercise.vehicles.Truck":
                            truck.refuel(distanceOrLiters);
                            break;
                    }
            }
        }

        System.out.printf("polymorphism.exercise.vehicles.Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("polymorphism.exercise.vehicles.Truck: %.2f", truck.getFuelQuantity());
    }
}
