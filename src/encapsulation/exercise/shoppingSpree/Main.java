package encapsulation.exercise.shoppingSpree;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] persons = scanner.nextLine().split(";");

        LinkedHashMap<String,Person> personLinkedList = new LinkedHashMap<>();
       LinkedHashMap<String, Product> existingProducts = new LinkedHashMap<>();

        for (String person : persons) {

            String[] personData = person.split("=");

            try {
                personLinkedList.put(personData[0],
                        new Person(personData[0], Double.parseDouble(personData[1])));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String [] products = scanner.nextLine().split(";");

        for (String s : products) {
            String[] productData = s.split("=");
            try {
                existingProducts.put(productData[0],
                        new Product(productData[0], Double.parseDouble(productData[1])));
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        String command;

        while(!"END".equalsIgnoreCase(command = scanner.nextLine())){
            String [] order = command.split("\\s+");
            String name = order[0];
            String wantedProduct = order[1];

            if(personLinkedList.containsKey(name)){
                try {
                    personLinkedList.get(name).buyProduct(existingProducts.get(wantedProduct));
                } catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
        }

        personLinkedList.forEach((k,v) ->{
            System.out.println(v.toString());
        } );
    }
}
