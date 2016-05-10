package Controller;

import Model.*;
import View.GameGUI;

import java.awt.event.ActionEvent;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class BackButtonController extends GameController
{
    public BackButtonController(Game game, GameGUI view)
    {
        super(game, view);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        GameActionController.setSTATUS(ButtonStatus.NOT_SELECTED);
        super.getView().getPlayGround()
                .disableButtons(super.getGame().getOccupiedBoardLocation(),
                        null);
        super.getView().getPlayerStatus().getTop().enableBackButton(false);
        super.getView().getPlayerStatus().setWeaponListVisible(false);
        super.getView().setStatus(super.getGame().getCurrentPlayer().getName() +
                ", select the troop you wish to move or attack with");
    }
}