package org.example.Models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symbol {
    private char ch;

    public Symbol(char ch){
        this.ch=ch;
    }
}
