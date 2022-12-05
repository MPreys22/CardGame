import java.util.ArrayList;
public class Player {
    //Pt 1
    private ArrayList<Card> hand;
    private int points;
    private String name;

    //Pt 2
    public Player(ArrayList<Card> hand, String name) {
        this.hand = hand;
        this.points = 0;
        this.name = name;
    }
    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    //Pt 3
    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    //Pt 4
    public void addPoints(int newPoints) {
        points += newPoints;
    }

    //Pt 5
    public void addCard(Card newCard) {
        hand.add(newCard);
    }

    //Pt 6
    @Override
    public String toString() {
        return  name + " has " + points + " points \n" +
                name + "'s cards: " + hand;
    }
}
