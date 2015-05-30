package cosmo.state;

import cosmo.app.Application;
import cosmo.ground.Board;
import java.awt.Graphics;

public class StateGround extends State
{
    private Board board;
    
    public StateGround()
    {
        this.board = new Board();
    }
    
    public void eventEnd()
    {
        
    }
    
    public void eventStart()
    {
        
    }
    
    public void render(Graphics gfx)
    {
        this.board.render(gfx);
    }
    
    public void tick()
    {
        this.board.tick();
    }
    
}