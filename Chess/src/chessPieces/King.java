package chessPieces;

import concepts.BoardPosition;
import concepts.ChessMove;

public class King extends ChessPiece {

	public King(BoardPosition position, boolean white) {
		super(position, white);
		type = PieceType.KING;
	}

	@Override
	public boolean canPotentiallyMakeMove(ChessMove move) {
		BoardPosition initialPosition = move.getInitialPosition();
		BoardPosition finalPosition = move.getFinalPosition();

		int deltaX = Math.abs(initialPosition.getX() - finalPosition.getX());
		int deltaY = Math.abs(initialPosition.getY() - finalPosition.getY());

		return ((deltaX > 0 || deltaY > 0) && deltaX <= 1 && deltaY <= 1);
	}
	
	@Override
	public String getTextRender() {
		if(isWhite()){
			return "[K]";
		}
		else{
			return "[k]";
		}
	}

}
