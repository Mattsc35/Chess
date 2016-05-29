package misc;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

import concepts.BoardPosition;

public class Utilities {

	public static final long NANOS_PER_SECOND = 1000000000;
	private static final Random rand = new Random();

	public static double xToPercentage(int x) {
		return (((double) x) / Preferences.getWindowWidth()) * 100.0;
	}

	public static double yToPercentage(int y) {
		return (((double) y) / Preferences.getWindowHeight()) * 100.0;
	}

	public static double getRandInRange(double min, double max) {
		return min + (rand.nextDouble() * (max - min));
	}

	public static BoardPosition clickToPosition(MouseEvent e) {
		double x = xToPercentage(e.getX());
		double y = yToPercentage(e.getY());
		return new BoardPosition((int) (x / 12.5), 7 - ((int) (y / 12.5)));
	}

}
