package Collidables;

import Interfaces.Collidable;
import Shapes.Point;

/**
 * The type Collision info.
 */
public class CollisionInfo {
    private final Point collisionPoint;
    private final Collidable collisionObject;

    /**
     * Instantiates a new Collision info.
     *
     * @param collisionPoint  the collision point
     * @param collisionObject the collision object
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * Return the collision point.
     *
     * @return the point
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * Return the collision object.
     *
     * @return the collision object
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }

    /**
     * Return the place on the rectangle that the hitting point is on.
     * @param num the number
     * @return the place the point hits on the rectangle. return 1-4 on each line.
     */
    public boolean getPlaceHit(int num) {
        if (num == 1) {
            return collisionObject.getCollisionRectangle().getLeftLine().isDotOnLine(this.collisionPoint);
        }
        if (num == 2) {
            return collisionObject.getCollisionRectangle().getRightLine().isDotOnLine(this.collisionPoint);
        }
        if (num == 3) {
            return collisionObject.getCollisionRectangle().getUpLine().isDotOnLine(this.collisionPoint);
        }
        if (num == 4) {
            return collisionObject.getCollisionRectangle().getLowLine().isDotOnLine(this.collisionPoint);
        }
        return false;
    }
}
