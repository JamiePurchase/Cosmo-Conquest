package cosmo.skirmish;

import cosmo.app.Application;
import cosmo.gfx.Drawing;
import cosmo.ui.Panel;
import java.awt.Color;
import java.awt.Graphics;

public class DisplayMessage
{
    private Panel textPanel;
    private String textMessage;
    private int tickNow, tickMax;
    private boolean enabled;
    
    public DisplayMessage(String message, int duration)
    {
        this.textPanel = new Panel(100, 25, 1166, 50);
        this.textMessage = message;
        this.tickNow = 0;
        this.tickMax = duration;
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
            this.textPanel.render(gfx);
            gfx.setColor(Application.getThemeColour("TEXT"));
            gfx.setFont(Application.getThemeFont("MESSAGE"));
            int textWidth = gfx.getFontMetrics().stringWidth(this.textMessage);
            Drawing.writeTextShadow(gfx, this.textMessage, 683 - (textWidth / 2), 40);
        }
    }
    
    public void tick()
    {
        if(this.tickNow < this.tickMax && this.enabled)
        {
            this.tickNow += 1;
            if(this.tickNow > this.tickMax)
            {
                this.enabled = false;
            }
        }
    }
}