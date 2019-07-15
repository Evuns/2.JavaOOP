package Inheritance.Exercise.animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();

        while (!type.equalsIgnoreCase("Beast!")) {
            String[] data = scanner.nextLine().split("\\s+");
            if (data.length != 3) {
                System.out.println("Invalid input!");
            } else {

                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String gender = data[2];

                Animal animal = null;

                switch (type) {
                    case "Cat":
                        animal = new Cat(name, age, gender);
                        break;
                    case "Dog":
                        animal = new Dog(name, age, gender);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name, age);
                        break;
                    case "Kitten":
                        animal = new Kitten(name, age);
                        break;
                    case "Frog":
                        animal = new Frog(name, age, gender);
                }

                System.out.println(animal.toString());

            }
            type = scanner.nextLine();
        }

    }
}
