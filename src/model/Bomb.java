package model;

        import java.util.ArrayList;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Bomb extends Weapon {
    public Bomb() {
        super(1, 25);
    }

    @Override
    public ArrayList<Point> weaponRange(Point point)
    {
        ArrayList<Point> shootingOptions = new ArrayList<>();
        shootingOptions.addAll(super.getDiagonalShootingOptions(point));
        return shootingOptions;
    }
}
