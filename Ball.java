/**
 * ID 303080097
 */

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The class is responsible for the constructors and
 * actions related to a ball object.
 */
public class Ball implements Sprite {
    private Point center;
    private int radius;
    private Color color;
    private Color colorLine;
    private Velocity velocity;
    private GameEnvironment environment;
    private GameLevel game;

    /**
     * constructor.
     *
     * @param center The center point of the circle.
     * @param r      The radius of the circle.
     * @param color  The color of the circle.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
    }

    /**
     * @param center      The center point of the circle.
     * @param r           The radius of the circle.
     * @param color       The color of the circle.
     * @param v           velocity of the ball.
     * @param environment the environment game of the ball.
     * @param game        the game of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color, Velocity v, GameEnvironment environment, GameLevel game) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.velocity = v;
        this.environment = environment;
        this.game = game;
    }
    /**
     * @param center      The center point of the circle.
     * @param r           The radius of the circle.
     * @param color       The color of the circle.
     * @param v           velocity of the ball.
     * @param colorLine   the color the line of rhe ball.
     */
    public Ball(Point center, int r, Velocity v, java.awt.Color color, java.awt.Color colorLine) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.velocity = v;
        this.colorLine = colorLine;
    }
    /**
     * constructor.
     *
     * @param gEnvironment the environment game of the ball.
     */
    public void setEnvironment(GameEnvironment gEnvironment) {
        this.environment = gEnvironment;
    }

    /**
     * constructor.
     *
     * @param game1 the game of the ball.
     */
    public void setGame(GameLevel game1) {
        this.game = game1;
    }

    /**
     * @param x     The x value of the circle center point.
     * @param y     The y value of the circle center point.
     * @param r     The radius of the circle.
     * @param color The color of the circle.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
    }

    /**
     * @param x     The x value of the circle center point.
     * @param y     The y value of the circle center point.
     * @param r     The radius of the circle.
     * @param color The color of the circle.
     * @param dx    Horizontal speed of the ball.
     * @param dy    Vertical speed of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color, double dx, double dy) {
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * @param x     The x value of the circle center point.
     * @param y     The y value of the circle center point.
     * @param r     The radius of the circle.
     * @param color The color of the circle.
     * @param v     velocity of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color, Velocity v) {
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
        this.velocity = v;
    }

    // accessors

    /**
     * @return The x value of the circle center point.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * @return The y value of the circle center point.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return The radius value of the circle.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * @return The color value of the circle.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * @param v The velocity value of the circle.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * @param dx Horizontal speed of the ball.
     * @param dy Vertical speed of the ball.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * @return The velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * @param minWidth  Left border of the board.
     * @param maxWidth  Right border of the board.
     * @param minHeight Up border of the board.
     * @param maxHeight Down border of the board.
     */
    public void moveOneStep(int minWidth, int maxWidth, int minHeight, int maxHeight) {

        if ((this.center.getX() + radius + velocity.getDx()) >= (maxWidth)) {
            setVelocity((velocity.getDx() * (-1)), velocity.getDy());
        } else if ((this.center.getX() - radius + velocity.getDx()) <= (minWidth)) {
            setVelocity((velocity.getDx() * (-1)), velocity.getDy());
        } else if ((this.center.getY() + radius + velocity.getDy()) >= (maxHeight)) {
            setVelocity(velocity.getDx(), (velocity.getDy() * (-1)));
        } else if ((this.center.getY() - radius + velocity.getDy()) <= (minHeight)) {
            setVelocity(velocity.getDx(), (velocity.getDy() * (-1))); // velocity.dy = velocity.dy * (-1);
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * This method move step and change the velocity if have a hit.
     */
    public void moveOneStep() {
        double endX = 0;
        double endY = 0;
        double radiusX = radius;
        double radiusY = radius;
        double relativeRX = radius;
        double relativeRY = radius;

        //the relative effect of the radius
        radiusX = Math.abs(this.radius * Math.sin(Math.toRadians(velocity.getAngle())));
        radiusY = Math.abs(this.radius * Math.cos(Math.toRadians(velocity.getAngle())));
        if (velocity.getDx() < 0) {
            radiusX = radiusX * (-1);
            relativeRX = relativeRX * (-1);
        }
        if (velocity.getDy() < 0) {
            radiusY = radiusY * (-1);
            relativeRY = relativeRY * (-1);
        }
        // the value of the end point of the line trajectory.
        endX = this.center.getX() + velocity.getDx() + radiusX;
        endY = this.center.getY() + velocity.getDy() + radiusY;
        Point endPoint = new Point(endX, endY);
        //line starting at current location, and ending where the
        // velocity will take the ball if no collisions will occur.
        Line trajectory = new Line(this.center, endPoint);
        CollisionInfo hitInfo = this.environment.getClosestCollision(trajectory);
        if (hitInfo == null) {
            moveSimpleStep();
            return;
        } else {
            //is a hit.
            //Approaches the ball to the point of impact
            // and changes the direction of the ball's progress
            moveOneStep(hitInfo.collisionPoint(), radiusX, radiusY);
            setVelocity(hitInfo.collisionObject().hit(this, hitInfo.collisionPoint(), this.velocity));
        }
    }

    /**
     * make move one step.
     */
    public void moveSimpleStep() {
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * @param collisionPoint the collision point.
     * @param radiusX        the relative effect of the radius on x axis.
     * @param radiusY        the relative effect of the radius on y axis.
     */
    public void moveOneStep(Point collisionPoint, double radiusX, double radiusY) {
        this.center = new Point(collisionPoint.getX() - radiusX, collisionPoint.getY() - radiusY);
    }

    /**
     * Draw the circle.
     *
     * @param surface Object created object view.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(getColor());
        surface.fillCircle(getX(), getY(), getSize());
        surface.setColor(this.colorLine);
        surface.drawCircle(getX(), getY(), getSize());
    }

    @Override
    /**
     * Perform actions between each movement.
     */
    public void timePassed() {
        moveOneStep();
    }

    /**
     * added the ball to the list of sprites of the game.
     *
     * @param g the game of the ball.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
    /**
     * remove the ball from the list of sprites of the game.
     *
     * @param g the game of the ball.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}



