package nl.olaf.coolgame.objects;

import android.util.Log;

import nl.olaf.coolgame.CoolGame;
import nl.playground.model.GameBoard;
import nl.playground.model.GameObject;

/**
 * Created by Olaf on 27-5-2017.
 */

public class Fiche extends GameObject {

    boolean player1;
    public static final String PLAYER_1 = "Player1";
    public static final String PLAYER_2 = "Player2";


    @Override
    public String getImageId() {
        if (player1) {
            return PLAYER_1;
        } else {
            return PLAYER_2;
        }
    }

    @Override
    public void onTouched(GameBoard gameBoard) {
        Log.d(CoolGame.TAG, "Touched fiche");
        DropBox db = (DropBox) gameBoard.getObject(getPositionX(), 0);
        db.dropFiche(gameBoard, getPositionX());
        db = null;
    }

    public void checkFour(GameBoard gameBoard, int x, int y, boolean goingLeft, boolean addToRow, int inRow) throws ExceptionInInitializerError {
        Fiche currentfiche;
        Fiche nextFiche;
        boolean player1;
        if(addToRow) {
            inRow++;
        }
        else {
            inRow = 0;
        }
        //check left, if left fiche is player1 true, check left of that. if false, use as starting point to go right.
        currentfiche = (Fiche) gameBoard.getObject(x, y);
        //making leftmost fiche starting fiche
        if(goingLeft) {
            Log.d(CoolGame.TAG, "going left");
            //set amount in a row to 0 if we're going left
            inRow = 0;
            //if we can go left
            if(x > 0 && gameBoard.getObject(x - 1, y) != null) {
                Log.d(CoolGame.TAG, "not the leftmost fiche");
                nextFiche = (Fiche) gameBoard.getObject(x - 1, y);
                //if we should not go left
                if(nextFiche.player1 != currentfiche.player1) {
                    //the fiche is for a different player, cycle right
                    Log.d(CoolGame.TAG, "left fiche is different player, going right");
                    checkFour(gameBoard, currentfiche.getPositionX(), currentfiche.getPositionY(), false, false, 0);
                }
                //if nextFiche is for the same player
                else {
                    Log.d(CoolGame.TAG, "left fiche is same player, going left");
                    checkFour(gameBoard, nextFiche.getPositionX(), nextFiche.getPositionY(), true, false, 0);
                }
            }
            //if we're the leftmost fiche
            else {
                Log.d(CoolGame.TAG, "leftmost fiche, going right");
                checkFour(gameBoard, currentfiche.getPositionX(), currentfiche.getPositionY(), false, false, 0);
            }
        }

        //if going right
        if(!goingLeft) {

            //if we're the not the rightmost fiche
            if(x < gameBoard.getWidth()-1 && gameBoard.getObject(x + 1, y) != null) {
                    nextFiche = (Fiche) gameBoard.getObject(x + 1, y);
                //if the fiche to the right is the same player
                if(nextFiche.player1 == currentfiche.player1) {
                    //go right, adding one to inRow
                    Log.d(CoolGame.TAG, "right fiche is same player, " + inRow + "/2");
                    checkFour(gameBoard, nextFiche.getPositionX(), nextFiche.getPositionY(), false, true, inRow);
                }

                //right fiche is different player, so do nothing
                else {
                    Log.d(CoolGame.TAG, "right fiche is different player, " + inRow + "/3");
                    //de loop eindigt, check of we gewonnen hebben
                    if(inRow >= 3) {
                        //won game!
                        Log.d(CoolGame.TAG, "WON GAME!");
                        if(currentfiche.player1 == true) {
                            ((CoolGame)gameBoard.getGame()).setWinner("1");
                        }
                        else {
                            ((CoolGame)gameBoard.getGame()).setWinner("2");
                        }
                    }
                }
            }
            //we're the rightmost fiche, so do nothing
            else {
                Log.d(CoolGame.TAG, "righmost fiche");
                //de loop eindigt, check of we gewonnen hebben
                if(inRow >= 3) {
                    //won game!
                    Log.d(CoolGame.TAG, "WON GAME!");
                    if(currentfiche.player1 == true) {
                        ((CoolGame)gameBoard.getGame()).setWinner("1");
                    }
                    else {
                        ((CoolGame)gameBoard.getGame()).setWinner("2");
                    }
                }
            }
        }
        //recursive bullshit
        //if you can go right 3 times with player1 = true, end the game and if player1 is true, winner is player 2
        //else its player 2
    }
}
