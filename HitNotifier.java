/**
 * ID 303080097
 */

/**
 * Interface for list listener.
 */

public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     * @param hl the hit listener that added.
     */
    void addHitListener(HitListener hl);
    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl Remove hl from the list of listeners.
     */
    void removeHitListener(HitListener hl);
    /**
     * This method is called whenever the beingHit object is hit.
     * the hitter parameter is the Ball that's doing the hitting.
     * @param beingHit the block is hit.
     * @param hitter tha ball is hit.
     */
    void hitEvent(Block beingHit, Ball hitter);
}