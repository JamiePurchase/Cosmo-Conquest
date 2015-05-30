package cosmo.flight;

import java.awt.Point;
import java.awt.Rectangle;

public class MeshCube extends Mesh
{
    private int width, height;
    private Rectangle rect;
    
    public MeshCube(Entity entity, int width, int height)
    {
        super(entity);
        this.width = width;
        this.height = height;
        this.rect = new Rectangle(entity.getAreaPosX() - (width / 2), entity.getAreaPosY() - (height / 2), width, height);
    }

    @Override
    public boolean getCollision(int x, int y)
    {
        return this.getCollision(new Point(x, y));
    }

    @Override
    public boolean getCollision(Point xy)
    {
        return this.rect.contains(xy);
    }
}