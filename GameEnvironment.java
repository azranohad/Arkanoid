/**
 * ID 303080097
 */
import java.util.List;
import java.util.ArrayList;
/**
 * The class is responsible for the constructors and
 * actions related to a GameEnvironment object.
 */
public class GameEnvironment {
    private List<Collidable> collidables;
    /**
     * constructor new collidable list.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    /**
     * constructor new collidable list.
     * @param collidables list of collidables.
     */
    public GameEnvironment(List<Collidable> collidables) {
        this.collidables = collidables;
    }
    /**
     * add the given collidable to the environment.
     * @param c the collidable added.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }
    /**
     * remove collidable from this game.
     * @param c the collidable that remove.
     */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }

    /**
     * clear the list of collidable.
     */
    public void removeAllCollidable() {
        collidables.clear();
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     * @param trajectory the next ball motion vector.
     * @return if have a hit, return the collision info.
     * */
    public CollisionInfo getClosestCollision(Line trajectory) {
        int counter = 0;
        CollisionInfo tempCollInfo = new CollisionInfo(null, null);
        CollisionInfo closestColInfo = new CollisionInfo(null, null);
        List<Collidable> collidablesList = new ArrayList<>(this.collidables);
        for (Collidable i : collidables) {
            if (collidables.size() == 0) {
                return null;
            }
            Point tempPoint = trajectory.closestIntersectionToStartOfLine(i.getCollisionRectangle());
            Collidable tempObj = i;

            if (tempPoint == null) {
                continue;
                //is a hit
            } else {
                counter++;
                tempCollInfo.setPointCollision(tempPoint);
                //this the first collision point.
                if (closestColInfo.collisionPoint() == null) {
                    closestColInfo.setPointCollision(tempPoint);
                    closestColInfo.setObjCollision(tempObj);
                    //check if the new collision point closer.
                } else if (closestColInfo.collisionPoint().distance(trajectory.start())
                        > tempCollInfo.collisionPoint().distance(trajectory.start())) {
                    closestColInfo.setPointCollision(tempPoint);
                    closestColInfo.setObjCollision(tempObj);
                }
            }
            tempPoint = null;
        }
        if (counter > 0) {
            return closestColInfo;
        }
        return null;
    }
}

