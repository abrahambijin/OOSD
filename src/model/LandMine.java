package model;

/**
 * Created by mitulmanish on 23/04/2016.
 */
public class LandMine extends GameItem {
    private float healthDiminishinfFactor;

    public LandMine(String name) {
        super(name);
    }

    public LandMine(String name, float diminishFactor) {
        super(name);
        this.healthDiminishinfFactor = diminishFactor;
    }

    public float getHealthDiminishinfFactor() {
        return healthDiminishinfFactor;
    }
}
