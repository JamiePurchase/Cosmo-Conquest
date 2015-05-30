package cosmo.state;

import cosmo.app.Application;
import cosmo.flight.Environment;
import cosmo.flight.HudMap;
import cosmo.flight.HudStats;
import cosmo.flight.VesselPlayer;
import cosmo.gfx.Drawing;
import java.awt.Graphics;

public class StateFlight extends State
{
    // Mission
    private int missionTick;
    
    // Player
    private VesselPlayer playerVessel;
    
    // Environment
    private Environment environment;
    
    // HUD
    private HudStats hudStats;
    private HudMap hudMap;
    
    public StateFlight()
    {
        // Mission
        this.missionTick = 0;
        
        // Player
        this.playerVessel = new VesselPlayer();
        
        // Environment
        this.environment = new Environment();
        
        // HUD
        this.hudStats = new HudStats();
        this.hudMap = new HudMap();
    }
    
    public void eventEnd()
    {
        
    }
    
    public void eventStart()
    {
        
    }
    
    public void render(Graphics gfx)
    {
        this.environment.render(gfx);
        
        // Temp
        gfx.drawImage(Drawing.getImage("scenery/MeteoriteIdle1.png"), 200, 200, null);
        
        this.playerVessel.render(gfx);
        this.hudStats.render(gfx);
        if(this.hudMap.getEnabled()) {this.hudMap.render(gfx);}
    }
    
    public void tick()
    {
        if(Application.getInputKeyboard().getKeyPressed() != "NONE") {tickKey();}
        tickMission();
        this.environment.tick();
        this.playerVessel.tick();
    }
    
    private void tickKey()
    {
        
    }
    
    private void tickMission()
    {
        this.missionTick += 1;
    }
    
}