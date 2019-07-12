package WorkingWithAbstraction.Exercise.CardsWithPower;

public class Card {
    RankPower rank;
    SuitPower suit;

    public Card(RankPower rank, SuitPower suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int cardPower(){
        int cardPower = rank.getPower() + suit.getSuitPower();
        return cardPower;
    }
}
