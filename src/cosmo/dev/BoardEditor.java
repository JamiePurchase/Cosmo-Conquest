package cosmo.dev;

import cosmo.app.Application;
import cosmo.ground.Board;
import cosmo.ground.Scenery;
import cosmo.ground.Unit;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BoardEditor
{
    // File Data
    private static boolean fileActive;
    private static String filePath;
    private static boolean fileUnsaved;
    private static Board fileBoard;
    
    // Scenery
    private ArrayList<Scenery> scenery;
    
    public static void main(String args[])
    {
        appStart();
    }
    
    private static void appStart()
    {
        fileActive = false;
        filePath = "";
        fileUnsaved = false;
        fileBoard = new Board();
    }
    
    private static void render(Graphics gfx)
    {
        
    }
    
    private static void tick()
    {
        
    }
    
}