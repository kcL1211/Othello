package com.company;

import java.util.ArrayList;

/**
 * Created by Casey on 8/12/16.
 */
public class Othello {
    protected static final int EMPTY = 0;
    protected static final int BLACK = 1;
    protected static final int WHITE = 2;

    public Othello() {
        Board b = new Board(8);
        Gui g = new Cli();
        g.showBoard(b);
        //playGame(b, g);


//        // test isFull
//        b.setPosition(BLACK, 5);
//        b.setPosition(BLACK, 6);
//        g.showBoard(b);
//        System.out.println("b.isFull(): " + b.isFull());
//
//        // test X
//        b.setPosition(WHITE, 2);
//        b.setPosition(WHITE, 1);
//        g.showBoard(b);
//        System.out.println("b.getEmpties() " + b.getEmpties());

        // test addPiece()
//        b.addPiece(BLACK, 5); //expect true
//        g.showBoard(b);
//        b.addPiece(BLACK, 6); //expect false
//        g.showBoard(b);
//        b.setPosition(WHITE, 2);
//        b.setPosition(WHITE, 1);
//        b.addPiece(BLACK, 0); //expect true
//        g.showBoard(b);

//        //test getDirectionArray()
//        b.setPosition(WHITE, 2);
//        b.setPosition(WHITE, 5);
//        b.setPosition(WHITE, 7);
//        g.showBoard(b);
//        ArrayList x = b.getDirectionArray(3, Board.LT);
//        System.out.println(x.toString());
//        x = b.getDirectionArray(3, Board.RT);
//        System.out.println(x.toString());

        //test flip
        b.setPosition(WHITE, 2);
        b.setPosition(WHITE, 5);
        b.setPosition(WHITE, 7);
        g.showBoard(b);
        //b.flip(BLACK, 6 ,b.LT);
        b.addPiece(BLACK, 6);
        g.showBoard(b);

    }

    //get input
    private void playGame(Board b, Gui g) {
        for(int turn = 0; !b.isFull(); turn++){
            int player = (turn % 2 == 0) ? BLACK : WHITE;
            if(moveAvailable(b, player));
            takeTurn(b, g, player);
//            switch("temporary") {
//                case "game over":
//                    break;
//                //do stuff...(calc winner);
//                case "skip turn":
//                    continue;
//                default:
//            }
        }

    }

    //told what turn by playGame() -> get input -> check place
    public void takeTurn(Board b, Gui g, int player){
        int pos = g.getInput(player);
        //  if(b.openspots.length == 0)   //game over
        //      return "game over";//declare winner
        //  else
        //      return "skip turn"; to next players turn    //skip turn

        ////normal turn
        //int newMove
        //do        //get a valid position
        //  newMove = g.getinput()
        //while(!b.isValidMove(newMove));

        //b.addPiece(newMove);
        //g.refresh();  //(update display)
        //return "next player";
    }

    public boolean moveAvailable(Board b, int player){
        //var empties = board.getEmpties()
        //boolean moveavailable = false;
        //for each empty
        //  if (isValidMove(b, player, emptyPos)) return true;
        //return false
        return true;
    }

    public boolean isValidMove(Board b, int player, int pos){
        return false;
    }
}
