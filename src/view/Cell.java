package View;

import Controller.*;
import Utility.Position;
import Utility.ButtonStatus;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by ankurdabral on 11/04/2016.
 * to initialize cell position in board
 */

public class Cell extends JButton
{

    private Position position;
    private GameActionController actionController;

    public Cell(int xCoordinate, int yCoordinate)
    {
        this.position = new Position(xCoordinate, yCoordinate);
        this.setOpaque(false);
    }

    public Position getPosition()
    {
        return position;
    }

    public void setActionController(ButtonStatus buttonStatus, GameGUI view)
    {
        switch (buttonStatus)
        {
            case SELECTED_TO_MOVE:
                actionController = new MoveUnitController(view, position);
                break;

            case SELECTED_TO_ATTACK:
                actionController = new AttackUnitController(view, position);
                break;

            case INITIAL_PLACING:
                actionController = new InitialItemPlacingController(view,
                        position);
                break;

            default:
                actionController = new SelectUnitController(view,position);
        }

        for (ActionListener listener : this.getActionListeners())
            this.removeActionListener(listener);

        this.addActionListener(actionController);
    }
}
