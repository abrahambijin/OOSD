package model;

/**
 * Created by mitulmanish on 23/04/2016.
 */
public class HealthDiminisher extends GameItem {
    private float healthDiminishinfFactor;

    public HealthDiminisher(String name) {
        super(name);
    }

    public HealthDiminisher(String name, float diminishFactor) {
        super(name);
        this.healthDiminishinfFactor = diminishFactor;
    }

    public float getHealthDiminishinfFactor() {
        return healthDiminishinfFactor;
    }
}
