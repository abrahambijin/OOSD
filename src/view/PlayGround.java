package view;

import controller.CellButtonController;
import controller.InitialItemPlacingController;
import model.Game;
import model.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class PlayGround extends JPanel
{
    private int size;
    private Cell cell[][];


    public PlayGround(Game game, GameGUI view)
    {
        size = game.getBOARD_SIZE();
        this.setLayout(new GridLayout(size, size));
        cell = new Cell[size][size];
        initialise(game, view);
    }

    private void initialise(Game game, GameGUI view)
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                cell[i][j] = new Cell(i, j);
                cell[i][j]
                        .setBorder(BorderFactory.createLineBorder(Color.black));
                cell[i][j].addActionListener(
                        new InitialItemPlacingController(new Position(i, j),
                                game, view));

                this.add(cell[i][j]);

            }
        }
    }

    public void disableButtons(ArrayList<Position> exceptionsList)
    {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                cell[i][j].setEnabled(
                        exceptionsList.contains(new Position(i, j)));
    }

    public void setButtonImage(Position location, String path)
    {
        cell[location.getXCoordinate()][location.getYCoordinate()]
                .setIcon(new ImageIcon(path));
    }

    public void resetButtonActionListener(Game game, GameGUI view)
    {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
            {
                for (ActionListener listener : cell[i][j].getActionListeners())
                    cell[i][j].removeActionListener(listener);
                cell[i][j].addActionListener(
                        new CellButtonController(new Position(i, j), game,
                                view));
            }
    }

    public void moveItem(Position initialPosition, Position finalPosition,
                         String imagePath)
    {
        setButtonImage(initialPosition,null);
        setButtonImage(finalPosition,imagePath);
    }

}


