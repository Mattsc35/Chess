package util;

import board.ChessBoard;
import chessPieces.ChessPiece;
import chessPieces.PieceType;
import concepts.BoardPosition;
import concepts.ChessMove;

public class MoveChecker {

	public MoveChecker() {
	}

	public static boolean canMakeMove(ChessBoard theBoard, ChessMove moveToMake) {
		
		BoardPosition initialPosition = moveToMake.getInitialPosition();
		BoardPosition finalPosition = moveToMake.getFinalPosition();
		if (initialPosition.equals(finalPosition)) {
			Logger.debug("Can make move", "Initial and final positions equal.");
			return false;
		}

		ChessPiece initialPiece = theBoard.getPiece(initialPosition);
		ChessPiece finalPiece = theBoard.getPiece(finalPosition);
		if (initialPiece.isEmpty()) {
			Logger.debug("Can make move", "Initial positions empty.");
			return false;
		}

		// See if move would capture a piece of the same color
		if (initialPiece.isWhite() == finalPiece.isWhite() && !finalPiece.isEmpty()) {
			Logger.debug("Can make move", "Would capture equivilent piece.");
			return false;
		}

		PieceType initialPieceType = initialPiece.getType();
		if (initialPieceType == PieceType.PAWN) {
			return canPawnMakeMove(theBoard, moveToMake);
		}
		else if (initialPieceType == PieceType.ROOK) {
			return canRookMakeMove(theBoard, moveToMake);
		}
		else if (initialPieceType == PieceType.KNIGHT) {
			return canKnightMakeMove(theBoard, moveToMake);
		}
		else if (initialPieceType == PieceType.BISHOP) {
			return canBishopMakeMove(theBoard, moveToMake);
		}
		else if (initialPieceType == PieceType.QUEEN) {
			return canQueenMakeMove(theBoard, moveToMake);
		}
		else if (initialPieceType == PieceType.KING) {
			return canKingMakeMove(theBoard, moveToMake);
		}

		return false;
	}

	public static boolean canPawnMakeMove(ChessBoard theBoard, ChessMove moveToMake) {
		BoardPosition initialPosition = moveToMake.getInitialPosition();
		BoardPosition finalPosition = moveToMake.getFinalPosition();
		ChessPiece initialPiece = theBoard.getPiece(initialPosition);
		ChessPiece finalPiece = theBoard.getPiece(finalPosition);
		if (initialPiece.getType() != PieceType.PAWN || !initialPiece.canPotentiallyMakeMove(moveToMake)) {
			return false;
		}
		int deltaX = Math.abs(initialPosition.getX() - finalPosition.getX());
		int deltaY = Math.abs(initialPosition.getY() - finalPosition.getY());
		final int initialX = initialPosition.getX();
		final int initialY = initialPosition.getY();
		final int finalY = finalPosition.getY();
		boolean up = (initialY - finalY) < 0;
		int yIncrement = (up) ? 1 : -1;
		if (deltaX == 0) {
			ChessPiece pieceOneAhead = theBoard.getPiece(new BoardPosition(initialX, initialY + yIncrement));
			if (deltaY == 1) {
				return pieceOneAhead.isEmpty();
			}
			else if (deltaY == 2) {
				ChessPiece pieceTwoAhead = theBoard.getPiece(new BoardPosition(initialX, initialY + (2 * yIncrement)));
				return pieceOneAhead.isEmpty() && pieceTwoAhead.isEmpty();
			}
		}
		else if (deltaX == 1) {
			return (!finalPiece.isEmpty() && (finalPiece.isWhite() != initialPiece.isWhite()));
		}

		return false;
	}

