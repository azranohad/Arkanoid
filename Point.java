/**
 * ID 303080097
 */

/**
 * The class is responsible for the constructors and
 * actions related to a point object.
 */

public class Point {
    private double x;
    private double y;

    // constructor
    /**
     * @param  x The x value of the point.
     * @param  y The y value of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * @param xp set the x value of the point.
     */
    public void setX(double xp) {
        this.x = xp;
    }
    /**
     * @param yp set the y value of the point.
     */
    public void setY(double yp) {
        this.y = yp;
    }

    /**
     * @return the x value of this point.
     * */
    public double getX() {
        return this.x;
    }
    /**
     * @return the y value of this point.
     * */
    public double getY() {
        return this.y;
    }

    /**
     * @param  other  other point.
     * @return The distance between this line and other line.
     */
    public double distance(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        return distance;
    }
    /**
     * @param  other  other point.
     * @return True is the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        double epsilon = Math.pow(10, -10);
        if ((Math.abs(this.x - other.x)) < epsilon && (Math.abs(this.y - other.y) < epsilon)) {
            return true;
        }
        return false;
    }
}