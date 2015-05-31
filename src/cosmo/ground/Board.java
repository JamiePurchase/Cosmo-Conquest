package cosmo.ground;

import cosmo.app.Application;
import cosmo.flight.Mesh;
import cosmo.gfx.Animation;
import cosmo.gfx.Drawing;
import cosmo.gfx.Tileset;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Board
{
    // Information
    private String infoName;
    private boolean infoEdit;
    
    // Tiles
    private String tileBackground;
    private int tileCountX, tileCountY;
    private String[][] tileTerrain;
    private BufferedImage tileImage;
    private boolean tileImageReady;
    
    // Units
    private Unit player;
    
    // Scenery
    private ArrayList<Scenery> scenery;
    private Scenery sceneryTarget;
    
    // Interface
    private DisplayCharacter uiCharacter;
    private DisplayEquipment uiEquipment;
    private DisplayMinimap uiMinimap;
    
    public Board()
    {
        // Information
        this.infoName = "";
        this.infoEdit = false;
        
        // Tiles
        this.tileBackground = "grass2";
        this.tileCountX = 42;
        this.tileCountY = 24;
        this.tileTerrain = new String[this.tileCountX][this.tileCountY];
        this.tileImageReady = false;
        this.setTerrainAll("grass2");

        // Units
        //this.player = new Unit(this, "PLAYER", "Gomran", 10, 4, 0, "CUBE", new Tileset(Drawing.getImage("unit/chGomran.png"), 32, 32, 3, 4), false, 0);
        this.player = new Unit(this, "PLAYER", "Tungstan", 10, 4, 0, "CUBE", new Tileset(Drawing.getImage("unit/veTungstanBodyMuslowt.png"), 96, 96, 2, 8), true, 0);
        
        // Scenery
        this.scenery = new ArrayList<Scenery>();
        this.addScenery(new Scenery("treeA"), 6, 4);
        this.addScenery(new Scenery("treeA"), 28, 3);
        this.addScenery(new Scenery("treeB"), 22, 5);
        this.addScenery(new Scenery("treeC"), 8, 14);
        this.addScenery(new Scenery("treeC"), 16, 18);
        this.sceneryTarget = null;
        
        // Interface
        this.uiCharacter = new DisplayCharacter();
        this.uiEquipment = new DisplayEquipment();
        this.uiMinimap = new DisplayMinimap(this.player);
    }
    
    public void addScenery(Scenery scenery, int posX, int posY)
    {
        scenery.setTilePosition(posX, posY);
        this.scenery.add(scenery);
    }
    
    public boolean getScenery(int posX, int posY)
    {
        this.sceneryTarget = null;
        for(int s = 0; s < this.scenery.size(); s++)
        {
            if(this.scenery.get(s).getTilePosX() == posX && this.scenery.get(s).getTilePosY() == posY)
            {
                this.sceneryTarget = this.scenery.get(s);
                return true;
            }
        }
        return false;
    }
    
    public Scenery getSceneryFound()
    {
        Scenery scenery = this.sceneryTarget;
        this.sceneryTarget = null;
        return scenery;
    }
    
    private Image getTerrainBackground()
    {
        return Drawing.getImage("terrain/" + this.tileBackground + "bkg.png");
    }
    
    private Image getTerrainImage(int posX, int posY)
    {
        return Drawing.getImage("terrain/" + this.tileTerrain[posX][posY] + ".png");
    }
    
    public void render(Graphics gfx)
    {
        //renderBackground(gfx);
        renderTerrain(gfx);
        this.player.render(gfx);
        if(this.scenery.size() > 0) {renderScenery(gfx);}
        renderDisplay(gfx);
    }
    
    public void renderBackground(Graphics gfx)
    {
        gfx.drawImage(this.getTerrainBackground(), 0, 0, null);
    }
    
    private void renderDisplay(Graphics gfx)
    {
        if(this.uiCharacter.isEnabled()) {this.uiCharacter.render(gfx);}
        if(this.uiEquipment.isEnabled()) {this.uiEquipment.render(gfx);}
        if(this.uiMinimap.isEnabled()) {this.uiMinimap.render(gfx);}
        // NOTE: the minimap needs access to the entities
    }
    
    public void renderScenery(Graphics gfx)
    {
        for(int object = 0; object < this.scenery.size(); object++)
        {
            this.scenery.get(object).render(gfx);
        }
    }
    
    public void renderTerrain(Graphics gfx)
    {
        // NOTE: consider drawing a large portion of the tileImage onto a fresh bufferedImage
        // then just add the new row or column when scrolling the board
        if(this.tileImageReady == false)
        {
            this.tileImage = new BufferedImage(1344, 768, BufferedImage.TYPE_BYTE_INDEXED);
            Graphics tileImageGfx = tileImage.createGraphics();
            for(int x = 0; x < this.tileCountX; x++)
            {
                for(int y = 0; y < this.tileCountY; y++)
                {
                    tileImageGfx.drawImage(this.getTerrainImage(x, y), x * 32, y * 32, null);
                    //gfx.drawImage(Drawing.resize(Drawing.getImage("terrain/grass2.png"), 32, 32), x * 32, y * 32, null);
                }
            }
            this.tileImageReady = true;
        }
        gfx.drawImage(this.tileImage, 0, 0, null);
    }
    
    public void setTerrain(int posX, int posY, String terrain)
    {
        this.tileTerrain[posX][posY] = terrain;
    }
    
    public void setTerrainAll(String terrain)
    {
        for(int x = 0; x < this.tileCountX; x++)
        {
            for(int y = 0; y < this.tileCountY; y++)
            {
                this.setTerrain(x, y, terrain);
            }
        }
    }
    
    public void setTileImageRedraw()
    {
        // IMPORTANT!
        // this needs to be called whenever the tiles on the screen change
        // including board scrolling when the player moves and any terrain changes for any other reason
        this.tileImageReady = false;
        
        // CONSIDER
        // it may be possible to have animated tiles layered on top without drawing all tiles
    }
    
    public void tick()
    {
        this.player.tick();
        // CONSIDER may not need this if
        if(this.player.getAnimWalk() == false)
        {
            if(Application.getInputKeyboard().keyUp.isPressed() && Application.getInputKeyboard().keyRight.isPressed()) {this.player.move("NE");}
            else if(Application.getInputKeyboard().keyUp.isPressed() && Application.getInputKeyboard().keyLeft.isPressed()) {this.player.move("NW");}
            else if(Application.getInputKeyboard().keyDown.isPressed() && Application.getInputKeyboard().keyRight.isPressed()) {this.player.move("SE");}
            else if(Application.getInputKeyboard().keyDown.isPressed() && Application.getInputKeyboard().keyLeft.isPressed()) {this.player.move("SW");}
            else if(Application.getInputKeyboard().keyUp.isPressed()) {this.player.move("N");}
            else if(Application.getInputKeyboard().keyDown.isPressed()) {this.player.move("S");}
            else if(Application.getInputKeyboard().keyLeft.isPressed()) {this.player.move("W");}
            else if(Application.getInputKeyboard().keyRight.isPressed()) {this.player.move("E");}
        }
    }
    
}