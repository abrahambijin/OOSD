package Utility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Bijin on 29-May-16.
 */
public enum Posture
{
    ATTACK, DEFENCE, NORMAL;

    public ArrayList<String> getPostures()
    {
        return new ArrayList<>(Arrays.asList("ATTACK","DEFENCE","NORMAL"));
    }
}
