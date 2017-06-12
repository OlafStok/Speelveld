package nl.olaf.coolgame;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
	public ImageView player1ico;
	public ImageView player2ico;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// Load main.xml
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Find some of the user interface elements
		gameView = (CoolGameBoardView) findViewById(R.id.game);


		// Create the game object. This contains all data and functionality
		// belonging to the game
		game = new CoolGame(this);

		// Tell the game board view which game board to show
		GameBoard board = game.getGameBoard();
		gameView.setGameBoard(board);
		gameView.setFixedGridSize(board.getWidth(), board.getHeight());
		player1ico = (ImageView) findViewById(R.id.imageView);
		player2ico = (ImageView) findViewById(R.id.imageView6);
		
		// Do something when user clicks new game
		registerNewGameButton();

		// Tell user to start the game
		Toast.makeText(getApplicationContext(), "Lets start",
				Toast.LENGTH_SHORT).show();

		final Handler handler = new Handler();
		class MyRunnable implements Runnable {
			private Handler handler;
			public MyRunnable(Handler handler) {
				this.handler = handler;
			}
			@Override
			public void run() {
				this.handler.postDelayed(this, 50);
				changeTurn();
				Log.d(CoolGame.TAG, "updated");
			}
		}
		handler.post(new MyRunnable(handler));

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
		final Button button1 = (Button) findViewById(R.id.button);
		
		// Add a click listener to the button that calls initNewGame()
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				game.initNewGame();
			}
		});
	}

	public void changeTurn() {
		//change playerico with turn
		if(game.isPlayer1()) {
			player1ico.setVisibility(View.VISIBLE);
			player2ico.setVisibility(View.INVISIBLE);
		}
		else {
			player2ico.setVisibility(View.VISIBLE);
			player1ico.setVisibility(View.INVISIBLE);
		}
	}
}
