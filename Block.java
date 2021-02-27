/**
 * ID 303080097
 */

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
//import biuoop.DrawSurface;

/**
 * The class is responsible for the constructors and
 * actions related to a block object.
 */
public class Block implements Sprite, Collidable, HitNotifier {

    private Point upperLeft;
    private double width;
    private double height;
    private Color color;
    private Color colorLine;
    private List<HitListener> hitListeners;

    /**
     * constructor.
     * @param upperLeft the upper left point of the block.
     * @param width the width of the block.
     * @param height the height of the block.
     */
    public  Block(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.hitListeners = new ArrayList<HitListener>();
    }
    /**
     * constructor.
     * @param rect the rectangle data of the block.
     */
    public Block(Rectangle rect) {
        this.upperLeft = rect.getUpperLeft();
        this.width = rect.getWidth();
        this.height = rect.getHeight();
        this.hitListeners = new ArrayList<HitListener>();
    }
    /**
     * constructor.
     * @param upperLeft the upper left point of the block.
     * @param width the width of the block.
     * @param height the height of the block.
     * @param color color of the block.
     */
    public Block(Point upperLeft, double width, double height, Color color) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }
    /**
     * constructor.
     * @param upperLeft the upper left point of the block.
     * @param width the width of the block.
     * @param height the height of the block.
     * @param color color of the block.
     * @param colorLine the color the line of rhe block.
     */
    public Block(Point upperLeft, double width, double height, Color color, Color colorLine) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.color = color;
        this.colorLine = colorLine;
        this.hitListeners = new ArrayList<HitListener>();
    }
    /**
     * constructor.
     * @param x the x value of the upper left point of the block.
     * @param y the y value of the upper left point of the block.
     * @param width the width of the block.
     * @param height the height of the block.
     * @param color color of the block.
     * @param colorLine the color the line of rhe block.
     */
    public Block(double x, double y, double width, double height, Color color, Color colorLine) {
        this.upperLeft = new Point(x, y);
        this.width = width;
        this.height = height;
        this.color = color;
        this.colorLine = colorLine;
        this.hitListeners = new ArrayList<HitListener>();
    }
    /**
     * set the color of the block.
     * @param color1 the color of the block.
     */
    public void setColor(Color color1) {
        this.color = color1;
    }
    /**
     * set the list of the HitListeners.
     */
    public void setHitListeners() {
        this.hitListeners = new ArrayList<HitListener>(); }
    /**
     * @return The color value of the block.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * @return the rectangle of the block.
     */
    public Rectangle getCollisionRectangle() {
        Rectangle rect = new Rectangle(this.upperLeft, this.width, this.height);
        return rect;
    }

    /**
     * @param v the current velocity.
     * @return The velocity of the ball after collision in a ul point.
     */
    public Velocity hitUL(Velocity v) {
        double dx = v.getDx();
        double dy = v.getDy();
        if ((v.getDx() >= 0) && (v.getDy() >= 0)) {
            return hitOpenCornerPoint(v);
            //from inside the block.
        } else if ((v.getDx() <= 0) && (v.getDy() <= 0)) {
            dy = dy * (-1);
            dx = dx * (-1);
        } else if ((v.getDx() >= 0) && (v.getDy() <= 0)) {
            dx = dx * (-1);
            return new Velocity(dx, dy);
        } else if ((v.getDx() <= 0) && (v.getDy() >= 0)) {
            dy = dy * (-1);
            return new Velocity(dx, dy);
        }
        return new Velocity(dx, dy);
    }
    /**
     * @param v the current velocity.
     * @return The velocity of the ball after collision in a ur point.
     */
    public Velocity hitUR(Velocity v) {
        double dx = v.getDx();
        double dy = v.getDy();



        if ((v.getDx() <= 0) && (v.getDy() >= 0)) {
            return hitOpenCornerPoint(v);
            //from inside the block.
        } else if ((v.getDx() >= 0) && (v.getDy() <= 0)) {
            dy = dy * (-1);
            dx = dx * (-1);
            return new Velocity(dx, dy);
        } else if ((v.getDx() >= 0) && (v.getDy() >= 0)) {
            dy = dy * (-1);
            return new Velocity(dx, dy);
        } else if ((v.getDx() <= 0) && (v.getDy() <= 0)) {
            dx = dx * (-1);
            return new Velocity(dx, dy);
        }
        return new Velocity(dx, dy);
    }
    /**
     * @param v the current velocity.
     * @return The velocity of the ball after collision in a dr point.
     */
    public Velocity hitDR(Velocity v) {
        double dx = v.getDx();
        double dy = v.getDy();



        if ((v.getDx() <= 0) && (v.getDy() <= 0)) {
            return hitOpenCornerPoint(v);
            //from inside the block.
        } else if ((v.getDx() >= 0) && (v.getDy() >= 0)) {
            dy = dy * (-1);
            dx = dx * (-1);
            return new Velocity(dx, dy);
        } else if ((v.getDx() >= 0) && (v.getDy() <= 0)) {
            dy = dy * (-1);
            return new Velocity(dx, dy);
        } else if ((v.getDx() <= 0) && (v.getDy() >= 0)) {
            dx = dx * (-1);
            return new Velocity(dx, dy);
        }
        return new Velocity(dx, dy);
    }
    /**
     * @param v the current velocity.
     * @return The velocity of the ball after collision in a dl point.
     */
    public Velocity hitDL(Velocity v) {
        double dx = v.getDx();
        double dy = v.getDy();
        if ((v.getDx() >= 0) && (v.getDy() <= 0)) {
            return hitOpenCornerPoint(v);
            //from inside the block.
        } else if ((v.getDx() <= 0) && (v.getDy() >= 0)) {
            dy = dy * (-1);
            dx = dx * (-1);
            return new Velocity(dx, dy);
        } else if ((v.getDx() >= 0) && (v.getDy() >= 0)) {
            dx = dx * (-1);
            return new Velocity(dx, dy);
        } else if ((v.getDx() <= 0) && (v.getDy() <= 0)) {
            dy = dy * (-1);
            return new Velocity(dx, dy);
        }
        return new Velocity(dx, dy);
    }
    /**
     * @param v the current velocity.
     * @return The velocity of the ball after collision in a corner
     * and the ball arrival from open corner.
     */
    public Velocity hitOpenCornerPoint(Velocity v) {
        double dx = v.getDx();
        double dy = v.getDy();
        double dxAbs = Math.abs(dx);
        double dyAbs = Math.abs(dy);

        if (dxAbs > dyAbs) {
            dx = dx * (-1);
        } else if (dxAbs < dyAbs) {
            dy = dy * (-1);
        } else {
            dy = dy * (-1);
            dx = dx * (-1);
        }
        return new Velocity(dx, dy);
    }

    /**
     * Goes through the entire list of listeners and performs
     * the actions required for each object after an hit.
     * @param hitter the ball is a hit.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        if (this.hitListeners != null) {
            List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
            for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
            }
        }
    }
        /**
     * the method changing the velocity after collision in collidable.
     * @param collisionPoint the collision point.
     * @param currentVelocity the current velocity.
     * @param hitter the ball that hit.
     * @return The velocity of the ball after collision.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();

        if (collisionPoint.equals(getCollisionRectangle().getUl())) {
            return hitUL(currentVelocity);
        } else if (collisionPoint.equals(getCollisionRectangle().getUr())) {
            return hitUR(currentVelocity);
        } else if (collisionPoint.equals(getCollisionRectangle().getDr())) {
            return hitDR(currentVelocity);
        } else if (collisionPoint.equals(getCollisionRectangle().getDl())) {
            return hitDL(currentVelocity);
        } else if ((collisionPoint.getX() == getCollisionRectangle().getUl().getX())
                || (collisionPoint.getX() == getCollisionRectangle().getUr().getX())) {
            dx = dx * (-1);
            return new Velocity(dx, dy);
        } else if ((collisionPoint.getY() == getCollisionRectangle().getUl().getY())
                || (collisionPoint.getY() == getCollisionRectangle().getDr().getY())) {
            dy = dy * (-1);
            return new Velocity(dx, dy);
        }
        return new Velocity(dx, dy);
    }
    /**
     * Draw the block.
     * @param surface Object created object view.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(getColor());
        surface.fillRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(),
                (int) this.width, (int) this.height);
        surface.setColor(this.colorLine);
        surface.drawRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(),
                (int) this.width, (int) this.height);
    }

    @Override
    /**
     * Perform actions between each movement.
     */
    public void timePassed() {

    }
    /**
     * added the block to the list of sprites and collidable of the game.
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * remove this block from the list of sprites and collidable of the game.
     * @param g the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeCollidable(this);
        g.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {

    }

}
