package chessPieces;

import concepts.BoardPosition;
import concepts.ChessMove;

public class Knight extends ChessPiece{

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
		
		return ((deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1));
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
