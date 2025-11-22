package mkanilsson.december.entity;

import java.util.Random;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class HasseEntity extends SpiderEntity {
    public HasseEntity(EntityType<? extends SpiderEntity> entityType, World world) {
        super(entityType, world);
    }
}
