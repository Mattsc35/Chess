package concepts;

import util.Logger;

public class BoardPosition {
	private int x;
	private int y;

	public BoardPosition(int x, int y) {
		if (x < 0 || x >= 8 || y < 0 || y >= 8) {
			Logger.error("Board Position", "One or more parameters out of range.");
		}

		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String toString() {
		String returnString = "(" + Integer.toString(x) + "," + Integer.toString(y) + ")";
		return returnString;
	}

	public boolean equals(Object o) {
		if ((o instanceof BoardPosition) && 
				(((BoardPosition) o).getX() == this.x)&& 
				(((BoardPosition) o).getY() == this.y)) {
			return true;
		}
		else {
			return false;
		}
	}
}
