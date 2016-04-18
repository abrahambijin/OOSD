package controller;

import model.Game;
import model.GameItem;
import model.Player;
import model.Point;
import view.GameGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ankurdabral on 12/04/2016.
 */
public class InitialItemPlacingController implements ActionListener
{

    private static int ITEM_INDEX = 0;
    private static int PLAYER_INDEX = 1;

    private Point location;
    private Game game;
    private GameGUI view;

    public InitialItemPlacingController(Point location, Game game, GameGUI view)
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
                view.getPlayerStatus().getTop()
                        .setPlayer(game.getCurrentPlayer());
            }

            if (PLAYER_INDEX <= Game.getNO_OF_PLAYERS())
                view.getPlayGround()
                        .disableButtons(game.possiblePointToPlaceItems());
            else
            {

            }
        }

        //System.out.println(location);
        //new CellPosition(location.getXCoordinate(),location.getYCoordinate());


    }
}
