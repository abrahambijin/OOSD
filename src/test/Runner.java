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
                while(!game.addItemToBoard(player,item,location))
                {
                    System.out.println("Incorrect position");
                    System.out.print("Where would you like to place " +
                            item.getName() + ":");
                    location = getLocationInput();
                }
            }
        }
        displayBoard();

        while(true)
        {
            Player currentPlayer = game.getNextPlayer();
            System.out.println(currentPlayer.getName()+": Select a Troop");
            Point selectedPoint = getLocationInput();
            while(!game.isTroopOfCurrentPlayer(selectedPoint))
            {
                System.out.println("Incorrect selection");
                System.out.println(currentPlayer.getName()+": Select a Troop");
                selectedPoint = getLocationInput();
            }
            System.out.println("Where do you want to move "+game.getItem
                    (selectedPoint).getName());
            Point newLocation = getLocationInput();
            while(!game.move(selectedPoint,newLocation))
            {
                System.out.println("Incorrect selection");
                System.out.println("Where do you want to move "+game.getItem
                        (selectedPoint).getName());
                newLocation = getLocationInput();
            }
            System.out.println();
            displayBoard();
        }
    }

    private static void askName(int number)
    {
        System.out
                .print("Player" + number + ",please select your team name: ");
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

    private static void displayBoard()
    {
        for(int i=0; i<game.getBOARD_SIZE();i++)
        {
            System.out.print("|");
            for(int j=0;j<game.getBOARD_SIZE();j++)
            {
                GameItem item = game.getItem(new Point(i,j));
                if(item!=null)
                    System.out.print(item.getName()+" |");
                else
                    System.out.print("      |");
            }
            System.out.println();
        }
    }

}
