package Inheritance.Exercise.animals;

public class Cat extends Animal {

    private final static String CAT_MEOWING = "Meow meow";

    public Cat(String name, int age, String gender){
        super(name,age,gender);
    }

    @Override
    public  String produceSound() {
        return CAT_MEOWING;
    }
}
