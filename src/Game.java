import java.util.Scanner;
public class Game {

    Player player1;
    Player dealer;
    Deck deck;
    Scanner input = new Scanner(System.in);

    /*
      initialize both the dealer and player (not given a hand)
      hard code in arrays for rank suit and point value of cards in deck
      initialize full deck using all arrays
    */
    public Game() {
        dealer = new Player("Dealer");
        player1 = new Player("Player");
        String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suit = {"Hearts", "Clubs", "Spades", "Diamonds"};
        int[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        deck = new Deck(rank, suit, value);
    }

    // runs through different sections of game
    public void playGame() {
        printInstructions();
        playRound();
    }

    // print instructions of game and extra line
    public void printInstructions() {
        System.out.println("Welcome to BlackJack! You will try to get as close to 21 as possible by either hitting or "
                +"staying\ndepending on what you draw from the card deck. If you go higher than 21 you lose! Have fun!");
        System.out.println();
    }

    // runs through 1 round of blackjack
    public void playRound() {
        boolean stillPlaying = true;
        // if the user is still playing continue on with round
        while(stillPlaying) {
            draw();
            // checks to make sure user does not have too many points
           if (player1.getPoints() > 21) {
               System.out.println("Oh! You went over 21 and lost! Better luck next time!");
               break;
           }
           // prompt user to continue game and get response
           System.out.println("Would you like to hit or stand?");
           String response = input.next();
           // if the user stands check winner and end round
           if (response.equals("stand")) {
               checkWinner();
               break;
           }
        }
    }

    // draws a card for both user as well as dealer and prints what the user pulled
    public void draw() {
        Card pull = deck.deal();
        Card pull2 = deck.deal();
        dealer.addPoints(pull2.getPoint());
        player1.addPoints(pull.getPoint());
        System.out.println("You pulled a " + pull + " worth " + pull.getPoint() + " points and now have " + player1.getPoints());
    }

    /* checks differences between 21 and dealer/player points
       whoever has less will win the game and have a message printed
    * */
    public void checkWinner() {
        if(dealer.getPoints() > 21) {
            System.out.println("The dealer had more than 21 points and you win!");
            return;
        }
        if((21 - dealer.getPoints()) < (21 - player1.getPoints())) {
            System.out.println("The dealer finished with " + dealer.getPoints() + " points and wins!");
        }
        else if((21 - dealer.getPoints()) > (21 - player1.getPoints())) {
            System.out.println("The dealer finished with " + dealer.getPoints() + " points and you win!");
        }
        else {
            System.out.println("The dealer finished with " + dealer.getPoints() + " points. It's a draw!");
        }
    }

    // create game function and play game
    public static void main(String[] args) {
        Game blackJack = new Game();
        blackJack.playGame();
    }
}
