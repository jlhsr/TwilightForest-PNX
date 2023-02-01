package otherentity;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.custom.CustomEntity;
import cn.nukkit.entity.custom.CustomEntityDefinition;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import AI.MosterEntityAI;

public class troblin extends MosterEntityAI implements CustomEntity {



    @Override
    public float getWidth() {
        return 0.6f;
    }

    @Override
    public float getHeight() {
        return 1.9f;
    }


    public final static CustomEntityDefinition def = CustomEntityDefinition.builder().identifier("sc:troblin")
            .summonable(true)
            .spawnEgg(true)
            .build();

    public troblin(FullChunk chunk, CompoundTag nbt) {
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
        this.diffHandDamage = new float[]{2.5f, 3f, 4.5f};
        super.initEntity();
    }
    @Override
    public String getOriginalName() {
        return "minotaur_death";
    }

    public float AttackRunSpeed (){
        return 0.3f;
    }


}

