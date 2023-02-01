package AI;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.EntityWalkable;
import cn.nukkit.entity.ai.behavior.Behavior;
import cn.nukkit.entity.ai.behaviorgroup.BehaviorGroup;
import cn.nukkit.entity.ai.behaviorgroup.IBehaviorGroup;
import cn.nukkit.entity.ai.controller.LookController;
import cn.nukkit.entity.ai.controller.WalkController;
import cn.nukkit.entity.ai.evaluator.MemoryCheckNotEmptyEvaluator;
import cn.nukkit.entity.ai.executor.MeleeAttackExecutor;
import cn.nukkit.entity.ai.executor.FlatRandomRoamExecutor;
import cn.nukkit.entity.ai.memory.CoreMemoryTypes;
import cn.nukkit.entity.ai.route.finder.impl.SimpleFlatAStarRouteFinder;
import cn.nukkit.entity.ai.route.posevaluator.WalkingPosEvaluator;
import cn.nukkit.entity.ai.sensor.NearestPlayerSensor;
import cn.nukkit.entity.mob.EntityMob;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

import java.util.Set;


public class MosterEntityAI extends EntityMob implements EntityWalkable {

    private IBehaviorGroup behaviorGroup;

    public MosterEntityAI(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }


    @Override
    public IBehaviorGroup getBehaviorGroup() {
        if (behaviorGroup == null) {
            behaviorGroup = new BehaviorGroup(
                    this.tickSpread,
                    Set.of(),
                    Set.of(
                            new Behavior(new MeleeAttackExecutor(CoreMemoryTypes.ATTACK_TARGET, AttackRunSpeed(), 40, true, 10), all(
                                    new MemoryCheckNotEmptyEvaluator(CoreMemoryTypes.ATTACK_TARGET),
                                    entity -> !entity.getMemoryStorage().notEmpty(CoreMemoryTypes.ATTACK_TARGET) || !(entity.getMemoryStorage().get(CoreMemoryTypes.ATTACK_TARGET) instanceof Player player) || player.isAdventure()
                            ), 3, 1),
                            new Behavior(new MeleeAttackExecutor(CoreMemoryTypes.NEAREST_PLAYER, AttackRunSpeed(), 40, false, 10), all(
                                    new MemoryCheckNotEmptyEvaluator(CoreMemoryTypes.NEAREST_PLAYER),
                                    entity -> {
                                        if (entity.getMemoryStorage().isEmpty(CoreMemoryTypes.NEAREST_PLAYER)) return true;
                                        Player player = entity.getMemoryStorage().get(CoreMemoryTypes.NEAREST_PLAYER);
                                        return player.isAdventure();
                                    }
                            ), 2, 1),
                            new Behavior(new FlatRandomRoamExecutor(RandomRoamRunSpeed(), 12, 100, false, -1, true, 10), (entity -> true), 1, 1)
                    ),
                    Set.of(new NearestPlayerSensor(40, 0, 20)),
                    Set.of(new WalkController(), new LookController(true, true)),
                    new SimpleFlatAStarRouteFinder(new WalkingPosEvaluator(), this)
            );
        }
        return behaviorGroup;
    }
    @Override
    public int getNetworkId() {
        return Entity.NETWORK_ID;
    }

    @Override
    public boolean attack(EntityDamageEvent source) {
        var result = super.attack(source);
        if (source instanceof EntityDamageByEntityEvent entityDamageByEntityEvent) {
            //更新仇恨目标
            getMemoryStorage().put(CoreMemoryTypes.ATTACK_TARGET, entityDamageByEntityEvent.getDamager());
        }
        return result;
    }



    public float RandomRoamRunSpeed (){
        return 0.2f;
    }

    public float AttackRunSpeed (){
        return 0.2f;
    }



}

