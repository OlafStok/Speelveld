package nl.olaf.coolgame.settings.settingtypes;

/**
 * Created by Hoodz on 29/05/2017.
 */

public class SoundSettings {

    private boolean muted;
    private boolean specialSoundEffects;
    private int volumePercentage;

    public SoundSettings() {
        this.muted = false;
        this.specialSoundEffects = false;
        this.volumePercentage = 75;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    public boolean isMuted() {
        return muted;
    }

    public boolean isSpecialSoundEffects() {
        return specialSoundEffects;
    }

    public int getVolumePercentage() {
        return volumePercentage;
    }

    public void setSpecialSoundEffects(boolean specialSoundEffects) {
        this.specialSoundEffects = specialSoundEffects;
    }

    public void setVolumePercentage(int volumePercentage) {
        this.volumePercentage = volumePercentage;
    }

}
