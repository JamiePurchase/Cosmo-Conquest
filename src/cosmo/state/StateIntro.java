package cosmo.state;

import cosmo.app.Application;
import cosmo.gfx.Drawing;
import java.awt.Graphics;

public class StateIntro extends State
{
    private boolean tickIntro;
    private int tickCount;
    private int tickFrame;
    
    public StateIntro()
    {
        tickIntro = true;
        tickCount = 0;
        tickFrame = 1;
    }
    
    public void eventEnd()
    {
        
    }
    
    public void eventStart()
    {
        
    }
    
    public void render(Graphics gfx)
    {
        // Background
        renderBackground(gfx);
    }
    
    public void renderBackground(Graphics gfx)
    {
        Drawing.fillScreen(gfx);
    }
    
    public void tick()
    {
        if(tickIntro == true) {tickIntro();}
    }
    
    public void tickIntro()
    {
        // Animation
        tickCount += 1;
        /*if(tickFrame == 1 && tickCount >= 50)
        {
            tickFrame += 1;
            tickCount = 0;
        }
        if(tickFrame == 2 && tickCount >= 140)
        {
            tickFrame += 1;
            tickCount = 0;
        }
        if(tickFrame == 3 && tickCount >= 30)
        {
            tickIntro = false;
            Application.setState(new StateTitle());
        }*/
        
        // Temp
        Application.setState(new StateTitle());
    }
}