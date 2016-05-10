package Controller;

import Model.Game;
import Model.GameItem;
import Model.PlayerColor;
import Model.Position;
import View.GameGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by ankurdabral on 10/05/2016.
 */
public class AttackButtonController implements ActionListener {

    private Game game;
    private GameGUI view;

    public AttackButtonController(Game game, GameGUI view) {
        this.game = game;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        CellButtonController.setIsItemSelected(true);
//        GameItem item = game.getItem(view.getPlayerStatus().getItemLocation());
//        PlayerColor playerColor = game.getCurrentPlayer().getColor();
//        Color cellColor =
//                new Color(playerColor.getRed(), playerColor.getGreen(),
//                        playerColor.getBlue());
//        view.getPlayGround()
//                .disableButtons(new ArrayList<Position>(), cellColor);
//        view.getPlayGround().setDisabledButtonIcon(item.getPosition(),
//                item.getImageIconPath());
//        view.getPlayerStatus().getTop().enableBackButton(true);
//        view.setStatus(game.getCurrentPlayer().getName() +
//                ", where would you like to attack with " + item.getName() + "?");
    }
}
