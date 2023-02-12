// Michael Preys

import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame {
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;
    private Game game;

    // Create window and send in game variable to call methods from
    public GameViewer(Game game) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("BlackJack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.game = game;
    }

    public void paint(Graphics g) {
        // Game will initially be null at the start of the program so methods will not work
        if(this.game != null) {
            // Point values for both player and dealers
            int score = this.game.getCard().getPoint();
            int totalScore = this.game.getPlayer1().getPoints();
            int dealScore = this.game.getDealer().getPoints();
            g.setColor(Color.white);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.black);
            g.setFont(new Font("Serif", Font.PLAIN, 10));

            // Checks for win and specific win scenarios such as dealer or user winning
            if(this.game.ifWon()) {
                g.setFont(new Font("Serif", Font.PLAIN, 50));
                if(this.game.checkWinner() == 1) {
                    g.setColor(Color.green);
                    g.drawString("USER SCORE: " + totalScore, 225, 75);
                    g.drawString("DEALER SCORE: " + dealScore, 225, 125);
                    g.drawString("YOU WIN! ", 300, 400);
                    return;
                }
                else if(this.game.checkWinner() == 2) {
                    g.setColor(Color.red);
                    g.drawString("USER SCORE: " + totalScore, 225, 75);
                    g.drawString("DEALER SCORE: " + dealScore, 225, 125);
                    g.drawString("YOU LOSE! ", 300, 400);
                    return;
                }
                else if (this.game.checkWinner() == 3) {
                    g.setColor(Color.green);
                    g.drawString("USER SCORE: " + totalScore, 225, 75);
                    g.drawString("DEALER SCORE: " + dealScore, 225, 125);
                    g.drawString("YOU WIN! ", 300, 400);
                    return;
                }
                else {
                    g.drawString("USER SCORE: " + totalScore, 225, 75);
                    g.drawString("DEALER SCORE: " + dealScore, 225, 125);
                    g.drawString("ITS A DRAW! ", 300, 400);
                    return;
                }
            }
            else {
                // Keep instructions for the game on the screen if the game is not yet won
                g.drawString("Welcome to BlackJack! You will try to ", 10, 100);
                g.drawString("get as close to 21 as possible by", 10, 110);
                g.drawString("either hitting or staying depending on ", 10, 120);
                g.drawString("what you draw from the card deck.", 10, 130);
                g.drawString("If you go higher than 21 you lose! ", 10, 140);
                g.drawString("Have fun!", 10, 150);

                // If game is not won, display card drawn, score for that card, and total user score
                g.setFont(new Font("Serif", Font.PLAIN, 50));
                g.drawString("USER DRAW: ", 250, 75);
                g.setFont(new Font("Serif", Font.PLAIN, 25));

                this.game.getCard().draw(g);

                g.drawString("Card Score: " + String.valueOf(score), 200, 600);
                g.drawString("Total Score: " + String.valueOf(totalScore), 200, 700);
            }
        }
    }
}
