/**
 * ID 303080097
 */
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The screen to display after pressing p (pause).
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * constructor.
     * @param k the keyboard sensor.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(180, d.getHeight() / 2, "paused -- press space to continue", 32);
    }
    @Override
    public boolean shouldStop() {
        return this.stop; }
}