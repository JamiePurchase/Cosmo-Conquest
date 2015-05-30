package cosmo.flight;

import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class MeshSphere extends Mesh
{
    private int radius;
    private Ellipse2D.Float circle;
    
    public MeshSphere(Entity entity, int radius)
    {
        super(entity);
        this.radius = radius;
        this.circle = new Ellipse2D.Float(entity.getAreaPosX() - radius, entity.getAreaPosY() - radius, radius * 2, radius * 2);
    }

    @Override
    public boolean getCollision(int x, int y)
    {
        return this.getCollision(new Point(x, y));
    }

    @Override
    public boolean getCollision(Point xy)
    {
        return circle.contains(xy);
    }
}