package util;

import java.util.ArrayList;
import java.util.LinkedList;
import board.ChessBoard;
import chessPieces.ChessPiece;
import chessPieces.Pawn;
import chessPieces.PieceType;
import concepts.BoardPosition;
import concepts.ChessMove;

public class PotentialMoveFinder {
	private static String tag = "PotentialMoveFinder";

	public PotentialMoveFinder() {

	}

	public static ArrayList<ChessMove> getPotentialMoves(ChessBoard theBoard, BoardPosition position) {
		ChessPiece currentPiece = theBoard.getPiece(position);

		if (currentPiece == null || currentPiece.isEmpty()) {
			return new ArrayList<ChessMove>();
		}

		if (currentPiece.getType() == PieceType.PAWN) {
			return getPotentialPawnMoves(theBoard, position);
		}
		else if (currentPiece.getType() == PieceType.ROOK) {
			return getPotentialRookMoves(theBoard, position);
		}
		else if (currentPiece.getType() == PieceType.KNIGHT) {
			return getPotentialKnightMoves(theBoard, position);
		}
		else if (currentPiece.getType() == PieceType.BISHOP) {
			return getPotentialBishopMoves(theBoard, position);
		}
		else if (currentPiece.getType() == PieceType.QUEEN) {
			return getPotentialQueenMoves(theBoard, position);
		}
		else if (currentPiece.getType() == PieceType.KING) {
			return getPotentialKingMoves(theBoard, position);
		}
		else {
			Logger.error(tag, "PotentialMoveFinder, Invalid board piece.");
			return new ArrayList<ChessMove>();
		}
	}

	private static ArrayList<ChessMove> getPotentialPawnMoves(ChessBoard theBoard, BoardPosition position) {
		// TODO check
		ArrayList<ChessMove> returnList = new ArrayList<ChessMove>();
		ChessPiece currentPiece = theBoard.getPiece(position);
		int currentY = position.getY();
		int currentX = position.getX();
		boolean white = currentPiece.isWhite();
		boolean canMoveTwo = ((white && currentY == 1) || (!white && currentY == 6));
		int deltaY = (white) ? 1 : -1;

		if ((!white && currentY > 0) || (white && currentY < 7)) {
			ChessPiece potentialPiece;
			potentialPiece = theBoard.getPiece(new BoardPosition(currentX, currentY + deltaY));
			// One in front
			if (potentialPiece.isEmpty()) {
				returnList.add(new ChessMove(position, new BoardPosition(currentX, currentY + deltaY)));
			}
			else {
				canMoveTwo = false;
			}

			// Two in front
			if (canMoveTwo) {
				potentialPiece = theBoard.getPiece(new BoardPosition(currentX, currentY + deltaY + deltaY));
				if (potentialPiece.isEmpty()) {
					returnList.add(new ChessMove(position, new BoardPosition(currentX, currentY + deltaY + deltaY)));
				}
			}

			// Side captures
			if (currentX > 0) {
				potentialPiece = theBoard.getPiece(new BoardPosition(currentX - 1, currentY + deltaY));
				if (!potentialPiece.isEmpty() && potentialPiece.isWhite() != white) {
					returnList.add(new ChessMove(position, new BoardPosition(currentX - 1, currentY + deltaY)));
				}
			}
			if (currentX < 7) {
				potentialPiece = theBoard.getPiece(new BoardPosition(currentX + 1, currentY + deltaY));
				if (!potentialPiece.isEmpty() && potentialPiece.isWhite() != white) {
					returnList.add(new ChessMove(position, new BoardPosition(currentX + 1, currentY + deltaY)));
				}
			}
		}

		return returnList;
	}

	private static ArrayList<ChessMove> getPotentialRookMoves(ChessBoard theBoard, BoardPosition position) {
		// TODO check
		ArrayList<ChessMove> returnList = new ArrayList<ChessMove>();
		boolean white = theBoard.getPiece(position).isWhite();

		// Left Spaces
		for (int newX = position.getX() - 1; newX >= 0; newX--) {
			BoardPosition currentPosition = new BoardPosition(newX, position.getY());
			ChessPiece currentPiece = theBoard.getPiece(currentPosition);
			if (currentPiece.isEmpty()) {
				returnList.add(new ChessMove(position, currentPosition));
			}
			else if (currentPiece.isWhite() != white) {
				returnList.add(new ChessMove(position, currentPosition));
				break;
			}
			else {
				break;
			}
		}
		// Right Spaces
		for (int newX = position.getX() + 1; newX < 8; newX++) {
			BoardPosition currentPosition = new BoardPosition(newX, position.getY());
			ChessPiece currentPiece = theBoard.getPiece(currentPosition);
			if (currentPiece.isEmpty()) {
				returnList.add(new ChessMove(position, currentPosition));
			}
			else if (currentPiece.isWhite() != white) {
				returnList.add(new ChessMove(position, currentPosition));
				break;
			}
			else {
				break;
			}
		}

		// Down Spaces
		for (int newY = position.getY() - 1; newY >= 0; newY--) {
			BoardPosition currentPosition = new BoardPosition(position.getX(), newY);
			ChessPiece currentPiece = theBoard.getPiece(currentPosition);
			if (currentPiece.isEmpty()) {
				returnList.add(new ChessMove(position, currentPosition));
			}
			else if (currentPiece.isWhite() != white) {
				returnList.add(new ChessMove(position, currentPosition));
				break;
			}
			else {
				break;
			}
		}
		// Up Spaces
		for (int newY = position.getY() + 1; newY < 8; newY++) {
			BoardPosition currentPosition = new BoardPosition(position.getX(), newY);
			ChessPiece currentPiece = theBoard.getPiece(currentPosition);
			if (currentPiece.isEmpty()) {
				returnList.add(new ChessMove(position, currentPosition));
			}
			else if (currentPiece.isWhite() != white) {
				returnList.add(new ChessMove(position, currentPosition));
				break;
			}
			else {
				break;
			}
		}

		return returnList;
	}

