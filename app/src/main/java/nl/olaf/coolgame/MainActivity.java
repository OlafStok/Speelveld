package nl.olaf.coolgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import nl.playground.model.GameBoard;

/**
 * The main activity.
 * 
 * @author Paul de Groot
 * @author Jan Stroet
 */
public class MainActivity extends Activity {
	private CoolGame game;
	private CoolGameBoardView gameView;
	private TextView tv;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// Load main.xml
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Find some of the user interface elements
		gameView = (CoolGameBoardView) findViewById(R.id.game);
		tv = (TextView) findViewById(R.id.CurrentTurn);

		// Create the game object. This contains all data and functionality
		// belonging to the game
		game = new CoolGame(this);

		// Tell the game board view which game board to show
		GameBoard board = game.getGameBoard();
		gameView.setGameBoard(board);
		gameView.setFixedGridSize(board.getWidth(), board.getHeight());
		
		// Do something when user clicks new game
		registerNewGameButton();

		// Tell user to start the game
		Toast.makeText(getApplicationContext(), "Lets start",
				Toast.LENGTH_SHORT).show();
	}

	/**
	 * Set a new score on the score label
	 * 
	 * @param newScore  The new score.
	 */


	/**
	 * Returns the view on the game board.
	 */
	public CoolGameBoardView getGameBoardView() {
		return gameView;
	}
	public TextView getTv() {
		return tv;
	}

	/**
	 * Install a listener to the 'New game'-button so that it starts a new
	 * game when clicked.
	 */
	private void registerNewGameButton() {
		// Find the 'New Game'-button in the activity
		final Button button1 = (Button) findViewById(R.id.newGameButton);
		
		// Add a click listener to the button that calls initNewGame()
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				game.initNewGame();
			}
		});
	}

}
