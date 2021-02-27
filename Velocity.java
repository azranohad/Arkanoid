/**
 * ID 303080097
 */

/**
 * The class is responsible for the constructors and
 * actions related to a velocity object.
 */
// Velocity specifies the change in position on the `x` and the `y` axes.
public class Velocity {

    private double dx;
    private double dy;
    /**
     * @param  dx Horizontal speed of the ball.
     * @param  dy Vertical speed of the ball.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * @return The angle value of the velocity.
     */
    public double getAngle() {
        double angle = Math.toDegrees(Math.asin(this.dx / getSpeed()));
        return angle;
    }
    /**
     * @return The speed value of the velocity.
     */
    public double getSpeed() {
        double speed = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        return speed;
    }

    /**
     * @param  angle The angle of the velocity vector.
     * @param  speed The speed of the velocity vector.
     * @return dx = Horizontal speed of the ball.
     *         dy = Vertical speed of the ball.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = (-1) * (speed * Math.cos(Math.toRadians(angle)));
        return new Velocity(dx, dy);
    }
    /**
     * @return this dx = Horizontal speed of the ball.
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * @return this dy = Horizontal speed of the ball.
     */
    public double getDy() {
        return this.dy;
    }
    /**
     * @param  other other velocity.
     * @return true if this velocity and other velocity is a same velocity.
     * */
    public boolean equals(Velocity other) {
        if ((this.getDx() == other.getDx()) && (this.getDy() == other.getDy())) {
            return true;
        }
        return false;
    }
    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    /**
     * @param  p Current center point circle.
     * @return The center point of the circle to one movement
     */
    public Point applyToPoint(Point p) {
        Point move = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return move;
    }
}