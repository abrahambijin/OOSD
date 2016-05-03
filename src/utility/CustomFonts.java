package utility;

import java.awt.*;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ankurdabral on 2/05/2016.
 */
public final class CustomFonts
{

    public static Font lifeCraft, perfectDark, hand, neverWinter, fof, orena,
            reTurn, chelsea, WOW;

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
            perfectDark = Font.createFont(Font.TRUETYPE_FONT,
                    new File("Fonts/Perfect Dark Zero.ttf"))
                    .deriveFont(Font.BOLD, 30);
            hand = Font.createFont(Font.TRUETYPE_FONT,
                    new File("Fonts/hand.ttf")).deriveFont(Font.BOLD, 20);
            neverWinter = Font.createFont(Font.TRUETYPE_FONT,
                    new File("Fonts/Neverwinter.otf"))
                    .deriveFont(Font.BOLD, 40);
            fof = Font.createFont(Font.TRUETYPE_FONT,
                    new File("Fonts/FEASFBRG.TTF")).deriveFont(Font.BOLD, 20);
            orena = Font.createFont(Font.TRUETYPE_FONT,
                    new File("Fonts/Orena.ttf")).deriveFont(Font.BOLD, 18);
            reTurn = Font.createFont(Font.TRUETYPE_FONT,
                    new File("Fonts/return.ttf")).deriveFont(Font.BOLD, 30);
            chelsea = Font.createFont(Font.TRUETYPE_FONT,
                    new File("Fonts/Chelsea.ttf")).deriveFont(Font.BOLD, 20);
            WOW = Font.createFont(Font.TRUETYPE_FONT,
                    new File("Fonts/world of water.ttf"))
                    .deriveFont(Font.BOLD, 30);

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
        ge.registerFont(perfectDark);
        ge.registerFont(orena);
        ge.registerFont(fof);
        ge.registerFont(hand);
        ge.registerFont(reTurn);
        ge.registerFont(chelsea);
        ge.registerFont(WOW);


    }


}
