package cosmo.skirmish;

import cosmo.gfx.Drawing;
import java.awt.Graphics;

public class Battle
{
    // Information
    private int infoTurnCount;
    
    // Forces
    private Unit[][] forceUnit;
    private int[] forceUnitCount;
    
    // Interface
    private DisplayCommand uiCommand;
    private DisplayMessage uiMessage;
    
    public Battle()
    {
        // Information
        this.infoTurnCount = 0;
        
        // Force Defaults
        this.forceUnit = new Unit[2][1];
        this.forceUnitCount = new int[2];
        
        // Force 0 (allies)
        this.forceUnit[0][0] = new Unit();
        this.forceUnitCount[0] = 1;
        
        // Force 1 (enemies)
        this.forceUnit[1][0] = new Unit();
        this.forceUnitCount[1] = 1;
        
        // Interface
        this.uiCommand = new DisplayCommand("Attack", "?????", "?????", "?????");
        // NOTE: we should pass in the unit id and establish the command menu options from there
        this.uiMessage = new DisplayMessage("This is a message", 12);
    }
    
    public void render(Graphics gfx)
    {
        renderBackground(gfx);
        renderForceUnits(gfx);
        renderDisplay(gfx);
    }
    
    public void renderBackground(Graphics gfx)
    {
        Drawing.fillScreen(gfx, 207, 215, 121);
    }
    
    public void renderDisplay(Graphics gfx)
    {
        if(this.uiCommand.isEnabled()) {this.uiCommand.render(gfx);}
        if(this.uiMessage.isEnabled()) {this.uiMessage.render(gfx);}
    }
    
    public void renderForceUnits(Graphics gfx)
    {
        // Force 0 (Allies)
        for(int unit = 0; unit < forceUnitCount[0]; unit++)
        {
            this.forceUnit[0][unit].render(gfx);
        }
        
        // Force 1 (Enemies)
        for(int unit = 0; unit < forceUnitCount[1]; unit++)
        {
            this.forceUnit[1][unit].render(gfx);
        }
    }
    
    public void tick()
    {
        // Force 0 (Allies)
        for(int unit = 0; unit < forceUnitCount[0]; unit++)
        {
            this.forceUnit[0][unit].tick();
        }
        
        // Force 1 (Enemies)
        for(int unit = 0; unit < forceUnitCount[1]; unit++)
        {
            this.forceUnit[1][unit].tick();
        }
    }
    
}