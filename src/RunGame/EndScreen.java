package RunGame;

import Interfaces.Animation;
import biuoop.DrawSurface;


import java.awt.Color;

/**
 * The type End screen.
 */
public class EndScreen implements Animation {
    private final boolean didWin;
    private final ScoreIndicator scoreIndicator;

    /**
     * Instantiates a new End screen.
     *
     * @param didWin         the did win
     * @param scoreIndicator the score indicator
     */
    public EndScreen(boolean didWin, ScoreIndicator scoreIndicator) {
        this.didWin = didWin;
        this.scoreIndicator = scoreIndicator;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (didWin) {
            d.setColor(new java.awt.Color(101, 255, 65));
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(Color.BLACK);
            d.drawText(330, 200, "YOU WIN!", 32);
            d.drawText(290, 300, "Your Score Is: " + this.scoreIndicator.getScores().getCountScore().getValue(),
                    32);
        } else {
            d.setColor(new java.awt.Color(231, 44, 44));
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(Color.BLACK);
            d.drawText(330, 200, "YOU LOST!", 32);
            d.drawText(290, 300, "Your Score Is: " + this.scoreIndicator.getScores().getCountScore().getValue(),
                    32);
        }
    }
    @Override
    public boolean shouldStop() {
        return true;
    }
}
