/**
 * ID 303080097
 */
import biuoop.GUI;
import java.util.ArrayList;
import java.util.List;

/**
 * the main class.
 */
public class Ass6Game {

    /**
     * Generates a list of steps per game according to the arguments list.
     * @param args args from the main.
     * @return list of LevelInformation - the level of the game.
     */
    public static List<LevelInformation> getLevels(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        LevelInformation directHit = new DirectHit();
        LevelInformation wideEasy = new WideEasy();
        LevelInformation green3 = new Green3();
        LevelInformation finalFour = new FinalFour();

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("1")) {
                levels.add(directHit);
            } else if (args[i].equals("2")) {
                levels.add(wideEasy);
            } else if (args[i].equals("3")) {
                levels.add(green3);
            } else if (args[i].equals("4")) {
                levels.add(finalFour);
            }
        }
        //if the args is empty.
        if ((levels.size() == 0) && (args.length == 0)) {
            levels.add(directHit);
            levels.add(wideEasy);
            levels.add(green3);
            levels.add(finalFour);
        } else if (levels.size() == 0) {
            System.out.print("error! all the input entered is incorrect");
            System.exit(1);
        }
        return levels;
    }

    /**
     * the main class.
     * @param args empty.
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = getLevels(args);
        GUI gui = new GUI("Arkanoid", 800, 600);
        biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
        AnimationRunner animationRunner = new AnimationRunner(gui);
        GameFlow gameFlow = new GameFlow(animationRunner, keyboard, gui);
        gameFlow.runLevels(levels);
        gui.close();
    }
}
