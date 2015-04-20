package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Map;
import model.Tile;

public class GraphicPanel extends JPanel {

	private static final long serialVersionUID = 321562980917862556L;
	private Map map;
	
	//images of the character and the ground
	private BufferedImage character, ground;

	public GraphicPanel(Map map) {
		this.map = map;
		this.setPreferredSize(new Dimension(1024, 992));
		loadImages("Down");
	}
	
	/**
	 * This method loads the images for later use.
	 */
	public void loadImages(String dir) {
		try {
			String direction = dir;
			character = ImageIO.read(new File("Images/Trainer/Trainer" + direction + ".png"));
			ground = ImageIO.read(new File("Images/Tiles/TallGrass.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * paints the map
	 */
	public void paintComponent(Graphics g) {
		drawMap(g, map);
	}
	
	/**
	 * Draws entire map onto the graphics passed
	 * @param g Graphics to draw on
	 * @param map Map being drawn
	 * 
	 * @see Tile#drawTile(Graphics, BufferedImage, int, int)
	 * @see java.awt.Graphics#drawImage(java.awt.Image, int, int, java.awt.image.ImageObserver)
	 */
	public void drawMap(Graphics g, Map map) {
		for (int i = 0; i < map.getHeight(); i++) {
			for (int j = 0; j < map.getWidth(); j++) {
				drawTile(g, map.tileAt(i, j), j * 32, i * 32);
			}
		}

	}
	
	/**
	 * This method draws the tile on the Graphics passed.
	 * 
	 * @param g The graphics to be painted on
	 * @param tile The tile object to paint
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * 
	 * @see java.awt.Graphics#drawImage(Image, int, int, Observer)
	 */
	public void drawTile(Graphics g, Tile tile, int x, int y) {
		try {
		    ground = ImageIO.read(new File("Images/Tiles/" + tile.getTileName() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		g.drawImage(ground, x, y, null);
		if(tile.hasCharacter())
			g.drawImage(character, x, y, null);

	}

}
