import board.ChessBoard;
import board.GameBoard;
import concepts.ChessMove;
import players.HumanPlayer;
import util.Logger;
import util.LoggerLevel;

public class main {

	
	public static void testChessBoard(){
		
	}
	
	public static void scratchSpace(){
		ChessBoard board = new ChessBoard();
		board.printBoard();
	}
	
	public static void scratchSpace2(){
		GameBoard gameBoard = new GameBoard();
		gameBoard.printBoard();
	}
	
	public static void movePieces(){
		Logger.setLoggerLevel(LoggerLevel.DEBUG);
		GameBoard gameBoard = new GameBoard();
		HumanPlayer hp = new HumanPlayer();
		
		while(true){
			gameBoard.printBoard();
			ChessMove move = hp.getNextMove(gameBoard);
			if(!gameBoard.makeMove(move)){
				System.out.println("invalid move");
			}
		}
		
	}

	public static void main(String[] args) {
		movePieces();
	}

}
















