package entity;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.custom.CustomEntity;
import cn.nukkit.entity.custom.CustomEntityDefinition;
import cn.nukkit.entity.mob.EntityMob;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

import java.util.Set;

public class firefly extends EntityMob implements CustomEntity {



    @Override
    public float getWidth() {
        return 0.6f;
    }

    @Override
    public float getHeight() {
        return 1.0f;
    }


    public final static CustomEntityDefinition def = CustomEntityDefinition.builder().identifier("twilightforest:firefly")
            .summonable(true)
            .spawnEgg(true)
            .build();

    public firefly(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public int getNetworkId() {
        return Entity.NETWORK_ID;
    }

    @Override
    public CustomEntityDefinition getDefinition() {
        return def;
    }
    @Override
    protected void initEntity() {
        this.setMaxHealth(20);
        super.initEntity();
    }
    @Override
    public String getOriginalName() {
        return "firefly";
    }






}

