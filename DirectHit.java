/**
 * ID 303080097
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the level information of the one level.
 */
public class DirectHit implements LevelInformation {



    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        Velocity ballV1 = new Velocity(0, -10);
        velocities.add(ballV1);
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        Block backGround = new Block(0, 0, 800, 600, Color.BLACK, Color.BLACK);
        return backGround;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<Block>();
        Block block = new Block(390, 130, 30, 30, Color.RED, Color.RED);
        blocks.add(block);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
