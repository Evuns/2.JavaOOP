package Inheritance.Exercise.animals;

public class Tomcat extends Cat {

    private final static String GENDER = "Male";
    private final static String TOMCAT_MEOW = "MEOW";

    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    public static String getGENDER() {
        return GENDER;
    }

    @Override
    public  String produceSound() {
        return TOMCAT_MEOW;
    }
}


