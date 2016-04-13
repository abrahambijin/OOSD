package test;

import exceptions.ObjectAlreadyExistException;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mitulmanish on 12/04/2016.
 */
public class Runner
{
    static Game game;

    public static void main(String[] args)
    {

        System.out.println("Player One will defend the base");
        ArrayList<String> teamNames = new ArrayList<>();
        for (int i = 1; i <= Game.getNO_OF_PLAYERS(); i++)
        {
            askName(i);
            teamNames.add(getTeamName());
        }
        try
        {
            game = Game.gameFactory(teamNames);
        }
        catch (ObjectAlreadyExistException e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        System.out.println();
        for(Player player: game.getPlayers())
        {
            System.out.println(player.getName()+": ");
            for (GameItem item : player.getItems())
            {
                System.out.print("Where would you like to place " +
                        item.getName() + ":");
                Point location = getLocationInput();
                item.setPosition(location);
            }
        }
        game.placePlayersOnBoard();


        for(int i=0; i<game.getBOARD_SIZE();i++)
        {
            System.out.print("|");
            for(int j=0;j<game.getBOARD_SIZE();j++)
            {
                System.out.print(game.getItemName(new Point(i,j))+"|");
            }
            System.out.println();
        }
    }

    private static void askName(int number)
    {
        System.out
                .println("Player" + number + ",please select your team name:");
    }

    private static String getTeamName()
    {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private static Point getLocationInput()
    {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        return new Point(x,y);
    }

}
