package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Dir;
import model.Map;
import model.Tile;

public class GraphicPanel extends JPanel implements Observer, KeyListener{

	private static final long serialVersionUID = 321562980917862556L;
	private Map map;
	//images of the character and the ground
	private BufferedImage ground, character, hm;

	public GraphicPanel(Map map) {
		this.map = map;
		this.setPreferredSize(new Dimension(352, 352));
		loadImages("Down");
		registerListeners();
		map.addObserver(this);
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	/**
	 * This method loads the images for later use.
	 */
	public void loadImages(String dir) {
		try {
			String direction = dir;
			character = ImageIO.read(new File("Images/Trainer/Trainer" + direction + ".png"));
			ground = ImageIO.read(new File("Images/Tiles/TallGrass.png"));
			hm = ImageIO.read(new File("Images/Tiles/HMTile.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	public void comeBack(){
		this.setFocusable(true);
		this.requestFocusInWindow();
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
		if(tile.getHasRockSmash())
			g.drawImage(hm, x, y, null);

	}
	
	public Map getMap(){
		return map;
	}
	
    private void registerListeners() {
		
		this.addKeyListener(this);
		
	}
    
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//if(graphic instanceof GraphicPanel){
		    if(e.getKeyCode() == KeyEvent.VK_UP)
			    map.move(Dir.UP,  this);
		    if(e.getKeyCode() == KeyEvent.VK_LEFT)
			    map.move(Dir.LEFT,  this);
		    if(e.getKeyCode() == KeyEvent.VK_DOWN)
		        map.move(Dir.DOWN, this);
		    if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			    map.move(Dir.RIGHT,  this);
		//}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.repaint();
	}

}
