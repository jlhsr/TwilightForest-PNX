package items;

import cn.nukkit.item.ItemSwordDiamond;

public class steeleaf_sword extends CustomItemWepeon {
    public steeleaf_sword() {
        super("steeleaf_sword", "铁叶剑", "steeleafSword");
    }


    @Override
    public int getMaxDurability() {
        return 100;
    }



    @Override
    public int getTier() {
        return ItemSwordDiamond.TIER_DIAMOND;
    }

    @Override
    public int getAttackDamage() {
        return 8;
    }
}

