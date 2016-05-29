package Controller;

import Model.*;
import Utility.Posture;
import View.GameGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


/**
 * Created by ankurdabral on 10/05/2016.
 */
public class AttackButtonController extends GameController
{

    public AttackButtonController(Game game, GameGUI view)
    {
        super(game, view);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        GameActionController.setSTATUS(ButtonStatus.SELECTED_TO_ATTACK);
        GameItem item = super.getGame()
                .getItem(super.getView().getPlayerStatus().getItemLocation());

        super.getView().getPlayerStatus().getBottom().setListenerStatus(true);
        String selectedWeapon =
                super.getView().getPlayerStatus().getBottom().getSelectedID();

        PlayerColor playerColor = super.getGame().getCurrentPlayer().getColor();
        Color cellColor =
                new Color(playerColor.getRed(), playerColor.getGreen(),
                        playerColor.getBlue());


        super.getView().getPlayGround().disableButtons(super.getGame()
                        .getPossibleShootingOptions(item.getPosition(), selectedWeapon),
                cellColor);

        super.getView().getPlayGround()
                .setDisabledButtonIcon(item.getPosition(),
                        item.getImageIconPath());

        boolean pass = item instanceof Unit;
        if (pass)
        {
            super.getView().getPlayerStatus().getBottom()
                    .updateList(((Unit) item).getWeapons());
            super.getView().getPlayerStatus().getBottom()
                    .setWeaponInfo(((Unit) item).getCurrentPosture());
        }
        super.getView().getPlayerStatus().setWeaponListVisible(pass);
        super.getView().getPlayerStatus().getTop().enableBackButton(true);
        super.getView().setStatus(super.getGame().getCurrentPlayer().getName() +
                ", select the item you want to attack with");
    }