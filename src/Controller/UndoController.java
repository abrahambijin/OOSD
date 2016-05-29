package Controller;

import Memento.CareTaker;
import Model.GameItem;
import Utility.Position;
import Settings.GameSettings;
import Utility.ButtonStatus;
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
        ArrayList<String> inputs = new ArrayList<>();
        for (int i = 1;
             i <= (CareTaker.getCount() / (GameSettings.NO_OF_PLAYERS + 1)) &&
                     i <= GameSettings.MAX_POSSIBLE_UNDO; i++)
            inputs.add(i + "");

        if (inputs.isEmpty())
            JOptionPane.showMessageDialog(super.getView(),
                    "There are no " + "saved states");
        else
        {
            Object selected = JOptionPane
                    .showInputDialog(null, "Select level of undo", "Selection",
                            JOptionPane.QUESTION_MESSAGE, null,
                            inputs.toArray(), "0");
            if (selected != null)
            {//null if the user cancels.
                String selectedString = selected.toString();
                super.undo(Integer.parseInt(selectedString));
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
                super.getView().getPlayGround()
                        .disableButtons(occupiedPositions, null);
                super.getView().getPlayerStatus()
                        .updatePage(super.getGame().getCurrentPlayer());
                super.getView().getPlayerStatus().getTop()
                        .enableBackButton(false);
                super.getView().getPlayGround()
                        .resetButtonActionListener(ButtonStatus.NOT_SELECTED,
                                getView());
                super.getView().setStatus(
                        super.getGame().getCurrentPlayer().getName() +
                                ", select the troop you wish to move or attack with");
            }
            else
            {
                System.out.println("User cancelled");
            }
        }
    }
}
