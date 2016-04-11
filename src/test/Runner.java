package test;

import model.Board;
import model.Game;

import java.util.Scanner;

/**
 * Created by mitulmanish on 12/04/2016.
 */
public class Runner {
    static Game game;

    public static void main(String [] args){

        System.out.println("Player One will defend the base");
        askName(1);
        String teamNamePlayerOne = getTeamName();

        askName(2);
        String teamNamePlayerTwo = getTeamName();
        game = new Game();
        game.initializeGame(teamNamePlayerOne, teamNamePlayerTwo );
    }

    private static void askName(int number) {
        System.out.println("Player" +  number + ",please select your team name:");
    }

    private static String getTeamName() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

}
