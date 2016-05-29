package Controller;

import View.GameGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class BackButtonController extends GameController implements
        ActionListener
{
    public BackButtonController(GameGUI view)
    {
        super(view);
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
        super.getView().getPlayerStatus().getBottom2().resetButton();
        super.getView().setStatus(super.getGame().getCurrentPlayer().getName() +
                ", select the troop you wish to move or attack with");
    }
}