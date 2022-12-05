import java.util.ArrayList;

public class Deck {
    //Instance Variables
    private ArrayList<Card> cards;
    private int cardsLeft;

    public Deck(String[] ranks, String[] suits, int[] values) {
        cards = new ArrayList<Card>();
        for (int i=0; i<ranks.length; i++) {
            for (int j=0; j<suits.length; j++) {
                Card card = new Card(ranks[i], suits[j], values[i]);
                cards.add(card);
            }
        }
        cardsLeft = cards.size();
        shuffle();
    }

    public boolean isEmpty() {
        if (getCardsLeft() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getCardsLeft() {
        return cardsLeft;
    }

    public Card deal() {
        if(isEmpty()) {
            return null;
        }
        cardsLeft--;
        return cards.get(cardsLeft + 1);
    }
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

