package nl.olaf.coolgame.settings.settingtypes;

import nl.olaf.coolgame.settings.settingtypes.powerup.PowerUpSettings;

/**
 * Created by Hoodz on 29/05/2017.
 */

public class GameSettings {

    private int playerCount;
    private PowerUpSettings powerUps;
    private FieldSettings fieldSettings;

    public GameSettings() {
        this.playerCount = 2;
        this.powerUps = new PowerUpSettings();
        this.fieldSettings = new FieldSettings();
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public PowerUpSettings isPowerUps() {
        return powerUps;
    }

    public void setPowerUps(PowerUpSettings powerUps) {
        this.powerUps = powerUps;
    }

    public FieldSettings getFieldSettings() {
        return fieldSettings;
    }

}
