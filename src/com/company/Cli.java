package com.company;

import java.util.Scanner;

/**
 * Created by Casey on 8/12/16.
 */
public class Cli implements Gui {

    int color;
    int position;

    public void instructions(){
        System.out.println("Black = 0" + "\t" + "White = -1");
        System.out.println("Enter the following:");



    }

    public void visuals(){
        ;//not needed for CLI version
    }

    public void showBoard(Board b){
        System.out.println(getBoardString(b));
    }


    private String getBoardString(Board board){
        int[] b = board.getBoard();
        String bString = " 0 1 2 3 4 5 6 7 \n";
        //(ex.| | | |B|W| | | |)
        for(int i = 0; i < board.getSize(); i++) {
            bString += '|';
            switch (b[i]){
                case Othello.BLACK:
                    bString += 'B';
                    break;
                case Othello.WHITE:
                    bString += 'W';
                    break;
                case Othello.EMPTY:
                    bString += ' ';
                    break;
            }
        }
        bString += '|';
        return bString;
    }

    public int getInput(int player){
        Scanner kbReader = new Scanner(System.in);
        this.color = color;
        color = kbReader.nextInt();
        this.position = position;
        position = kbReader.nextInt();
        System.out.println(getBoardString(new Board(8)));
        System.out.println("The color of the piece: " + color);
        System.out.println("The position of the piece: " + position);
        if(position > 8) {
            System.out.println("Please enter a number less than 8");
        }
        return position;
    }



}
