package cosmo.flight;

import cosmo.gfx.Drawing;
import java.awt.Graphics;

public class Vessel
{
    // Information
    private String infoName;
    private String infoClass;
    private boolean infoAlly;
    
    // Data
    private int dataVelocity;
    private int dataAreaPosX, dataAreaPosY;
    private int dataSizeWide, dataSizeHigh;
    
    // Animation
    private String animFile;
    private int animTick, animFrame;

    // Stats
    private int statHealthMax, statHealthNow;
    private int statShieldMax, statShieldNow;
    
    public Vessel()
    {
        // Temporary
        this.dataAreaPosX = 0;
        this.dataAreaPosY = 0;
        this.dataSizeWide = 100;
        this.dataSizeHigh = 100;
        this.animTick = 0;
        this.animFrame = 1;
        this.statHealthNow = 100;
        this.statHealthMax = 100;
        this.statShieldMax = 0;
        this.statShieldNow = 0;
    }
    
    private int getDrawPosX()
    {
        return 683 - (dataSizeWide / 2) + dataAreaPosX;
    }
    
    private int getDrawPosX(int size)
    {
        return 683 - (size / 2) + dataAreaPosX;
    }
    
    private int getDrawPosY()
    {
        return 500 - (dataSizeHigh / 2) + dataAreaPosY;
    }
    
    private int getDrawPosY(int size)
    {
        return 500 - (size / 2) + dataAreaPosY;
    }
    
    public void moveAreaPosX(int move)
    {
        this.dataAreaPosX += move;
    }
    
    public void moveAreaPosY(int move)
    {
        this.dataAreaPosY += move;
    }
    
    public void render(Graphics gfx)
    {
        renderVessel(gfx);
        if(this.statShieldNow > 0) {renderShield(gfx);}
    }
    
    public void renderShield(Graphics gfx)
    {
        /*
        ** TASK
        **  - calculate the current shield percentage
        **  - set the opacity between 0.0f and 0.5f dependant on the percentage
        */
        Float opacity = 0.3f;
        Drawing.drawImageOpaque(gfx, Drawing.getImage("vessel/shield1.png"), this.getDrawPosX(200), this.getDrawPosY(200), opacity);
    }
    
    public void renderVessel(Graphics gfx)
    {
        String image = "vessel/carbon1a.png";
        if(this.animFrame == 2) {image = "vessel/carbon1b.png";}
        gfx.drawImage(Drawing.getImage(image), this.getDrawPosX(), this.getDrawPosY(), null);
    }
    
    public void setAreaPosX(int pos)
    {
        this.dataAreaPosX = pos;
    }
    
    public void setAreaPosY(int pos)
    {
        this.dataAreaPosY = pos;
    }
    
    public void tick()
    {
        this.animTick += 1;
        if(this.animTick > 30)
        {
            this.animTick = 0;
            this.animFrame += 1;
            if(this.animFrame > 2)
            {
                this.animFrame = 1;
            }
        }
    }
    
}