import java.util.Scanner;
public class Game {

    Player player1;
    Player dealer;
    Deck deck;
    Scanner input = new Scanner(System.in);

    public Game() {
        dealer = new Player("Dealer");
        player1 = new Player("Player");
        String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suit = {"Hearts", "Clubs", "Spades", "Diamonds"};
        int[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        deck = new Deck(rank, suit, value);
    }

    public void playGame() {
        printInstructions();
        playRound();
    }

    public void printInstructions() {
        System.out.println("Welcome to BlackJack! You will try to get as close to 21 as possible by either hitting or "
                +"staying\ndepending on what you draw from the card deck. If you go higher than 21 you lose! Have fun!");
        System.out.println();
    }

    public void playRound() {
        boolean stillPlaying = true;

        while(stillPlaying) {
            draw();
           if (player1.getPoints() > 21) {
               System.out.println("Oh! You went over 21 and lost! Better luck next time!");
               break;
           }

           System.out.println("Would you like to hit or stand?");
           String response = input.next();

           if (response.equals("stand")) {
               checkWinner();
               break;
           }
        }
    }
    public void draw() {
        Card pull = deck.deal();
        Card pull2 = deck.deal();
        dealer.addPoints(pull2.getPoint());
        player1.addPoints(pull.getPoint());
        System.out.println("You pulled a " + pull + " worth " + pull.getPoint() + " points and now have " + player1.getPoints());
    }

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
    public static void main(String[] args) {
        Game blackJack = new Game();
        blackJack.playGame();
    }
}
