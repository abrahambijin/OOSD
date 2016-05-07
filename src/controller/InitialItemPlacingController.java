package Controller;

import Model.*;
import Settings.GameSettings;
import View.GameGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class InitialItemPlacingController implements ActionListener
{

    private static int ITEM_INDEX = 0;
    private static int PLAYER_INDEX = 1;

    private Position location;
    private Game game;
    private GameGUI view;

    public InitialItemPlacingController(Position location, Game game,
                                        GameGUI view)
    {
        this.location = location;
        this.game = game;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        Player currentPlayer = game.getCurrentPlayer();

        GameItem item = currentPlayer.getItems().get(ITEM_INDEX);
        boolean success = game.addItemToBoard(currentPlayer, item, location);

        if (success)
        {
            ITEM_INDEX++;
            view.getPlayGround()
                    .setButtonImage(location, item.getImageIconPath());

            if (ITEM_INDEX >= currentPlayer.getItems().size())
            {
                ITEM_INDEX = 0;
                game.nextPlayer();
                PLAYER_INDEX++;
                view.getPlayerStatus().setPlayer(game.getCurrentPlayer());
            }

            currentPlayer = game.getCurrentPlayer();
            item = currentPlayer.getItems().get(ITEM_INDEX);


            if (PLAYER_INDEX <= GameSettings.NO_OF_PLAYERS)
            {
                view.getPlayGround()
                        .disableButtons(game.possiblePointToPlaceItems(), null);
                view.setStatus(
                        currentPlayer.getName() + ", where would you like to" +
                                " place " + item.getName() + "? ");
            }
            else
            {
                view.getPlayGround()
                        .disableButtons(game.getOccupiedBoardLocation(), null);
                view.getPlayGround().resetButtonActionListener(game, view);
                view.setStatus(
                        currentPlayer.getName() + ", select the troop you " +
                                "wish to move or attack with  ");
            }


        }

    }
}
