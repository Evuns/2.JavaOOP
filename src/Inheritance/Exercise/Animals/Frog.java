package Inheritance.Exercise.animals;

public class Frog extends Animal {

    private final static String FROG_SOUND = "Ribbit";

    public Frog(String name, int age, String gender){
        super(name,age,gender);
    }

    @Override
    public  String produceSound() {
        return FROG_SOUND;
    }
}
