
import java.awt.Dimension;
import javax.swing.JFrame;

import controller.Controller;
import controller.GetPotentialMovesController;
import misc.Preferences;
import misc.Utilities;
import view.ChessView;

public class MainController {

	ChessView view;
	JFrame frame;
	Controller currentScreen;
	MainController game;
	private long lastTime, now;
	private final double ticksPerSecond = 60.0;
	private double nanosPerTick = Utilities.NANOS_PER_SECOND / ticksPerSecond;
	private long deltaNs = 0;
	public boolean running;

	public MainController() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Chess!");
		view = new ChessView();
		switchStates(new GetPotentialMovesController());

		initializePreferences();

		view.setPreferredSize(new Dimension(Preferences.getWindowWidth(), Preferences.getWindowHeight()));
		frame.getContentPane().add(view);
		setFrameProperties();

		running = false;
	}

	private void initializePreferences() {
		Preferences.initalize();
		Preferences.setFullscreen(false);
	}

	public void drawScreen() {
		view.render(currentScreen);
	}

	private void setFrameProperties() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(Preferences.isFullscreen());
		frame.setUndecorated(Preferences.isFullscreen());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void switchStates(Controller newScreen) {
		if (view.getMouseListeners().length > 0) {
			view.removeMouseListener(currentScreen);
		}
		if (view.getMouseMotionListeners().length > 0) {
			view.removeMouseMotionListener(currentScreen);
		}

		currentScreen = newScreen;

		view.addMouseListener(currentScreen);
		view.addMouseMotionListener(currentScreen);
	}

	public void start() {
		running = true;
		run();
	}

	public void run() {
		view.requestFocus();
		lastTime = System.nanoTime();
		while (running) {
			now = System.nanoTime();
			deltaNs += Math.abs(now - lastTime);
			lastTime = now;
			if (deltaNs >= nanosPerTick) {
				onTick(deltaNs);
				deltaNs = 0;
				drawScreen();
			}
		}
	}

	public void onTick(long deltaNs) {

	}

	/*
	 * public void switchStates(GameState newState) { if
	 * (view.getMouseListeners().length > 0) {
	 * view.removeMouseListener(currentScreen); } if
	 * (view.getMouseMotionListeners().length > 0) {
	 * view.removeMouseMotionListener(currentScreen); }
	 * 
	 * view.addMouseListener(currentScreen);
	 * view.addMouseMotionListener(currentScreen); }
	 */
}