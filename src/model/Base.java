package model;

import exceptions.ObjectAlreadyExistException;

/**
 * Created by Bijin on 14-Apr-16.
 */
public class Base extends GameItem
{
    private static int COUNT = 0;

    private Base()
    {
        super("Base", 500);
        COUNT++;
    }

    public static Base baseFactory() throws ObjectAlreadyExistException
    {
        if(COUNT==0)
            return new Base();
        else
            throw new ObjectAlreadyExistException("The game can have only one" +
                    " Base class");
    }
}
