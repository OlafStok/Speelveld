package nl.olaf.coolgame;

import nl.olaf.coolgame.objects.DropBox;
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

		// Reset the game
		initNewGame();
	}
	public void initNewGame() {
		player1 = true;
		vierOpEenRij = false;
		GameBoard board = getGameBoard();
		board.removeAllObjects();

		//create dropboxes
		DropBox db0 = new DropBox();
		DropBox db1 = new DropBox();
		DropBox db2 = new DropBox();
		DropBox db3 = new DropBox();
		DropBox db4 = new DropBox();
		DropBox db5 = new DropBox();
		DropBox db6 = new DropBox();
		DropBox db7 = new DropBox();
		DropBox db8 = new DropBox();
		DropBox db9 = new DropBox();
		// Add dropboxes
		board.addGameObject(db0, 0, 0);
		board.addGameObject(db1, 1, 0);
		board.addGameObject(db2, 2, 0);
		board.addGameObject(db3, 3, 0);
		board.addGameObject(db4, 4, 0);
		board.addGameObject(db5, 5, 0);
		board.addGameObject(db6, 6, 0);
		board.addGameObject(db7, 7, 0);
		board.addGameObject(db8, 8, 0);
		board.addGameObject(db9, 9, 0);

		// Redraw the game view
		board.updateView();
	}

	public void changeTurn() {
		//can be called when turn is changed to update powerups or sth
	}
	public void setWinner(String winner) {
		initNewGame();
	}
}
