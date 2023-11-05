package Collidables;

import Interfaces.HitListener;
import RunGame.GameLevel;
import Shapes.Ball;

/**
 * The type Ball remover.
 */
public class BallRemover implements HitListener {
    private final GameLevel gameLevel;
    private final Collidables.Counter remainingBalls;

    /**
     * Instantiates a new Ball remover.
     *
     * @param gameLevel         the game
     * @param removedBalls the removed balls
     */
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        this.remainingBalls.decrease(1);
    }
}
