package chessPieces;

import concepts.BoardPosition;

public class EmptyPiece extends ChessPiece {

	public EmptyPiece(BoardPosition position) {
		super(position, true);
		this.type = PieceType.EMPTY;
	}

	@Override
	public String getTextRender() {
		return "[" + position.toString() + "]";
		//return "[ ]";
	}

	@Override
	public boolean canPotentiallyMakeMove() {
		return false;
	}

}
