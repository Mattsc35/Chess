package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import board.ChessBoard;
import board.GameBoard;
import chessPieces.EmptyPiece;
import chessPieces.Queen;
import chessPieces.Rook;
import concepts.BoardPosition;
import concepts.ChessMove;

public class GameBoardTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGameBoard() {
		GameBoard testBoard = new GameBoard();

		ChessBoard controlBoard = new ChessBoard();
		String[] newBoard = { "rnbqkbnr", "pppppppp", "        ", "        ", "        ", "        ", "PPPPPPPP",
				"RNBQKBNR" };
		controlBoard.parseBoard(newBoard);

		assertTrue(testBoard.getChessBoard().equals(controlBoard));
	}

	@Test
	public void testMakeMove() {
		//fail("Not yet implemented"); // TODO

		assertTrue(pawnMakeMove());
		assertTrue(RookMakeMove());
		//assertTrue(KnightMakeMove());
		//assertTrue(BishopMakeMove());
		//assertTrue(QueenMakeMove());
		//assertTrue(KingMakeMove());

		GameBoard testBoard = new GameBoard();
		BoardPosition initialPosition;
		BoardPosition finalPosition;

		initialPosition = new BoardPosition(0, 0);
		finalPosition = new BoardPosition(0, 0);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		initialPosition = new BoardPosition(1, 1);
		finalPosition = new BoardPosition(1, 2);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		initialPosition = new BoardPosition(0, 1);
		finalPosition = new BoardPosition(0, 4);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		initialPosition = new BoardPosition(0, 1);
		finalPosition = new BoardPosition(0, 3);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		ChessBoard controlBoard = new ChessBoard();
		String[] newBoard = { "rnbqkbnr", "pppppppp", "        ", "        ", "P       ", " P      ", "  PPPPPP",
				"RNBQKBNR" };
		controlBoard.parseBoard(newBoard);
	}

	private boolean QueenMakeMove() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean KingMakeMove() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean BishopMakeMove() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean KnightMakeMove() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean RookMakeMove() {
		// TODO Auto-generated method stub
		String[] initialBoardText = { "        ", "   Q    ", "        ", "        ", "        ", "        ",
				"q  R  Qq", "        " };
		ChessBoard initialTestBoard = new ChessBoard();
		initialTestBoard.parseBoard(initialBoardText);
		GameBoard testGameBoard = new GameBoard(initialTestBoard);
		BoardPosition initialPosition;
		BoardPosition finalPosition;

		initialPosition = new BoardPosition(3, 1);
		finalPosition = new BoardPosition(3, 2);
		testGameBoard.makeMove(new ChessMove(initialPosition, finalPosition));
		ChessBoard testGameBoardChessBoard = testGameBoard.getChessBoard();
		assertTrue(testGameBoardChessBoard.getPiece(initialPosition).equals(new EmptyPiece(initialPosition)));
		assertTrue(testGameBoardChessBoard.getPiece(finalPosition).equals(new Rook(finalPosition, true)));

		initialPosition = new BoardPosition(3, 2);
		finalPosition = new BoardPosition(3, 6);
		testGameBoard.makeMove(new ChessMove(initialPosition, finalPosition));
		testGameBoardChessBoard = testGameBoard.getChessBoard();
		assertTrue(testGameBoardChessBoard.getPiece(initialPosition).equals(new Rook(initialPosition, true)));
		assertTrue(testGameBoardChessBoard.getPiece(finalPosition).equals(new Queen(finalPosition, true)));

		initialPosition = new BoardPosition(3, 2);
		finalPosition = new BoardPosition(3, 7);
		testGameBoard.makeMove(new ChessMove(initialPosition, finalPosition));
		testGameBoardChessBoard = testGameBoard.getChessBoard();
		assertTrue(testGameBoardChessBoard.getPiece(initialPosition).equals(new Rook(initialPosition, true)));
		assertTrue(testGameBoardChessBoard.getPiece(finalPosition).equals(new EmptyPiece(finalPosition)));

		initialPosition = new BoardPosition(3, 2);
		finalPosition = new BoardPosition(3, 1);
		testGameBoard.makeMove(new ChessMove(initialPosition, finalPosition));
		testGameBoardChessBoard = testGameBoard.getChessBoard();
		assertTrue(testGameBoardChessBoard.getPiece(initialPosition).equals(new EmptyPiece(initialPosition)));
		assertTrue(testGameBoardChessBoard.getPiece(finalPosition).equals(new Rook(finalPosition, true)));

		initialPosition = new BoardPosition(3, 1);
		finalPosition = new BoardPosition(0, 1);
		testGameBoard.makeMove(new ChessMove(initialPosition, finalPosition));
		testGameBoardChessBoard = testGameBoard.getChessBoard();
		assertTrue(testGameBoardChessBoard.getPiece(initialPosition).equals(new EmptyPiece(initialPosition)));
		assertTrue(testGameBoardChessBoard.getPiece(finalPosition).equals(new Rook(finalPosition, true)));

		initialPosition = new BoardPosition(0, 1);
		finalPosition = new BoardPosition(7, 1);
		testGameBoard.makeMove(new ChessMove(initialPosition, finalPosition));
		testGameBoardChessBoard = testGameBoard.getChessBoard();
		assertTrue(testGameBoardChessBoard.getPiece(initialPosition).equals(new Rook(initialPosition, true)));
		assertTrue(testGameBoardChessBoard.getPiece(finalPosition).equals(new Queen(finalPosition, false)));

		return true;
	}

	private boolean pawnMakeMove() {
		GameBoard testBoard = new GameBoard();
		BoardPosition initialPosition;
		BoardPosition finalPosition;

		initialPosition = new BoardPosition(0, 0);
		finalPosition = new BoardPosition(0, 0);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		initialPosition = new BoardPosition(1, 1);
		finalPosition = new BoardPosition(1, 2);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		initialPosition = new BoardPosition(0, 1);
		finalPosition = new BoardPosition(0, 4);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		initialPosition = new BoardPosition(0, 1);
		finalPosition = new BoardPosition(0, 3);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		initialPosition = new BoardPosition(2, 1);
		finalPosition = new BoardPosition(1, 2);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		initialPosition = new BoardPosition(2, 1);
		finalPosition = new BoardPosition(3, 2);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		initialPosition = new BoardPosition(0, 3);
		finalPosition = new BoardPosition(0, 4);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		initialPosition = new BoardPosition(0, 4);
		finalPosition = new BoardPosition(0, 5);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		initialPosition = new BoardPosition(0, 5);
		finalPosition = new BoardPosition(0, 6);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		initialPosition = new BoardPosition(0, 5);
		finalPosition = new BoardPosition(1, 6);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		initialPosition = new BoardPosition(1, 6);
		finalPosition = new BoardPosition(0, 6);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		initialPosition = new BoardPosition(1, 6);
		finalPosition = new BoardPosition(1, 5);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		initialPosition = new BoardPosition(1, 6);
		finalPosition = new BoardPosition(2, 7);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		initialPosition = new BoardPosition(2, 7);
		finalPosition = new BoardPosition(3, 6);
		testBoard.makeMove(new ChessMove(initialPosition, finalPosition));

		ChessBoard controlBoard = new ChessBoard();
		String[] newBoard = { "rnPqkbnr", "p pppppp", "        ", "        ", "        ", " P      ", "  PPPPPP",
				"RNBQKBNR" };
		controlBoard.parseBoard(newBoard);

		return controlBoard.equals(testBoard.getChessBoard());
	}

	@Test
	public void testUndoMove() {
		fail("Not yet implemented"); // TODO
	}

}
