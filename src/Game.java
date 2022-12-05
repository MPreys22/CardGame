public class Game {

    Player player1;
    Player player2;
    Deck deck;

    public Game() {
        player1 = new Player("");
        player2 = new Player("");
        String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suit = {"Hearts", "Clubs", "Spades", "Diamonds"};
        int[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        deck = new Deck(rank, suit, value);
    }

    public void playGame() {
        printInstructions();
    }

    public void printInstructions() {
        System.out.println("Welcome to BlackJack! You will try to get as close to 21 as possible by either hitting or "
                +"staying\ndepending on what you draw from the card deck. If you go higher than 21 you lose! Have fun!");
    }

    public static void main(String[] args) {
        Game blackJack = new Game();
        blackJack.playGame();
    }
}
