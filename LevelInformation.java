/**
 * ID 303080097
 */
import java.util.List;

/**
 * the interface of all departments of the stage data in the game.
 */
public interface LevelInformation {
    /**
     * @return number of balls in this stage.
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     * @return list of velocities of balls in the game.
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return the speed of the paddle.
     */
    int paddleSpeed();
    /**
     * @return the width of the paddle.
     */
    int paddleWidth();
    /**
     * the level name will be displayed at the top of the screen.
     * @return the level name.
     */
    String levelName();

    /**
     * returns a sprite with the background of the level.
     * @return the background object.
     */
    Sprite getBackground();
    // The Blocks that make up this level, each block contains
    // its size, color and location.

    /**
     * The Blocks that make up this level, each block contains,
     * its size, color and location.
     * @return list of blocks.
     */
    List<Block> blocks();
    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();

    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * @return blocks.size().
     * */
    int numberOfBlocksToRemove();
}