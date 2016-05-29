package misc;

import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;

public class Preferences {

	private static int windowHeight;
	private static int windowWidth;
	private static boolean fullscreen;
	private static double chessPieceRenderDimension;
	

	public static void initalize() {
		setWindowHeight(600);
		setWindowWidth(1000);
		setFullscreen(false);
		
		setChessPieceRenderDimension(100/8.0);
	}

	public static int getWindowHeight() {
		return windowHeight;
	}

	public static void setWindowHeight(int windowHeight) {
		Preferences.windowHeight = windowHeight;
	}

	public static int getWindowWidth() {
		return windowWidth;
	}

	public static void setWindowWidth(int windowWidth) {
		Preferences.windowWidth = windowWidth;
	}

	public static boolean isFullscreen() {
		return fullscreen;
	}

	public static void setFullscreen(boolean fullscreen) {
		Preferences.fullscreen = fullscreen;
		if(fullscreen){
			DisplayMode dm = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
			setWindowHeight(dm.getHeight());
			setWindowWidth(dm.getWidth());
		}
	}

	public static double getChessPieceRenderDimension() {
		return chessPieceRenderDimension;
	}

	public static void setChessPieceRenderDimension(double chessPieceRenderDimension) {
		Preferences.chessPieceRenderDimension = chessPieceRenderDimension;
	}
}
