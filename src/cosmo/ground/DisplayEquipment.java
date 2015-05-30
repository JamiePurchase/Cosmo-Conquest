package cosmo.ground;

import cosmo.app.Application;
import java.awt.Graphics;

public class DisplayEquipment
{
    private boolean enabled;
    
    public DisplayEquipment()
    {
        this.enabled = true;
    }
    
    public boolean isEnabled()
    {
        return this.enabled;
    }
    
    public void render(Graphics gfx)
    {
        if(this.enabled)
        {
            gfx.setColor(Application.getThemeColour("TEXT"));
            gfx.drawString("EQUIPMENT INFO", 1166, 718);
            gfx.drawString("WEAPON / AMMO", 1191, 748);
        }
    }
    
    public void tick()
    {
        
    }
}