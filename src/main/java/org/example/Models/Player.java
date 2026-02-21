package org.example.Models;


import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Player {
    private String name;
    private Symbol symbol;
    Scanner sc;

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
        this.sc =new Scanner(System.in);
    }

    public Move makeMove(Board board){
        System.out.println(this.name + " is making a move");
        System.out.println("Enter row number: ");
        int row=sc.nextInt();
        System.out.println("Enter col number: ");
        int col=sc.nextInt();
        Cell currCell=new Cell(row,col);
        return new Move(currCell, this);
    }

}
