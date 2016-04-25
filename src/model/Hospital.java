package model;

/**
 * Created by mitulmanish on 23/04/2016.
 */
public class Hospital extends GameItem {
    private int healthMultiplyingFactor;

    public Hospital(String name, int healthMultiplyingFactor) {
        super(name);
        this.healthMultiplyingFactor = healthMultiplyingFactor;
    }

    public int getHealthMultiplyingFactor() {
        return healthMultiplyingFactor;
    }
}
