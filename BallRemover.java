/**
 * ID 303080097
 */
/**
 * The class is responsible for the constructors and
 * actions related to a BallRemover object.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * constructor new ball remover.
     * @param game the game of the ball.
     * @param remainBalls remain Balls.
     */
    public BallRemover(GameLevel game, Counter remainBalls) {
        this.game = game;
        this.remainingBalls = remainBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
