package model;

        import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Mg17 extends Weapon{
    public Mg17() {
        super(2, 20);
    }


    @Override
    public ArrayList<Point> weaponRange(Point point)
    {
        ArrayList<Point> shootingOptions = new ArrayList<>();
        shootingOptions.addAll(super.getDiagonalShootingOptions(point));
        return shootingOptions;
    }
}
