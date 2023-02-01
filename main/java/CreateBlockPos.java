import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.level.Position;

import java.util.LinkedList;
import java.util.Objects;

public class CreateBlockPos implements Listener {


    private void saveBlocks() {
        LinkedList<String> stringCache = new LinkedList<>();
        for (Position position : Main.blocks) {
            String s = (int)position.x + ":" + (int)position.y + ":" + (int)position.z + ":" + position.getLevel().getName();
            stringCache.add(s);
        }
        Main.c.set("blocks", stringCache);
        Main.c.save();
    }
    @EventHandler
    public void onInteract(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        if(Objects.equals(block.getName(), "FireFly Jar")){
            Position position = new Position(block.getFloorX(), (block.getFloorY()), block.getFloorZ(), block.getLevel());

            if (!Main.blocks.contains(position)) {
                Main.blocks.add(position);
                player.sendActionBar("成功设置萤火虫");
                saveBlocks();
            }

        }
    }

    @EventHandler
    public void onInteract(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
//        if (event.getAction() == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
        if(Objects.equals(block.getName(), "FireFly Jar")){
            Position position = new Position(block.getFloorX(), (block.getFloorY()), block.getFloorZ(), block.getLevel());

            if (Main.blocks.contains(position)) {
                Main.blocks.remove(position);
                player.sendActionBar("移除萤火虫");
                saveBlocks();
            }

        }
    }




}
