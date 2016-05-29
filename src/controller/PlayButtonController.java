package Controller;

import Model.Game;
import View.GameGUI;
import View.SettingsScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by ankurdabral on 29/04/2016.
 */
public class PlayButtonController implements ActionListener
{
    private SettingsScreen screen;

    public PlayButtonController(SettingsScreen screen)
    {
        this.screen = screen;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        ArrayList<String> names = screen.getNames();
        int board = screen.getBoardSize();
        int peices = screen.getPecies();
        screen.setVisible(false);

        Game game = Game.GameFactory(names, board, peices);
        GameController.setController(game);
        GameGUI gui = new GameGUI(game);

        gui.setSize(1400, 700);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
