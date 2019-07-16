package encapsulation.exercise.animalFarm;

public class Chicken {

    private String name;
    private int age;


    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name.length() > 0 && !name.equals(" ")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setAge(int age) {
        if (age < 16 && age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    public double productPerDay() {
       return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double producePerDay;
        if (age < 6) {
            producePerDay = 2;
        } else if(age < 12){
            producePerDay = 1;
        } else{
            producePerDay = 0.75;
        }
        return producePerDay;
    }

    @Override
    public String toString() {
       return String.format("encapsulation.exercise.animalFarm.Chicken %s (age %d) can produce %.2f eggs per day.",
               this.name, this.age, productPerDay());
    }
}
