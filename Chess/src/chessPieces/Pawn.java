package chessPieces;

import concepts.BoardPosition;

public class Pawn extends ChessPiece {

	public Pawn(BoardPosition position, boolean white) {
		super(position, white);
		type = PieceType.PAWN;
	}

	@Override
	public boolean canPotentiallyMakeMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getTextRender() {
		if(isWhite()){
			return "[P]";
		}
		else{
			return "[p]";
		}
	}

}
