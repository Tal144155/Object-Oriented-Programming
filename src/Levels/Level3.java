package Levels;


import Backgrounds.BackgroundLevel3;
import Collidables.Block;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 3.
 */
public class Level3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> lst = new ArrayList<>();
        lst.add(new Velocity(2, -3));
        lst.add(new Velocity(-2, -3));
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return new BackgroundLevel3();
    }

    @Override
    public List<Block> blocks() {
        List<Block> lst = new ArrayList<>();
        Color[] colors = {new java.awt.Color(255, 255, 255), new java.awt.Color(255, 102, 102),
                new java.awt.Color(255, 51, 51), new java.awt.Color(255, 0, 0),
                new java.awt.Color(204, 0, 0), new java.awt.Color(153, 0, 0)};
        for (int i = 0; i < 5; i++) {
            Color c = colors[i];
            for (int k = 0; k < 10 - i; k++) {
                Block b = new Block(new Rectangle(new Point(290 + i * 50 + 50 * k,
                        190 + i * 30),
                        50, 30, c));
                lst.add(b);
            }
        }
        return lst;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
    @Override
    public Point startPaddle() {
        return new Point(365, 570);
    }
}
