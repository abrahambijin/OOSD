package View;

import Controller.CellButtonController;
import Controller.InitialItemPlacingController;
import Controller.MoveUnitController;
import Controller.SelectUnitController;
import Model.Game;
import Model.Position;

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
                cell[i][j].addActionListener(
                        new InitialItemPlacingController(new Position(i, j),
                                game, view));
                cell[i][j]
                        .setBorder(BorderFactory.createLineBorder(Color.black));

                this.add(cell[i][j]);

            }
        }
    }

    public void disableButtons(ArrayList<Position> exceptionsList,
                               Color buttonColor)
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (exceptionsList.contains(new Position(i, j)))
                {
                    cell[i][j].setEnabled(true);
                    //cell[i][j].setBackground(buttonColor);
                    cell[i][j].setBorder(
                            BorderFactory.createLineBorder(buttonColor, 1));
                }
                else
                {
                    cell[i][j].setEnabled(false);
                    //cell[i][j].setBackground(null);
                    cell[i][j].setOpaque(false);
                    cell[i][j].setBorder(
                            BorderFactory.createLineBorder(Color.lightGray));
                    cell[i][j].setDisabledIcon(null);
                }
            }
        }
    }

    public void setButtonImage(Position location, String path)
    {
        Image buttonImage = getScaledImage(location, path);

        cell[location.getXCoordinate()][location.getYCoordinate()]
                .setIcon(new ImageIcon(buttonImage));
    }

    public void resetButtonActionListener(Game game, GameGUI view)
    {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
            {
                for (ActionListener listener : cell[i][j].getActionListeners())
                    cell[i][j].removeActionListener(listener);
                cell[i][j].addActionListener(
                        new SelectUnitController(game, view,
                                new Position(i, j)));
                cell[i][j].addActionListener(
                        new MoveUnitController(game, view, new Position(i, j)));
            }
    }

    public void moveItem(Position initialPosition, Position finalPosition,
                         String imagePath)
    {
        setButtonImage(initialPosition, null);
        setButtonImage(finalPosition, imagePath);
    }

    public void setDisabledButtonIcon(Position location, String path)
    {
        Image buttonImage = getScaledImage(location, path);

        cell[location.getXCoordinate()][location.getYCoordinate()]
                .setDisabledIcon(new ImageIcon(buttonImage));
    }

    private Image getScaledImage(Position location, String path)
    {
        int imageWidth =
                cell[location.getXCoordinate()][location.getYCoordinate()]
                        .getWidth() * 2 / 3;
        int imageHeight =
                cell[location.getXCoordinate()][location.getYCoordinate()]
                        .getHeight() * 3 / 4;

        return new ImageIcon(path).getImage()
                .getScaledInstance(imageWidth, imageHeight,
                        Image.SCALE_DEFAULT);
    }
}


