package org.example.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
public class Board {
    private int dimension;
    private List<List<Cell>> cells;

    public Board(int dimension){
        this.dimension=dimension;
        this.cells=new ArrayList<>();
        for(int i=0;i<dimension;i++){
            cells.add(new ArrayList<>());
            for(int j=0;j<dimension;j++){
                cells.get(i).add(new Cell(i,j));
            }
        }
    }
}
