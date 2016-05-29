package view;

import java.util.LinkedList;
import java.util.prefs.PreferenceChangeEvent;

import board.ChessBoard;
import chessPieces.ChessPiece;
import chessPieces.PieceType;
import concepts.BoardPosition;
import concepts.ChessMove;
import misc.Preferences;
import util.Logger;

public class RenderInstructionsMaker {

	static String tag = "RenderInstructionsMaker";
	
	private static double getDrawX(int row){
		return (row * Preferences.getChessPieceRenderDimension());
	}
	
	private static double getDrawY(int col){
		System.out.println((7-col) * Preferences.getChessPieceRenderDimension());
		return ((7-col) * Preferences.getChessPieceRenderDimension());
	}
	
	public RenderInstructionsMaker() {
	}
	
	public static LinkedList<RenderInstructions> renderPossibleMoves(LinkedList<ChessMove> possibleMoves){
		LinkedList<RenderInstructions> renderBatch = new LinkedList<RenderInstructions>();
		if(possibleMoves.isEmpty()){
			return renderBatch;
		}

		int currentRow;
		int currentCol;
		String path;
		double renderDimensions  = Preferences.getChessPieceRenderDimension();
		
		currentRow = possibleMoves.get(0).getInitialPosition().getX();
		currentCol = possibleMoves.get(0).getInitialPosition().getY();
		path = "res/blueSquare.png";
		RenderInstructions origin = new RenderInstructions(getDrawX(currentRow), getDrawY(currentCol), path, renderDimensions, renderDimensions);
		renderBatch.add(origin);		

		
		path = "res/yellowSquare.png";
		for (ChessMove currentMove : possibleMoves) {
			currentRow = currentMove.getFinalPosition().getX();
			currentCol = currentMove.getInitialPosition().getY();
			RenderInstructions currentInst = new RenderInstructions(getDrawX(currentRow), getDrawY(currentCol), path, renderDimensions, renderDimensions);
			renderBatch.add(currentInst);
		}
		return renderBatch;
	}
	
	
	public static LinkedList<RenderInstructions> renderPieces(ChessBoard board){
		LinkedList<RenderInstructions> renderBatch = new LinkedList<RenderInstructions>();
		double renderDimensions  = Preferences.getChessPieceRenderDimension();
		
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				ChessPiece currentPiece = board.getPiece(new BoardPosition(row, col));
				String path = "";
				if (currentPiece.isEmpty()) {
					continue;
				}

				if (currentPiece.getType() == PieceType.PAWN) {
					path = "res/pawn";
				}
				else if (currentPiece.getType() == PieceType.ROOK) {
					path = "res/rook";
				}
				else if (currentPiece.getType() == PieceType.KNIGHT) {
					path = "res/knight";
				}
				else if (currentPiece.getType() == PieceType.BISHOP) {
					path = "res/bishop";
				}
				else if (currentPiece.getType() == PieceType.QUEEN) {
					path = "res/queen";
				}
				else if (currentPiece.getType() == PieceType.KING) {
					path = "res/king";
				}
				else {
					Logger.error(tag, "RenderPieces. Invalid Piece");
				}
				
				if (currentPiece.isWhite()) {
					path += "White.png";
				}
				else {
					path += "Black.png";
				}

				
				double drawX = getDrawX(row);
				double drawY = getDrawY(col);

				RenderInstructions currentRenderInst = new RenderInstructions(drawX, drawY, path,
						renderDimensions, renderDimensions);
				renderBatch.add(currentRenderInst);
			}
		}
		return renderBatch;
	}

}
