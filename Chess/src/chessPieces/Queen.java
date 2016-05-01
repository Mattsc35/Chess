package chessPieces;

import concepts.BoardPosition;
import concepts.ChessMove;

public class Queen extends ChessPiece {

	public Queen(BoardPosition position, boolean white) {
		super(position, white);
		type = PieceType.QUEEN;
	}

	@Override
	public boolean canPotentiallyMakeMove(ChessMove move) {
		BoardPosition initialPosition = move.getInitialPosition();
		BoardPosition finalPosition = move.getFinalPosition();

		int deltaX = Math.abs(initialPosition.getX() - finalPosition.getX());
		int deltaY = Math.abs(initialPosition.getY() - finalPosition.getY());

		return (((deltaX == 0 && deltaY > 0) || (deltaY == 0 && deltaX > 0)) || 
				(deltaX > 0 && deltaX == deltaY));
	}

	@Override
	public String getTextRender() {
		if (isWhite()) {
			return "[Q]";
		}
		else {
			return "[q]";
		}
	}
}