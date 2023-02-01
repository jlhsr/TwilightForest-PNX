package items.armor;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemArmor;
import cn.nukkit.item.customitem.CustomItemDefinition;
import cn.nukkit.item.customitem.ItemCustomArmor;
import cn.nukkit.item.customitem.data.ItemCreativeCategory;

import java.util.List;

public class steeleafHelmet extends ItemCustomArmor {
    public steeleafHelmet() {
        super("twilightforest:steeleaf_helmet", null, "steeleafHelm");
    }

    @Override
    public CustomItemDefinition getDefinition() {
        return CustomItemDefinition
                .armorBuilder(this, ItemCreativeCategory.EQUIPMENT)
                .addRepairItems(List.of(Item.fromString("minecraft:amethyst_shard")), 100)
                .addRepairItems(List.of(Item.fromString("yes:amethyst_helmet")), 220)
                .creativeGroup("itemGroup.name.helmet")
                .build();
    }

    @Override
    public boolean isHelmet() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_DIAMOND;
    }

    @Override
    public int getMaxDurability() {
        return 203;
    }

    @Override
    public int getEnchantAbility() {
        return 22;
    }

    @Override
    public int getArmorPoints() {
        return 3;
    }
}
