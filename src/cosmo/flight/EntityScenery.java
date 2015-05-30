package cosmo.flight;

import cosmo.gfx.Drawing;
import cosmo.gfx.Animation;
import java.awt.Graphics;

public class EntityScenery extends Entity
{
    private Animation animIdle;

    public EntityScenery(String code, String name, int posX, int posY, int posZ, Mesh mesh, Animation idle, int statHealth, int destroyScore, Entity destroySpawn)
    {
        super(code, name, posX, posY, posZ, mesh, idle, statHealth, destroyScore, destroySpawn);
    }
    
    public void render(Graphics gfx)
    {
        gfx.drawImage(this.animIdle.getImage(), 0, 0, null);
    }
    
    public void tick()
    {
        
    }
}