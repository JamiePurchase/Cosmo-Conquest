package cosmo.flight;

import cosmo.gfx.Animation;

public class FactoryScenery
{
    public static EntityScenery build(String template)
    {
        return new EntityScenery("scMeteor01", "Meteor", 200, 300, 0, null, new Animation("MeteoriteIdle", 1), 100, 5, null);
    }
}