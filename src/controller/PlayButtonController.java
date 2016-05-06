package Controller;

import Model.Game;
import View.GameGUI;
import View.SettingsScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import View.GameGUI;

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
        screen.setVisible(false);

        Game game = new Game(names, board, 2);

        GameGUI gui = new GameGUI(game);
        gui.setSize(1400, 700);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
