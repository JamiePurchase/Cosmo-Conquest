package cosmo.skirmish;

import cosmo.gfx.Drawing;
import java.awt.Graphics;

public class Unit
{
    // Information
    private String infoName;
    
    public Unit()
    {
        
    }
    
    public void render(Graphics gfx)
    {
        gfx.drawImage(Drawing.getImage("unit/veTungstanBodyIdle1.png"), 1100, 200, null);
        gfx.drawImage(Drawing.getImage("unit/veTungstanCannonIdle1.png"), 1100, 200, null);
    }
    
    public void tick()
    {
        
    }
    
}