package encapsulation.exercise.shoppingSpree;

public class Product {

    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else {
            this.cost = cost;
        }
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }
}
