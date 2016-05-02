package players;

import java.util.Scanner;

import board.GameBoard;
import concepts.BoardPosition;
import concepts.ChessMove;

public class HumanPlayer extends Player {


	
	@Override
	public ChessMove getNextMove(GameBoard currentBoard) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter initial x: ");
		int initialX = scanner.nextInt();
		if(initialX < 0 || initialX > 7){
			System.out.println("wrong input try again");
			initialX = scanner.nextInt();
		}
		
		System.out.println("enter initial y: ");
		int initialY = scanner.nextInt();
		if(initialY < 0 || initialY > 7){
			System.out.println("wrong input try again");
			initialY = scanner.nextInt();
		}
		
		System.out.println("enter final x: ");
		int finalX = scanner.nextInt();
		if(finalX < 0 || finalX > 7){
			System.out.println("wrong input try again");
			finalX = scanner.nextInt();
		}
		
		System.out.println("enter final y: ");
		int finalY = scanner.nextInt();
		if(finalY < 0 || finalY > 7){
			System.out.println("wrong input try again");
			finalY = scanner.nextInt();
		}
		
		BoardPosition initialPosition = new BoardPosition(initialX, initialY);
		BoardPosition finalPosition = new BoardPosition(finalX, finalY);
		ChessMove move = new ChessMove(initialPosition, finalPosition);
		return move;
	}

}
