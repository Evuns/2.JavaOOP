package encapsulation.exercise.pizzaCalorie;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;


    public Pizza(String name, int numberOfToppings){
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    private void setName(String name){
        if(name.trim().isEmpty() || name.length() > 15){
            throw new IllegalArgumentException("encapsulation.exercise.pizzaCalorie.Pizza name should be between 1 and 15 symbols.");
        } else{
            this.name = name;
        }
    }

    private void setToppings(int numberOfToppings){
        if(numberOfToppings < 0 || numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public void setDough(Dough dough){
        this.dough = dough;
    }

    public String getName(){
        return this.name;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    public double getOverallCalories(){
        double toppingCalories = 0;
        for (Topping topping:toppings) {
           toppingCalories += topping.calculateCalories();
        }
        return this.dough.calculateCalories() + toppingCalories;
    }
}
