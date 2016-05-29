package Controller;

import Model.*;
import Settings.GameSettings;
import View.GameGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class InitialItemPlacingController extends GameController implements ActionListener
{

    private static int ITEM_INDEX = 0;
    private static int PLAYER_INDEX = 1;

    private Position location;

    public InitialItemPlacingController(Position location, GameGUI view)
    {
        super(view);
        this.location = location;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        Player currentPlayer = super.getGame().getCurrentPlayer();

        GameItem item = currentPlayer.getItems().get(ITEM_INDEX);
        boolean success = super.getGame().addItemToBoard(currentPlayer, item, location);

        if (success)
        {
            ITEM_INDEX++;
            super.getView().getPlayGround()
                    .setButtonImage(location, item.getImageIconPath());

            if (ITEM_INDEX >= currentPlayer.getItems().size())
            {
                ITEM_INDEX = 0;
                super.getGame().nextPlayer();
                PLAYER_INDEX++;
                super.getView().getPlayerStatus().setPlayer(super.getGame().getCurrentPlayer());
            }

            currentPlayer = super.getGame().getCurrentPlayer();
            item = currentPlayer.getItems().get(ITEM_INDEX);


            if (PLAYER_INDEX <= GameSettings.NO_OF_PLAYERS)
            {
                super.getView().getPlayGround()
                        .disableButtons(super.getGame().possiblePointToPlaceItems(), null);
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

                super.getView().getPlayGround()
                        .disableButtons(super.getGame().getOccupiedBoardLocation(), null);
                super.getView().getPlayGround().resetButtonActionListener
                        (super.getView());
                super.getView().setStatus(
                        currentPlayer.getName() + ", select the troop you " +
                                "wish to move or attack with  ");
            }


        }

    }
}
