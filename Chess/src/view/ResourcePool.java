package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class ResourcePool {
	HashMap<String, BufferedImage> resourceMap;

	public ResourcePool() {
		resourceMap = new HashMap<String, BufferedImage>();
		initializeResources();
	}

	public void initializeResources() {

		addResource("res/chessboard.png");

		addResource("res/pawnWhite.png");
		addResource("res/pawnBlack.png");
		
		addResource("res/rookWhite.png");
		addResource("res/rookBlack.png");
		
		addResource("res/knightWhite.png");
		addResource("res/knightBlack.png");
		
		addResource("res/bishopWhite.png");
		addResource("res/bishopBlack.png");

		addResource("res/queenWhite.png");
		addResource("res/queenBlack.png");
		
		addResource("res/kingWhite.png");
		addResource("res/kingBlack.png");
		
		addResource("res/yellowSquare.png");
		addResource("res/blueSquare.png");
	}

	public static BufferedImage loadImage(String path, Object host) throws IOException {
		return ImageIO.read(new File(path));
	}

	private void addResource(String imagePath) {
		BufferedImage newResource = null;
		try {
			newResource = loadImage(imagePath, null);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		resourceMap.put(imagePath, newResource);
	}

	public BufferedImage getImage(String imageName) {
		return resourceMap.get(imageName);
	}
}