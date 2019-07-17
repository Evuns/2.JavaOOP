package encapsulation.exercise.pizzaCalorie;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equalsIgnoreCase("meat") ||
                toppingType.equalsIgnoreCase("veggies") ||
                toppingType.equalsIgnoreCase("cheese") ||
                toppingType.equalsIgnoreCase("sauce")) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
    }



    public double calculateCalories() {
        double baseCalorie = this.weight * 2;
        return baseCalorie * ToppingsModifiers.valueOf(this.toppingType).getModifier();
    }
}
