/**
 * ID 303080097
 */

/**
 * a BlockRemover is in charge of removing blocks from the game,
 * as well as keeping count of the number of blocks that remain.
 */

public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor new block remover.
     * @param game the game of the block.
     * @param remainBlocks remain blocks.
     */
    public BlockRemover(GameLevel game, Counter remainBlocks) {
        this.game = game;
        this.remainingBlocks = remainBlocks;
     }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        beingHit.removeHitListener(this);
        this.remainingBlocks.decrease(1);
    }
}