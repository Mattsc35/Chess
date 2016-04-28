package players;

import board.GameBoard;
import concepts.ChessMove;

public abstract class Player {
	
	boolean isWhite;
	public abstract ChessMove getNextMove(GameBoard currentBoard);
	public boolean getIsWhite(){
		return isWhite;
	}

}
