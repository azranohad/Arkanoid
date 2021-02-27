/**
 * ID 303080097
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * the level information of the second level.
 */
public class WideEasy implements LevelInformation {

    private List<Block> blocks;
    /**
     * constructor.
     * Creates a new list to use for the blocks of the stage
     */
    public WideEasy() {
        this.blocks = new ArrayList<Block>();
    }

    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        double degreeRight = 12;
        double degreeLeft = 300;
        for (int i = 0; i < 5; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(degreeRight, 10));
            velocities.add(Velocity.fromAngleAndSpeed(degreeLeft, 10));
            degreeRight = degreeRight + 12;
            degreeLeft = degreeLeft + 12;
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        Block backGround = new Block(0, 0, 800, 600, Color.WHITE, Color.WHITE);
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
        Point redUL = new Point(25, 250);
        createLineBlocks(redUL, 2, Color.RED);
        Point orangeUL = new Point(125, 250);
        createLineBlocks(orangeUL, 2, Color.orange);
        Point yellowUL = new Point(225, 250);
        createLineBlocks(yellowUL, 2, Color.yellow);
        Point greenUL = new Point(325, 250);
        createLineBlocks(greenUL, 3, Color.green);
        Point blueUL = new Point(475, 250);
        createLineBlocks(blueUL, 2, Color.blue);
        Point magentaUL = new Point(575, 250);
        createLineBlocks(magentaUL, 2, Color.magenta);
        Point cyanUL = new Point(675, 250);
        createLineBlocks(cyanUL, 2, Color.cyan);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks.size();
    }

}
