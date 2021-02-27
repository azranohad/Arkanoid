/**
 * ID 303080097
 */

/**
 * Interface for all objects related to the hit.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * the hitter parameter is the Ball that's doing the hitting.
     * @param beingHit the block is hit.
     * @param hitter tha ball is hit.
      */
    void hitEvent(Block beingHit, Ball hitter);
}