/**
 * ID 303080097
 */
import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * The class is responsible for the constructors and
 * actions related to a Game object.
 */
public class GameLevel implements Animation {
    private AnimationRunner runner;
    private boolean running;
    private SpriteCollection sprites;
    private Paddle paddle;
    private GameEnvironment environment;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter score;
    private ScoreIndicator scoreIndicator;
    private ScoreTrackingListener scoreTrackingListener;
    private GUI gui;
    private KeyboardSensor keyboard;
    private LevelInformation levelInfo;

    /**
     * constructor new level.
     * @param gui the gui of the game.
     * @param keyboard the keyboard sensor of the game.
     * @param levelInfo in this object have the data level.
     * @param scoreIndicator the score until this level.
     */
    public GameLevel(GUI gui, KeyboardSensor keyboard, LevelInformation levelInfo, ScoreIndicator scoreIndicator) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.remainingBlocks = new Counter(0);
        this.remainingBalls = new Counter(0);
        this.score = new Counter(0);
        this.gui = gui;
        this.runner = new AnimationRunner(gui);
        this.keyboard = keyboard;
        this.levelInfo = levelInfo;
        this.scoreIndicator = scoreIndicator;
        this.scoreTrackingListener = new ScoreTrackingListener(scoreIndicator.getScoreIndicator());
    }
    /**
     * return the remaining blocks.
     * @return the remaining blocks.
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }

    /**
     * return the remaining balls.
     * @return the remaining balls.
     */
    public Counter getRemainingBalls() {
        return this.remainingBalls;
    }

    /**
     * return this score.
     * @return this score.
     */
    public Counter getScore() {
        return this.score;
    }

    /**
     * get this runner.
     * @return this runner.
     */
    public AnimationRunner getRunner() {
        return this.runner;
    }
    /**
     * added collidable to the list of collidables of the game.
     * @param c the collidable added.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }
    /**
     * added sprite to the list of sprites of the game.
     * @param s the sprite added.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * remove collidable from this game.
     * @param c the collidable that remove.
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * remove sprite from this game.
     * @param s the sprite that remove.
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
     }

    /**
     * Initialize a new game: create the Blocks ,Ball and Paddle
     * and add them to the game.
     */
    public void initialize() {

        //the background.
        List<Sprite> backGrounds = new ArrayList<Sprite>();
        backGrounds.add(levelInfo.getBackground());
        for (Sprite i : backGrounds) {
            i.addToGame(this);
        }

        //create a paddle and add to the game.
        double halfWidth = (double) ((this.levelInfo.paddleWidth()) / 2);
        this.paddle = new Paddle((400 - halfWidth), 585, this.levelInfo.paddleWidth(),
                15, Color.ORANGE, Color.BLACK, this.levelInfo.paddleSpeed());
        paddle.setKeyboard(keyboard);
        paddle.addToGame(this);

        //create  balls.
        int radius = 6;
        Point startBalls = new Point(400, this.paddle.getCollisionRectangle().getUl().getY()
                - ((double) radius / 2));
        Ball[] balls = new Ball[this.levelInfo.numberOfBalls()];
        for (int i = 0; i < this.levelInfo.numberOfBalls(); i++) {
            Velocity velocityBall = this.levelInfo.initialBallVelocities().get(i);
            balls[i] = new Ball(startBalls, radius, velocityBall, Color.white, Color.black);
            //add the balls to the list game.
            balls[i].addToGame(this);
            balls[i].setGame(this);
            balls[i].setEnvironment(this.environment);
            this.remainingBalls.increase(1);
        }

        //the block screener the score.
        Block scoreLine = new Block(0, 0, 800, 25, Color.WHITE, Color.BLACK);
        scoreLine.addToGame(this);
        //score indicator.
        scoreIndicator.addToGame(this);
        //level name.
        LevelName levelName = new LevelName(this.levelInfo.levelName());
        levelName.addToGame(this);


        //the bounds of the screen.
        Block upLine = new Block(0, 25, 800, 25, Color.gray, Color.BLACK);
        upLine.addToGame(this);
        Block leftLine = new Block(0, 50, 25, 575, Color.gray, Color.BLACK);
        leftLine.addToGame(this);
        Block rightLine = new Block(775, 50, 25, 575, Color.gray, Color.BLACK);
        rightLine.addToGame(this);

        // the death block.
        Block deathArea = new Block(25, 599, 750, 1, Color.gray, Color.BLACK);
        deathArea.addToGame(this);
        HitListener ballRemover = new BallRemover(this, this.remainingBalls);
        deathArea.addHitListener(ballRemover);

        HitListener blockRemover = new BlockRemover(this, this.remainingBlocks);
        List<Block> blocks = this.levelInfo.blocks();
        this.remainingBlocks.increase(this.levelInfo.numberOfBlocksToRemove());
        for (Block i : blocks) {
            i.addToGame(this);
            i.addHitListener(blockRemover);
            i.addHitListener(scoreTrackingListener);
        }
        levelInfo.blocks().clear();
    }

    /**
     * remove all the elements of this level.
     */
    public void clearGameLevel() {
        sprites.removeAllSprite();
        environment.removeAllCollidable();
    }
    /**
     * Checks if the balls are over.
     * @return if the balls are over return true, else return false.
     */
    public boolean ballsOver() {
        if (this.remainingBalls.getValue() == 0) {
            return true;
        }
        return false;
    }
    /**
     * Checks if the blocks are over.
     * @return if the blocks are over return true, else return false.
     */
    public boolean blocksOver() {
        if (this.remainingBlocks.getValue() == 0) {
            return true;
        }
        return false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (blocksOver()) {
            scoreIndicator.increaseScoreIndicator(this.score.getValue() + 100);
            scoreTrackingListener.setCurrentScore(scoreIndicator.getScoreIndicator());
            this.running = false;
            clearGameLevel();

        } else if (ballsOver()) {
            this.running = false;
            clearGameLevel();
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(
                    new KeyPressStoppableAnimation(keyboard,
                    "Space", new PauseScreen(this.keyboard)));
        }
    }


    @Override
    public boolean shouldStop() {
        return !this.running;
    }
    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.running = true;
        this.runner.run(new CountdownAnimation(3, this.sprites));
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }
}

