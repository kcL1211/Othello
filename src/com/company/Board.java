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
        //flag to see if any pieces heed to be flipped. If never true,-> invalid move
        boolean flipped = false;

        //return false if position is already taken
        if(b[position] != 0){
            flipped = false;
            return flipped;
        }

        //check if pieces will be flipped, if yes, flip them
        //loop through directions looking for the one that the player wanted to flip
        for(int i = 0; i < numDirections; i++){
            boolean directionFlipped = flip(player, position, i);
            if(directionFlipped){
                flipped = true;
            }
        }
        return flipped;
    }

    /***
     *
     * @param player
     * @param pos
     * @return true if valid, false if invalid
     */
    protected boolean isValidMove(int player, int pos){
        //foreach direction
        for(int i = 0; i < numDirections; i++) {
            if(isFlippable(player, pos, i))
                return true;
        }
        return false;
    }

    /***
     *
     * @param player
     * @param pos
     * @return if valid: index of endcap, if not valid: -1;
     */
    protected boolean isFlippable(int player, int pos, int dir){
        switch(dir){
            case RT:
                return isRTFlippable(player, pos);
            case LT:
                return isLTFlippable(player, pos);
            default:
                return false;
        }
    }

    protected boolean isRTFlippable(int player, int pos){
        //1. adj piece is opposite color
        if(b[pos+1] == player) return false;
        //2. seqential pieces are opposite color until same color is found
        for(int i = pos+1; i < b.length; i++){
            if(b[i] == player){
                return true;
            }
        }
        return false;
    }

    protected boolean isLTFlippable(int player, int pos){
        //1. adj piece is opposite color
        if(b[pos-1] == player) return false;
        //2. sequential pieces are opposite color until same color is found
        for(int i = pos-1; i >= 0; i--){
            if(b[i] == player){
                return true;
            }
        }
        return false;
    }


    protected int flipLTTo(int player, int pos){
        //1. adj piece is opposite color
        if(b[pos-1] == player) return -1;
        //2. sequential pieces are opposite color until same color is found
        for(int i = pos-1; i >= 0; i--){
            if(b[i] == player){
                return i;
            }
        }
        return -1;
    }

    protected int flipRTTo(int player, int pos){
        //1. adj piece is opposite color
        if(b[pos+1] == player) return -1;
        //2. sequential pieces are opposite color until same color is found
        for(int i = pos+1; i <b.length; i++){
            if(b[i] == player){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param player
     * @param pos
     * @param dir
     * @return null if invalid flip, otherwise returns an int array of the form: [???]
     */
    protected boolean flip(int player, int pos, int dir){
        int capPos = -1;    //keep track of end cap position of same color
        switch(dir){
            case RT:
                //if adjacent piece is same color, then nothing will be flipped
                if(b[pos+1] == player) return false;

                //find next of same color
                for(int i = pos + 1; i < size; i++) {
                    if (b[i] == player) {
                        capPos = i; //end cap found, save to flip outside of this for loop
                        break;
                    }
                }

                //if valid flip found, flip pieces from cap to capPos
                if(capPos != -1) {
                    for (int i = pos; i < capPos; i++) {
                        setPosition(player, i);
                    }
                    return true;
                    //flipRT(player, pos, capPos);
                } else {
                    return false;
                }

            case LT:
                //if adjacent piece is same color, then nothing will be flipped
                if(b[pos-1] == player) return false;

                //find next of same color
                for(int i = pos - 1; i >= 0; i--) {
                    if (b[i] == player) {
                        capPos = i; //end cap found, save to flip outside of this for loop
                        break;
                    }
                }

                //flip pieces from pos to capPos
                if(capPos != -1) {
                    for (int i = pos; i > capPos ; i--) {
                        setPosition(player, i);
                    }
                    //flipLT(player, pos, capPos);
                    return true;
                } else {
                    return false;
                }

            default:
                return false;
        }
    }

    protected void flipRT(int player, int from, int to){
        for (int i = from; i < to; i++) {
            setPosition(player, i);
        }
    }

    protected void flipLT(int player, int from, int to){
        for (int i = from; i > to; i--) {
            setPosition(player, i);
        }
    }
}
