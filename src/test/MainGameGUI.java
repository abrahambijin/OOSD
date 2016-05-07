package Test;

import Settings.UnitsList;
import Utility.CustomFonts;
import View.SplashScreen;
import View.SettingsScreen;

import javax.swing.*;

/**
 * Created by ankurdabral on 15/04/2016.
 */
public class MainGameGUI
{
    public static void main(String[] arg)
    {
        final SplashScreen splashScreen = new SplashScreen();
        splashScreen.setLocationRelativeTo(null);
        splashScreen.setVisible(true);

        CustomFonts.initialiseFont();
        UnitsList.generateUnits();
        try
        {
            Thread.sleep(1000);
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
