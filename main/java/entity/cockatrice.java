package entity;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.custom.CustomEntity;
import cn.nukkit.entity.custom.CustomEntityDefinition;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import AI.MosterEntityAI;

public class cockatrice extends MosterEntityAI implements CustomEntity{
    @Override
    public String getOriginalName() {
        return "cockatrice";
    }
    public cockatrice(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }
    public final static CustomEntityDefinition def = CustomEntityDefinition.builder().identifier("mlcs:cockatrice")
            .summonable(true)
            .spawnEgg(false)
            .build();
    public float getHeight() {
        return 2.9f;
    }

    @Override
    public float getWidth() {
        return 0.9f;
    }

    @Override
    protected void initEntity() {
        this.setMaxHealth(20);
        this.diffHandDamage = new float[]{2.5f, 3f, 4.5f};

        super.initEntity();
    }
    @Override
    public int getNetworkId() {
        return Entity.NETWORK_ID;
    }

    @Override
    public CustomEntityDefinition getDefinition() {
        return def;
    }






}
