package nl.olaf.coolgame;

import java.util.ArrayList;

import nl.olaf.coolgame.objects.DropBox;
import nl.olaf.coolgame.settings.SettingsMenu;
import nl.playground.model.Game;
import nl.playground.model.GameBoard;

/**
 * Awesome game for the Speelveld-project.
 * 
 * @author Paul de Groot
 */
public class CoolGame extends Game {
	/** Tag used for log messages */
	public static final String TAG = "CoolGame";

	/** Reference to the main activity, so some labels can be updated. */
	private MainActivity activity;

	/** Aantal tegels op een rij. */
	private boolean vierOpEenRij = false;
	public static boolean player1 = true;


	private ArrayList<DropBox> dropBoxes;
	private SettingsMenu settingsMenu;


	/**
	 * Constructor.
	 *
	 * @param activity  The main activity
	 */
	public CoolGame(MainActivity activity) {
		// Create a new game board and couple it to this game
		super(new CoolGameBoard());
		
		// Store reference to the main activity
		// This is used to update the score label
		this.activity = activity;

		settingsMenu = new SettingsMenu();

		// Reset the game
		initNewGame();
	}

	public void initNewGame() {
		dropBoxes = new ArrayList<>();
		player1 = true;
		vierOpEenRij = false;
		GameBoard board = getGameBoard();
		board.removeAllObjects();

		//create dropboxes
		for (int index = 0; index < 10; index++) {
			board.addGameObject(new DropBox(), index, 0);
		}


		// Redraw the game view
		board.updateView();
	}

	public void changeTurn() {
		//can be called when turn is changed to update powerups or sth
	}
	public void setWinner(String winner) {
		initNewGame();
	}

	public SettingsMenu getSettingsMenu() {
		return settingsMenu;
	}
}
