package Collidables;

import Interfaces.Collidable;
import Interfaces.HitListener;
import Interfaces.HitNotifier;
import Interfaces.Sprite;
import RunGame.GameLevel;
import Shapes.Ball;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Velocity;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Collidables.Block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private final Rectangle rec;
    private final List<HitListener> hitListeners;

    /**
     * Instantiates a new Collidables.Block.
     *
     * @param rec the rec
     */
    public Block(Rectangle rec) {
        this.rec = rec;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * Remove from game.
     *
     * @param gameLevel the game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }

    /**
     * Return the rectangle.
     * @return the rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.rec;
    }

    /**
     * changes the velocity according to meeting point.
     *
     * @param collisionPoint  the point of meeting
     * @param currentVelocity the current velocity
     * @param hitter the ball we are hitting with
     * @return the new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //if the point is on the left line.
        if (this.rec.getLeftLine().isDotOnLine(collisionPoint)) {
            if (currentVelocity.getDx() > 0) {
                currentVelocity = new Velocity((-1) * currentVelocity.getDx(), currentVelocity.getDy());
            }
        }
        //if the point is on the right line.
        if (this.rec.getRightLine().isDotOnLine(collisionPoint)) {
            if (currentVelocity.getDx() < 0) {
                currentVelocity = new Velocity((-1) * currentVelocity.getDx(), currentVelocity.getDy());
            }
        }
        //if the point is on the up line.
        if (this.rec.getUpLine().isDotOnLine(collisionPoint)) {
            if (currentVelocity.getDy() > 0) {
                currentVelocity = new Velocity(currentVelocity.getDx(), (-1) * currentVelocity.getDy());
            }
        }
        //if the point is on the low line.
        if (this.rec.getLowLine().isDotOnLine(collisionPoint)) {
           if (currentVelocity.getDy() < 0) {
                currentVelocity = new Velocity(currentVelocity.getDx(), (-1) * currentVelocity.getDy());
            }
        }
        this.notifyHit(hitter);
        return currentVelocity;
    }

    /**
     * draw a new block using the DrawSurface.
     *
     * @param surface the surface we draw on
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.rec.getColor());
        surface.fillRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(), (int) this.rec.getHeight());
    }

    /**
     * Draw lines on rectangle, the borders.
     *
     * @param surface the surface
     */
    public void drawLinesOnRect(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) this.rec.getUpperLeft().getX(), (int) this.rec.getUpperLeft().getY(),
                (int) this.rec.getWidth(), (int) this.rec.getHeight());
    }

    /**
     * After time passed do something (we don't have something to do yet).
     */
    public void timePassed() {
        //System.out.println("nothing");
    }
    /**
     * Add block to the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
