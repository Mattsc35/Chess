package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import controller.Controller;

import java.util.ArrayList;

public class ChessView extends Canvas {
	private static final long serialVersionUID = 825705767070212692L;
	private BufferStrategy bs;
	private ResourcePool resourcePool;
	double windowHeight;
	double windowWidth;

	public ChessView() {
		resourcePool = new ResourcePool();
	}

	public void render(Controller currentScreen) {
		windowHeight = getPreferredSize().getHeight();
		windowWidth = getPreferredSize().getWidth();
		bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			return;
		}
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		////// RENDERING LOOP ///////

		LinkedList<RenderInstructions> renderBatch = currentScreen.getRenderInstructions();

		for (RenderInstructions currentInstruction : renderBatch) {
			// Sets up values for current render
			if (currentInstruction == null) {
				continue;
			}
			int translateX = (int) ((currentInstruction.getX() / 100.0) * windowWidth);
			int translateY = (int) ((currentInstruction.getY() / 100.0) * windowHeight);
			double rotation = currentInstruction.getRotation();
			double scaleX = currentInstruction.getScaleX();
			double scaleY = currentInstruction.getScaleY();
			String imageName = currentInstruction.getImageName();
			BufferedImage sprite = resourcePool.getImage(imageName);
			double heightPercentage = currentInstruction.getHeightPercentage();
			double widthPercentage = currentInstruction.getWidthPercentage();
			boolean rotateFlag = (rotation != 0);
			boolean scaleFlag = ((scaleX != 0) || (scaleY != 0));

			// Translate, rotate, and scale if needed
			g.translate(translateX, translateY);
			if (rotateFlag) {
				g.rotate(rotation);
			}
			if (scaleFlag) {
				g.scale(scaleX, scaleY);
			}

			//Draw image
			g.drawImage(sprite, 0, 0, (int) (windowWidth * (widthPercentage / 100)),
					(int) (windowHeight * (heightPercentage / 100)), null, null);

			// Reverse translate, rotate, and scale if needed
			if (scaleFlag) {
				g.scale(-scaleX, -scaleY);
			}
			if (rotateFlag) {
				g.rotate(-rotation);
			}
			g.translate(-translateX, -translateY);
		}

		g.dispose();// releases resources
		bs.show(); // shows next available buffer
	}
}
