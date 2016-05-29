import board.GameBoard;
import concepts.ChessMove;
import players.Player;

public class ChessGame {

	Player whitePlayer;
	Player blackPlayer;
	GameBoard gameBoard;

	public ChessGame() {

	}

	public void playChess() {
		boolean whiteTurn = true;
		Player currentPlayer = whitePlayer;

		while (true) {
			if (whiteTurn) {
				ChessMove moveToMake = whitePlayer.getNextMove(gameBoard);
			}

		}

	}

}
