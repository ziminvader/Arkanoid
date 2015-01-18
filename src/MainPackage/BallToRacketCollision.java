package MainPackage;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.AdvanceCollisionGroup;
import static com.golden.gamedev.object.collision.CollisionGroup.BOTTOM_TOP_COLLISION;
import static com.golden.gamedev.object.collision.CollisionGroup.LEFT_RIGHT_COLLISION;
import static com.golden.gamedev.object.collision.CollisionGroup.RIGHT_LEFT_COLLISION;
import static com.golden.gamedev.object.collision.CollisionGroup.TOP_BOTTOM_COLLISION;

public class BallToRacketCollision extends AdvanceCollisionGroup {
    @Override
    public void collided(Sprite s1, Sprite s2)
    {
        if (getCollisionSide() == TOP_BOTTOM_COLLISION || getCollisionSide() == BOTTOM_TOP_COLLISION)
        {
            s1.setSpeed(s1.getVerticalSpeed() * -1, s1.getHorizontalSpeed());
        }
        if (getCollisionSide() == LEFT_RIGHT_COLLISION || getCollisionSide() == RIGHT_LEFT_COLLISION)
        {
            s1.setSpeed(s1.getVerticalSpeed(), s1.getHorizontalSpeed() * -1);
        }
    }
}
