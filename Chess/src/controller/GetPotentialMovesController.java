package controller;

import java.awt.event.MouseEvent;
import java.util.LinkedList;

import board.GameBoard;
import chessPieces.ChessPiece;
import chessPieces.PieceType;
import concepts.BoardPosition;
import util.Logger;
import view.RenderInstructions;
import view.RenderInstructionsMaker;

public class GetPotentialMovesController extends Controller {

	private GameBoard theBoard;
	private String tag = "GetPotentialMovesController";

	public GetPotentialMovesController() {
		theBoard = new GameBoard();
	}

	@Override
	public LinkedList<RenderInstructions> getRenderInstructions() {

		LinkedList<RenderInstructions> renderBatch = new LinkedList<RenderInstructions>();

		RenderInstructions background = new RenderInstructions(0, 0, "res/chessboard.png", 100, 100);
		renderBatch.add(background);

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
		// TODO Auto-generated method stub

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
