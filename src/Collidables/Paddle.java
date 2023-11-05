package Collidables;

import Interfaces.Collidable;
import Interfaces.Sprite;
import RunGame.GameLevel;
import Shapes.Line;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Velocity;
import Shapes.Ball;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The type Collidables.Paddle.
 */
public class Paddle implements Sprite, Collidable {
    private final biuoop.KeyboardSensor keyboard;
    private final Rectangle rect;
    private final java.awt.Color color;
    private int speed;

    /**
     * Instantiates a new Collidables.Paddle.
     *
     * @param keyboard the keyboard
     * @param rect     the rect
     * @param color    the color
     * @param speed the speed
     */
    public Paddle(biuoop.KeyboardSensor keyboard, Rectangle rect, java.awt.Color color, int speed) {
        this.keyboard = keyboard;
        this.rect = rect;
        this.color = color;
        this.speed = speed;
    }

    /**
     * Move left if the user pressed the left key.
     */
    public void moveLeft() {
        if (this.rect.getUpperLeft().getX() <= 10) {
            return;
        }
        this.rect.setStart(new Point(this.rect.getUpperLeft().getX() - this.speed, this.rect.getUpperLeft().getY()));
    }

    /**
     * Move right if the user pressed the right key.
     */
    public void moveRight() {
        if (this.rect.getUpperLeft().getX() + rect.getWidth() >= 790) {
            return;
        }
        this.rect.setStart(new Point(this.rect.getUpperLeft().getX() + this.speed, this.rect.getUpperLeft().getY()));
    }

    /**
     * Check if the user pressed the right or left key.
     */
    public void timePassed() {
        if (keyboard.isPressed(biuoop.KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }
    /**
     * Draw the paddle on the surface.
     * @param d the Draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.rect.getColor());
        d.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }

    /**
     * Return the rectangle.
     * @return the rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }
    /**
     * Change the velocity according to the place the ball gits the paddle.
     * @param collisionPoint the hitting point.
     * @param currentVelocity the cuurent velocity.
     * @param hitter the ball we are hitting with
     * @return the new velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double lengthParts = this.rect.getWidth() / 5;
        int place = -1;
        for (int i = 0; i < 5; i++) {
            Line l1 = new Line(this.rect.getUpperLeft().getX() + lengthParts * i, this.rect.getUpperLeft().getY(),
                    this.rect.getUpperLeft().getX() + lengthParts * (i + 1), this.rect.getUpperLeft().getY());
            if (l1.isDotOnLine(collisionPoint)) {
                place = i;
            }
        }
        switch (place) {
            case 0:
                return Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
            case 1:
                return Velocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
            case 2:
                return new Velocity(currentVelocity.getDx(), (-1) * currentVelocity.getDy());
            case 3:
                return Velocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
            case 4:
                return Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
            default:
                break;
        }
        if (this.rect.getRightLine().isDotOnLine(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
        }
        if (this.rect.getLeftLine().isDotOnLine(collisionPoint)) {
            return Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
        }
        return currentVelocity;
    }

    /**
     * Add the paddle to the game.
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * Draw the borders of the rectangle.
     * @param surface the surface.
     */
    public void drawLinesOnRect(DrawSurface surface) {
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }
}