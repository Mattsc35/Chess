package board;

import java.awt.Point;

import chessPieces.*;
import concepts.BoardPosition;

public class GameBoard {
	private ChessBoard currentChessBoard;
	
	public GameBoard(){
		currentChessBoard = new ChessBoard();
		initializeInitialChessboard();
	}

	private void initializeInitialChessboard() {
		// TODO Auto-generated method stub
		for (int x = 0; x < 8; x++) {
			BoardPosition currentPosition = new BoardPosition(x,1);
			currentChessBoard.setPiece(currentPosition, new Pawn(currentPosition, true));
		}
		
	}
	
	public void printBoard(){
		currentChessBoard.printBoard();
	}
	
	
}
