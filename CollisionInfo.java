/**
 * ID 303080097
 */

/**
 * The class is responsible for the constructors and
 * actions related to a Collision info object.
 * the collision info object including the point collision
 * and the object collision.
 */
public class CollisionInfo {
    private Point pointCollision;
    private Collidable objCollision;
    /**
     * constructor.
     * @param pointCollision the collision point.
     * @param objCollision the object of the ball hit them.
     */
    public CollisionInfo(Point pointCollision, Collidable objCollision) {
        this.pointCollision = pointCollision;
        this.objCollision = objCollision;
    }
    /**
     * set the collision point.
     * @param pointColl the collision point.
     */
     public void setPointCollision(Point pointColl) {
        this.pointCollision = pointColl;
     }
    /**
     * set the object collision.
     * @param objColl the object collision.
     */
     public void setObjCollision(Collidable objColl) {
        this.objCollision = objColl;
     }
    /**
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.pointCollision;
    }
    /**
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.objCollision;
    }
}
