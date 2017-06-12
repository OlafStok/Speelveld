package nl.olaf.coolgame.settings.settingtypes;

/**
 * Created by Hoodz on 29/05/2017.
 */

public class GameSettings {

    private PowerUpSettings powerUps;
    private BoardSettings boardSettings;
    private PlayerSettings playerSettings;

    public static String TAG = "GameSettings";

    public GameSettings() {
        this.powerUps = new PowerUpSettings();
        this.boardSettings = new BoardSettings();
        this.playerSettings = new PlayerSettings();
    }

    public PowerUpSettings getPowerUpsSettings() {
        return powerUps;
    }

    public BoardSettings getBoardSettings() {
        return boardSettings;
    }

    public PlayerSettings getPlayerSettings() {
        return playerSettings;
    }

}
