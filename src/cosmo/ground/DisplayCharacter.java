package cosmo.ground;

import cosmo.app.Application;
import cosmo.gfx.Drawing;
import java.awt.Graphics;

public class DisplayCharacter
{   
    private boolean enabled;
    
    public DisplayCharacter()
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
            /*gfx.setColor(Application.getThemeColour("TEXT"));
            gfx.drawString("CHARACTER INFO", 50, 718);
            gfx.drawString("HEALTH / ENERGY", 75, 748);*/
            
            gfx.drawImage(Drawing.getImage("interface/hudCharacter.png"), 25, 593, null);
            gfx.drawImage(Drawing.getImage("interface/hudCharacterTungstan.png"), 25, 593, null);
            
            // Portrait Image
            //gfx.setImage();
            
            // Portrait Background
            /*gfx.setColor(Application.getThemeColour("BACK"));
            gfx.fillOval(40, 668, 50, 50);*/
            
            // Portrait Border
            /*gfx.setColor(Application.getThemeColour("BACK"));
            gfx.drawOval(40, 668, 50, 50);
            gfx.drawOval(45, 673, 40, 40);*/
            
            // Health Background
            /*gfx.setColor(Application.getThemeColour("STANDARD"));
            gfx.fillRect(90, 640, 300, 50);*/
            
            // Health Percentage
            //int barX = 300;
            // NOTE: barX needs to be health percentage * 3
            /*gfx.setColor(Application.getThemeColour("BARHEALTH"));
            gfx.fillRect(90, 640, barX, 50);*/
            
            // Health Border
            /*gfx.setColor(Application.getThemeColour("FORE"));
            gfx.drawRect(90, 640, 300, 50);*/
            
            // Energy Background
            /*gfx.setColor(Application.getThemeColour("STANDARD"));
            gfx.fillRect(90, 690, 300, 50);*/
            
            // Energy Percentage
            //barX = 300;
            // NOTE: barX needs to be energy percentage * 3
            /*gfx.setColor(Application.getThemeColour("BARENERGY"));
            gfx.fillRect(90, 690, barX, 50);*/
            
            // Energy Border
            /*gfx.setColor(Application.getThemeColour("FORE"));
            gfx.drawRect(90, 690, 300, 50);*/
        }
    }
    
    public void tick()
    {
        
    }
}