package Levels;

import Backgrounds.BackgroundLevel2;
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
 * The type Level 2.
 */
public class Level2 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> lst = new ArrayList<>();
        lst.add(Velocity.fromAngleAndSpeed(-64, 5));
        lst.add(Velocity.fromAngleAndSpeed(-50, 5));
        lst.add(Velocity.fromAngleAndSpeed(-36, 5));
        lst.add(Velocity.fromAngleAndSpeed(-22, 5));
        lst.add(Velocity.fromAngleAndSpeed(-8, 5));
        lst.add(Velocity.fromAngleAndSpeed(6, 5));
        lst.add(Velocity.fromAngleAndSpeed(20, 5));
        lst.add(Velocity.fromAngleAndSpeed(34, 5));
        lst.add(Velocity.fromAngleAndSpeed(48, 5));
        lst.add(Velocity.fromAngleAndSpeed(62, 5));
        return lst;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new BackgroundLevel2();
    }

    @Override
    public List<Block> blocks() {
        List<Block> lst = new ArrayList<>();
        Color[] colors = {new java.awt.Color(255, 0, 0), new java.awt.Color(236, 109, 31),
                new java.awt.Color(255, 221, 51), new java.awt.Color(75, 239, 10),
                new java.awt.Color(23, 52, 201), new java.awt.Color(171, 92, 92, 255),
                new java.awt.Color(111, 220, 188, 255)};
        for (int i = 0; i < 15; i++) {
            Color c = Color.BLUE;
            if (i < 2) {
                c = colors[0];
            }
            if (i >= 2 && i < 4) {
                c = colors[1];
            }
            if (i >= 4 && i < 6) {
                c = colors[2];
            }
            if (i >= 6 && i < 9) {
                c = colors[3];
            }
            if (i >= 9 && i < 11) {
                c = colors[4];
            }
            if (i >= 11 && i < 13) {
                c = colors[5];
            }
            if (i >= 13) {
                c = colors[6];
            }
            Block b = new Block(new Rectangle(new Point(10 + i * 52,
                    250),
                    52, 30, c));
            lst.add(b);
        }
        return lst;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }

    @Override
    public Point startPaddle() {
        return new Point(100, 570);
    }
}
