package nl.olaf.coolgame.settings;

import nl.olaf.coolgame.settings.settingtypes.GameSettings;
import nl.olaf.coolgame.settings.settingtypes.SoundSettings;

/**
 * Created by Hoodz on 29/05/2017.
 */

public class SettingsMenu {

    private final SoundSettings soundSettings;
    private final GameSettings gameSettings;

    public SettingsMenu() {
        this.soundSettings = new SoundSettings();
        this.gameSettings = new GameSettings();
    }

    public SoundSettings getSoundSettings() {
        return soundSettings;
    }

    public GameSettings getGameSettings() {
        return gameSettings;
    }

    public void open() {

    }

    public void close() {

    }

    public void saveSettings() {

    }

}
