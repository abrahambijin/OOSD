package Interfaces;

import Model.Position;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mitulmanish on 28/04/2016.
 */
public interface Shootable
{
    HashMap<Position, ArrayList<Position>> getWeaponRange(Position location);
}
