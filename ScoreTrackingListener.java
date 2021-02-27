/**
 * ID 303080097
 */
/**
 * The class is responsible for the constructors and
 * actions related to a ScoreTrackingListener object.
 */

public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor.
     * @param scoreCounter the initial number scoreCounter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * initial score.
     * @param newScore the new score to initial.
     */
    public void setCurrentScore(Counter newScore) {
        this.currentScore = newScore;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}