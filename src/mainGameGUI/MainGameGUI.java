package mainGameGUI;

import exceptions.ObjectAlreadyExistException;
import model.Game;
import view.GameGUI;
import view.SplashScreen;

import javax.swing.*;

/**
 * Created by ankurdabral on 15/04/2016.
 */
public class MainGameGUI
{

    public static void main(String[] arg)
    {


        ImageIcon imageIcon = new ImageIcon("Images/warzone.jpg");
        final SplashScreen splashScreen = new SplashScreen(imageIcon);
        splashScreen.setLocationRelativeTo(null);
        splashScreen.setVisible(true);

        try
        {
            Game game = Game.gameFactory(splashScreen.getNames());
            splashScreen.setVisible(false);
            GameGUI gui = new GameGUI(game);
            gui.setSize(1400, 700);
            gui.setLocationRelativeTo(null);
            gui.setVisible(true);
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch (ObjectAlreadyExistException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
