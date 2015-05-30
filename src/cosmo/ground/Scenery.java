package cosmo.ground;

import cosmo.gfx.Drawing;
import java.awt.Graphics;
import java.awt.Image;

public class Scenery
{
    // Board
    private int tilePosX, tilePosY;
    
    // Animation
    private String animFile;
    private int animTickNow, animTickMax, animFrameNow, animFrameMax;
    
    public Scenery(String anim)
    {
        this.tilePosX = 0;
        this.tilePosY = 0;
        this.animFile = anim;
        this.animFrameNow = 1;
        this.animFrameMax = 1;
        // NOTE: how about using a tileset instead of an image?
    }
    
    private Image getRenderImage()
    {
        return Drawing.getImage("scenery/" + this.animFile + this.animFrameNow + ".png");
    }
    
    private int getRenderPosX()
    {
        return this.tilePosX * 32;
    }
    
    private int getRenderPosY()
    {
        return this.tilePosY * 32;
    }
    
    public void render(Graphics gfx)
    {
        gfx.drawImage(this.getRenderImage(), this.getRenderPosX(), this.getRenderPosY(), null);
    }
    
    public void setTilePosition(int posX, int posY)
    {
        this.tilePosX = posX;
        this.tilePosY = posY;
    }
    
    public void tick()   
    {
        
    }
    
}