/**
 * ID 303080097
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * the level information of the three level.
 */
public class Green3 implements LevelInformation {
    private List<Block> blocks;
    /**
     * constructor.
     * Creates a new list to use for the blocks of the stage
     */
    public Green3() {
        this.blocks = new ArrayList<Block>();
    }

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        velocities.add(Velocity.fromAngleAndSpeed(330, 5));
        velocities.add(Velocity.fromAngleAndSpeed(030, 5));
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        Color green = new Color(18, 166, 23);
        Block backGround = new Block(0, 0, 800, 600, green, green);
        return backGround;
    }
    /**
     * create new lin of blocks.
     * @param upperLeft the upper left point of the left block in the line.
     * @param numOfBlocks Number of blocks required to produce.
     * @param color color of the block.
     */
    public  void createLineBlocks(Point upperLeft, int numOfBlocks, Color color) {
        Point[] up = new Point[numOfBlocks];
        for (int i = 0; i < numOfBlocks; i++) {
            up[i] = new Point(upperLeft.getX(), upperLeft.getY());
            blocks.add(new Block(up[i], 50, 25, color, Color.BLACK));
            upperLeft.setX(upperLeft.getX() + 50);
        }
    }
    @Override
    public List<Block> blocks() {
        Point greyUL = new Point(275, 150);
        createLineBlocks(greyUL, 10, Color.GRAY);
        Point redUL = new Point(325, 175);
        createLineBlocks(redUL, 9, Color.RED);
        Point yellowUL = new Point(375, 200);
        createLineBlocks(yellowUL, 8, Color.yellow);
        Point blueUL = new Point(425, 225);
        createLineBlocks(blueUL, 7, Color.blue);
        Point whiteUL = new Point(475, 250);
        createLineBlocks(whiteUL, 6, Color.WHITE);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove()  {
        return blocks.size();
    }
}
