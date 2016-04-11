package model;

import java.util.Random;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Tower extends Troop
{

    Point head;

    public Tower(Point position)
    {
        super("Tower",position, 1, new Sniper(), new Grenade());

        Random randomNumberGenerator = new Random();
        int headXPos = randomNumberGenerator.nextInt(3) - 1;
        int headYPos;
        do
        {
            headYPos = randomNumberGenerator.nextInt(3) - 1;
        } while (headXPos == 0 && headYPos == 0);

        head = new Point(headXPos, headYPos);
        updateWeaponHead();
    }

    private void updateWeaponHead()
    {
        ((Sniper)super.getPrimaryWeapon()).updateHead(head);
        ((Grenade)super.getSecondaryWeapon()).updateHead(head);
    }
}
