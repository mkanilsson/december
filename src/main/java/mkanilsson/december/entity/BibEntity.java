package mkanilsson.december.entity;

import java.util.Random;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class BibEntity extends SpiderEntity {
    public BibEntity(EntityType<? extends SpiderEntity> entityType, World world) {
        super(entityType, world);
    }

    public static boolean canSpawnBib(EntityType<BibEntity> type, WorldAccess world,
            SpawnReason spawnReason, BlockPos pos, Random random) {
        return canMobSpawn(type, world, spawnReason, pos, random);
    }

    public static boolean canMobSpawn(EntityType<? extends SpiderEntity> type, WorldAccess world,
            SpawnReason spawnReason,
            BlockPos pos, Random random) {
        BlockPos blockPos = pos.down();
        return SpawnReason.isAnySpawner(spawnReason)
                || world.getBlockState(blockPos).allowsSpawning(world, blockPos, type);
    }
}
