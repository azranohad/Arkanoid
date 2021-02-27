/**
 * ID 303080097
 */
import biuoop.DrawSurface;
/**
 * Interface for all All objects that are animated.
 */
public interface Animation {
    /**
     * Displays one frame of the animation.
     * @param d the draw surface object.
     */
    void doOneFrame(DrawSurface d);

    /**
     * Responsible for stopping the current animation.
     * @return if is true - the animation run. else, this animation stop.
     */
    boolean shouldStop();
}