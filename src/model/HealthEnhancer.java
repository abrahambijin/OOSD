package model;

/**
 * Created by mitulmanish on 23/04/2016.
 */
public class HealthEnhancer extends GameItem {
    private int healthMultiplyingFactor;

    public HealthEnhancer(String name, int healthMultiplyingFactor) {
        super(name);
        this.healthMultiplyingFactor = healthMultiplyingFactor;
    }

    public int getHealthMultiplyingFactor() {
        return healthMultiplyingFactor;
    }
}
