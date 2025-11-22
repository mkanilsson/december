package mkanilsson.december.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.world.World;

public class BibEntity extends SpiderEntity {
    public BibEntity(EntityType<? extends SpiderEntity> entityType, World world) {
        super(entityType, world);
    }
}

