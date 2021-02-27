/**
 * ID 303080097
 */

/**
 * the interface of the Collidables.
 */
public interface Collidable {


    /**
     * @return  the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();


    /**
     * @param collisionPoint the collision point.
     * @param currentVelocity the current velocity.
     * @param hitter the ball that hit.
     * @return  is the new velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}