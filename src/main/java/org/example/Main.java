package org.example;

import org.example.Controller.GameController;
import org.example.Models.*;
import org.example.exceptions.InvalidMoveException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the dimension of the board");
        int dimension= sc.nextInt();
        List<Player> players=new ArrayList<>();
        players.add(new Player("ABC",new Symbol('x')));
        players.add(new Bot("bot",new Symbol('o'), BotDifficultyLevel.EASY));
        GameController gameController=new GameController();
        Game game=gameController.startGame(dimension,players);

        while(game.getGameState()==GameState.IN_PROGRESS){
//            gameController.getBoard(game);
            gameController.makeMove(game);
            gameController.getBoard(game);
        }
        gameController.getBoard(game);
        System.out.println("game "+ game.getGameState());
        if(game.getGameState()==GameState.ENDED)
            System.out.println("Winner of this game is "+game.getWinner().getName());
    }
}