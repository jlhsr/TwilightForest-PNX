import cn.nukkit.Player;
import cn.nukkit.level.Level;
import cn.nukkit.level.Position;
import cn.nukkit.level.particle.EnchantmentTableParticle;
import cn.nukkit.level.particle.FlameParticle;
import cn.nukkit.math.Vector3;

public  class CustomParticle {


    public static void spawnpart(Position pos){
        int type =1;

        int x = 0;
        int y = 0;
        int z = 0;


        if((int) (Math.random() * 2) ==1){
            x =-1;
        }else {
            x =1;
        }
        if((int) (Math.random() * 2) ==1){
            y =-1;
        }else {
            y =0;
        }
        if((int) (Math.random() * 2) ==1){
            z =-1;
        }else {
            z =1;
        }
        Vector3 pos2;
        Level l = pos.getLevel();
        pos2 = new Vector3(pos.getX()+x, pos.getY()+y, pos.getZ()+z);
        spawnCustomParticle(type,pos2,l);
    }




    public static void spawnpart(Player e, Position pos2){
       int type =1;
//        Vector3 pos2;
        Level l = e.level;
//        pos2 = new Vector3(-620, 33 , -1403);
        spawnCustomParticle(type,pos2,l);
    }


    private static void spawnCustomParticle(int type, Vector3 pos2, Level l) {
        switch (type) {
            case 1:
                l.addParticleEffect(pos2.asVector3f(), "twilightforest:firefly_particle", -1, l.getDimension(), Player.EMPTY_ARRAY);
                break;
            case 2:
                l.addParticle(new EnchantmentTableParticle(pos2) );
                break;
            case 3:
                l.addParticleEffect(pos2.asVector3f(), "minecraft:endrod", -1, l.getDimension(), Player.EMPTY_ARRAY);
                break;
            case 4:
                l.addParticleEffect(pos2.asVector3f(), "sc:flame_particle", -1, l.getDimension(), Player.EMPTY_ARRAY);
                break;
            //雪花
            default:
                l.addParticle(new FlameParticle(pos2));
        }

    }
}