package otherentity;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.custom.CustomEntity;
import cn.nukkit.entity.custom.CustomEntityDefinition;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import AI.MosterEntityAI;

public class mimic extends MosterEntityAI implements CustomEntity {



    @Override
    public float getWidth() {
        return 1.0f;
    }

    @Override
    public float getHeight() {
        return 1.0f;
    }


    public final static CustomEntityDefinition def = CustomEntityDefinition.builder().identifier("sc:mimic")
            .summonable(true)
            .spawnEgg(true)
            .build();

    public mimic(FullChunk chunk, CompoundTag nbt) {
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
        this.diffHandDamage = new float[]{4.5f, 5f, 6.5f};
        super.initEntity();
    }
    @Override
    public String getOriginalName() {
        return "minotaur_death";
    }

    public float AttackRunSpeed (){
        return 1.9f;
    }





}

