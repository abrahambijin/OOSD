package Utility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Bijin on 29-May-16.
 */
public enum Posture
{
    ATTACK(10), DEFENCE(-10), NORMAL(0);

    private int value;

    Posture(int value)
    {
        this.value = value;
    }

    public static ArrayList<String> getPostures()
    {
        return new ArrayList<>(Arrays.asList("ATTACK", "NORMAL", "DEFENCE"));
    }

    public int getValue()
    {
        return value;
    }

    public static Posture getPosture (String posture)
    {
        if(posture.equalsIgnoreCase("ATTACK"))
            return ATTACK;
        else if (posture.equalsIgnoreCase("DEFENCE"))
            return DEFENCE;
        else
            return NORMAL;
    }

}
