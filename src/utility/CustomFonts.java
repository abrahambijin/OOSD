package Utility;

import java.awt.*;
import java.io.*;
import java.io.IOException;

/**
 * Created by ankurdabral on 2/05/2016.
 */
public final class CustomFonts
{

    public static Font lifeCraft, perfectDark, hand, neverWinter, fof, droidSans,
            reTurn, chelsea, primeTime;

    private CustomFonts()
    {
    }

    public static void initialiseFont()
    {
        try
        {
            lifeCraft = Font.createFont(Font.TRUETYPE_FONT,
                    new File("Fonts/LifeCraft_Font.ttf"))
                    .deriveFont(Font.BOLD, 30);

            droidSans = Font.createFont(Font.TRUETYPE_FONT,
                    new File("Fonts/DroidSans.ttf")).deriveFont(Font.BOLD, 14);

            chelsea = Font.createFont(Font.TRUETYPE_FONT,
                    new File("Fonts/Chelsea.ttf")).deriveFont(Font.BOLD, 20);
            primeTime = Font.createFont(Font.TRUETYPE_FONT,
                    new File("Fonts/PrimeTime.ttf"))
                    .deriveFont(Font.BOLD, 16);

        }
        catch (FontFormatException e)
        {
            e.printStackTrace();
            System.err.println(" not loaded.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.err.println("not loaded.");
        }

        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        //register the font
        ge.registerFont(lifeCraft);
        //ge.registerFont(perfectDark);
        ge.registerFont(droidSans);
        //ge.registerFont(fof);
        //ge.registerFont(hand);
        //ge.registerFont(reTurn);
        ge.registerFont(chelsea);
        ge.registerFont(primeTime);


    }


}
