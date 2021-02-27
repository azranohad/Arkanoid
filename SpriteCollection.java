/**
 * ID 303080097
 */

import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;
/**
 * The class is responsible for the constructors and
 * actions related to a SpriteCollection object.
 */
public class SpriteCollection {
    private List<Sprite> sprites;
    /**
     * constructor new SpriteCollection list.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }
    /**
     * add the given sprite to the game.
     * @param s the sprite added.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * remove the sprite s from the list.
     * @param s the sprite that remove.
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * remove all the sprite from the list.
     */
    public void removeAllSprite() {
        this.sprites.clear();
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spriteList = new ArrayList<>(this.sprites);
        for (Sprite i : spriteList) {
            i.timePassed();
        }
    }
    /**
     * call drawOn(d) on all sprites.
     * @param d Object created object view.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite i : sprites) {
            i.drawOn(d);
        }
    }
}
