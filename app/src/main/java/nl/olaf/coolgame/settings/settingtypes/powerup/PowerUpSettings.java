package nl.olaf.coolgame.settings.settingtypes.powerup;

import java.util.ArrayList;

/**
 * Created by Hoodz on 29/05/2017.
 */

public class PowerUpSettings {

    private boolean enabled;
    private ArrayList<PowerUp> powerUpArrayList;

    public PowerUpSettings() {
        this.enabled = false;
        this.powerUpArrayList = new ArrayList();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public ArrayList<PowerUp> getPowerUpArrayList() {
        return powerUpArrayList;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void addPowerUp(PowerUp powerUp) {
        powerUpArrayList.add(powerUp);
    }

    public void removePowerUp(PowerUp powerUp) {
        powerUpArrayList.remove(powerUp);
    }

}
