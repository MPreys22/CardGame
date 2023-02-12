// Michael Preys
import javax.swing.*;
import java.awt.*;

public class Card {
    private String rank;
    private String suit;
    private int point;
    private GameViewer gameView;

    private Image card;


    // Sets all values of one card (suit, rank, point value)
    public Card(String rank, String suit, int point, GameViewer gameView, Image card) {
        this.rank = rank;
        this.suit = suit;
        this.point = point;
        this.gameView = gameView;
        this.card = card;
    }


    // Getter and setters for rank suit and points
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

    // Print what the card is (suit and rank)
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public void draw(Graphics g) {
            g.drawImage(card, 200, 100, 400, 400, this.gameView);


    }
}
