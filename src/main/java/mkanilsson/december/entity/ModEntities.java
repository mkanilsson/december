package mkanilsson.december.entity;

import mkanilsson.december.December;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.SpiderEyesFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {
    private static final RegistryKey<EntityType<?>> BIB_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE,
            Identifier.of(December.MOD_ID, "bib"));

    public static final EntityType<BibEntity> BIB = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(December.MOD_ID, "bib"),
            EntityType.Builder.create(BibEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1.4f, 0.9f).eyeHeight(0.65F).passengerAttachments(new float[] { 0.765F })
                    .maxTrackingRange(8).build(BIB_KEY));

    private static final RegistryKey<EntityType<?>> HASSE_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE,
            Identifier.of(December.MOD_ID, "hasse"));

    public static final EntityType<HasseEntity> HASSE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(December.MOD_ID, "hasse"),
            EntityType.Builder.create(HasseEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1.4f, 0.9f).eyeHeight(0.65F).passengerAttachments(new float[] { 0.765F })
                    .maxTrackingRange(8).build(HASSE_KEY));

    public static void registerModEntites() {
        December.LOGGER.info("Registering mod entities");

        FabricDefaultAttributeRegistry.register(BIB, BibEntity.createSpiderAttributes());
        EntityRendererRegistry.register(BIB, BibEntityRenderer::new);

        FabricDefaultAttributeRegistry.register(HASSE, HasseEntity.createSpiderAttributes());
        EntityRendererRegistry.register(HASSE, HasseEntityRenderer::new);
    }
}

class BibEntityRenderer<T extends SpiderEntity>
        extends MobEntityRenderer<T, LivingEntityRenderState, SpiderEntityModel> {
    private static final Identifier TEXTURE = Identifier.of(December.MOD_ID, "textures/entity/bib/bib.png");

    public BibEntityRenderer(EntityRendererFactory.Context context) {
        this(context, EntityModelLayers.SPIDER);
    }

    public BibEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer layer) {
        super(ctx, new SpiderEntityModel(ctx.getPart(layer)), 0.8F);
        this.addFeature(new SpiderEyesFeatureRenderer(this));
    }

    protected float getLyingPositionRotationDegrees() {
        return 180.0F;
    }

    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE;
    }

    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    public void updateRenderState(T spiderEntity, LivingEntityRenderState livingEntityRenderState, float f) {
        super.updateRenderState(spiderEntity, livingEntityRenderState, f);
    }
}

class HasseEntityRenderer<T extends SpiderEntity>
        extends MobEntityRenderer<T, LivingEntityRenderState, SpiderEntityModel> {
    private static final Identifier TEXTURE = Identifier.of(December.MOD_ID, "textures/entity/hasse/hasse.png");

    public HasseEntityRenderer(EntityRendererFactory.Context context) {
        this(context, EntityModelLayers.SPIDER);
    }

    public HasseEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer layer) {
        super(ctx, new SpiderEntityModel(ctx.getPart(layer)), 0.8F);
        this.addFeature(new SpiderEyesFeatureRenderer(this));
    }

    protected float getLyingPositionRotationDegrees() {
        return 180.0F;
    }

    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE;
    }

    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    public void updateRenderState(T spiderEntity, LivingEntityRenderState livingEntityRenderState, float f) {
        super.updateRenderState(spiderEntity, livingEntityRenderState, f);
    }
}
