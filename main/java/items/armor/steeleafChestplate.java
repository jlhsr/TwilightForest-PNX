package items.armor;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemArmor;
import cn.nukkit.item.customitem.CustomItemDefinition;
import cn.nukkit.item.customitem.ItemCustomArmor;
import cn.nukkit.item.customitem.data.ItemCreativeCategory;

import java.util.List;

public class steeleafChestplate extends ItemCustomArmor {
    public steeleafChestplate() {
        super("twilightforest:steeleaf_chestplate", null, "steeleafPlate");
    }

    @Override
    public CustomItemDefinition getDefinition() {
        return CustomItemDefinition
                .armorBuilder(this, ItemCreativeCategory.EQUIPMENT)
                .addRepairItems(List.of(Item.fromString("minecraft:amethyst_shard")), 100)
                .addRepairItems(List.of(Item.fromString("yes:amethyst_chestplate")), 300)
                .creativeGroup("itemGroup.name.chestplate")
                .build();
    }

    @Override
    public boolean isChestplate() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_DIAMOND;
    }

    @Override
    public int getMaxDurability() {
        return 295;
    }

    @Override
    public int getEnchantAbility() {
        return 22;
    }

    @Override
    public int getArmorPoints() {
        return 7;
    }
}
