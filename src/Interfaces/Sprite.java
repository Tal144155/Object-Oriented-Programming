package Interfaces;

import RunGame.GameLevel;
import biuoop.DrawSurface;

/**
 * The interface Interfaces.Sprite.
 */
public interface Sprite {
    /**
     * Draw on.
     *
     * @param d the d
     */
    void drawOn(DrawSurface d);

    /**
     * Time passed.
     */
    void timePassed();
    /**
     * Adding to the game.
     * @param g the game we are adding to.
     */
    void addToGame(GameLevel g);
}
