package entity;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.custom.CustomEntity;
import cn.nukkit.entity.custom.CustomEntityDefinition;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import AI.NatureEntityAI;

public class squirrel extends NatureEntityAI implements CustomEntity {
    @Override
    public float getWidth() {
        return 0.5f;
    }

    @Override
    public float getHeight() {
        return 0.5f;
    }
    public final static CustomEntityDefinition def = CustomEntityDefinition.builder().identifier("twilightforest:squirrel")
            .summonable(true)
            .spawnEgg(false)
            .build();

    public squirrel(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public int getNetworkId() {
        return Entity.NETWORK_ID;
    }


    @Override
    protected void initEntity() {
        this.setMaxHealth(20);
        super.initEntity();
    }


    @Override
    public CustomEntityDefinition getDefinition() {
        return def;
    }

    @Override
    public String getOriginalName() {
        return "twilightforest:squirrel";
    }
}

