package RunGame;

import Collidables.Block;
import Collidables.BallRemover;
import Collidables.BlockRemover;
import Collidables.Counter;
import Collidables.Paddle;
import Interfaces.Animation;
import Interfaces.Collidable;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import Levels.Level1;
import Levels.Level2;
import Levels.Level3;
import Shapes.Ball;
import Shapes.Point;
import Shapes.Rectangle;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.List;


/**
 * The type RunGame.Game.
 */
public class GameLevel implements Animation {
    private final SpriteCollection sprites;
    private final GameEnvironment environment;
    private GUI gui;
    private biuoop.Sleeper sleeper;
    private final Counter counter;
    private Counter countBalls;
    private final ScoreIndicator score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation level;

    /**
     * Instantiates a new RunGame.Game.
     *
     * @param levelNum       the level num
     * @param scoreIndicator the score indicator
     * @param gui            the gui
     * @param keyboardSensor the keyboard sensor
     */
    public GameLevel(int levelNum, ScoreIndicator scoreIndicator, GUI gui, KeyboardSensor keyboardSensor) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.gui = gui;
        this.sleeper = null;
        this.counter = new Counter(0);
        this.countBalls = null;
        this.keyboard = keyboardSensor;
        this.score = scoreIndicator;
        this.running = true;
        this.runner = null;
        switch (levelNum) {
            case 1:
                this.level = new Level1();
                break;
            case 2:
                this.level = new Level2();
                break;
            case 3:
                this.level = new Level3();
                break;
            default:
                this.level = null;
                break;
        }
    }

    /**
     * Add collidable to the Interfaces.Collidable list.
     *
     * @param c the c
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Add sprite to the sprite list.
     *
     * @param s the s
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        this.environment.deleteFromLst(c);
    }

    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        this.sprites.deleteFromLst(s);
    }

    /**
     * Initialize a new game: create the Blocks and Shapes.Ball (and Collidables.Paddle)
     * and add them to the game.
     */
    public void initialize() {
        this.sprites.addSprite(this.level.getBackground());
        BlockRemover ptr = new BlockRemover(this, this.counter);
        this.sleeper = new biuoop.Sleeper();
        Paddle p1 = new Paddle(gui.getKeyboardSensor(), new Rectangle(this.level.startPaddle(),
                this.level.paddleWidth(), 20, Color.ORANGE), Color.ORANGE, this.level.paddleSpeed());
        p1.addToGame(this);
        this.countBalls = new Counter(this.level.numberOfBalls());
        for (int i = 0; i < this.level.numberOfBalls(); i++) {
            Ball ball = new Ball(new Point(400, 560), 5, Color.white);
            ball.setVelocity(this.level.initialBallVelocities().get(i));
            ball.addToGame(this);
            ball.setGame(this.environment);
        }
        List<Block> blocks = this.level.blocks();
        for (int j = 0; j < this.level.blocks().size(); j++) {
            blocks.get(j).addToGame(this);
            blocks.get(j).addHitListener(ptr);
            blocks.get(j).addHitListener(this.score.getScores());
        }
        this.counter.increase(this.level.numberOfBlocksToRemove());
        //adding borders to the game
        Block upBorder = new Block(new Rectangle(new Point(-10, 30), 810, 10, Color.BLACK));
        Block leftBorder = (new Block(new Rectangle(new Point(-10, 30), 20, 780, Color.BLACK)));
        Block deathBorder = (new Block(new Rectangle(new Point(-10, 600), 810, 10, Color.BLACK)));
        Block rightBorder = (new Block(new Rectangle(new Point(790, 30), 10, 780, Color.BLACK)));
        upBorder.addToGame(this);
        leftBorder.addToGame(this);
        deathBorder.addToGame(this);
        BallRemover btr = new BallRemover(this, this.countBalls);
        deathBorder.addHitListener(btr);
        rightBorder.addToGame(this);
        this.sprites.addSprite(this.score);
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.runner = new AnimationRunner(this.gui, 60);
        this.running = true;
        this.runner.run(new CountdownAnimation(6, 3, this.sprites, this.environment,
                        this.level.levelName()),
                (double) 1 / ((double) 3 / 3)); // countdown before turn starts.
        this.running = true;
        this.runner = new AnimationRunner(this.gui, 60);
        this.runner.run(this, 0);
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.environment.drawRectLines(d);
        this.sprites.notifyAllTimePassed();
        d.drawText(600, 27, "Level: " + this.level.levelName(), 20);
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                            new PauseScreen()), 0);
        }
        if (this.counter.getValue() == 0) {
            this.score.getScores().getCountScore().increase(100);
            this.running = false;
        }
        if (this.countBalls.getValue() == 0) {
            this.running = false;
        }
    }

    /**
     * Gets count balls.
     *
     * @return the count balls
     */
    public Counter getCountBalls() {
        return countBalls;
    }
}
