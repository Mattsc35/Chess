package concepts;

import chessPieces.ChessPiece;

public class MoveLog {
	ChessMove move;
	ChessPiece movedPiece;
	ChessPiece capturedPiece;

	public MoveLog(ChessMove move, ChessPiece movedPiece, ChessPiece capturedPiece) {
		this.move = move;
		this.movedPiece = movedPiece;
		this.capturedPiece = capturedPiece;
	}

	
	public ChessMove getMove() {
		return move;
	}
	public ChessPiece getMovedPiece() {
		return movedPiece;
	}
	public ChessPiece getCapturedPiece() {
		return capturedPiece;
	}

}
