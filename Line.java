/**
 * ID 303080097
 */
import java.util.List;
/**
 * The class is responsible for the constructors and
 * actions related to a line object.
 */
public class Line {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private Point start;
    private Point end;
    // constructors.
    /**
     * @param  start The start point of the line.
     * @param  end The end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.x1 = start.getX();
        this.y1 = start.getY();
        this.x2 = end.getX();
        this.y2 = end.getY();
    }
    /**
     * @param  x1 The x value of start point.
     * @param  y1 The y value of start point.
     * @param  x2 The x value of end point.
     * @param  y2 The x value of end point.
     * */
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    // Return the length of the line.
    /**
     * @return the length of this line.
     * */
    public double length() {
        double dx = this.x2 - this.x1;
        double dy = this.y2 - this.y1;
        double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        return distance;
    }
    // Returns the middle point of the line.
    /**
     * @return the middle point of this line.
     * */
    public Point middle() {
        double middleX = ((this.x2 + this.x1) / 2);
        double middleY = ((this.y2 + this.y1) / 2);
        Point middleP = new Point(middleX, middleY);
        return middleP;
    }

    // Returns the start point of the line.
    /**
     * @return the start point of this line.
     * */
    public Point start() {
        return new Point(this.x1, this.y1);
    }

    // Returns the end point of the line.
    /**
     * @return the end point of this line.
     * */
    public Point end() {
        return new Point(this.x2, this.y2);
    }

