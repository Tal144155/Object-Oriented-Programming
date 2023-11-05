package RunGame;

import Interfaces.Animation;
import biuoop.DrawSurface;

/**
 * The type Countdown animation.
 */
public class CountdownAnimation implements Animation {
    private final double numOfSeconds;
    private int countFrom;
    private final SpriteCollection gameScreen;
    private final GameEnvironment gameEnvironment;
    private final String levelName;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds    the num of seconds
     * @param countFrom       the count from
     * @param gameScreen      the game screen
     * @param gameEnvironment the game environment
     * @param levelName       the level name
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen,
                              GameEnvironment gameEnvironment, String levelName) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.gameEnvironment = gameEnvironment;
        this.levelName = levelName;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        this.gameEnvironment.drawRectLines(d);
        d.drawText(600, 27, "Level: " + this.levelName, 20);
        d.drawText(380, 370, Integer.toString(this.countFrom), 70);
        this.countFrom = this.countFrom - 1;
    }

    @Override
    public boolean shouldStop() {
        return this.countFrom == 0;
    }
}
