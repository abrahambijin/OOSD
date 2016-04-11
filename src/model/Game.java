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

<<<<<<< HEAD
        this.board = board;
    }

    public void initializeGame(String teamNamePlayerOne, String teamNamePlayerTwo) {
=======
        this.board = new Board(BOARDSIZE);
        initializeGame();
        placePlayersOnBoard(new Player[]{playerOne, playerTwo});
    }

    private void initializeGame()
    {
>>>>>>> master

        Weapon Ak47 = new Weapon(2,15,true,true);
        Weapon bomb = new Weapon(1,25,true,false);
        Weapon cannon = new Weapon(2,15,false,true);

<<<<<<< HEAD
        Jet jet = new Jet(new Point(0,0), 3, bomb, new Mg17());
        Army army = new Army(new Point(6,6), 1, new Pistol(), Ak47);
        Tank tank = new Tank(new Point(6,6), 2, cannon, new MachineGun());
        Tower tower = new Tower(new Point(9,9));
        Base base = new Base(new Point(0,0), 500);

        playerOne = new BasePlayer(teamNamePlayerOne, tank, tower, base);
        playerTwo = new Player(teamNamePlayerTwo,jet, army);

        placePlayersOnBoard(new Player[] {playerOne, playerTwo});
=======
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
>>>>>>> master
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
