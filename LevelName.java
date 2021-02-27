/**
 * ID 303080097
 */
import biuoop.DrawSurface;
/**
 * the class responsible about the level name that will screen.
 */
public class LevelName implements Sprite {
    private String levelName;
    /**
     * constructor.
     * @param levelName the level name.
     */
    public LevelName(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public void drawOn(DrawSurface d)  {
        d.drawText(500, 18, "Level Name:" + this.levelName, 15);
    }

    @Override
    public void timePassed() {

    }
    /**
     * add this String to the list games.
     * @param g the game.
     */
    @Override
    public void addToGame(GameLevel g)  {
        g.addSprite(this);
    }
}
