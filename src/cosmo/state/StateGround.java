package cosmo.state;

import cosmo.app.Application;
import cosmo.gfx.Drawing;
import cosmo.ground.Board;
import java.awt.Graphics;

public class StateGround extends State
{
    private boolean pause;
    private Board board;
    
    public StateGround()
    {
        this.pause = false;
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
        if(this.pause) {this.renderPause(gfx);}
        else {this.board.render(gfx);}
    }
    
    public void renderPause(Graphics gfx)
    {
        Drawing.fadeScreen(gfx);
        gfx.setFont(Application.getThemeFont("HEADER"));
        int textWidth = gfx.getFontMetrics().stringWidth("PAUSE");
        Drawing.writeTextShadow(gfx, "PAUSE", 683 - (textWidth / 2), 375);
    }
    
    public void tick()
    {
        if(this.pause)
        {
            if(Application.getInputKeyboard().getKeyPressed() == "ENTER") {this.pause = false;}
        }
        else
        {
            if(Application.getInputKeyboard().getKeyPressed() == "ENTER") {this.pause = true;}
            else {this.board.tick();}
        }
    }
    
}