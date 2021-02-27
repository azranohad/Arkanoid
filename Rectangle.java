/**
 * ID 303080097
 */

import java.util.ArrayList;

/**
 * The class is responsible for the constructors and
 * actions related to a rectangle object.
 */
public class Rectangle {
    private Point ul, ur, dr, dl;
    private Line lineUp, lineDown, lineRight, lineLeft;
    private double width;
    private double height;
    private Point upperLeft;

    /**
     * Create a rectangle for drawing points from.
     *
     * @param upperLeft the upper left point of the rectangle.
     * @param width the width of the rectangle.
     * @param height the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.ul = upperLeft;
        this.ur = new Point(upperLeft.getX() + width, upperLeft.getY());
        this.dr = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        this.dl = new Point(upperLeft.getX(), upperLeft.getY() + height);

        this.lineUp = new Line(ul, ur);
        this.lineDown = new Line(dl, dr);
        this.lineRight = new Line(ur, dr);
        this.lineLeft = new Line(ul, dl);
    }

    /**
     * @param line other line.
     * @return   list of all intersection points between another
     * straight and this rectangle.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        ArrayList<Point> intersectionPoint = new ArrayList<Point>(2);

        if ((lineUp.intersectionWith(line)) != null) {
            intersectionPoint.add(lineUp.intersectionWith(line));
        }
        if ((lineDown.intersectionWith(line)) != null) {
            intersectionPoint.add(lineDown.intersectionWith(line));
        }
        if ((lineLeft.intersectionWith(line)) != null) {
            intersectionPoint.add(lineLeft.intersectionWith(line));
        }
        if ((lineRight.intersectionWith(line)) != null) {
            intersectionPoint.add(lineRight.intersectionWith(line));
        }
        return intersectionPoint;
    }
    /**
     * checks whether the list of intersection points is empty.
     * @param line other line.
     * @return  true if the list is empty, else return false.
     */
    public boolean intersectionListEmp(Line line) {
        if (intersectionPoints(line).isEmpty()) {
            return true;
        }
        return false;

    }
    /**
     * @return this lineup of rectangle.
     */
    public Line getLineUp() {
        return this.lineUp;
    }
    /**
     * @return this linedown of rectangle.
     */
    public Line getLineDown() {
        return this.lineDown;
    }
    /**
     * @return this lineright of rectangle.
     */
    public Line getLineRight() {
        return this.lineRight;
    }
    /**
     * @return this lineleft of rectangle.
     */
    public Line getLineLeft() {
        return this.lineLeft;
    }
    /**
     * @return this DR point of rectangle.
     */
    public Point getDr() {
        return this.dr;
    }
    /**
     * @return this UL point of rectangle.
     */
    public Point getUl() {
        return this.ul;
    }
    /**
     * @return this UR point of rectangle.
     */
    public Point getUr() {
        return this.ur;
    }
    /**
     * @return this DL point of rectangle.
     */
    public Point getDl() {
        return this.dl;
    }

    /**
     * @return the width of rectangle.
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * @return the height of rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}


