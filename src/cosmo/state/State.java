package cosmo.state;

import java.awt.Graphics;

public abstract class State
{
    public abstract void eventEnd();
    public abstract void eventStart();
    public abstract void render(Graphics gfx);
    public abstract void tick();
}