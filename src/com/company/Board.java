package com.company;

import java.util.ArrayList;

/**
 * Created by Casey on 8/12/16.
 */
public class Board {
    int[] b;
    int size;


    public Board(int size){
        this.size = size;
        b = new int[size];
        b[size/2-1] = Othello.BLACK;
        b[size/2] = Othello.WHITE;
    }

    public int[] getBoard(){
        return b;
    }

    public int getSize(){
        return size;
    }

    public Boolean isFull(){
        for(int i = 0; i < b.length; i++){
            if(b[i] == Othello.EMPTY){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> getEmpties(){
        ArrayList<Integer> empties = new ArrayList<>();
        for (int j = 0; j < b.length ; j++) {
            if(b[j] == Othello.EMPTY){
                empties.add(j);
            }
        }
        return empties;
    }
}
