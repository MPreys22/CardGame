// Michael Preys
import java.util.ArrayList;
public class Player {
    private ArrayList<Card> hand;
    private int points;
    private String name;

    // Constructor taking in both a hand and name and sets points
    public Player(ArrayList<Card> hand, String name) {
        this.hand = hand;
        this.points = 0;
        this.name = name;
    }

    // Takes in player name only and sets points
    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    // Getter and setters for name, hand, and points
    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    // Adds points from drawn card to users total for the round
    public void addPoints(int newPoints) {
        points += newPoints;
    }

    // Add card to users hand
    public void addCard(Card newCard) {
        hand.add(newCard);
    }

    // Print users points as well as their hand
    @Override
    public String toString() {
        return  name + " has " + points + " points \n" +
                name + "'s cards: " + hand;
    }
}
