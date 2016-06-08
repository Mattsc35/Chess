package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import board.ChessBoard;
import chessPieces.Bishop;
import chessPieces.EmptyPiece;
import chessPieces.King;
import chessPieces.Knight;
import chessPieces.Pawn;
import chessPieces.Queen;
import concepts.BoardPosition;

public class ChessBoardTest {

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
	public void testChessBoard() {
		ChessBoard testBoard = new ChessBoard();

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				BoardPosition currentPosition = new BoardPosition(row, col);
				assertEquals(new EmptyPiece(currentPosition), testBoard.getPiece(currentPosition));
			}
		}
	}

	@Test
	public void testSetPiece() {
		ChessBoard testBoard = new ChessBoard();
		BoardPosition positionA = new BoardPosition(2, 2);
		testBoard.setPiece(new Pawn(positionA, true));
		BoardPosition positionB = new BoardPosition(3, 3);
		testBoard.setPiece(new King(positionB, false));

		assertEquals(new Pawn(positionA, true), testBoard.getPiece(positionA));
		assertEquals(new King(positionB, false), testBoard.getPiece(positionB));
	}

	@Test
	public void testGetPiece() {
		ChessBoard testBoard = new ChessBoard();
		BoardPosition positionA = new BoardPosition(2, 2);
		testBoard.setPiece(new Pawn(positionA, true));
		BoardPosition positionB = new BoardPosition(3, 3);
		testBoard.setPiece(new King(positionB, false));

		assertEquals(new Pawn(positionA, true), testBoard.getPiece(positionA));
		assertEquals(new King(positionB, false), testBoard.getPiece(positionB));
	}

	@Test
	public void testEqualsObject() {
		ChessBoard testBoard1 = new ChessBoard();
		BoardPosition positionA = new BoardPosition(2, 2);
		testBoard1.setPiece(new Pawn(positionA, true));
		BoardPosition positionB = new BoardPosition(3, 3);
		testBoard1.setPiece(new King(positionB, false));

		ChessBoard testBoard2 = new ChessBoard();
		positionA = new BoardPosition(2, 2);
		testBoard2.setPiece(new Pawn(positionA, true));
		positionB = new BoardPosition(3, 3);
		testBoard2.setPiece(new King(positionB, false));

		assertTrue(testBoard1.equals(testBoard2));

		testBoard2.setPiece(new Queen(positionA, true));
		
		assertFalse(testBoard1.equals(testBoard2));
	}

	@Test
	public void testParseBoard() {
		ChessBoard testBoard = new ChessBoard();
		/*
		 String[] parseString = {
				"        ",
				"     X  ",
				"  [[[[[[[]      ",
				"  [[[[K     ",
				"  q     ",
				"  Q     ",
				" N      ",
				"b       "}; 
		 */
		String[] parseString = {
				"        ",
				"     X  ",
				"        ",
				"  K     ",
				"  q     ",
				"  Q     ",
				" N      ",
				"b       "};
		testBoard.parseBoard(parseString);
		
		ChessBoard controlBoard = new ChessBoard();
		BoardPosition currentPosition;
		
		currentPosition = new BoardPosition(0, 0);
		controlBoard.setPiece(new Bishop(currentPosition, false));

		currentPosition = new BoardPosition(1,1);
		controlBoard.setPiece(new Knight(currentPosition, true));
		
		currentPosition = new BoardPosition(2,2);
		controlBoard.setPiece(new Queen(currentPosition, true));
		
		currentPosition = new BoardPosition(2,3);
		controlBoard.setPiece(new Queen(currentPosition, false));
		
		currentPosition = new BoardPosition(2,4);
		controlBoard.setPiece(new King(currentPosition, true));
		
		assertTrue(controlBoard.equals(testBoard));
	}

}
