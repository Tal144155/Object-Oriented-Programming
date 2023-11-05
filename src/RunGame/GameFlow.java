package RunGame;

import Collidables.Counter;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * The type Game flow.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private final KeyboardSensor keyboardSensor;
    private final ScoreIndicator scoreIndicator;
    private final GUI gui;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar the ar
     * @param ks the ks
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.scoreIndicator = new ScoreIndicator(new ScoreTrackingListener(new Counter(0)));
        this.gui = new GUI("Arkanoid", 800, 600);
    }

    /**
     * Instantiates a new Game flow.
     */
    public GameFlow() {
        this.scoreIndicator = new ScoreIndicator(new ScoreTrackingListener(new Counter(0)));
        this.gui = new GUI("Arkanoid", 800, 600);
        this.keyboardSensor = this.gui.getKeyboardSensor();
    }

    /**
     * Run levels.
     *
     * @param levels the levels
     */
    public void runLevels(List<Integer> levels) {
        for (int levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.scoreIndicator, this.gui, this.keyboardSensor);
            level.initialize();
            while (!level.shouldStop()) {
                level.run();
            }
            if (level.getCountBalls().getValue() == 0) {
                AnimationRunner runner = new AnimationRunner(this.gui, 60);
                EndScreen end = new EndScreen(false, this.scoreIndicator);
                runner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY, end), 60);
                this.gui.close();
            }
        }
        AnimationRunner runner = new AnimationRunner(this.gui, 60);
        EndScreen end = new EndScreen(true, this.scoreIndicator);
        runner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY, end), 60);
        this.gui.close();
    }
}
