/**
 * ID 303080097
 */
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * The decorator Responsible for exiting a screen with a space click.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * constructor.
     * @param sensor the keyboard sensor.
     * @param key the name of key.
     * @param animation the screen from which you exit / return.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (!this.sensor.isPressed(KeyboardSensor.SPACE_KEY)) {
            isAlreadyPressed = false;
        }
        if (this.sensor.isPressed(KeyboardSensor.SPACE_KEY) && (!isAlreadyPressed)) {
            this.stop = true;
        }
    }
    @Override
    public boolean shouldStop() {
        return this.stop; }
}