package cosmo.skirmish;

import cosmo.app.Application;
import cosmo.gfx.Drawing;
import cosmo.ui.Panel;
import java.awt.Graphics;

public class DisplayCommand
{
    private Panel commandPanel;
    private String[] commandOption;
    private boolean commandEnabled;
    
    public DisplayCommand(String opt1, String opt2, String opt3, String opt4)
    {
        this.commandPanel = new Panel(25, 443, 200, 300);
        this.commandOption = new String[4];
        this.commandOption[0] = opt1;
        this.commandOption[1] = opt2;
        this.commandOption[2] = opt3;
        this.commandOption[3] = opt4;
        this.commandEnabled = true;
    }
    
    public boolean isEnabled()
    {
        return this.commandEnabled;
    }
    
    public void render(Graphics gfx)
    {
        this.commandPanel.render(gfx);
        gfx.setColor(Application.getThemeColour("TEXT"));
        gfx.setFont(Application.getThemeFont("MESSAGE"));
        for(int option = 0; option < this.commandOption.length; option++)
        {
            gfx.drawString(this.commandOption[option], 40, (option * 30) + 430);
        }
    }
}