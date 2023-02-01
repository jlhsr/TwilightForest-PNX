package items;

import cn.nukkit.item.customitem.CustomItemDefinition;
import cn.nukkit.item.customitem.ItemCustomTool;
import cn.nukkit.item.customitem.data.ItemCreativeCategory;
import cn.nukkit.item.customitem.data.RenderOffsets;
import cn.nukkit.nbt.tag.CompoundTag;

public class CustomItemWepeon extends ItemCustomTool {
    public CustomItemWepeon(String stringid, String name, String textname) {
        super("twilightforest:" + stringid,name,textname);
    }
    public int scaleoffset() {
        return 16;
    }
    @Override
    public CustomItemDefinition getDefinition() {
        return CustomItemDefinition
                .toolBuilder(this, ItemCreativeCategory.EQUIPMENT)
                .creativeGroup("itemGroup.name.item")
                .allowOffHand(false)
                .handEquipped(true)
                .renderOffsets(RenderOffsets.scaleOffset(scaleoffset()))
                .customBuild(nbt -> {
                    nbt.getCompound("components")
                            .putCompound("minecraft:cooldown", new CompoundTag()
                                    .putString("category", "sword")
                                    .putFloat("duration", 3f))
                            .getCompound("item_properties").putBoolean("animates_in_toolbar", true)
                            .getCompound("item_properties").putInt("use_duration", 640);
                });
    }


    @Override
    public int getMaxDurability() {
        return 1;
    }
    @Override
    public int getAttackDamage() {
        return 1;
    }

    @Override
    public boolean isSword() {
        return true;
    }
}
