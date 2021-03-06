package Controller;

import Model.*;
import Settings.GameSettings;
import Utility.ButtonStatus;
import Utility.Position;
import View.GameGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class InitialItemPlacingController extends GameActionController
        implements ActionListener
{

    private static int ITEM_INDEX = 0;
    private static int PLAYER_INDEX = 1;


    public InitialItemPlacingController(GameGUI view, Position location)
    {
        super(view, location);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        Player currentPlayer = super.getGame().getCurrentPlayer();

        GameItem item = currentPlayer.getItems().get(ITEM_INDEX);
        boolean success = super.getGame()
                .addItemToBoard(currentPlayer, item, super.getLocation());

        if (success)
        {
            ITEM_INDEX++;
            super.getView().getPlayGround().setButtonImage(super.getLocation(),
                    item.getImageIconPath());

            if (ITEM_INDEX >= currentPlayer.getItems().size())
            {
                ITEM_INDEX = 0;
                super.getGame().nextPlayer();
                PLAYER_INDEX++;
                super.getView().getPlayerStatus()
                        .setPlayer(super.getGame().getCurrentPlayer());
            }

            currentPlayer = super.getGame().getCurrentPlayer();
            item = currentPlayer.getItems().get(ITEM_INDEX);


            if (PLAYER_INDEX <= GameSettings.NO_OF_PLAYERS)
            {
                super.getView().getPlayGround().disableButtons(
                        super.getGame().possiblePointToPlaceItems(), null);
                super.getView().setStatus(
                        currentPlayer.getName() + ", where would you like to" +
                                " place " + item.getName() + "? ");
            }
            else
            {
                ArrayList<Position> locations = super.getGame().addObstacles();
                for (Position position : locations)
                {
                    GameItem obstacle = super.getGame().getItem(position);
                    super.getView().getPlayGround().setButtonImage(position,
                            obstacle.getImageIconPath());
                }

                super.saveGame();

                super.getView().getPlayGround().disableButtons(
                        super.getGame().getOccupiedBoardLocation(), null);
                super.getView().getPlayGround()
                        .resetButtonActionListener(ButtonStatus.NOT_SELECTED,
                                getView());
                super.getView().setStatus(
                        currentPlayer.getName() + ", select the troop you " +
                                "wish to move or attack with  ");
            }


        }

    }
}
