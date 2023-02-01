package block.buildblock;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.block.customblock.CustomBlock;
import cn.nukkit.block.customblock.CustomBlockDefinition;
import cn.nukkit.item.Item;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class twilight_log extends Block implements CustomBlock {

    @Override
    public String getNamespaceId() {
        return "twilightforest:twilight_log";
    }

    @Override
    public CustomBlockDefinition getDefinition() {
        return CustomBlockDefinition
                .builder(this, "oak_wood")
                .creativeGroup("itemGroup.name.block")
                .build();
    }


    @Override
    public double calculateBreakTime(@NotNull Item item, @Nullable Player player) {
        return 3;
    }

    @Override
    public double getFrictionFactor() {
        return 0.1;
    }


    @Override
    public int getLightLevel() {
        return 0;
    }

    @Override
    public String getName() {
        return CustomBlock.super.getName();
    }

    @Override
    public int getId() {
        return CustomBlock.super.getId();
    }

    @Override
    public int getLightFilter() {
        return 15;
    }

    @Override
    public int getBurnAbility() {
        return 0;
    }

    @Override
    public int getBurnChance() {
        return 0;
    }


}
