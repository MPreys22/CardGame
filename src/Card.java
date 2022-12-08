public class Card {
    private String rank;
    private String suit;
    private int point;

    // sets all values of one card (suit, rank, point value)
    public Card(String rank, String suit, int point) {
        this.rank = rank;
        this.suit = suit;
        this.point = point;
    }

    // getter and setters for rank suit and points
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    // print what the card is (suit and rank)
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
