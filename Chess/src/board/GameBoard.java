package board;

import java.util.Deque;
import java.util.LinkedList;

import chessPieces.*;
import concepts.BoardPosition;
import concepts.ChessMove;
import concepts.MoveLog;
import util.Logger;
import util.MoveChecker;

public class GameBoard {
	private ChessBoard currentChessBoard;
	private Deque<MoveLog> pastMoves;
	private String loggerTag;
	
	public GameBoard() {
		currentChessBoard = new ChessBoard();
		pastMoves = new LinkedList<MoveLog>();
		loggerTag = "GameBoard";
		initializeInitialChessboard();
	}

	private void initializeInitialChessboard() {
		Logger.log(loggerTag,"Initializing Chessboard");
		
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

	public boolean makeMove(ChessMove moveToMake) {
		boolean canMakeMove = MoveChecker.canMakeMove(currentChessBoard, moveToMake);
		
		if(canMakeMove){
			BoardPosition initialPosition = moveToMake.getInitialPosition();
			BoardPosition finalPosition = moveToMake.getFinalPosition();
			ChessPiece initialPiece = currentChessBoard.getPiece(initialPosition);
			ChessPiece finalPiece = currentChessBoard.getPiece(initialPosition);
			PieceType initialPieceType = initialPiece.getType();
			boolean isWhite = initialPiece.isWhite();
			
			pastMoves.push(new MoveLog(moveToMake, initialPiece, finalPiece));

			ChessPiece newPiece = null;
			if (initialPieceType == PieceType.PAWN) {
				newPiece = new Pawn(finalPosition, isWhite);
			}
			else if (initialPieceType == PieceType.ROOK) {
				newPiece = new Rook(finalPosition, isWhite);
			}
			else if (initialPieceType == PieceType.KNIGHT) {
				newPiece = new Knight(finalPosition, isWhite);
			}
			else if (initialPieceType == PieceType.BISHOP) {
				newPiece = new Bishop(finalPosition, isWhite);
			}
			else if (initialPieceType == PieceType.QUEEN) {
				newPiece = new Queen(finalPosition, isWhite);
			}
			else if (initialPieceType == PieceType.KING) {
				newPiece = new King(finalPosition, isWhite);
			}
			
			currentChessBoard.setPiece(new EmptyPiece(initialPosition));
			currentChessBoard.setPiece(newPiece);
			Logger.debug(loggerTag, "Make Move: Move Made");
		}
		else{
			Logger.debug(loggerTag, "Make Move: Move not able to be made");
		}

		return canMakeMove; // TODO Change
	}

	public void printBoard() {
		currentChessBoard.printBoard();
	}

	public void undoMove(){
		if(pastMoves.isEmpty()){
			Logger.debug(loggerTag, "Undo move. No moves to undo.");
			return;
		}
		
		MoveLog lastMoveLog = pastMoves.pop();
		ChessMove lastMove = lastMoveLog.getMove();
		ChessPiece movedPiece = lastMoveLog.getMovedPiece();
		ChessPiece capturedPiece = lastMoveLog.getCapturedPiece();
		
		currentChessBoard.setPiece(movedPiece);
		currentChessBoard.setPiece(capturedPiece);
		
	}
}
 