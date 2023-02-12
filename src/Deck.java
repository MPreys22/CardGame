// Michael Preys
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Image;

public class Deck {
    private ArrayList<Card> cards;
    private int cardsLeft;

    // Initialize deck of cards using previously declared arrays of suits, values, and ranks
    public Deck(String[] ranks, String[] suits, int[] values, GameViewer window) {
        Image cardImage;
        String path = "Recources/Cards/";
        String add;
        String path2;
        cards = new ArrayList<Card>();
        for (int i=0; i<ranks.length; i++) {
            for (int j=0; j<suits.length; j++) {
                add = String.valueOf(((i*4) + 1)+j);
                path2 = path + add + ".png";
                cardImage = new ImageIcon(path2).getImage();
                Card card = new Card(ranks[i], suits[j], values[i], window, cardImage);
                cards.add(card);
            }
        }
        cardsLeft = cards.size();
        shuffle();
    }

    // Check if array has nothing left
    public boolean isEmpty() {
        if (getCardsLeft() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    // Cards left in deck
    public int getCardsLeft() {
        return cardsLeft;
    }

    // Deals card making sure deck is not empty and edits cardsLft variable
    public Card deal() {
        if(isEmpty()) {
            return null;
        }
        cardsLeft--;
        return cards.get(cardsLeft);
    }

    // Shuffles deck using math random and swapping values current i instance with random instance in array
    public void shuffle() {
        Card temp;
        int index;
        for (int i = cards.size()-1; i >= 0; i--) {
            index = (int)(Math.random() * cards.size());
            temp = cards.get(i);
            cards.set(i, cards.get(index));
            cards.set(index, temp);
        }
        cardsLeft = cards.size();
    }
}

