package Controller;

import Model.*;
import Utility.ButtonStatus;
import Utility.PlayerColor;
import View.GameGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by ankurdabral on 12/04/2016.
 */
public class MoveButtonController extends GameController implements
        ActionListener
{

    public MoveButtonController(GameGUI view)
    {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        super.getView().getPlayGround()
                .resetButtonActionListener(ButtonStatus.SELECTED_TO_MOVE,
                        getView());
        GameItem item = super.getGame()
                .getItem(super.getView().getPlayerStatus().getItemLocation());

        PlayerColor playerColor = super.getGame().getCurrentPlayer().getColor();

        Color cellColor =
                new Color(playerColor.getRed(), playerColor.getGreen(),
                        playerColor.getBlue());

        super.getView().getPlayGround()
                .disableButtons(super.getGame().getPossibleMovePoints(item),
                        cellColor);

        super.getView().getPlayGround()
                .setDisabledButtonIcon(item.getPosition(),
                        item.getImageIconPath());
        super.getView().getPlayerStatus().getTop().enableBackButton(true);
        super.getView().getPlayerStatus().setMoveButtons();
        //super.getView().getPlayerStatus().getBottom2().resetButton();
        super.getView().setStatus(super.getGame().getCurrentPlayer().getName() +
                ", where would you like to move " + item.getName() + " to?");
    }
}
