package board;

import chessPieces.Bishop;
import chessPieces.ChessPiece;
import chessPieces.EmptyPiece;
import chessPieces.King;
import chessPieces.Knight;
import chessPieces.Pawn;
import chessPieces.Queen;
import chessPieces.Rook;
import concepts.BoardPosition;
import util.Logger;

//Most low level board
public class ChessBoard {
	private ChessPiece[][] board;
	private String tag = "Chessboard";

	public ChessBoard() {
		board = new ChessPiece[8][8];
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				BoardPosition position = new BoardPosition(row, col);
				setPiece(new EmptyPiece(position));
			}
		}
	}

	private ChessPiece getPiece(int x, int y) {
		return board[x][y];
	}

	private void setPiece(int x, int y, ChessPiece piece) {
		board[x][y] = piece;
	}

	public void setPiece(ChessPiece piece) {
		setPiece(piece.getPosition().getX(), piece.getPosition().getY(), piece);
	}

	public ChessPiece getPiece(BoardPosition position) {
		return getPiece(position.getX(), position.getY());
	}

	public void printBoard() {
		for (int col = 7; col >= 0; col--) {
			System.out.print(col);
			for (int row = 0; row < 8; row++) {
				System.out.print(getPiece(row, col).getTextRender());
			}
			System.out.println();
		}
		System.out.println("  0  1  2  3  4  5  6  7");
	}

	public boolean equals(Object o) {
		if (!(o instanceof ChessBoard)) {
			return false;
		}

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (!getPiece(row, col).equals(((ChessBoard) o).getPiece(row, col))) {
					return false;
				}
			}
		}

		return true;
	}
	

	public void parseBoard(String[] newBoard) {
		if (newBoard.length != 8) {
			Logger.error(tag, "INVALID BOARD. TOO MANY ROWS");
			return;
		}
		for (String line : newBoard) {
			System.out.println(line);
			line = line.replace("[", "");
			line = line.replace("]", "");
			System.out.println(line);
			if (line.length() != 8) {
				Logger.error(tag, "INVALID BOARD. TOO MANY COLUMNS");
				return;
			}
		}
		
		for (int row = 0; row < newBoard.length; row++) {
			for (int col = 0; col < newBoard.length; col++) {
				ChessPiece newPiece = null;
				char currentChar = newBoard[7-row].charAt(col);
				BoardPosition currentPosition = new BoardPosition(row, col);

				if (currentChar == ' ' || currentChar == 'x' || currentChar == 'X') {
					newPiece = new EmptyPiece(currentPosition);
				}
				else if (currentChar == 'P') {
					newPiece = new Pawn(currentPosition, true);
				}
				else if (currentChar == 'p') {
					newPiece = new Pawn(currentPosition, false);
				}
				else if (currentChar == 'R') {
					newPiece = new Rook(currentPosition, true);
				}
				else if (currentChar == 'r') {
					newPiece = new Rook(currentPosition, false);
				}
				else if (currentChar == 'N') {
					newPiece = new Knight(currentPosition, true);
				}
				else if (currentChar == 'n') {
					newPiece = new Knight(currentPosition, false);
				}
				else if (currentChar == 'B') {
					newPiece = new Bishop(currentPosition, true);
				}
				else if (currentChar == 'b') {
					newPiece = new Bishop(currentPosition, false);
				}
				else if (currentChar == 'Q') {
					newPiece = new Queen(currentPosition, true);
				}
				else if (currentChar == 'q') {
					newPiece = new Queen(currentPosition, false);
				}
				else if (currentChar == 'K') {
					newPiece = new King(currentPosition, true);
				}
				else if (currentChar == 'k') {
					newPiece = new King(currentPosition, false);
				}
				else {
					Logger.error(tag, "Invalid board character");
					System.out.println(currentChar);
					return;
				}
				setPiece(newPiece);
			}
		}
	}
}
