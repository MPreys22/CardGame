import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame {
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;
    private Game game;


    public GameViewer(Game game) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("BlackJack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.game = game;
    }

    public void paint(Graphics g) {
        if(this.game != null) {
            int score = this.game.getCard().getPoint();
            int totalScore = this.game.getPlayer1().getPoints();
            int dealScore = this.game.getDealer().getPoints();
            g.setColor(Color.white);
            g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
            g.setColor(Color.black);
            g.setFont(new Font("Serif", Font.PLAIN, 50));

            if(this.game.checkWinner() == 1) {
                g.drawString("USER SCORE: " + totalScore, 250, 75);
                g.drawString("DEALER SCORE: " + dealScore, 250, 125);
                g.drawString("THE DEALER HAD OVER 21 AND YOU WIN!: ", 250, 175);
                return;
            }
            else if(this.game.checkWinner() == 2) {
                g.drawString("USER SCORE: " + totalScore, 250, 75);
                g.drawString("DEALER SCORE: " + dealScore, 250, 125);
                g.drawString("YOU LOSE!: ", 250, 175);
                return;
            }
            else if (this.game.checkWinner() == 3) {
                g.drawString("USER SCORE: " + totalScore, 250, 75);
                g.drawString("DEALER SCORE: " + dealScore, 250, 125);
                g.drawString("YOU WIN!: ", 250, 175);
                return;
            }
            else if (this.game.checkWinner() == 4) {
                g.drawString("USER SCORE: " + totalScore, 250, 75);
                g.drawString("DEALER SCORE: " + dealScore, 250, 125);
                g.drawString("ITS A DRAW!: ", 250, 175);
                return;
            }
            else {
                g.drawString("USER DRAW: ", 250, 75);
                g.setFont(new Font("Serif", Font.PLAIN, 25));

                this.game.getCard().draw(g);

                g.drawString("Card Score: " + String.valueOf(score), 200, 600);
                g.drawString("Total Score: " + String.valueOf(totalScore), 200, 700);
            }
        }
    }
}
