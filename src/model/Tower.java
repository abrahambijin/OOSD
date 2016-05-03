package model;

import utility.PossiblePoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Tower extends Troop
{

    Position head;

    public Tower()
    {
        super("Tower", 1,
                new ArrayList<>(Arrays.asList(new Sniper(), new Grenade())), Direction.CUSTOM);

        Random randomNumberGenerator = new Random();
        int headXPos = randomNumberGenerator.nextInt(3) - 1;
        int headYPos;
        do
        {
            headYPos = randomNumberGenerator.nextInt(3) - 1;
        } while (headXPos == 0 && headYPos == 0);

        head = new Position(headXPos, headYPos);
        super.setImageIconPath("Images/Tower/Tower" + head + ".png");
    }

    public HashMap<Position, ArrayList<Position>> getWeaponRange(int weaponIndex)

    {
        return super.getWeaponRange(weaponIndex, head);
    }


    public HashMap<Position, ArrayList<Position>> possibleMovePositions()
    {
        HashMap<Position, ArrayList<Position>> positions = PossiblePoints
                .getPossiblePoints(super.getPosition(), super.getMaxNoOfSteps(),
                        Direction.ANY);
        positions.remove(head);
        return positions;
    }

    public void move(Position newPosition)
    {
        int headX =
                newPosition.getXCoordinate() - getPosition().getXCoordinate();
        int headY =
                newPosition.getYCoordinate() - getPosition().getYCoordinate();
        head = new Position(headX, headY);
        super.setImageIconPath("Images/Tower/Tower" + head + ".png");
    }

}
