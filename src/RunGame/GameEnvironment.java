package RunGame;

import Collidables.CollisionInfo;
import Interfaces.Collidable;
import Shapes.Line;
import Shapes.Point;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * The type RunGame.Game environment.
 */
public class GameEnvironment {
    private final java.util.List<Collidable> lst;
    private int numCollide;

    /**
     * Instantiates a new RunGame.Game environment.
     */
    public GameEnvironment() {
        this.lst = new ArrayList<>();
        this.numCollide = 0;
    }

    /**
     * Add the given collidable to the environment.
     *
     * @param c the c
     */
    public void addCollidable(Collidable c) {
        this.lst.add(c);
        this.numCollide++;
    }

    /**
     * Delete from lst.
     *
     * @param c the c
     */
    public void deleteFromLst(Collidable c) {
        this.lst.remove(c);
        this.numCollide -= 1;
    }

    /**
     * Gets the closest collision.
     * using the movement line, check if the end of the line meets one of the block.
     * if he does, find the closest meeting point to the start of the line. if not, return null
     *
     * @param trajectory the trajectory
     * @return the closest collision
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        java.util.List<CollisionInfo> collisionList = new ArrayList<>();
        for (int i = 0; i < this.numCollide; i++) {
            //collecting the meeting points and adding them to a list.
            Point p1 = trajectory.closestIntersectionToStartOfLine(this.lst.get(i).getCollisionRectangle());
            if (p1 != null) {
                collisionList.add(new CollisionInfo(p1, this.lst.get(i)));
            }
        }
        if (collisionList.size() == 0) {
            return null;
        }
        //searching for the closest meeting point.
        CollisionInfo c1;
        CollisionInfo min = collisionList.get(0);
        for (int i = 0; i < collisionList.size(); i++) {
            c1 = collisionList.get(i);
            if (c1.collisionPoint().distance(trajectory.start()) < min.collisionPoint().distance(trajectory.start())) {
                min = c1;
            }
        }
        return min;
    }

    /**
     * Gets size of list collide.
     *
     * @return the num collide
     */
    public int getNumCollide() {
        return this.numCollide;
    }

    /**
     * Gets lst.
     *
     * @return the lst
     */
    public List<Collidable> getLst() {
        return this.lst;
    }

    /**
     * Draw rect lines, draw the borders along the rectangle.
     *
     * @param d the d
     */
    public void drawRectLines(DrawSurface d) {
        for (int i = 0; i < this.numCollide; i++) {
            this.lst.get(i).drawLinesOnRect(d);
        }
    }
}
