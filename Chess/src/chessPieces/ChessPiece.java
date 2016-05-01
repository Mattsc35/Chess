package chessPieces;

import concepts.BoardPosition;
import concepts.ChessMove;

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
	
	public boolean isEmpty(){
		return type == PieceType.EMPTY;
	}

	public abstract boolean canPotentiallyMakeMove(ChessMove move);
	public abstract String getTextRender();
}
