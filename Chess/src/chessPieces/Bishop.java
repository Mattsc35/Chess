package chessPieces;

import concepts.BoardPosition;
import concepts.ChessMove;
import util.Logger;

public class Bishop extends ChessPiece {

	static String loggerTag = "Bishop";
	public Bishop(BoardPosition position, boolean white) {
		super(position, white);
		type = PieceType.BISHOP;
	}

	@Override
	public boolean canPotentiallyMakeMove(ChessMove move) {
		BoardPosition initialPosition = move.getInitialPosition();
		BoardPosition finalPosition = move.getFinalPosition();
		
		int deltaX = Math.abs(initialPosition.getX() - finalPosition.getX());
		int deltaY = Math.abs(initialPosition.getY() - finalPosition.getY());
		
		boolean returnValue = ((deltaX > 0) && (deltaX == deltaY));
		if(!returnValue){
			Logger.debug(loggerTag, "Not a valid potential move");
		}
		
		return returnValue;
	}
	
	@Override
	public String getTextRender() {
		if(isWhite()){
			return "[B]";
		}
		else{
			return "[b]";
		}
	}

	

}
