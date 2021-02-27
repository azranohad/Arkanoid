/**
 * ID 303080097
 */
import biuoop.KeyboardSensor;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The class is responsible for the constructors and
 * actions related to a paddle object.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Point upperLeft;
    private double width;
    private double height;
    private Color color;
    private Color colorLine;
    private double paddleSpeed;
    /**
     * constructor.
     * @param upperLeft the upper left point of the paddle.
     * @param width the width of the paddle.
     * @param height the height of the paddle.
     */
    public  Paddle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }
    /**
     * constructor.
     * @param rect the rectangle data of the paddle.
     */
    public Paddle(Rectangle rect) {
        this.upperLeft = rect.getUpperLeft();
        this.width = rect.getWidth();
        this.height = rect.getHeight();
    }
    /**
     * constructor.
     * @param upperLeft the upper left point of the paddle.
     * @param width the width of the paddle.
     * @param height the height of the paddle.
     * @param color color of the paddle.
     */
    public Paddle(Point upperLeft, double width, double height, Color color) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    /**
     * constructor.
     * @param upperLeft the upper left point of the paddle.
     * @param width the width of the paddle.
     * @param height the height of the paddle.
     * @param color color of the paddle.
     * @param colorLine the color the line of rhe paddle.
     */
    public Paddle(Point upperLeft, double width, double height, Color color, Color colorLine) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.color = color;
        this.colorLine = colorLine;

    }
    /**
     * constructor.
     * @param x the x value of the upper left point of the paddle.
     * @param y the y value of the upper left point of the paddle.
     * @param width the width of the paddle.
     * @param height the height of the paddle.
     * @param color color of the paddle.
     * @param colorLine the color the line of rhe paddle.
     * @param paddleSpeed the paddle speed.
     */
    public Paddle(double x, double y, double width, double height, Color color, Color colorLine, double paddleSpeed) {
        this.upperLeft = new Point(x, y);
        this.width = width;
        this.height = height;
        this.color = color;
        this.colorLine = colorLine;
        this.paddleSpeed = paddleSpeed;
    }
    /**
     * constructor.
     * @param keyboard1 the keyboard sensor.
     */
    public void setKeyboard(KeyboardSensor keyboard1) {
        this.keyboard = keyboard1;
    }
    /**
     * @return The block data of the paddle.
     */
    public Block getPaddleBlock() {
        Block blockPaddle = new Block(this.upperLeft, this.width, this.height);
        return blockPaddle;
    }
    /**
     * move the paddle to left.
     */
    public void moveLeft() {
        double bufferScreen = 25;
        if (this.upperLeft.getX() - bufferScreen <= 0) {
            this.upperLeft.setX(0 + bufferScreen);
        } else {
            this.upperLeft.setX(upperLeft.getX() - 10);
        }

    }
    /**
     * move the paddle to right.
     */
    public void moveRight() {
        double bufferScreen = 25;
        double widthScreen = 800;
        if (this.upperLeft.getX() + width + bufferScreen >= widthScreen) {
            this.upperLeft.setX(widthScreen - bufferScreen - width);;
        } else {
            this.upperLeft.setX(upperLeft.getX() + 10);
        }
    }


    /**
     * Checks whether there was a move command.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }
    /**
     * Draw the paddle.
     * @param d Object created object view.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(), (int) this.width, (int) this.height);
        d.setColor(this.colorLine);
        d.drawRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(), (int) this.width, (int) this.height);
    }

    /**
     * @return the rectangle of the block.
     */
    public Rectangle getCollisionRectangle() {
        Rectangle rect = new Rectangle(this.upperLeft, this.width, this.height);
        return rect;
    }
    /**
     * the method changing the velocity after collision in paddle.
     * Changes the angle of impact according to the area of
     * the paddle where the point of impact was.
     * @param collisionPoint the collision point.
     * @param currentVelocity the current velocity.
     * @param hitter the ball that hit.
     * @return The velocity of the ball after collision.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double part = this.width / 5;
        double ulX = this.upperLeft.getX();
        double collX = collisionPoint.getX();
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();

        //part 1.
        if (((collX > ulX) && (collX <= (ulX + part))
                || (collisionPoint.equals(this.getCollisionRectangle().getUl())))) {
            return Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
            //part 2.
        } else if ((collX > ulX + part) && (collX <= (ulX + (2 * part)))) {
            return Velocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
            //part 3.
        } else if ((collX > (ulX + (2 * part))) && (collX <= (ulX + (3 * part)))) {
            dy = dy * (-1);
            return new Velocity(dx, dy);
            //part 4.
        } else if ((collX > (ulX + (3 * part))) && (collX <= (ulX + (4 * part)))) {
            return Velocity.fromAngleAndSpeed(030, currentVelocity.getSpeed());
            //part 5.
        } else if (((collX > (ulX + (4 * part))) && (collX <= (ulX + (5 * part))))
                || (collisionPoint.equals(this.getCollisionRectangle().getUl()))) {
            return Velocity.fromAngleAndSpeed(060, currentVelocity.getSpeed());
        } else if ((collX > ulX + (5 * part)) || (collX < ulX)) {
            dx = dx * (-1);
            Velocity v = new Velocity(dx, dy);
            return v;
        } else {
            dy = dy * (-1);
            Velocity v = new Velocity(dx, dy);
            return v;
        }
    }

    /**
     * added the paddle to the list of sprites and collidable of the game.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}

