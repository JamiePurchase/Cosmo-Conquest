package cosmo.state;

import cosmo.app.Application;
import cosmo.gfx.Drawing;
import java.awt.Graphics;

public class StateTitle extends State
{
    
    public void eventEnd()
    {
        
    }
    
    public void eventStart()
    {
        
    }
    
    public void render(Graphics gfx)
    {
        Drawing.fillScreen(gfx);
        gfx.drawImage(Drawing.getImage("interface/title.png"), 533, 25, null);
    }
    
    public void tick()
    {
        if(Application.getInputKeyboard().getKeyPressed() != "NONE")
        {
            if(Application.getInputKeyboard().getKeyPressed() == "Escape")
            {
                Application.getInputKeyboard().keyPressedDone();
                System.exit(0);
            }
            //Application.setState(new StateFlight());
            Application.setState(new StateGround());
            //Application.setState(new StateSkirmish());
        }
    }
    
}