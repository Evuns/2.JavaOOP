package polymorphism.lab.animal;

public class Dog extends Animal {

private static final String DJAAF = "DJAAF";

    protected Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        String explain = String.format(baseExplain() + System.lineSeparator()
                + DJAAF);
        return explain;
    }
}
