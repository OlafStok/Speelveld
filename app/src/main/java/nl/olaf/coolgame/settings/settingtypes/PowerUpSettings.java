package nl.olaf.coolgame.settings.settingtypes;

import java.util.ArrayList;

import nl.olaf.coolgame.powerup.PowerUp;

/**
 * Created by Hoodz on 29/05/2017.
 */

@SuppressWarnings("unchecked")
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
