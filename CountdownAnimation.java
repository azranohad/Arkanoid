
/**
 * ID 303080097
 */
import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;

/**
 * Displays a countdown at the beginning of each stage of the game.
 */
public class CountdownAnimation implements Animation {
    private int countFrom;
    private SpriteCollection gameScreen;
    private Sleeper sleeper;
    private boolean stop;

    /**
     * constructor.
     * @param countFrom The countdown will begin countFrom.
     * @param gameScreen the sprites of the levelGame.
     */
    public CountdownAnimation(int countFrom, SpriteCollection gameScreen) {
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.sleeper = new Sleeper();
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (countFrom == (0)) {
            this.stop = true;
        }
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.gray);
        d.drawText(360, 450, "" + countFrom, 150);
        sleeper.sleepFor(1000);
        countFrom--;

    }
    @Override
    public boolean shouldStop() {
        return this.stop; }
}