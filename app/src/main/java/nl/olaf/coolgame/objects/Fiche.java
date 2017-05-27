package nl.olaf.coolgame.objects;

import android.util.Log;

import nl.olaf.coolgame.CoolGame;
import nl.playground.model.GameBoard;
import nl.playground.model.GameObject;

/**
 * Created by Olaf on 27-5-2017.
 */

public class Fiche extends GameObject {

    Boolean player1;
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
    }
}
