import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the level information of the four level.
 */
public class FinalFour implements LevelInformation {
    private List<Block> blocks;

    /**
     * constructor.
     * Creates a new list to use for the blocks of the stage
     */
    public FinalFour() {
        this.blocks = new ArrayList<Block>();
    }

    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        velocities.add(Velocity.fromAngleAndSpeed(330, 5));
        velocities.add(Velocity.fromAngleAndSpeed(030, 5));
        velocities.add(Velocity.fromAngleAndSpeed(000, 8));
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        Color blue = new Color(66, 161, 243);
        Block backGround = new Block(0, 0, 800, 600, blue, blue);
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
        Point greyUL = new Point(25, 113);
        createLineBlocks(greyUL, 15, Color.GRAY);
        Point redUL = new Point(25, 138);
        createLineBlocks(redUL, 15, Color.RED);
        Point yellowUL = new Point(25, 163);
        createLineBlocks(yellowUL, 15, Color.yellow);
        Point greenUL = new Point(25, 188);
        createLineBlocks(greenUL, 15, Color.GREEN);
        Point whiteUL = new Point(25, 213);
        createLineBlocks(whiteUL, 15, Color.WHITE);
        Point pinkUL = new Point(25, 238);
        createLineBlocks(pinkUL, 15, Color.PINK);
        Point cyanUL = new Point(25, 263);
        createLineBlocks(cyanUL, 15, Color.cyan);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove()  {
        return blocks.size();
    }
}

