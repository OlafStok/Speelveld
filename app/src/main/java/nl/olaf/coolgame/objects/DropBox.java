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
        dropFiche(gameBoard, getPositionX());
    }

    public void dropFiche(GameBoard gameBoard, int x) {
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
                gameBoard.addGameObject(player1fiche, x, fichePos);
                ((CoolGame) gameBoard.getGame()).changeTurn();
                CoolGame.player1 = false;
                player1fiche.checkFour(gameBoard, player1fiche.getPositionX(), player1fiche.getPositionY(), true, false, 0);
            } else {
                gameBoard.addGameObject(player2fiche, x, fichePos);
                ((CoolGame) gameBoard.getGame()).changeTurn();
                CoolGame.player1 = true;
                player2fiche.checkFour(gameBoard, player2fiche.getPositionX(), player2fiche.getPositionY(), true, false, 0);
            }
            fichesfrombottom++;
            gameBoard.updateView();
        }
    }

}
