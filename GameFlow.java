/**
 * ID 303080097
 */
import java.util.List;
import biuoop.GUI;
import biuoop.KeyboardSensor;

/**
 * This class will be in charge of creating the different levels,
 * and moving from one level to the next.
 */
public class GameFlow {

    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private GUI gui;
    private ScoreIndicator scoreIndicator;

    /**
     * constructor.
     * @param ar the animationRunner of the game.
     * @param ks the keyboard sensor of the game.
     * @param gui the gui of the game.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.gui = gui;
        this.scoreIndicator = new ScoreIndicator(new Counter(0));
    }

    /**
     * A loop that runs all stages of the game.
     * @param levels List of game stages.
     */
    public void runLevels(List<LevelInformation> levels) {

        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(gui, keyboardSensor, levelInfo, scoreIndicator);
            level.initialize();
            while ((!level.ballsOver()) && (!level.blocksOver())) {
                level.run();
            }
            // if the balls are over.
            if (level.ballsOver()) {
                animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, "Space",
                        new GameOver(keyboardSensor, scoreIndicator)));
                return;
            }
        }
        //If the game stages are over without disqualification.
            animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor, "Space",
                    new  EndScreenWin(keyboardSensor, scoreIndicator)));
    }
}