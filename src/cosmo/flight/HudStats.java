package cosmo.flight;

import java.awt.Color;
import java.awt.Graphics;

public class HudStats
{
    
    public HudStats()
    {
        
    }
    
    public void render(Graphics gfx)
    {
        gfx.setColor(Color.WHITE);
        gfx.drawRect(25, 593, 300, 150);
    }
    
}