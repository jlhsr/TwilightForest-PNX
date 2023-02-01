package items.armor;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemArmor;
import cn.nukkit.item.customitem.CustomItemDefinition;
import cn.nukkit.item.customitem.ItemCustomArmor;
import cn.nukkit.item.customitem.data.ItemCreativeCategory;

import java.util.List;

public class steeleaftLeggings extends ItemCustomArmor {
    public steeleaftLeggings() {
        super("twilightforest:steeleaf_leggings", null, "steeleafLegs");
    }

    @Override
    public CustomItemDefinition getDefinition() {
        return CustomItemDefinition
                .armorBuilder(this, ItemCreativeCategory.EQUIPMENT)
                .addRepairItems(List.of(Item.fromString("minecraft:amethyst_shard")), 100)
                .addRepairItems(List.of(Item.fromString("yes:amethyst_leggings")), 300)
                .creativeGroup("itemGroup.name.leggings")
                .build();
    }

    @Override
    public boolean isLeggings() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_DIAMOND;
    }

    @Override
    public int getMaxDurability() {
        return 276;
    }

    @Override
    public int getEnchantAbility() {
        return 22;
    }

    @Override
    public int getArmorPoints() {
        return 5;
    }
}
