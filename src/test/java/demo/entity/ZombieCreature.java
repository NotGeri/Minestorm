package demo.entity;

import net.minestorm.server.entity.EntityCreature;
import net.minestorm.server.entity.EntityType;
import net.minestorm.server.entity.ai.EntityAIGroupBuilder;
import net.minestorm.server.entity.ai.goal.RandomLookAroundGoal;

public class ZombieCreature extends EntityCreature {

    public ZombieCreature() {
        super(EntityType.ZOMBIE);
        addAIGroup(
                new EntityAIGroupBuilder()
                        .addGoalSelector(new RandomLookAroundGoal(this, 20))
                        .build()
        );
    }
}
