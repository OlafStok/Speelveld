package nl.olaf.coolgame.players;

import android.graphics.Color;

/**
 * Created by Hoodz on 29/05/2017.
 */

public class Player {

    private Color color;
    private String name;
    private int id;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        switch (this.id) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
