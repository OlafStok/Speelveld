package nl.olaf.coolgame;

import nl.olaf.coolgame.objects.DropBox;
import nl.playground.model.GameBoard;

/**
 * The game board for CoolGame.
 * 
 * @author Paul de Groot
 */
public class CoolGameBoard extends GameBoard {
	private static final int GAMEBOARD_WIDTH = 10;
	private static final int GAMEBOARD_HEIGHT = 8;

	/**
	 * Create a new game board.
	 */
	public CoolGameBoard() {
		super(GAMEBOARD_WIDTH, GAMEBOARD_HEIGHT);
	}

	@Override
	public void onEmptyTileClicked(int x, int y) {
		DropBox db = (DropBox) getObject(x, 0);
		db.dropFiche(this, x);
		db = null;
	}
	
	@Override
	public String getBackgroundImg(int mx, int my) {
		return "empty";
	}
	
}
