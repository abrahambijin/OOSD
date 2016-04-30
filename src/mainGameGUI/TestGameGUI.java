package mainGameGUI;

import view.SScreen;
import view.SettingsScreen;

import javax.swing.*;

/**
 * Created by ankurdabral on 15/04/2016.
 */
public class TestGameGUI
{
    public static void main(String[] arg)
    {

        final SScreen splashScreen = new SScreen();
        splashScreen.setLocationRelativeTo(null);
        splashScreen.setVisible(true);

        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        splashScreen.setVisible(false);


        final SettingsScreen view = new SettingsScreen();
        view.setSize(542, 305);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
