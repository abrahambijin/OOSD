package Interfaces;

import Model.GameItem;
import Model.Unit;

import java.util.ArrayList;

/**
 * Created by mitulmanish on 6/05/2016.
 */
public interface PlayerItem {

    ArrayList<GameItem> getItems(int numberOfItems);
}
