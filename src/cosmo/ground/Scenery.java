package cosmo.ground;

import cosmo.gfx.Drawing;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Scenery
{
    // Board
    private int tilePosX, tilePosY;
    
    // Animation
    private String animFile;
    private int animTickNow, animTickMax, animFrameNow, animFrameMax;
    private boolean animSmash;
    
    // Collision
    //private Mesh ??
    private boolean collideSmashable;
    
    public Scenery(String anim)
    {
        this.tilePosX = 0;
        this.tilePosY = 0;
        this.animFile = anim;
        this.animFrameNow = 1;
        this.animFrameMax = 1;
        // NOTE: how about using a tileset instead of an image?
        
        // TEST
        this.collideSmashable = true;
    }
    
    private BufferedImage getRenderImage()
    {
        //return Drawing.getImage("scenery/" + this.animFile + this.animFrameNow + ".png");
        return Drawing.getImage("scenery/" + this.animFile + 1 + ".png");
    }
    
    private int getRenderPosX()
    {
        return this.tilePosX * 32;
    }
    
    private int getRenderPosY()
    {
        return this.tilePosY * 32;
    }
    
    public int getTilePosX()
    {
        return this.tilePosX;
    }
    
    public int getTilePosY()
    {
        return this.tilePosY;
    }
    
    public boolean isSmashable()
    {
        return this.collideSmashable;
    }
    
    public void render(Graphics gfx)
    {
        if(this.animSmash)
        {
            float alpha = 0.00f + (0.1f * this.animTickNow);
            Drawing.drawImageOpaque(gfx, this.getRenderImage(), this.getRenderPosX(), this.getRenderPosY(), alpha);
        }
        else {gfx.drawImage(this.getRenderImage(), this.getRenderPosX(), this.getRenderPosY(), null);}
    }
    
    public void setTilePosition(int posX, int posY)
    {
        this.tilePosX = posX;
        this.tilePosY = posY;
    }
    
    public void smash()
    {
        this.animSmash = true;
        this.animTickNow = 0;
        this.animTickMax = 10;
        this.animFrameNow = 0;
        this.animFrameMax = 0;
    }
    
    public void tick()   
    {
        this.animTickNow += 1;
        if(this.animTickNow > this.animTickMax)
        {
            this.animTickNow = 0;
            this.animFrameNow += 1;
            if(this.animFrameNow > this.animFrameMax)
            {
                // ??
            }
        }
    }
    
}