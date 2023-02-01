package entity;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.custom.CustomEntity;
import cn.nukkit.entity.custom.CustomEntityDefinition;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class PNXCustomEntity extends Entity implements CustomEntity {
    final static CustomEntityDefinition def = CustomEntityDefinition.builder().identifier("mlcs:yeti")
            .summonable(true)
            .spawnEgg(false)
            .build();



    public PNXCustomEntity(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public CustomEntityDefinition getDefinition() {
        return def;
    }
    @Override
    public int getNetworkId() {
        return Entity.NETWORK_ID;
    }
}
