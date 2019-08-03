package polymorphism.lab.animal;

public class Cat extends Animal {

    private static final String MEEOW = "MEEOW";

    protected Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        String explain = String.format(baseExplain() + System.lineSeparator()
        + MEEOW);
        return explain;
    }
}
