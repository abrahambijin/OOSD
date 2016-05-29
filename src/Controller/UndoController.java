package Controller;

import Model.Game;
import Model.GameItem;
import Model.Position;
import View.GameGUI;

import javax.swing.*;
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
        String[] values = {"1","2","3"};

        Object selected = JOptionPane.showInputDialog(null, "Select level of undo", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");
        if ( selected != null ){//null if the user cancels.
            String selectedString = selected.toString();
            //do something
        }else{
            System.out.println("User cancelled");
        }
        super.undo();
        super.getGame().getCurrentPlayer().undoIsCalled();


        //String value = super.getView().getUndoMove().getSelected();


        
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