    /**
     * @param  lx1 The x value of start point.
     * @param  ly1 The y value of start point.
     * @param  lx2 The x value of end point.
     * @param  ly2 The x value of end point.
     * @return the gradient of this line.
     * */
    public double gradient(double lx1, double ly1, double lx2, double ly2) {
        return ((ly2 - ly1) / (lx2 - lx1));
    }
    /**
     * @param  num1 Number
     * @param  num2 Number.
     * @return The min value between num1 & num2.
     * */
    public double min(double num1, double num2) {
        if (num1 < num2) {
            return num1;
        }
            return num2;
    }
    /**
     * @param  num1 Number
     * @param  num2 Number.
     * @return The max value between num1 & num2.
     * */
    public double max(double num1, double num2) {
        if (num1 > num2) {
            return num1;
        }
        return num2;
    }
    // Returns true if the lines intersect, false otherwise.
    /**
     * @param  other line other.
     * @return if have intersecting between this line and other line return true
     * else return false.
     * */
    public boolean isIntersecting(Line other) {

        if (intersectionWith(other) == null) {
            return false;
        }
        return true;
    }
    /**
     * the method call if the lines is converging.
     * @return if true if the line is converging.
     * */
    public boolean convergingLine() {
        return true;
    }
    // Returns the intersection point if the lines intersect,
    // and null otherwise.
    /**
     * @param  other line other.
     * @return if have intersecting between this line and other line return
     * the intersecting point, else return null.
     * */
    public Point intersectionWith(Line other) {
        double m1;
        double b1;
        double m2;
        double b2;
        double x;
        double y;
        Point intersection;

        double minThisY = min(this.y1, this.y2);
        double maxThisY = max(this.y1, this.y2);
        double minThisX = min(this.x1, this.x2);
        double maxThisX = max(this.x1, this.x2);
        double minOtherY = min(other.y1, other.y2);
        double maxOtherY = max(other.y1, other.y2);
        double minOtherX = min(other.x1, other.x2);
        double maxOtherX = max(other.x1, other.x2);

        //The rightmost point out of the leftmost point.
        double xStart = max(minThisX, minOtherX);
        //The leftmost point of the right-hand point
        double xEnd = min(maxThisX, maxOtherX);

        //The upper limit of the intersection point.
        double yStart = max(minThisY, minOtherY);
        //The lower limit of the intersection point.
        double yEnd = min(maxThisY, maxOtherY);

        //The lines are not in the same areas in the Y axis
        if ((minThisY > maxOtherY) || (minOtherY > maxThisY)) {
            return null;
        }
        //The lines are not in the same areas in the X axis
        if ((minThisX > maxOtherX) || (minOtherX > maxThisX)) {
            return null;
        }

        //Both lines are parallel to the y-axis and intersecting at the boundaries.
        if (((this.x1 == this.x2) && (other.x1 == other.x2)) && (xStart != xEnd)) {
            return null;
        } else if (((this.x1 == this.x2) && (other.x1 == other.x2)) && (xStart == xEnd)) {
            if ((this.y1 == other.y1) || (this.y1 == other.y2)) {
                y = this.y1;
            } else if ((this.y2 == other.y1) || (this.y2 == other.y2)) {
                y = this.y2;
            } else if (this.y1 == this.y2) {
                y = this.y1;
            } else if (other.y1 == other.y2) {
                y = other.y1;
            } else {
                return null;
            }
            intersection = new Point(xStart, y);
            return intersection;
        //"this" line parallel to the y-axis.
        } else if ((this.x1 == this.x2) && (other.x1 != other.x2)) {
            m2 = gradient(other.x1, other.y1, other.x2, other.y2);
            b2 = ((-(m2) * other.x1) + other.y1);
            x = this.x1;
            y = m2 * x + b2;
            if (((y >= yStart) && (y <= yEnd))
                    && ((x >= xStart) && (x <= xEnd))) {
                intersection = new Point(x, y);
                return intersection;
            } else {
                return null;
            }
        //"other" line parallel to the y-axis.
        } else if (other.x1 == other.x2) {
            m1 = gradient(this.x1, this.y1, this.x2, this.y2);
            b1 = ((-(m1) * this.x1) + this.y1);
            x = other.x1;
            y = m1 * x + b1;
            if (((y >= yStart) && (y <= yEnd))
                    && ((x >= xStart) && (x <= xEnd))) {
                intersection = new Point(x, y);
                return intersection;
            } else {
                return null;
            }
        }
        m1 = gradient(this.x1, this.y1, this.x2, this.y2);
        m2 = gradient(other.x1, other.y1, other.x2, other.y2);
        b1 = ((-(m1) * this.x1) + this.y1);
        b2 = ((-(m2) * other.x1) + other.y1);
        x = ((b2 - b1) / (m1 - m2));
        y = m1 * x + b1;

        //Both lines intersecting at the borders.
        if ((xStart == xEnd) && ((m1 * (xStart) + b1) == (m2 * (xStart) + b2))) {
            x = xStart;
            y = m1 * (xStart) + b1;
            intersection = new Point(x, y);
            return intersection;
        } else  if (yStart == yEnd) {
            intersection = new Point(x, yStart);
            return intersection;
            //Converging lines.
        } else if (((m1 * (xStart) + b1) == (m2 * (xStart) + b2))) {
            convergingLine();
            return null;
            //Parallel lines.
        } else if ((m1 == m2) || (m1 == -m2)) {
            return null;
            //Out of range.
        } else if ((x < xStart) || (x > xEnd)) {
            return null;
        }
        intersection = new Point(x, y);
        return intersection;
    }
    // equals -- return true is the lines are equal, false otherwise.
    /**
     * @param  other line other.
     * @return true if this line and other line is a same line.
     * */
    public boolean equals(Line other) {
        Point otherStart = new Point(other.x1, other.y1);
        Point otherEnd = new Point(other.x2, other.y2);
        if ((this.start.equals(otherStart)) && (this.end.equals(otherEnd))) {
            return true;
        }
        return false;
    }
    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.
    /**
     * @param  rect rectangle.
     * @return If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     * */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {

        Line line = new Line(this.start, this.end);
        List<Point> pointList = rect.intersectionPoints(line);
        //if this line is a line of rectangle.
       if (line.equals(rect.getLineDown())) {
            return null;
        } else if (line.equals(rect.getLineUp())) {
            return null;
        } else if (line.equals(rect.getLineLeft())) {
            return null;
        } else if (line.equals(rect.getLineRight())) {
            return null;
        }
        if (pointList.isEmpty()) {
            return null;
        } else if (pointList.size() == 1) {
            //converging line.
            if ((rect.getLineUp().start.equals(pointList.get(0)))
                || (rect.getLineUp().end.equals(pointList.get(0)))
                || (rect.getLineDown().start.equals(pointList.get(0)))
                || (rect.getLineDown().end.equals(pointList.get(0)))) {
                return null;
            } else {
                return rect.intersectionPoints(line).get(0);
            }
        } else if (rect.intersectionPoints(line).get(0).distance(this.start)
                > rect.intersectionPoints(line).get(1).distance(this.start)) {
            return rect.intersectionPoints(line).get(1);
        } else {
            return rect.intersectionPoints(line).get(0);
        }
    }
}