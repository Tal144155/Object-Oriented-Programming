package Interfaces;

import Shapes.Ball;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Velocity;
import biuoop.DrawSurface;

/**
 * The interface Interfaces.Collidable.
 */
public interface Collidable {
    /**
     * Gets collision rectangle.
     *
     * @return the collision rectangle
     */
// Return the "collision shape" of the object.
    Rectangle getCollisionRectangle();

    /**
     * Hit velocity.
     *
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @param hitter the ball we might have hit
     * @return the velocity
     */
// Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

    /**
     * Draw lines on rect.
     *
     * @param surface the surface
     */
    void drawLinesOnRect(DrawSurface surface);
}
