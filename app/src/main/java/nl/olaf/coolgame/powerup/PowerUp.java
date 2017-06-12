package nl.olaf.coolgame.powerup;

/**
 * Created by Hoodz on 29/05/2017.
 */

public abstract class PowerUp {

    private boolean used;

    public PowerUp() {
        this.used = false;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean isUsed() {
        return used;
    }

    abstract boolean validate();

    abstract void execute();

}
