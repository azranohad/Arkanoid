/**
 * ID 303080097
 */
import biuoop.DrawSurface;
/**
 * the interface of the Sprites.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     * @param d Object created object view.
     */
    void drawOn(DrawSurface d);
    /**
     * Perform actions between each movement.
     */
    void timePassed();

    /**
     * add this sprite to the game level.
     * @param g the game level.
     */
    void addToGame(GameLevel g);
}