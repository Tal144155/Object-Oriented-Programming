package Collidables;

import Interfaces.HitListener;
import RunGame.GameLevel;
import Shapes.Ball;

/**
 * The type Block remover.
 */
public class BlockRemover implements HitListener {
    private final GameLevel gameLevel;
    private final Collidables.Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     *
     * @param gameLevel          the game
     * @param removedBlocks the removed blocks
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }
    /**
     * Notification for a new hit event.
     *
     * @param beingHit         the object we are hitting with
     * @param hitter the ball we are hitting with
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.gameLevel);
        this.remainingBlocks.decrease(1);
    }
}