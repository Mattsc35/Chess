package board;

import chessPieces.ChessPiece;
import chessPieces.EmptyPiece;
import concepts.BoardPosition;

//Most low level board
public class ChessBoard {
	private ChessPiece[][] board;

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
}
