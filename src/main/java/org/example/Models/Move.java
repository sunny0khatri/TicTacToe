package org.example.Models;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Move {
    private Cell cell;
    private Player player;
    private PlayerType playerType;
}
