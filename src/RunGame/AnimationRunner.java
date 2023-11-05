package RunGame;

import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * The type Animation runner.
 */
public class AnimationRunner {
    private final GUI gui;
    private final int framesPerSecond;
    private final biuoop.Sleeper sleeper;

    /**
     * Instantiates a new Animation runner.
     *
     * @param gui             the gui
     * @param framesPerSecond the frames per second
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
        this.sleeper = new biuoop.Sleeper();
    }

    /**
     * Gets frames per second.
     *
     * @return the frames per second
     */
    public int getFramesPerSecond() {
        return framesPerSecond;
    }

    /**
     * Run.
     *
     * @param animation     the animation
     * @param timeCountdown the time countdown
     */
    public void run(Animation animation, double timeCountdown) {
        double millisecondsPerFrame;
        if (timeCountdown != 0) {
            millisecondsPerFrame = 1000 / timeCountdown;
        } else {
            millisecondsPerFrame = (double) 1000 / this.framesPerSecond;
        }
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = (long) millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
