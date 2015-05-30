package cosmo.state;

import cosmo.app.Application;
import cosmo.ground.Board;
import cosmo.skirmish.Battle;
import java.awt.Graphics;

public class StateSkirmish extends State
{
    private Battle battle;
    
    public StateSkirmish()
    {
        this.battle = new Battle();
    }
    
    public void eventEnd()
    {
        
    }
    
    public void eventStart()
    {
        
    }
    
    public void render(Graphics gfx)
    {
        this.battle.render(gfx);
    }
    
    public void tick()
    {
        this.battle.tick();
    }
    
}