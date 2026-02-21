package org.example.Strategies.BotPlayingStrategy;

import org.example.Models.Board;
import org.example.Models.Cell;
import org.example.Models.Move;
import org.example.Models.Player;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board, Player player) {
        for (List<Cell> cells: board.getCells()){
            for (Cell cell: cells){
                if(cell.isEmpty()){
                    return new Move(cell,player);
                }
            }
        }
        return null;
    }
}
