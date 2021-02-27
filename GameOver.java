/**
 * ID 303080097
 */
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * The screen that will appear when The player was disqualified.
 */
public class GameOver implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private ScoreIndicator scoreIndicator;

    /**
     * constructor.
     * @param k the keyboard sensor.
     * @param scoreIndicator Scoring at the game.
     */
    public GameOver(KeyboardSensor k, ScoreIndicator scoreIndicator) {
        this.keyboard = k;
        this.stop = false;
        this.scoreIndicator = scoreIndicator;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(250, d.getHeight() / 3, "Game Over", 50);
        d.drawText(240, d.getHeight() / 2, "Your Score is "
                + scoreIndicator.getScoreIndicator().getValue(), 40);
    }

    @Override
    public boolean shouldStop() {
        return this.stop; }
}
