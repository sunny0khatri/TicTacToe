package org.example.Strategies.WinningStrategy;

import org.example.Models.Board;
import org.example.Models.Move;
import org.example.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWiseWinningStrategy implements WinningStrategy{
    Map<Integer, Map<Symbol,Integer>> mp=new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col=move.getCell().getCol();
        if(!mp.containsKey(col)){
            mp.put(col,new HashMap<>());
        }
        Map<Symbol,Integer> currMap=mp.get(col);
        Symbol symbol=move.getPlayer().getSymbol();
        if(!currMap.containsKey(symbol)){
            currMap.put(symbol,0);
        }
        currMap.put(symbol, currMap.get(symbol)+1);
        if(currMap.get(symbol)== board.getDimension())
            return true;
        return false;
    }
}
