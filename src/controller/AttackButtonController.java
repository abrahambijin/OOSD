package Controller;

import Model.*;
import Utility.Posture;
import View.GameGUI;
import View.PlayGround;
import View.PlayerStatus;

import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by ankurdabral on 10/05/2016.
 * to show the view to game when attack button is clicked
 */
public class AttackButtonController extends GameController implements
        ActionListener
{

    public AttackButtonController(GameGUI view)
    {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        PlayGround playGround = super.getView().getPlayGround();
        PlayerStatus playeStatus = super.getView().getPlayerStatus();
        Game game = super.getGame();

        super.getView().getPlayGround()
                .resetButtonActionListener(ButtonStatus.SELECTED_TO_ATTACK,
                        getView());
        GameItem item = game.getItem(playeStatus.getItemLocation());
        //set list listner to false initially
        playeStatus.getBottom().setListenerStatus(true);

        String selectedWeapon = playeStatus.getBottom().getSelectedID();
        PlayerColor playerColor = game.getCurrentPlayer().getColor(); // get current player color

        Color cellColor = new Color(playerColor.getRed(), playerColor.getGreen(),
                        playerColor.getBlue());
        //enable/disable button in playground
        playGround.disableButtons(game
                        .getPossibleShootingOptions(item.getPosition(), selectedWeapon),
                cellColor);

        playGround.setDisabledButtonIcon(item.getPosition(),
                        item.getImageIconPath());

        boolean pass = item instanceof Unit;

        if (pass)
        { //pass unit to update view
            playeStatus.updateWeapon((Unit) item);
        }

        playeStatus.setWeaponListVisible(pass);
        playeStatus.getTop().enableBackButton(true); //enable back button

        super.getView().setStatus(game.getCurrentPlayer().getName() +
                ", select the item you want to attack with");
    }
}