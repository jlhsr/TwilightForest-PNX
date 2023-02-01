package entity;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.custom.CustomEntity;
import cn.nukkit.entity.custom.CustomEntityDefinition;
import cn.nukkit.entity.data.FloatEntityData;
import cn.nukkit.level.Sound;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import AI.NatureEntityAI;

public class wild_deer extends NatureEntityAI implements CustomEntity {
    @Override
    public float getWidth() {
        return 0.6f;
    }

    @Override
    public float getHeight() {
        return 1.9f;
    }
    public final static CustomEntityDefinition def = CustomEntityDefinition.builder().identifier("twilightforest:wild_deer")
            .summonable(true)
            .spawnEgg(false)
            .build();

    public wild_deer(FullChunk chunk, CompoundTag nbt) {
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
        return "minotaur_death";
    }


    public void setAmbientSoundInterval(float interval) {
        this.setDataProperty(new FloatEntityData(DATA_AMBIENT_SOUND_INTERVAL, 1f));
    }
    @Override
    public void setAmbientSoundEvent(Sound sound) {
        this.setAmbientSoundEventName("mob.raven.idle");
    }


    public void setAmbientSoundIntervalRange(float range) {
        this.setDataProperty(new FloatEntityData(DATA_AMBIENT_SOUND_INTERVAL_RANGE, 10f));
    }

}

