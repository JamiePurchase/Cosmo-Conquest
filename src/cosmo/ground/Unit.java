package cosmo.ground;

import cosmo.gfx.Drawing;
import cosmo.gfx.Tileset;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

public class Unit
{
    // Information
    private String infoCode;
    private String infoName;
    
    // Location
    private int areaPosX, areaPosY, areaPosZ;
    private MeshUnit areaMesh;
    
    // Animation
    private Tileset animFile;
    private String animFace;
    private boolean animIdle;
    private boolean animWalk;
    private int animTickNow, animTickMax, animFrameNow, animFrameMax;
    
    // Stats
    private int statHealthMax, statHealthNow;
    
    public Unit(String code, String name, int posX, int posY, int posZ, String mesh, String anim, int health)
    {
        this.infoCode = code;
        this.infoName = name;
        this.areaPosX = posX;
        this.areaPosY = posY;
        this.areaPosZ = posZ;
        this.areaMesh = new MeshUnit(this);
        this.animFile = new Tileset(Drawing.getImage("unit/ch" + anim + ".png"), 32, 32, 3, 4);
        this.animFace = "S";
        this.animIdle = true;
        this.animWalk = false;
        this.animTickNow = 0;
        this.animTickMax = 6;
        this.animFrameNow = 1;
        this.animFrameMax = 4;
        this.statHealthNow = health;
        this.statHealthMax = health;
    }
    
    public String getAnimFace()
    {
        return this.animFace;
    }
    
    public Image getAnimImage()
    {
        int tileX = 2;
        int tileY = 1;
        if(this.animFace == "N") {tileY = 4;}
        if(this.animFace == "E") {tileY = 3;}
        if(this.animFace == "W") {tileY = 2;}
        if(this.animIdle == false)
        {
            tileX = this.animFrameNow;
            if(this.animFrameNow == 4) {tileX = 2;}
        }
        return this.animFile.getTileAt(tileX, tileY);
    }
    
    public int getAnimPosX()
    {
        if(this.animWalk)
        {
            if(this.animFace == "E") {return this.areaPosX * 32 + (this.animFrameNow * 8);}
            if(this.animFace == "W") {return this.areaPosX * 32 - (this.animFrameNow * 8);}
        }
        return this.areaPosX * 32;
    }
    
    public int getAnimPosY()
    {
        if(this.animWalk)
        {
            if(this.animFace == "N") {return this.areaPosY * 32 - (this.animFrameNow * 8);}
            if(this.animFace == "S") {return this.areaPosY * 32 + (this.animFrameNow * 8);}
        }
        return this.areaPosY * 32;
    }
    
    public boolean getAnimWalk()
    {
        return this.animWalk;
    }
    
    public Point getAreaPoint()
    {
        return new Point(this.areaPosX, this.areaPosY);
    }
    
    public int getAreaPosX()
    {
        return this.areaPosX;
    }
    
    public int getAreaPosY()
    {
        return this.areaPosY;
    }
    
    public int getAreaPosZ()
    {
        return this.areaPosZ;
    }
    
    public boolean getInputListen()
    {
        if(this.animWalk) {return false;}
        return true;
    }
    
    public void move(String face)
    {
        this.setAnimFace(face);
        // TASK: Check destination for collision
        this.animIdle = false;
        this.animWalk = true;
        this.animTickNow = 0;
        this.animTickMax = 1;
        this.animFrameNow = 1;
        this.animFrameMax = 4;
    }
    
    public void render(Graphics gfx)
    {
        //gfx.drawImage(this.getAnimImage(), this.getAnimPosX(), this.getAnimPosY(), null);
        gfx.drawImage(Drawing.getImage("unit/veTungstanBodyIdle" + this.animFrameNow + ".png"), this.getAnimPosX(), this.getAnimPosY(), null);
        gfx.drawImage(Drawing.getImage("unit/veTungstanCannonIdle1.png"), this.getAnimPosX(), this.getAnimPosY(), null);
    }
    
    public void setAnimFace(String face)
    {
        this.animFace = face;
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
                this.animFrameNow = 1;
                if(this.animWalk)
                {
                    if(this.animFace == "N") {this.areaPosY -= 1;}
                    if(this.animFace == "S") {this.areaPosY += 1;}
                    if(this.animFace == "E") {this.areaPosX += 1;}
                    if(this.animFace == "W") {this.areaPosX -= 1;}
                    this.animIdle = true;
                    this.animWalk = false;
                }
            }
        }
    }
}