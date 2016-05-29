package controller;

import java.awt.event.MouseEvent;
import java.util.LinkedList;

import board.GameBoard;
import chessPieces.ChessPiece;
import chessPieces.PieceType;
import concepts.BoardPosition;
import concepts.ChessMove;
import misc.Utilities;
import util.Logger;
import util.PotentialMoveFinder;
import view.RenderInstructions;
import view.RenderInstructionsMaker;

public class GetPotentialMovesController extends Controller {

	private GameBoard theBoard;
	private String tag = "GetPotentialMovesController";

	private boolean displaying;
	private BoardPosition originalPosition;
	private BoardPosition finalPosition;

	public GetPotentialMovesController() {
		theBoard = new GameBoard();
		displaying = false;
		originalPosition = null;
		finalPosition = null;
	}

	@Override
	public LinkedList<RenderInstructions> getRenderInstructions() {

		LinkedList<RenderInstructions> renderBatch = new LinkedList<RenderInstructions>();

		RenderInstructions background = new RenderInstructions(0, 0, "res/chessboard.png", 100, 100);
		renderBatch.add(background);

		if(displaying){
			RenderInstructions currentPieceHighlight = RenderInstructionsMaker.renderCurrentPieceHighlight(originalPosition);
			renderBatch.add(currentPieceHighlight);
			LinkedList<ChessMove> potentialMoves = PotentialMoveFinder.getPotentialMoves(theBoard, originalPosition);
			LinkedList<RenderInstructions> potentialMovesRender = RenderInstructionsMaker.renderPotentialPieces(potentialMoves);
			renderBatch.addAll(potentialMovesRender);
		}

		LinkedList<RenderInstructions> pieces = RenderInstructionsMaker.renderPieces(theBoard.getChessBoard());
		renderBatch.addAll(pieces);
		

		return renderBatch;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean shouldSwitchScreen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		BoardPosition positionClicked = Utilities.clickToPosition(e);
		// System.out.println(positionClicked.toString());
		ChessPiece pieceClicked = theBoard.getPiece(positionClicked);
		if (!displaying) {
			System.out.println("a");
			if (pieceClicked.isEmpty()) {
				return;
			}
			else {
				displaying = true;
				originalPosition = positionClicked;
			}
		}
		else {
			System.out.println("b");
			finalPosition = positionClicked;
			theBoard.makeMove(new ChessMove(originalPosition, finalPosition));
			displaying = false;
			originalPosition = null;
			finalPosition = null;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
