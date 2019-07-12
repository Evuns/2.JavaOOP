package WorkingWithAbstraction.Exercise.CardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");

        Type [] cards = Type.values();
        for (Type card:cards) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",card.ordinal(),card.name());
        }
    }
}
