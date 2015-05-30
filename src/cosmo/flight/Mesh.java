package cosmo.flight;

import java.awt.Point;

public abstract class Mesh
{
    private Entity entity;
    
    public Mesh(Entity entity)
    {
        this.entity = entity;
    }
    
    public abstract boolean getCollision(int x, int y);
    public abstract boolean getCollision(Point xy);
    
    public Entity getEntity()
    {
        return this.entity;
    }
}