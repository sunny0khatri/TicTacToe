package org.example.Strategies.WinningStrategy;

import org.example.Models.Board;
import org.example.Models.Move;
import org.example.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWiseWinningStrategy implements WinningStrategy{
    Map<Symbol,Integer> leftMap =new HashMap<>();
    Map<Symbol,Integer> rightMap =new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();
        Symbol symbol=move.getPlayer().getSymbol();
        if(row==col){
            leftMap.put(symbol, leftMap.getOrDefault(symbol,0)+1);
            if(leftMap.get(symbol)==board.getDimension())
                return true;
        }
        if(row+col==board.getDimension()-1){
            rightMap.put(symbol,rightMap.getOrDefault(symbol,0)+1);
            if(rightMap.get(symbol)==board.getDimension())
                return true;
        }
        return false;
    }
}