	private static ArrayList<ChessMove> getPotentialKnightMoves(ChessBoard theBoard, BoardPosition position) {
		// TODO check
		ArrayList<ChessMove> returnList = new ArrayList<ChessMove>();

		boolean white = theBoard.getPiece(position).isWhite();
		int origX = position.getX();
		int origY = position.getY();

		int newX = -1;
		int newY = -1;
		int[] deltaX = { 1, 2, 2, 1, -1, -2, -2, -1 };
		int[] deltaY = { 2, 1, -1, -2, -2, -1, 1, 2 };

		for (int i = 0; i < 8; i++) {
			newX = origX + deltaX[i];
			newY = origY + deltaY[i];
			if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
				BoardPosition currentPosition = new BoardPosition(newX, newY);
				ChessPiece currentPiece = theBoard.getPiece(currentPosition);
				if (currentPiece.isEmpty()) {
					returnList.add(new ChessMove(position, currentPosition));
				}
				else if (currentPiece.isWhite() != white) {
					returnList.add(new ChessMove(position, currentPosition));
				}
			}
		}

		return returnList;
	}

	private static ArrayList<ChessMove> getPotentialBishopMoves(ChessBoard theBoard, BoardPosition position) {
		// TODO check
		ArrayList<ChessMove> returnList = new ArrayList<ChessMove>();

		boolean white = theBoard.getPiece(position).isWhite();
		int origX = position.getX();
		int origY = position.getY();

		boolean deltaFlag = true;
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = true;
		boolean flag4 = true;
		for (int delta = 1; deltaFlag; delta++) {
			deltaFlag = false;
			int newX, newY;

			newX = origX + delta;
			newY = origY + delta;
			if (flag1 && newX < 8 && newY < 8) {
				deltaFlag = true;

				BoardPosition possiblePos = new BoardPosition(newX, newY);
				ChessPiece currentPiece = theBoard.getPiece(possiblePos);
				if (currentPiece.isEmpty()) {
					returnList.add(new ChessMove(position, possiblePos));
				}
				else if (currentPiece.isWhite() != white) {
					returnList.add(new ChessMove(position, possiblePos));
					flag1 = false;
				}
				else {
					flag1 = false;
				}
			}

			newX = origX + delta;
			newY = origY - delta;
			if (flag2 && newX < 8 && newY >= 0) {
				deltaFlag = true;

				BoardPosition possiblePos = new BoardPosition(newX, newY);
				ChessPiece currentPiece = theBoard.getPiece(possiblePos);
				if (currentPiece.isEmpty()) {
					returnList.add(new ChessMove(position, possiblePos));
				}
				else if (currentPiece.isWhite() != white) {
					returnList.add(new ChessMove(position, possiblePos));
					flag2 = false;
				}
				else {
					flag2 = false;
				}

			}

			newX = origX - delta;
			newY = origY + delta;
			if (flag3 && newX >= 0 && newY < 8) {
				deltaFlag = true;

				BoardPosition possiblePos = new BoardPosition(newX, newY);
				ChessPiece currentPiece = theBoard.getPiece(possiblePos);
				if (currentPiece.isEmpty()) {
					returnList.add(new ChessMove(position, possiblePos));
				}
				else if (currentPiece.isWhite() != white) {
					returnList.add(new ChessMove(position, possiblePos));
					flag3 = false;
				}
				else {
					flag3 = false;
				}

			}

			newX = origX - delta;
			newY = origY - delta;
			if (flag4 && newX >= 0 && newY >= 0) {
				deltaFlag = true;

				BoardPosition possiblePos = new BoardPosition(newX, newY);
				ChessPiece currentPiece = theBoard.getPiece(possiblePos);
				if (currentPiece.isEmpty()) {
					returnList.add(new ChessMove(position, possiblePos));
				}
				else if (currentPiece.isWhite() != white) {
					returnList.add(new ChessMove(position, possiblePos));
					flag4 = false;
				}
				else {
					flag4 = false;
				}

			}
		}

		return returnList;
	}

	private static ArrayList<ChessMove> getPotentialQueenMoves(ChessBoard theBoard, BoardPosition position) {
		// TODO check
		ArrayList<ChessMove> returnList = new ArrayList<ChessMove>();
		returnList = getPotentialRookMoves(theBoard, position);
		returnList.addAll(getPotentialBishopMoves(theBoard, position));
		return returnList;
	}

	private static ArrayList<ChessMove> getPotentialKingMoves(ChessBoard theBoard, BoardPosition position) {
		// TODO check
		ArrayList<ChessMove> returnList = new ArrayList<ChessMove>();
		boolean white = theBoard.getPiece(position).isWhite();
		int origX = position.getX();
		int origY = position.getY();

		int newX = -1;
		int newY = -1;
		int[] deltaX = { 1, 1, 1, 0, -1, -1, -1, 0 };
		int[] deltaY = { 1, 0, -1, -1, -1, 0, 1, 1 };

		for (int i = 0; i < 8; i++) {
			newX = origX + deltaX[i];
			newY = origY + deltaY[i];
			if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
				BoardPosition currentPosition = new BoardPosition(newX, newY);
				ChessPiece currentPiece = theBoard.getPiece(currentPosition);
				if (currentPiece.isEmpty()) {
					returnList.add(new ChessMove(position, currentPosition));
				}
				else if (currentPiece.isWhite() != white) {
					returnList.add(new ChessMove(position, currentPosition));
				}
			}
		}

		return returnList;
	}

}
