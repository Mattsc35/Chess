package util;

import java.util.LinkedList;

import board.ChessBoard;
import chessPieces.ChessPiece;
import chessPieces.PieceType;
import concepts.BoardPosition;
import concepts.ChessMove;

public class CheckmateChecker {

	private static String tag = "CheckmateChecker";

	public CheckmateChecker() {

	}

	private static BoardPosition findKing(ChessBoard theBoard, boolean white) {
		// TODO Check
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				BoardPosition currentPos = new BoardPosition(row, col);
				ChessPiece currentPiece = theBoard.getPiece(currentPos);
				if (currentPiece.getType() == PieceType.KING && currentPiece.isWhite() == white) {
					return currentPos;
				}
			}
		}
		Logger.error(tag, "Can't find king.");
		return null;
	}

	private static boolean isInCheck(ChessBoard theBoard, boolean white) {
		// TODO check
		LinkedList<ChessMove> enemyMoves = new LinkedList<ChessMove>();
		BoardPosition kingPosition = findKing(theBoard, white); 

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				BoardPosition currentPos = new BoardPosition(row, col);
				ChessPiece currentPiece = theBoard.getPiece(currentPos);
				if (!currentPiece.isEmpty() && currentPiece.isWhite() != white) {
					enemyMoves.addAll(PotentialMoveFinder.getPotentialMoves(theBoard, currentPos));
				}
			}
		}
		for (ChessMove enemyMove : enemyMoves) {
			if (enemyMove.getFinalPosition() == kingPosition) {
				return true;
			}
		}

		return false;
	}

	public static boolean isWhiteInCheck(ChessBoard theBoard, ChessMove moveToMake) {
		return isInCheck(theBoard, true);
	}

	public static boolean isBlackInCheck(ChessBoard theBoard, ChessMove moveToMake) {
		return isInCheck(theBoard, false);
	}

	private static boolean isInCheckmate(ChessBoard theBoard, boolean white) {
		//TODO Write
		return true;
	}

	public static boolean isWhiteInCheckmate(ChessBoard theBoard, ChessMove moveToMake) {
		return isInCheckmate(theBoard, true);
	}

	public static boolean isBlackInCheckmate(ChessBoard theBoard, ChessMove moveToMake) {
		return isInCheckmate(theBoard, false);
	}
}
