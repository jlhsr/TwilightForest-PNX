package block.otherblock;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.block.customblock.CustomBlock;
import cn.nukkit.block.customblock.CustomBlockDefinition;
import cn.nukkit.block.customblock.data.*;
import cn.nukkit.item.Item;
import cn.nukkit.math.Vector3f;
import cn.nukkit.nbt.tag.CompoundTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class twilight_portal extends Block implements CustomBlock {



    @Override
    public String getNamespaceId() {
        return "twilightforest:twilight_portal";
    }



    @Override
    public CustomBlockDefinition getDefinition() {
        return CustomBlockDefinition
                .builder(this, Materials.builder().any(Materials.RenderMethod.BLEND, "twilight_portal"), BlockCreativeCategory.CONSTRUCTION)

                .geometry("geometry.twilight")
                .creativeGroup("itemGroup.name.block")
                .permutations(
                        new Permutation(Component.builder()
                                .collisionBox(new CollisionBox(-4, 0, -4, 8, 8, 8))
                                .selectionBox(new SelectionBox(-4, 0, -4, 8, 8, 8))
                                .build(),
                                "query.block_property('bridge:top_slot_bit') == false && query.block_property('bridge:is_full_bit') == false"),
                        new Permutation(Component.builder()
                                .collisionBox(new CollisionBox(-4, 0, -4, 8, 8, 8))
                                .selectionBox(new SelectionBox(-4, 0, -4, 8, 8, 8))
                                .build(),
                                "query.block_property('bridge:top_slot_bit') == true && query.block_property('bridge:is_full_bit') == false"),
                        new Permutation(Component.builder()
                                .collisionBox(new CollisionBox(-4, 0, -4, 8, 8, 8))
                                .selectionBox(new SelectionBox(-4, 0, -4, 8, 8, 8))
                                .build(),
                                "query.block_property('bridge:is_full_bit') == true")
                )

                .customBuild((nbt) -> {
                    nbt.getCompound("components").putCompound("minecraft:part_visibility", new CompoundTag()
                            .putCompound("boneConditions", new CompoundTag()
                                    .putCompound("lower", new CompoundTag()
                                            .putString("bone_condition", "!query.block_property('bridge:top_slot_bit') || query.block_property('bridge:is_full_bit')")
                                            .putString("bone_name", "lower")
                                            .putInt("molang_version", 6))
                                    .putCompound("upper", new CompoundTag()
                                            .putString("bone_condition", "query.block_property('bridge:top_slot_bit') || query.block_property('bridge:is_full_bit')")
                                            .putString("bone_name", "upper")
                                            .putInt("molang_version", 6))));
                });

    }
    @Override
    public double calculateBreakTime(@NotNull Item item, @Nullable Player player) {
        return 3;
    }

    @Override
    public boolean canPassThrough() {
        return true;
    }


    @Override
    public boolean isTransparent(){
        return true;
    }


    @Override
    public double getFrictionFactor() {
        return 0.1;
    }

    @Override
    public double getResistance() {
        return 8;
    }

    @Override
    public int getLightLevel() {
        return 12;
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
        return 1;
    }




 

}
