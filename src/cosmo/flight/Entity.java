package cosmo.flight;

import cosmo.gfx.Animation;
import cosmo.gfx.Drawing;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Entity
{
    // Information
    private String infoCode;
    private String infoName;
    
    // Location
    private int areaPosX, areaPosY, areaPosZ;
    private Mesh areaMesh;
    
    // Animation
    private String animStance;
    private Animation animIdle;
    //private String animFile;
    //private int animSizeX, animSizeY;
    //private int animTick, animFrame, animFrameMax;
    
    // Movement
    private int moveSpdX, moveSpdY;
    
    // Stats
    private int statHealthMax, statHealthNow;
    
    // Destruction
    private int destroyScore;
    private Entity destroySpawn;
    
    public Entity(String code, String name, int posX, int posY, int posZ, Mesh mesh, Animation idle, int statHealth, int destroyScore, Entity destroySpawn)
    {
        /*this.infoCode = code;
        this.infoName = name;
        this.areaPosX = posX;
        this.areaPosY = posY;
        this.areaPosZ = posZ;
        this.areaMesh = mesh;
        this.animStance = "IDLE";
        this.animIdle = idle;
        this.moveSpdX = 0;
        this.moveSpdY = 0;
        this.statHealthNow = statHealth;
        this.statHealthMax = statHealth;
        this.destroyScore = destroyScore;
        this.destroySpawn = destroySpawn;*/
        
        /*this.animSizeX = sizeX;
        this.animSizeY = sizeY;
        this.animTick = 0;
        this.animFrame = 1;
        this.animFrameMax = 1;*/
    }
    
    public Animation getAnimIdle()
    {
        return this.animIdle;
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
    
    public abstract void render(Graphics gfx);
    public abstract void tick();
    
}