package nl.olaf.coolgame;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import nl.olaf.coolgame.objects.DropBox;
import nl.olaf.coolgame.objects.Fiche;
import nl.playground.view.GameBoardView;

/**
 * A view on the CoolGame game board.
 * 
 * @author Jan Stroet
 * @author Paul de Groot
 */
public class CoolGameBoardView extends GameBoardView {
	private static final String TAG = "GameView";

	/**
	 * Constructor.
	 */
	public CoolGameBoardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initGameView();
	}

	/**
	 * Constructor.
	 */
	public CoolGameBoardView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initGameView();
	}

	/**
	 * Loads all images that will be used for the game.
	 */
	private void initGameView() {
		Log.d(TAG, "Loading all images");

		spriteCache.setContext(this.getContext());

		// Load the 'empty' cell bitmap
		spriteCache.loadTile("empty", R.drawable.cell);

		// Load the images for the GameObjects
		spriteCache.loadTile(Fiche.PLAYER_1, R.drawable.player1);
		spriteCache.loadTile(Fiche.PLAYER_2, R.drawable.player2);
		spriteCache.loadTile(DropBox.DROPBOX_IMAGE, R.drawable.rock);
	}
}
