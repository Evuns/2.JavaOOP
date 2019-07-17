package encapsulation.exercise.pizzaCalorie;

public enum DoughModifiers {

    White(1.5),
    Wholegrain(1),
    Crispy(0.9),
    Chewy(1.1),
    Homemade(1);

    private double modifier;

    DoughModifiers(double modifier ){
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }
}
