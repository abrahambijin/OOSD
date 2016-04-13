package exceptions;

/**
 * Created by Bijin on 13-Apr-16.
 */
public class ObjectAlreadyExistException extends InstantiationException
{
    public ObjectAlreadyExistException(String message)
    {
        super(message);
    }
}
