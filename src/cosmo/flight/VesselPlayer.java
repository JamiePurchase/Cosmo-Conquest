package cosmo.flight;

import cosmo.app.Application;
import cosmo.gfx.Drawing;
import java.awt.Graphics;

public class VesselPlayer extends Vessel
{
    private String moveStrafe;
    
    public VesselPlayer()
    {
        super();
    }
    
    public void tick()
    {
        // Old
        //if(this.moveStrafe == "LEFT") {super.moveAreaPosX(-1);}
        //if(this.moveStrafe == "RIGHT") {super.moveAreaPosX(1);}
        
        // New
        if(Application.getInputKeyboard().keyLeft.isPressed()) {super.moveAreaPosX(-1);}
        if(Application.getInputKeyboard().keyRight.isPressed()) {super.moveAreaPosX(1);}
    }
}