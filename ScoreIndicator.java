/**
 * ID 303080097
 */

import biuoop.DrawSurface;
/**
 * the class responsible about the score indicator that will screen.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * constructor.
     * @param score the initial score.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(350, 18, "score:" + this.score.getValue(), 15);
    }
    @Override
    public void timePassed() {

    }

    /**
     * Adding a score.
     * @param addToScoreIndicator The number of points to add to the score.
     */
    public void increaseScoreIndicator(int addToScoreIndicator) {
        this.score = new Counter(this.score.getValue() + addToScoreIndicator);
    }

    /**
     * number of current score.
     * @return the current score.
     */
    public Counter getScoreIndicator() {
        return this.score;
    }
    /**
     * add this indicator to the list games.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