	public static boolean canKingMakeMove(ChessBoard theBoard, ChessMove moveToMake) {
		BoardPosition initialPosition = moveToMake.getInitialPosition();
		BoardPosition finalPosition = moveToMake.getFinalPosition();
		ChessPiece initialPiece = theBoard.getPiece(initialPosition);
		ChessPiece finalPiece = theBoard.getPiece(finalPosition);
		if (initialPiece.getType() != PieceType.KING|| !initialPiece.canPotentiallyMakeMove(moveToMake)) {
			return false;
		}
		
		if (initialPiece.isWhite() == finalPiece.isWhite() && !finalPiece.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}

	public static boolean canKnightMakeMove(ChessBoard theBoard, ChessMove moveToMake) {
		BoardPosition initialPosition = moveToMake.getInitialPosition();
		BoardPosition finalPosition = moveToMake.getFinalPosition();
		ChessPiece initialPiece = theBoard.getPiece(initialPosition);
		ChessPiece finalPiece = theBoard.getPiece(finalPosition);
		if (initialPiece.getType() != PieceType.KNIGHT || !initialPiece.canPotentiallyMakeMove(moveToMake)) {
			return false;
		}
		
		if (initialPiece.isWhite() == finalPiece.isWhite() && !finalPiece.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}

	public static boolean canQueenMakeMove(ChessBoard theBoard, ChessMove moveToMake) {
		final int initialX = moveToMake.getInitialPosition().getX();
		final int initialY = moveToMake.getInitialPosition().getY();
		final int finalX = moveToMake.getFinalPosition().getX();
		final int finalY = moveToMake.getFinalPosition().getY();
		boolean horizontal = (initialX - finalX) != 0; // TODO check
		boolean vertical = (initialY - finalY) != 0;

		if (horizontal && vertical) {
			return canBishopMakeMove(theBoard, moveToMake);
		}
		else {
			return canRookMakeMove(theBoard, moveToMake);
		}
	}

	public static boolean canBishopMakeMove(ChessBoard theBoard, ChessMove moveToMake) {
		BoardPosition initialPosition = moveToMake.getInitialPosition();
		BoardPosition finalPosition = moveToMake.getFinalPosition();
		ChessPiece initialPiece = theBoard.getPiece(initialPosition);
		ChessPiece finalPiece = theBoard.getPiece(finalPosition);
		if (initialPiece.getType() != PieceType.BISHOP || !initialPiece.canPotentiallyMakeMove(moveToMake)) {
			return false;
		}
		if (initialPiece.isWhite() == finalPiece.isWhite() && !finalPiece.isEmpty()) {
			return false;
		}

		final int initialX = initialPosition.getX();
		final int initialY = initialPosition.getY();
		final int finalX = finalPosition.getX();
		final int finalY = finalPosition.getY();
		if (Math.abs(initialX - finalX) != Math.abs(initialY - finalY)) {
			return false;
		}

		boolean right = (initialX - finalX) < 0; // TODO check
		boolean up = (initialY - finalY) < 0;

		int deltaX = (right) ? 1 : -1;
		int deltaY = (up) ? 1 : -1;

		int currentX = initialX + deltaX;
		int currentY = initialY + deltaY;

		// TODO double check or vs and
		while (currentX != finalX || currentY != finalY) {
			if ((currentX < 0 || currentX > 7) || (currentY < 0 || currentY > 7)) {
				Logger.error("CanBishopMove", "Invalid board positions");
				break;
			}

			BoardPosition currentPosition = new BoardPosition(currentX, currentY);
			if (!theBoard.getPiece(currentPosition).isEmpty()) {
				return false;
			}

			currentX += deltaX;
			currentY += deltaY;
		}

		return true;
	}

	public static boolean canRookMakeMove(ChessBoard theBoard, ChessMove moveToMake) {
		BoardPosition initialPosition = moveToMake.getInitialPosition();
		BoardPosition finalPosition = moveToMake.getFinalPosition();
		ChessPiece initialPiece = theBoard.getPiece(initialPosition);
		ChessPiece finalPiece = theBoard.getPiece(finalPosition);
		if (initialPiece.getType() != PieceType.ROOK|| !initialPiece.canPotentiallyMakeMove(moveToMake)) {
			return false;
		}
		if (initialPiece.isWhite() == finalPiece.isWhite() && !finalPiece.isEmpty()) {
			return false;
		}

		final int initialX = initialPosition.getX();
		final int initialY = initialPosition.getY();
		final int finalX = finalPosition.getX();
		final int finalY = finalPosition.getY();
		boolean horizontal = (initialX - finalX) != 0;

		if (horizontal) {
			boolean right = (initialX - finalX) < 0; // TODO check
			int delta = (right) ? 1 : -1;

			for (int i = 0; initialX + i != finalX; i += delta) {
				if (initialX + i < 0 || initialX + i > 7) {
					Logger.error("CanRookMove", "Invalid board positions");
					break;
				}
				BoardPosition currentPosition = new BoardPosition(i + initialX, initialY);
				if (!theBoard.getPiece(currentPosition).isEmpty()) {
					return false;
				}
			}
		}
		else {
			boolean up = (initialY - finalY) < 0; // TODO check
			int delta = (up) ? 1 : -1;

			for (int i = delta; initialY + i != finalY; i += delta) {
				if (initialY + i < 0 || initialY + i > 7) {
					Logger.error("CanRookMove", "Invalid board positions");
					break;
				}

				BoardPosition currentPosition = new BoardPosition(initialX, initialY + i);
				if (!theBoard.getPiece(currentPosition).isEmpty()) {
					return false;
				}
			}
		}

		return true;
	}

}
