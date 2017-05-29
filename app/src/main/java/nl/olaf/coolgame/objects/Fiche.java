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

    boolean wonGame;


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

    public boolean checkFourHorizontal(GameBoard gameBoard, int x, int y, boolean goingLeft, boolean addToRow, int inRow) {
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
                    checkFourHorizontal(gameBoard, currentfiche.getPositionX(), currentfiche.getPositionY(), false, false, 0);
                }
                //if nextFiche is for the same player
                else {
                    Log.d(CoolGame.TAG, "left fiche is same player, going left");
                    checkFourHorizontal(gameBoard, nextFiche.getPositionX(), nextFiche.getPositionY(), true, false, 0);
                }
            }
            //if we're the leftmost fiche
            else {
                Log.d(CoolGame.TAG, "leftmost fiche, going right");
                checkFourHorizontal(gameBoard, currentfiche.getPositionX(), currentfiche.getPositionY(), false, false, 0);
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
                    checkFourHorizontal(gameBoard, nextFiche.getPositionX(), nextFiche.getPositionY(), false, true, inRow);
                }

                //right fiche is different player, so do nothing
                else {
                    Log.d(CoolGame.TAG, "right fiche is different player, " + inRow + "/3");
                    //de loop eindigt, check of we gewonnen hebben
                    if(inRow >= 3) {
                        //won game!
                        Log.d(CoolGame.TAG, "WON GAME!");
                        if(currentfiche.player1 == true) {
                            wonGame = true;
                            ((CoolGame)gameBoard.getGame()).setWinner("1");
                        }
                        else {
                            ((CoolGame)gameBoard.getGame()).setWinner("2");
                        }
                    }
                    else {
                        wonGame = false;
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
                    //wonGame = true for game ended
                    wonGame = true;
                    if(currentfiche.player1 == true) {
                        ((CoolGame)gameBoard.getGame()).setWinner("1");
                    }
                    else {
                        ((CoolGame)gameBoard.getGame()).setWinner("2");
                    }
                }
                else {
                    wonGame = false;
                }
            }
        }
        //recursive bullshit
        //if you can go right 3 times with player1 = true, end the game and if player1 is true, winner is player 2
        //else its player 2
        return wonGame;
    }
    public void checkFourVertical(GameBoard gameBoard, int x, int y, boolean goingUp, boolean addToRow, int inRow) {
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
        if(goingUp) {
            Log.d(CoolGame.TAG, "going up");
            //set amount in a row to 0 if we're going up
                inRow = 0;
                Log.d(CoolGame.TAG, "topmost fiche, going down");
                checkFourVertical(gameBoard, currentfiche.getPositionX(), currentfiche.getPositionY(), false, false, 0);
        }

        //if going right
        if(!goingUp) {
            //if we're the not the bottommost fiche
            if(y < gameBoard.getHeight()-2 && gameBoard.getObject(x, y+1) != null) {
                Log.d(CoolGame.TAG, "Setting next fiche");
                nextFiche = (Fiche) gameBoard.getObject(x, y + 1);
                //if the fiche to the right is the same player
                if(nextFiche.player1 == currentfiche.player1) {
                    //go right, adding one to inRow
                    Log.d(CoolGame.TAG, "right fiche is same player, " + inRow + "/2");
                    checkFourVertical(gameBoard, nextFiche.getPositionX(), nextFiche.getPositionY(), false, true, inRow);
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
            //we're the topmost fiche, so do nothing
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
    public void checkFourDiagonalLeft(GameBoard gameBoard, int x, int y, boolean goingLeftUp, boolean addToRow, int inRow) {
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
        if(goingLeftUp) {
            Log.d(CoolGame.TAG, "going left up");
            //set amount in a row to 0 if we're going left
            inRow = 0;
            //if we can go left
            if(x > 0 && y > 1 && gameBoard.getObject(x - 1, y - 1) != null) {
                Log.d(CoolGame.TAG, "not the leftupmost fiche");
                nextFiche = (Fiche) gameBoard.getObject(x - 1, y - 1);
                //if we should not go left
                if(nextFiche.player1 != currentfiche.player1) {
                    //the fiche is for a different player, cycle right
                    Log.d(CoolGame.TAG, "leftup fiche is different player, going right");
                    checkFourHorizontal(gameBoard, currentfiche.getPositionX(), currentfiche.getPositionY(), false, false, 0);
                }
                //if nextFiche is for the same player
                else {
                    Log.d(CoolGame.TAG, "leftup fiche is same player, going left");
                    checkFourHorizontal(gameBoard, nextFiche.getPositionX(), nextFiche.getPositionY(), true, false, 0);
                }
            }
            //if we're the leftmost fiche
            else {
                Log.d(CoolGame.TAG, "leftupmost fiche, going right");
                checkFourHorizontal(gameBoard, currentfiche.getPositionX(), currentfiche.getPositionY(), false, false, 0);
            }
        }

        //if going rightdown
        if(!goingLeftUp) {

            //if we're the not the rightdownmost fiche
            if(x < gameBoard.getWidth()-1 && y < gameBoard.getHeight()-2 && gameBoard.getObject(x + 1, y + 1) != null) {
                nextFiche = (Fiche) gameBoard.getObject(x + 1, y + 1);
                //if the fiche to the right is the same player
                if(nextFiche.player1 == currentfiche.player1) {
                    //go right, adding one to inRow
                    Log.d(CoolGame.TAG, "right fiche is same player, " + inRow + "/2");
                    checkFourHorizontal(gameBoard, nextFiche.getPositionX(), nextFiche.getPositionY(), false, true, inRow);
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
    public void checkFourDiagonalRight(GameBoard gameBoard, int x, int y, boolean goingLeftDown, boolean addToRow, int inRow) {
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
        if(goingLeftDown) {
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
                    checkFourHorizontal(gameBoard, currentfiche.getPositionX(), currentfiche.getPositionY(), false, false, 0);
                }
                //if nextFiche is for the same player
                else {
                    Log.d(CoolGame.TAG, "left fiche is same player, going left");
                    checkFourHorizontal(gameBoard, nextFiche.getPositionX(), nextFiche.getPositionY(), true, false, 0);
                }
            }
            //if we're the leftmost fiche
            else {
                Log.d(CoolGame.TAG, "leftmost fiche, going right");
                checkFourHorizontal(gameBoard, currentfiche.getPositionX(), currentfiche.getPositionY(), false, false, 0);
            }
        }

        //if going right
        if(!goingLeftDown) {

            //if we're the not the rightmost fiche
            if(x < gameBoard.getWidth()-1 && gameBoard.getObject(x + 1, y) != null) {
                nextFiche = (Fiche) gameBoard.getObject(x + 1, y);
                //if the fiche to the right is the same player
                if(nextFiche.player1 == currentfiche.player1) {
                    //go right, adding one to inRow
                    Log.d(CoolGame.TAG, "right fiche is same player, " + inRow + "/2");
                    checkFourHorizontal(gameBoard, nextFiche.getPositionX(), nextFiche.getPositionY(), false, true, inRow);
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
