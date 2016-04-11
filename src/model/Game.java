package model;

import java.util.Scanner;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Game
{
    private final int BOARDSIZE = 10;
    private Board board;
    private BasePlayer playerOne;
    private Player playerTwo;

    public Game()
    {

        this.board = new Board(BOARDSIZE);
        initializeGame();
        placePlayersOnBoard(new Player[]{playerOne, playerTwo});
    }

    private void initializeGame()
    {

        System.out.println("Player One will defend the base");
        askName(1);
        String teamName = getTeamName();

        Troop jet = new Troop("Jet",new Point(0, 0), 3,
                new Weapon("Bomb", 1, 25, true, false),
                new Weapon("Mg17", 2, 20, true, false));
        Troop army = new Troop("Army",new Point(6,6),1,new Weapon("Pistol", 1,
                20, true, true),
                new Weapon("Ak47", 2, 15, true, true));
        Troop tank = new Troop("Tank",new Point(6, 6), 2,
                new Weapon("Cannon", 2, 15, false, true),
                new Weapon("Machine Gun", 1, 17, false, true));
        Tower tower = new Tower(new Point(9, 9));

        playerOne = new BasePlayer(teamName, tank, tower);
        askName(2);
        teamName = getTeamName();
        playerTwo = new Player(teamName, jet, army);
    }

    private void askName(int number)
    {
        System.out.println("Player" + Integer.toString(number) +
                ",please select your team name:");
    }

    private String getTeamName()
    {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    private void placePlayersOnBoard(Player[] players)
    {

        for (int i = 0; i < players.length; i++)
            populateGameItems(players[i].getItems());

    }

    private void populateGameItems(GameItem[] items)
    {

        for (int i = 0; i < items.length; i++)
            board.placeGameItem(items[i]);
    }

}
