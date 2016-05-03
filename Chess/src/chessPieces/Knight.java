package chessPieces;

import concepts.BoardPosition;
import concepts.ChessMove;
import util.Logger;

public class Knight extends ChessPiece{
	
	static String loggerTag = "Knight";
	
	public Knight(BoardPosition position, boolean white) {
		super(position, white);
		type = PieceType.KNIGHT;
	}

	@Override
	public boolean canPotentiallyMakeMove(ChessMove move) {
		BoardPosition initialPosition = move.getInitialPosition();
		BoardPosition finalPosition = move.getFinalPosition();
		
		int deltaX = Math.abs(initialPosition.getX() - finalPosition.getX());
		int deltaY = Math.abs(initialPosition.getY() - finalPosition.getY());
		
		boolean returnValue = (deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1);
		if(!returnValue){
			Logger.debug(loggerTag, "Not a valid potential move");
		}
		return returnValue;
		
	}

	@Override
	public String getTextRender() {
		if(isWhite()){
			return "[N]";
		}
		else{
			return "[n]";
		}
	}

	
}
