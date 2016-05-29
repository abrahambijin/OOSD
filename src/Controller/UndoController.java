package Controller;

import Model.Game;
import Model.GameItem;
import Model.Position;
import Undo.SaveGameState;
import View.GameGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Bijin on 10-May-16.
 */
public class UndoController extends GameController implements ActionListener
{
    public UndoController(GameGUI view)
    {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        super.undo();

        ArrayList<Position> occupiedPositions =
                super.getGame().getOccupiedBoardLocation();

        super.getView().getPlayGround().reset();
        for (Position position : occupiedPositions)
        {
            GameItem item = super.getGame().getItem(position);
            super.getView().getPlayGround()
                    .setButtonImage(position, item.getImageIconPath());
        }
        super.getView().getPlayGround().disableButtons(occupiedPositions, null);
        super.getView().getPlayerStatus()
                .updatePage(super.getGame().getCurrentPlayer());
        System.out.println(super.getGame().getCurrentPlayer().getName()+"++++");
        super.getView().getPlayerStatus().getTop().enableBackButton(false);
        GameActionController.setSTATUS(ButtonStatus.NOT_SELECTED);
        super.getView().setStatus(super.getGame().getCurrentPlayer().getName() +
                ", select the troop you wish to move or attack with");
    }
}
