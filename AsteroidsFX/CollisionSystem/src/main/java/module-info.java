import dk.sdu.cbse.collision.CollisionDetection;
import dk.sdu.cbse.common.IEntityPostProcessing;

module CollisionSystem {
    requires Common;

    provides IEntityPostProcessing with CollisionDetection;
}