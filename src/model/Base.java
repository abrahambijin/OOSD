package Model;

import Exceptions.ObjectAlreadyExistException;

import java.io.Serializable;

/**
 * Created by Bijin on 14-Apr-16.
 */
public class Base extends GameItem implements Serializable
{
    private static int COUNT = 0;

    private Base()
    {
        super("Base", 50);
        COUNT++;
    }

    public static Base baseFactory() throws ObjectAlreadyExistException
    {
        if (COUNT == 0)
            return new Base();
        else
            throw new ObjectAlreadyExistException(
                    "The game can have only one" + " Base class");
    }
}
