package board;

import chessPieces.*;
import concepts.BoardPosition;
import concepts.ChessMove;

public class GameBoard {
	private ChessBoard currentChessBoard;

	public GameBoard() {
		currentChessBoard = new ChessBoard();
		initializeInitialChessboard();
	}

	private void initializeInitialChessboard() {
		BoardPosition currentPosition;
		int whiteY = 1;
		int blackY = 6;
		
		for (int x = 0; x < 8; x++) {
			currentPosition = new BoardPosition(x, whiteY);
			currentChessBoard.setPiece(new Pawn(currentPosition, true));

			currentPosition = new BoardPosition(x, blackY);
			currentChessBoard.setPiece(new Pawn(currentPosition, false));
		}
		
		whiteY = 0;
		blackY = 7;

		// Rooks
		currentPosition = new BoardPosition(0, whiteY);
		currentChessBoard.setPiece(new Rook(currentPosition, true));
		currentPosition = new BoardPosition(7, whiteY);
		currentChessBoard.setPiece(new Rook(currentPosition, true));

		currentPosition = new BoardPosition(0, blackY);
		currentChessBoard.setPiece(new Rook(currentPosition, false));
		currentPosition = new BoardPosition(7, blackY);
		currentChessBoard.setPiece(new Rook(currentPosition, false));

		// Knights
		currentPosition = new BoardPosition(1, whiteY);
		currentChessBoard.setPiece(new Knight(currentPosition, true));
		currentPosition = new BoardPosition(6, whiteY);
		currentChessBoard.setPiece(new Knight(currentPosition, true));

		currentPosition = new BoardPosition(1, blackY);
		currentChessBoard.setPiece(new Knight(currentPosition, false));
		currentPosition = new BoardPosition(6, blackY);
		currentChessBoard.setPiece(new Knight(currentPosition, false));

		// Bishops
		currentPosition = new BoardPosition(2, whiteY);
		currentChessBoard.setPiece(new Bishop(currentPosition, true));
		currentPosition = new BoardPosition(5, whiteY);
		currentChessBoard.setPiece(new Bishop(currentPosition, true));

		currentPosition = new BoardPosition(2, blackY);
		currentChessBoard.setPiece(new Bishop(currentPosition, false));
		currentPosition = new BoardPosition(5, blackY);
		currentChessBoard.setPiece(new Bishop(currentPosition, false));

		// Queens
		currentPosition = new BoardPosition(3, whiteY);
		currentChessBoard.setPiece(new Queen(currentPosition, true));

		currentPosition = new BoardPosition(3, blackY);
		currentChessBoard.setPiece(new Queen(currentPosition, false));

		// Kings
		currentPosition = new BoardPosition(4, whiteY);
		currentChessBoard.setPiece(new King(currentPosition, true));

		currentPosition = new BoardPosition(4, blackY);
		currentChessBoard.setPiece(new King(currentPosition, false));

	}

	public boolean makeMove(ChessMove moveToMake){
		BoardPosition initialPosition = moveToMake.getInitialPosition();
		BoardPosition finalPosition = moveToMake.getFinalPosition();
		if(initialPosition.equals(finalPosition)){
			return false;
		}

		ChessPiece initialPiece = currentChessBoard.getPiece(initialPosition);
		ChessPiece finalPiece = currentChessBoard.getPiece(finalPosition);
		
		if(initialPiece.isEmpty()){
			return false;
		}
		if(initialPiece.isWhite() == finalPiece.isWhite() && !finalPiece.isEmpty()){
			return false;
		}
		
		
		return false; //TODO Change
	}
	
	
	
	
	public void printBoard() {
		currentChessBoard.printBoard();
	}

}
