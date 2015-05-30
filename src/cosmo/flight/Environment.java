package cosmo.flight;

import cosmo.gfx.Animation;
import cosmo.gfx.Drawing;
import java.awt.Graphics;
import java.util.ArrayList;

public class Environment
{
    // Information
    private String infoCallsign;
    private String infoLocation;
    private String infoBackdrop;
    
    // Objects
    private ArrayList<Vessel> entityVessels;
    private ArrayList<Entity> entityScenery;
    
    public Environment()
    {
        // Temporary
        //entityScenery.add(FactoryScenery.build("Meteorite"));
    }
    
    public void render(Graphics gfx)
    {
        renderBackdrop(gfx);
        //renderVessels(gfx);
        //renderScenery(gfx);
    }
    
    private void renderBackdrop(Graphics gfx)
    {
        Drawing.fillScreen(gfx);
    }
    
    private void renderScenery(Graphics gfx)
    {
        for(int scenery = 0; scenery < entityScenery.size(); scenery++)
        {
            entityScenery.get(scenery).render(gfx);
        }
    }
    
    private void renderVessels(Graphics gfx)
    {
        for(int vessel = 0; vessel < entityVessels.size(); vessel++)
        {
            //entityVessels[vessel].render(gfx);
        }
    }
    
    public void tick()
    {
        //tickBackdrop() ??
        //tickVessel();
        //tickEntity();
    }
    
    private void tickEntity()
    {
        for(int scenery = 0; scenery < entityScenery.size(); scenery++)
        {
            //entityScenery[scenery].tick();
        }
    }
    
    private void tickVessel()
    {
        for(int vessel = 0; vessel < entityVessels.size(); vessel++)
        {
            //entityVessels[vessel].tick();
        }
    }
    
}