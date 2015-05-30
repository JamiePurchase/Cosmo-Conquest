package cosmo.flight;

import java.awt.Color;
import java.awt.Graphics;

public class HudMap
{
    private boolean enabled;
    
    public HudMap()
    {
        this.enabled = true;
    }
    
    public boolean getEnabled()
    {
        return this.enabled;
    }
    
    public void render(Graphics gfx)
    {
        gfx.setColor(Color.WHITE);
        gfx.drawRect(1041, 593, 300, 150);
    }
    
}