package Inheritance.Exercise.animals;

public class Dog extends Animal {

    private final static String DOG_BARKING = "Woof!";

    public Dog(String name, int age, String gender){
        super(name,age,gender);
    }

    @Override
    public  String produceSound() {
        return DOG_BARKING;
    }
}
