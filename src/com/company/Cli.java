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

    }

    public void showBoard(){
        int[] board = new int[7];
        board[position] = color;

    }

    public int getInput(int position, int color){
        Scanner kbReader = new Scanner(System.in);
        this.color = color;
        color = kbReader.nextInt();
        this.position = position;
        position = kbReader.nextInt();
        System.out.println("The color of the piece: " + color);
        System.out.println("The position of the piece: " + position);
        if(position > 8) {
            System.out.println("Please enter a number less than 8");
        }
        return position;
    }



}
