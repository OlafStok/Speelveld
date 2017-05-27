package nl.olaf.coolgame.objects;

import android.util.Log;

import nl.olaf.coolgame.CoolGame;
import nl.playground.model.GameBoard;
import nl.playground.model.GameObject;

/**
 * Created by Olaf on 27-5-2017.
 */

public class DropBox extends GameObject {

    public static final String DROPBOX_IMAGE = "DropBox";
    public int fichesfrombottom = 0;

    @Override
    public String getImageId() {
        return DROPBOX_IMAGE;
    }

    @Override
    public void onTouched(GameBoard gameBoard) {
        dropFiche(gameBoard);
        checkFour(gameBoard);
    }

    public void dropFiche(GameBoard gameBoard) {
        Log.d(CoolGame.TAG, "Dropped Fiche");
        int fichePos = getPositionY() + 7 - fichesfrombottom;
        Fiche player1fiche = new Fiche();
        Fiche player2fiche = new Fiche();
        player1fiche.player1 = true;
        player2fiche.player1 = false;
        if (fichesfrombottom == 7) {
            //do nothing
        } else {
            if (CoolGame.player1 == true) {
                gameBoard.addGameObject(player1fiche, getPositionX(), fichePos);
                ((CoolGame) gameBoard.getGame()).changeTurn();
                CoolGame.player1 = false;
            } else {
                gameBoard.addGameObject(player2fiche, getPositionX(), fichePos);
                ((CoolGame) gameBoard.getGame()).changeTurn();
                CoolGame.player1 = true;
            }
            fichesfrombottom++;
            gameBoard.updateView();
        }
    }

    public void checkFour(GameBoard gameBoard) {
        if(horizontalFour(gameBoard)) {
            //new game
        }
        if(verticalFour(gameBoard)) {
            //new game
        }
        if(diagonalFourLeft(gameBoard)) {
            //new game
        }
        if(diagonalFourRight(gameBoard)) {
            //new game
        }
    }

    public boolean horizontalFour(GameBoard gameBoard) {
        //check if we have a  four-in-a-row
        return false;
    }
    public boolean verticalFour(GameBoard gameBoard) {
        //check if we have a four-in-a-row
        return false;
    }
    public boolean diagonalFourLeft(GameBoard gameBoard) {
        //check if we have a four-in-a-row
        return false;
    }
    public boolean diagonalFourRight(GameBoard gameBoard) {
        //check if we have a four-in-a-row
        return false;
    }
}
