package Inheritance.Exercise.animals;

public class Kitten extends Cat {

    private final static String GENDER = "Female";
    private final static String KITTEN_MEOW = "Meow";

    public Kitten(String name, int age){
        super(name,age,GENDER);
    }

    public static String getGENDER() {
        return GENDER;
    }

    @Override
    public  String produceSound() {
        return KITTEN_MEOW;
    }
}

