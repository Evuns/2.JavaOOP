package encapsulation.exercise.shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private final List<String> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public String getName() {
        return this.name;
    }

    public void buyProduct(Product product) {
        if (product.getCost() <= this.money) {
            this.products.add(product.getName());
            this.setMoney(this.money - product.getCost());
            System.out.printf("%s bought %s%n", this.getName(), product.getName());
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.getName(), product.getName()));
        }
    }

    @Override
    public String toString() {
        if (products.isEmpty()) {
            return String.format("%s - Nothing bought", this.name);
        }
        return String.format("%s - %s", this.name, products.toString().replaceAll("\\[|\\]", ""));

    }
}
