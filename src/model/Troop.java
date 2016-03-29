package model;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public abstract class Troop extends GameItem{
    private int steps;
    private Weapon primaryWeapon;
    private Weapon secondaryWeapon;


    public Troop(Point position, int steps, Weapon primaryWeapon, Weapon secondaryWeapon) {
        super(position);
        this.steps = steps;
        this.primaryWeapon = primaryWeapon;
        this.secondaryWeapon = secondaryWeapon;
    }


    public ArrayList<Point> primaryWeaponRange(){

    }

    public ArrayList<Point> secondaryWeaponRange(){

    }


}
