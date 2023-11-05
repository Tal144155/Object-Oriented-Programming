package Levels;

import Backgrounds.BackgroundLevel1;
import Collidables.Block;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Velocity;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 1.
 */
public class Level1 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> lst = new ArrayList<>();
        lst.add(new Velocity(0, -3));
        return lst;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 70;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new BackgroundLevel1();
    }

    @Override
    public List<Block> blocks() {
        List<Block> lst = new ArrayList<>();
        lst.add(new Block(new Rectangle(new Point(380, 200), 40, 40, java.awt.Color.RED)));
        return lst;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

    @Override
    public Point startPaddle() {
        return new Point(365, 570);
    }
}
