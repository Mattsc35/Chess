package chessPieces;

import concepts.BoardPosition;
import concepts.ChessMove;

public class Pawn extends ChessPiece {

	public Pawn(BoardPosition position, boolean white) {
		super(position, white);
		type = PieceType.PAWN;
	}

	@Override
	//TODO double check this
	public boolean canPotentiallyMakeMove(ChessMove move) {
		BoardPosition initialPosition = move.getInitialPosition();
		BoardPosition finalPosition = move.getFinalPosition();

		int deltaX = Math.abs(initialPosition.getX() - finalPosition.getX());
		int deltaY = Math.abs(initialPosition.getY() - finalPosition.getY());
		boolean whiteDirection = (initialPosition.getY() - finalPosition.getY()) < 0;
		
		if(whiteDirection != isWhite() || deltaX > 1 || deltaY > 2 || deltaY == 0){
			return false;
		}
		if(deltaX == 0){
			if(deltaY == 2){
				return ((isWhite() && this.position.getY() == 1) || (!isWhite() && this.position.getY() == 6));
			}
			if(deltaY == 1){
				return true;
			}
		}
		
		if(deltaX == 1){
			return (deltaY == 1);
		}
		
		
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
