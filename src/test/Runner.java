package Test;

import Model.*;
import Settings.GameSettings;
import Utility.Position;

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
        for (int i = 1; i <= GameSettings.NO_OF_PLAYERS; i++)
        {
            askName(i);
            teamNames.add(getTeamName());
        }
        game = new Game(teamNames, 10, 2);
        System.out.println();
        for (Player player : game.getPlayers())
        {
            System.out.println(player.getName() + ": ");
            for (GameItem item : player.getItems())
            {
                System.out.print("Where would you like to place " +
                        item.getName() + ":");
                Position location = getLocationInput();
                while (!game.addItemToBoard(player, item, location))
                {
                    System.out.println("Incorrect position");
                    System.out.print("Where would you like to place " +
                            item.getName() + ":");
                    location = getLocationInput();
                }
            }
        }
        displayBoard();

        while (true)
        {
            Player currentPlayer = game.getCurrentPlayer();
            System.out.println(currentPlayer.getName() + ": Select a Troop");
            Position selectedPosition = getLocationInput();
            while (!game.isUnitOfCurrentPlayer(selectedPosition))
            {
                System.out.println("Incorrect selection");
                System.out
                        .println(currentPlayer.getName() + ": Select a Troop");
                selectedPosition = getLocationInput();
            }
            System.out.println("Where do you want to move " +
                    game.getItem(selectedPosition).getName());
            Position newLocation = getLocationInput();
            while (!game.move(selectedPosition, newLocation))
            {
                System.out.println("Incorrect selection");
                System.out.println("Where do you want to move " +
                        game.getItem(selectedPosition).getName());
                newLocation = getLocationInput();
            }
            System.out.println();
            displayBoard();
            game.nextPlayer();
        }
    }

    private static void askName(int number)
    {
        System.out.print("Player" + number + ",please select your team name: ");
    }

    private static String getTeamName()
    {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private static Position getLocationInput()
    {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        return new Position(x, y);
    }

    private static void displayBoard()
    {
        for (int i = 0; i < game.getBOARD_SIZE(); i++)
        {
            System.out.print("|");
            for (int j = 0; j < game.getBOARD_SIZE(); j++)
            {
                GameItem item = game.getItem(new Position(i, j));
                if (item != null)
                    System.out.print(item.getName() + " |");
                else
                    System.out.print("      |");
            }
            System.out.println();
        }
    }

}
