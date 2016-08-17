package com.company;

/**
 * Created by Casey on 8/12/16.
 */
public class Othello {
    public Othello() {
        Board b = new Board();
        Gui g = new Cli();
        g.display();
        //playGame(b, g);

    }

    private void playGame(Board b, Gui g) {
        //for each turn
        //  string outcome = taketurn(i%2)
        //  switch(outcome):
        //      case 'game over'
        //          break;
        //          do stuff...(calc winner)
        //      case "skip turn":
        //          continue;
        //      case ....
        //end for
    }

    //String takeTurn(player){
    //if(!valid move available)
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
    //}


    public static void main(String[] args){





    }
}
