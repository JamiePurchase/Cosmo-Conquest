package cosmo.state;

import cosmo.app.Application;
import cosmo.gfx.Drawing;
import java.awt.Graphics;

public class StateTitle extends State
{
    private int cursorNow, cursorMax;
    
    public void eventEnd()
    {
        
    }
    
    public void eventStart()
    {
        this.cursorNow = 1;
        this.cursorMax = 3;
    }
    
    public void render(Graphics gfx)
    {
        Drawing.fillScreen(gfx);
        gfx.drawImage(Drawing.getImage("interface/title.png"), 533, 25, null);
        
        // Temp
        gfx.setColor(Application.getThemeColour("FORE"));
        gfx.setFont(Application.getThemeFont("HEADER"));
        gfx.drawString("Ground", 600, 400);
        gfx.drawString("Flight", 600, 450);
        gfx.drawString("Exit", 600, 500);
        gfx.drawString("->", 565, (50 * this.cursorNow) + 350);
    }
    
    public void tick()
    {
        if(Application.getInputKeyboard().getKeyPressed() != "NONE")
        {
            if(Application.getInputKeyboard().getKeyPressed() == "ENTER")
            {
                if(this.cursorNow == 1) {Application.setState(new StateGround());}
                if(this.cursorNow == 2) {Application.setState(new StateFlight());}
                if(this.cursorNow == 3) {System.exit(0);}
                Application.getInputKeyboard().keyPressedDone();
            }
            if(Application.getInputKeyboard().getKeyPressed() == "UP")
            {
                if(this.cursorNow > 1) {this.cursorNow -= 1;}
                Application.getInputKeyboard().keyPressedDone();
            }
            if(Application.getInputKeyboard().getKeyPressed() == "DOWN")
            {
                if(this.cursorNow < this.cursorMax) {this.cursorNow += 1;}
                Application.getInputKeyboard().keyPressedDone();
            }
            if(Application.getInputKeyboard().getKeyPressed() == "Escape")
            {
                Application.getInputKeyboard().keyPressedDone();
                System.exit(0);
            }
        }
    }
    
}