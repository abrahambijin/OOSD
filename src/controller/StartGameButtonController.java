package controller;

import model.Game;
import view.GameGUI;
import view.SplashScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import view.GameGUI;
/**
 * Created by ankurdabral on 29/04/2016.
 */
public class StartGameButtonController implements ActionListener{
   private Game game;
    private GameGUI gui;
    private SplashScreen view;
    public static ArrayList<String> names;
    public static int board;

    public StartGameButtonController(SplashScreen view)
    {
        this.view = view;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public int getBoard() {
        return board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        names =view.getNames();
        board = view.getBoardSize();
        view.setVisible(false);
        game = new Game(names,board);
        gui = new GameGUI(game);
        gui.setSize(1400, 700);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
