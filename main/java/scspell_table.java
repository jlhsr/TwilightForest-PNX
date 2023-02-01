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


public class scspell_table extends Block implements CustomBlock {



    @Override
    public String getNamespaceId() {
        return "voidlegacy:scspell_table";
    }



    @Override
    public CustomBlockDefinition getDefinition() {
        return CustomBlockDefinition
                .builder(this, Materials.builder().any(Materials.RenderMethod.ALPHA_TEST, "scspell_table"), BlockCreativeCategory.CONSTRUCTION)

                .geometry("geometry.spell_table")
                .creativeGroup("itemGroup.name.block")
                .permutations(
                        new Permutation(Component.builder()
                                .collisionBox(new CollisionBox(-8, 0, -8, 16, 12, 16))
                                .selectionBox(new SelectionBox(-8, 0, -8, 16, 12, 16))
                                .build(),
                                "query.block_property('bridge:top_slot_bit') == false && query.block_property('bridge:is_full_bit') == false"),
                        new Permutation(Component.builder()
                                .collisionBox(new CollisionBox(-8, 0, -8, 16, 12, 16))
                                .selectionBox(new SelectionBox(-8, 0, -8, 16, 12, 16))
                                .build(),
                                "query.block_property('bridge:top_slot_bit') == true && query.block_property('bridge:is_full_bit') == false"),
                        new Permutation(Component.builder()
                                .collisionBox(new CollisionBox(-8, 0, -8, 16, 12, 16))
                                .selectionBox(new SelectionBox(-8, 0, -8, 16, 12, 16))
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
    public double getFrictionFactor() {
        return 0.1;
    }


    @Override
    public int getLightLevel() {
        return 14;
    }

    @Override
    public String getName() {
        return "scspell_table";
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
