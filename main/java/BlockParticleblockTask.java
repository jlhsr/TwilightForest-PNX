import cn.nukkit.level.Position;
import cn.nukkit.scheduler.PluginTask;

import java.util.ArrayList;


public class BlockParticleblockTask extends PluginTask<Main> {
    private final ArrayList<Position> blocks;
        public BlockParticleblockTask(Main owner, ArrayList<Position> blocks) {
        super(owner);
            this.blocks = blocks;
    }

    @Override
    public void onRun(int i) {
        refreshParticl();
    }

    private void refreshParticl() {


        if (this.blocks.size() > 0)
            for (Position position : this.blocks) {
                if (position.level != null && position.getChunk() != null && position.getChunk().isLoaded() && position.level
                        .getPlayers().size() > 0)
                    CustomParticle.spawnpart(position);
            }

    }


}
