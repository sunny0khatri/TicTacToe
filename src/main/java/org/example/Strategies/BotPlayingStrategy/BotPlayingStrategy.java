package org.example.Strategies.BotPlayingStrategy;

import org.example.Models.Board;
import org.example.Models.Move;
import org.example.Models.Player;

public interface BotPlayingStrategy {
    public Move makeMove(Board board, Player player);
}
