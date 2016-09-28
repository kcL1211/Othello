package com.company;

import java.util.ArrayList;

/**
 * Created by Casey on 8/12/16.
 */
public class Board {
    int[] b;
    int size;

//    /* Reference:
//    UP_LT | UP_CT | UP_RT
//    CT_LT |       | CT_RT
//    DN_LT | DN_CT | DN_RT*/
//    protected static final int UP_LT = 0;
//    protected static final int UP_CT = 1;
//    protected static final int UP_RT = 2;
//    protected static final int CT_LT = 3;
//    protected static final int CT_RT = 4;
//    protected static final int DN_LT = 5;
//    protected static final int DN_CT = 6;
//    protected static final int DN_RT = 7;
//    protected static final int numDirections = 8;

    protected static final int LT = 0;
    protected static final int RT = 1;
    protected static final int numDirections = 2;

    public Board(int size){
        this.size = size;
        b = new int[size];
        //all position equal Othello.empty since default value of int is 0
        b[size/2-1] = Othello.BLACK;
        b[size/2] = Othello.WHITE;
    }

    public int[] getBoard(){
        return b;
    }

    public int getSize(){
        return size;
    }

    /**for testing purposes only
     * @Params: player: BLACK or WHITE of new piece
     *          position: number on the board to put new piece
     * Description: manually place a piece on the board without any checks
     */
    public void setPosition(int player, int position){
        b[position] = player;
    }

    /** @Returns: boolean that tells if the board is full
     * Description: tells if the boards is full
     **/
    public Boolean isFull(){
        for(int i = 0; i < b.length; i++){
            if(b[i] == Othello.EMPTY){
                return false;
            }
        }
        return true;
    }

    /**
     * @Returns: ArrayList of the empty spaces' indices
     * Description: tells which space's are empty
     */
    public ArrayList<Integer> getEmpties(){
        ArrayList<Integer> empties = new ArrayList<>();
        for (int j = 0; j < b.length ; j++) {
            if(b[j] == Othello.EMPTY){
                empties.add(j);
            }
        }
        return empties;
    }

    /**
     * @param player
     * @param position
     * @Return: boolean that tells if it's a valid move
     * @Description: if valid move, then return true, add piece and flip accordingly, if not, return false
     */
    public boolean addPiece(int player, int position){
        //return false if position is already taken
        if(b[position] != 0){
            return false;
        }
        //check if pieces will be flipped, if yes, flip them
        boolean flipped = false;     //flag to see if any pieces heed to be flipped. If never true,-> invalid move
        //loop through directions looking for the one that the player wanted to flip
        for(int i = 0; i < numDirections; i++){
            ArrayList<Integer> dirArr = getDirectionArray(position, i);
            boolean directionFlipped = flipDirection(player, dirArr);
            if(directionFlipped){
                flipped = true;
            }
        }
        if(flipped){
            b[position] = player;
        }
        return flipped;
    }

    /**
     * @param player (color of piece)
     * @param directionArray (the colors represented by numbers in one direction)
     * @return boolean; true if
     */
    private boolean flipDirection(int player, ArrayList<Integer> directionArray){
        int otherPlayer = ( player == 1 ) ? 2 : 1;
        //check if the adjacent position is of opposite color
        if(directionArray.get(0) == player) return false;

        //find next of same color to flip toward
        for(int i = 1; i < directionArray.size(); i++){
            if(directionArray.get(i) == player){
                flip(player, directionArray, i);
                return true;
            }
        }
        return false;
    }

    //flip pieces in directionArray from 0 to index of dA
    protected void flip(int player, ArrayList directionArray, int index){
        for(int i = 0; i < index; i++){
            directionArray.set(i, player);
        }
    }

    //get the integers from each direction and put it in an array
    protected ArrayList getDirectionArray(int pos, int dir){
        ArrayList<Integer> dirArray = new ArrayList<Integer>();
        switch(dir){
            case RT:
                for(int i = pos + 1; i < size; i++){
                    dirArray.add(b[i]);
                }
                break;
            case LT:
                for(int i = pos - 1; i >= 0; i--){
                    dirArray.add(b[i]);
                }
                break;
        }
        return dirArray;
    }
}
