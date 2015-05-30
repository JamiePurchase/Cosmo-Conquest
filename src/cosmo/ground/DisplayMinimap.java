package cosmo.ground;

import cosmo.app.Application;
import cosmo.gfx.Drawing;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DisplayMinimap
{
    private BufferedImage iconPlayer;
    private Unit unitPlayer;
    private boolean enabled;
    
    public DisplayMinimap(Unit player)
    {
        this.iconPlayer = Drawing.getImage("interface/minimapPlayer.png");
        this.unitPlayer = player;
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
            renderPanel(gfx);
            renderIcons(gfx, this.unitPlayer.getAnimFace());
        }
    }
    
    public void renderIcons(Graphics gfx, String playerFace)
    {
        // Player
        double rotate = 0;
        if(playerFace == "NE") {rotate = 45;}
        if(playerFace == "E") {rotate = 90;}
        if(playerFace == "SE") {rotate = 135;}
        if(playerFace == "S") {rotate = 180;}
        if(playerFace == "SW") {rotate = 225;}
        if(playerFace == "W") {rotate = 270;}
        if(playerFace == "NW") {rotate = 315;}
        Drawing.drawImageRotate(gfx, iconPlayer, 1258, 117, rotate);
    }
    
    public void renderPanel(Graphics gfx)
    {
        // NOTE: consider opaque background
        gfx.setColor(Application.getThemeColour("SHADOW"));
        gfx.fillRect(1191, 50, 150, 150);
        gfx.setColor(Application.getThemeColour("FORE"));
        gfx.drawRect(1191, 50, 150, 150);
        gfx.drawRect(1191 + 1, 50 + 1, 150 - 2, 150 - 2);
        
        gfx.drawImage(Drawing.getImage("interface/minimapBorder.png"), 1166, 25, null);
        
        // CONSIDER: animation of radar-like scanning movement in background
    }
    
    public void tick()
    {
        
    }
    
}