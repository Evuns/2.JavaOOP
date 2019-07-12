package WorkingWithAbstraction.Exercise.CardSuit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");

        CardSuit[] enumsValue = CardSuit.values();
        for (CardSuit value:enumsValue) {
        System.out.printf("Ordinal value: %d; Name value: %s%n",value.ordinal(),value.name() );

        }
    }
}
