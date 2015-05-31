package cosmo.ground;

import cosmo.gfx.Drawing;
import cosmo.gfx.Tileset;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

public class Unit
{
    // Information
    private Board infoBoard;
    private String infoCode;
    private String infoName;
    
    // Location
    private int areaPosX, areaPosY, areaPosZ;
    private MeshUnit areaMesh;
    private Scenery areaSmash;
    
    // Animation
    private Tileset animFile;
    private String animFace;
    private boolean animIdle, animWalk, animEight;
    private int animTickNow, animTickMax, animFrameNow, animFrameMax;
    private ArrayList<Tileset> animAttachFile;
    private int animAttachCount;
    
    // Stats
    private int statHealthMax, statHealthNow;
    
    public Unit(Board board, String code, String name, int posX, int posY, int posZ, String mesh, Tileset animFile, boolean animEight, int health)
    {
        this.infoBoard = board;
        this.infoCode = code;
        this.infoName = name;
        this.areaPosX = posX;
        this.areaPosY = posY;
        this.areaPosZ = posZ;
        this.areaMesh = new MeshUnit(this);
        this.areaSmash = null;
        this.animFile = animFile;
        this.animEight = animEight;
        this.animFace = "S";
        this.animIdle = true;
        this.animWalk = false;
        this.animTickNow = 0;
        this.animTickMax = 6;
        this.animFrameNow = 1;
        this.animFrameMax = 4;
        this.animAttachFile = new ArrayList<Tileset>();
        this.animAttachCount = 0;
        this.statHealthNow = health;
        this.statHealthMax = health;
    }
    
    public void attachAnim(Tileset attach)
    {
        this.animAttachFile.add(attach);
        this.animAttachCount += 1;
    }
    
    public String getAnimFace()
    {
        return this.animFace;
    }
    
    public Image getAnimImage()
    {
        if(this.animEight) {return this.getAnimImageEight();}
        return this.getAnimImageFour();
    }
    
    public Image getAnimImageEight()
    {
        int tileX = 1;
        int tileY = 1;
        if(this.animFace == "NW") {tileY = 2;}
        if(this.animFace == "W") {tileY = 3;}
        if(this.animFace == "SW") {tileY = 4;}
        if(this.animFace == "S") {tileY = 5;}
        if(this.animFace == "SE") {tileY = 6;}
        if(this.animFace == "E") {tileY = 7;}
        if(this.animFace == "NE") {tileY = 8;}
        if(this.animIdle == false)
        {
            if(this.animFrameNow == 2 || this.animFrameNow == 4) {tileX = 2;}
        }
        return this.animFile.getTileAt(tileX, tileY);
    }
    
    public Image getAnimImageFour()
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
        if(this.moveValid())
        {
            this.animIdle = false;
            this.animWalk = true;
            this.animTickNow = 0;
            this.animTickMax = 1;
            this.animFrameNow = 1;
            this.animFrameMax = 4;
        }
    }
    
    public boolean moveValid()
    {
        // TASK: Check destination for collision
        int targetX = this.areaPosX;
        int targetY = this.areaPosY;
        if(this.animFace == "NE")
        {
            targetX += 1;
            targetY -= 1;
        }
        else if(this.animFace == "NW")
        {
            targetX -= 1;
            targetY -= 1;
        }
        else if(this.animFace == "SE")
        {
            targetX += 1;
            targetY += 1;
        }
        else if(this.animFace == "SW")
        {
            targetX -= 1;
            targetY += 1;
        }
        else if(this.animFace == "N") {targetY -= 1;}
        else if(this.animFace == "E") {targetX += 1;}
        else if(this.animFace == "W") {targetX -= 1;}
        else if(this.animFace == "S") {targetY += 1;}
        
        // Is there scenery at the target tile?
        // CONSIDER: use the collision mesh to determine how many tiles to look at
        if(this.infoBoard.getScenery(targetX, targetY))
        {
            Scenery targetScenery = this.infoBoard.getSceneryFound();
            if(targetScenery.isSmashable())
            {
                this.areaSmash = targetScenery;
                return true;
            }
            else {return false;}
        }
        return true;
    }
    
    public void render(Graphics gfx)
    {
        // Test 1: Person
        //gfx.drawImage(this.getAnimImage(), this.getAnimPosX(), this.getAnimPosY(), null);
        
        // Test 2: Vehicle
        //gfx.drawImage(Drawing.getImage("unit/veTungstanBodyIdle" + this.animFrameNow + ".png"), this.getAnimPosX(), this.getAnimPosY(), null);
        //gfx.drawImage(Drawing.getImage("unit/veTungstanCannonIdle1.png"), this.getAnimPosX(), this.getAnimPosY(), null);
        
        // Test 3: Vehicle Tileset
        gfx.drawImage(this.getAnimImage(), this.getAnimPosX(), this.getAnimPosY(), null);
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
                    if(this.areaSmash != null) {this.areaSmash.smash();}
                }
            }
        }
    }
}