package cosmo.gfx;

import java.awt.Image;

public class Animation
{
    public String animFile;
    public int animTick;
    public int animFrameNow;
    public int animFrameMax;
    
    public Animation(String file, int frames)
    {
        this.animFile = file;
        this.animTick = 0;
        this.animFrameNow = 1;
        this.animFrameMax = frames;
    }
    
    public Image getImage()
    {
        return Drawing.getImage(this.animFile + "-" + this.animFrameNow + ".png");
    }
    
}