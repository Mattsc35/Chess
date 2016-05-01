package chessPieces;

import concepts.BoardPosition;
import concepts.ChessMove;

public class Bishop extends ChessPiece {

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
		
		return (deltaX > 0 && deltaX == deltaY);
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
