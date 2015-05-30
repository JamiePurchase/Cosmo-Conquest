package cosmo.ground;

import cosmo.flight.Entity;
import cosmo.flight.Mesh;
import java.awt.Point;
import java.awt.Rectangle;

public class MeshUnit
{
    private Unit unit;
    private Rectangle rect;
    
    public MeshUnit(Unit unit)
    {
        this.unit = unit;
        this.rect = new Rectangle(unit.getAreaPosX() - 16, unit.getAreaPosY() - 16, 32, 32);
    }

    public boolean getCollision(int x, int y)
    {
        return this.getCollision(new Point(x, y));
    }

    public boolean getCollision(Point xy)
    {
        return this.rect.contains(xy);
    }
}