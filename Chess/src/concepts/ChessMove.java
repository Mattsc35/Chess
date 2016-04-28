package concepts;

public class ChessMove {
	private BoardPosition initialPosition;
	private BoardPosition finalPosition;
	
	public ChessMove(BoardPosition initialPosition, BoardPosition finalPosition) {
		this.initialPosition = initialPosition;
		this.finalPosition = finalPosition;
	}

	public BoardPosition getInitialPosition() {
		return initialPosition;
	}

	public BoardPosition getFinalPosition() {
		return finalPosition;
	}
	
	public String toString(){
		String returnString = initialPosition.toString() + " to " + finalPosition.toString();
		return returnString;
	}
}
