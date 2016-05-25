package Model;

import Exceptions.ObjectAlreadyExistException;

/**
 * Created by Bijin on 14-Apr-16.
 */
public class Obstacles extends GameItem
{
    private static int COUNT = 0;

    private Obstacles()
    {
        super("Base", 50);
        COUNT++;
    }

    public static Obstacles baseFactory() throws ObjectAlreadyExistException
    {
        if (COUNT == 0)
            return new Obstacles();
        else
            throw new ObjectAlreadyExistException(
                    "The game can have only one" + " Base class");
    }
}
