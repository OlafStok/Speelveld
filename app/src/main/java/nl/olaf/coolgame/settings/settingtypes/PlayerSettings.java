package nl.olaf.coolgame.settings.settingtypes;

import android.util.Log;

import java.util.ArrayList;

import nl.olaf.coolgame.CoolGame;
import nl.olaf.coolgame.players.Player;

/**
 * Created by Hoodz on 29/05/2017.
 */

public class PlayerSettings {

    private int playerCount;
    private ArrayList<Player> playerArrayList;

    public PlayerSettings() {
        this.playerCount = 0;
        playerArrayList = new ArrayList<>();
        addPlayer();
        addPlayer();
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public ArrayList<Player> getPlayerArrayList() {
        return playerArrayList;
    }

    public void addPlayer() {
        playerCount++;
        Log.d(GameSettings.TAG, "Adding new player");
        playerArrayList.add(new Player("Player " + playerCount, playerCount - 1));
    }

    public void removePlayer() {
        if (playerArrayList.size() > 2) {
            Log.d(GameSettings.TAG, "Removing player");
            playerArrayList.remove(playerCount - 1);
            playerCount--;
        }
    }

}
