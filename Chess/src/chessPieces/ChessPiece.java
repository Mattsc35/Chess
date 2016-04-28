package chessPieces;

import concepts.BoardPosition;

public abstract class ChessPiece {
	protected PieceType type;
	protected BoardPosition position;
	protected boolean white;

	
	public ChessPiece(BoardPosition position, boolean white) {
		this.position = position;
		this.white = white;
	}
	
	public PieceType getType() {
		return type;
	}
	
	public BoardPosition getPosition() {
		return position;
	}
	
	public boolean isWhite(){
		return white;
	}

	public abstract boolean canPotentiallyMakeMove();
	public abstract String getTextRender();
}
