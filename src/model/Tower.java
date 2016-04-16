package model;

import utility.PossiblePoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Tower extends Troop
{

    Point head;

    public Tower()
    {
        super("Tower","Images/Tower.png", 1,
                new ArrayList<>(Arrays.asList(new Sniper(), new Grenade())),
                Direction.CUSTOM);

        Random randomNumberGenerator = new Random();
        int headXPos = randomNumberGenerator.nextInt(3) - 1;
        int headYPos;
        do
        {
            headYPos = randomNumberGenerator.nextInt(3) - 1;
        } while (headXPos == 0 && headYPos == 0);

        head = new Point(headXPos, headYPos);
    }

    @Override
    public ArrayList<Point> getWeaponRange(int weaponIndex)
    {
        return super.getWeaponRange(weaponIndex,head);
    }

    public  ArrayList<Point> possibleMovePositions()
    {
        return PossiblePoints.getPossiblePoints(super.getPosition(),
                super.getMaxNoOfSteps(),Direction.ANY);
    }

    public void move(Point newPosition)
    {
        int headX = newPosition.getXCoordinate()-head.getXCoordinate();
        int headY = newPosition.getYCoordinate()-head.getYCoordinate();
        head = new Point(headX,headY);
    }

}
