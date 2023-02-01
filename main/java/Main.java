import block.buildblock.*;
import block.otherblock.torchberry;
import block.otherblock.twilight_portal;
import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.command.selector.args.impl.L;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.provider.CustomClassEntityProvider;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;

import cn.nukkit.event.player.PlayerEatFoodEvent;
import cn.nukkit.item.Item;
import cn.nukkit.level.Position;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginLogger;
import cn.nukkit.scheduler.Task;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import entity.*;
import entity.firefly;
import items.armor.steeleafBoots;
import items.armor.steeleafChestplate;
import items.armor.steeleafHelmet;
import items.armor.steeleaftLeggings;
import items.steeleaf_sword;
import otherentity.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main extends PluginBase implements Listener {
    PluginLogger log;
    public static Config  c;

    public static final ArrayList<Position> blocks = new ArrayList<>();
    @Override
    public void onLoad() {

        log = new PluginLogger(this);

        List customitem = List.of(steeleafBoots.class, steeleafChestplate.class, steeleafHelmet.class, steeleaftLeggings.class, steeleaf_sword.class);


        if (Item.registerCustomItem(customitem)){
            this.getLogger().info(TextFormat.BLUE + "§a____________________PNX自定义物品项注册完毕____________________");
            Item.registerCustomItem(customitem);
        }else {
            this.getLogger().warning(TextFormat.RED + "§c__关键性PNX自定义项注册失败 考虑到对地图数据保护 已强制终止 请检查核心AddonAPI版本__");
            Server.getInstance().reload();
        }

List customblock = List.of(scspell_table.class,torchberry.class, rootblock.class, oreroots.class, aurora_block.class,twilight_portal.class,FireFlyJar.class, canopy_log.class, twilight_log.class, dark_log.class, dark_leaves.class, tower_wood_plain.class, tower_wood_encased.class, tower_wood_mossy.class, tower_wood_infested.class);


        if (Block.registerCustomBlock(customblock)){
            this.getLogger().info(TextFormat.BLUE + "§a____________________PNX自定义方块项注册完毕____________________");
            Block.registerCustomBlock(customblock);
        }else {
            this.getLogger().warning(TextFormat.RED + "§c__关键性PNX自定义项注册失败 考虑到对地图数据保护 已强制终止 请检查核心AddonAPI版本__");
        Server.getInstance().reload();
        }



        Entity.registerCustomEntity(new CustomClassEntityProvider(magma_dripper.def, magma_dripper.class));
        Entity.registerCustomEntity(new CustomClassEntityProvider(lich.def, lich.class));
        Entity.registerCustomEntity(new CustomClassEntityProvider(firefly.def, firefly.class));
        Entity.registerCustomEntity(new CustomClassEntityProvider(wild_deer.def, wild_deer.class));
        Entity.registerCustomEntity(new CustomClassEntityProvider(cockatrice.def, cockatrice.class));
        Entity.registerCustomEntity(new CustomClassEntityProvider(yeti.def, yeti.class));
        Entity.registerCustomEntity(new CustomClassEntityProvider(raven.def, raven.class));
        Entity.registerCustomEntity(new CustomClassEntityProvider(squirrel.def, squirrel.class));

        Entity.registerCustomEntity(new CustomClassEntityProvider(troblin.def, troblin.class));
        Entity.registerCustomEntity(new CustomClassEntityProvider(trogre.def, trogre.class));
        Entity.registerCustomEntity(new CustomClassEntityProvider(mimic.def, mimic.class));
        Entity.registerCustomEntity(new CustomClassEntityProvider(spider_hatchling.def, spider_hatchling.class));
        Entity.registerCustomEntity(new CustomClassEntityProvider(spider_queen.def, spider_queen.class));
    }

    @Override
    public void onEnable() {

        this.getServer().getPluginManager().registerEvents(new Main(), this);
        this.getServer().getPluginManager().registerEvents(new CreateBlockPos(),this);

        regTask(new BlockParticleblockTask(this, blocks), 30);


        c = new Config(getDataFolder() + "/config.yml", 2);
        loadConfig();



        this.getLogger().info(TextFormat.BLUE + "                §5Twilight  §eForest  §bAddon  §6PowerNukkitX");
        this.getLogger().info(TextFormat.BLUE + "");
        this.getLogger().info(TextFormat.BLUE + "                      §c作者XKSAHDOW");
        this.getLogger().info(TextFormat.BLUE + "§a____________________暮色森林模组启动成功____________________");
    }

    private void regTask(Task task, int period) {
        getServer().getScheduler().scheduleRepeatingTask(task, period);
        //Server.getInstance().getLogger().info(task.getClass().getName());
    }


    private void loadConfig() {
        blocks.clear();
        for (String string : c.getStringList("blocks")) {
            String[] s = string.split(":");
            blocks.add(new Position(
                    Integer.parseInt(s[0]), Integer.parseInt(s[1]),
                    Integer.parseInt(s[2]), getServer().getLevelByName(s[3])));
        }

    }


//    @EventHandler(priority = EventPriority.NORMAL)
//    public void onEat(PlayerEatFoodEvent event) {
//        System.out.println("触发事件");
//        new wild_deer(event.getPlayer().getChunk(), Entity.getDefaultNBT(event.getPlayer())).spawnToAll();
//        new squirrel(event.getPlayer().getChunk(), Entity.getDefaultNBT(event.getPlayer())).spawnToAll();
//    }
}
