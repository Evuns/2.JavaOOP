package WorkingWithAbstraction.Exercise.CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        RankPower rank = RankPower.valueOf(bf.readLine());
        SuitPower suit = SuitPower.valueOf(bf.readLine());
        Card card = new Card(rank,suit);

        System.out.printf("Card name: %s of %s; Card power: %d",rank.name(),suit.name(),card.cardPower());
    }
}
