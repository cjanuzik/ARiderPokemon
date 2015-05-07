package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Timer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.ARiderPokemonController;
import model.Dir;
import model.Map;
import model.Tile;

/**
 * Creates the graph Panel for the controller which has the map and the gameplay
 *
 */
public class GraphicPanel extends JPanel implements Observer, KeyListener{

	private static final long serialVersionUID = 321562980917862556L;
	/**
	 * instance of the map created. This is then displayed in the panel
	 */
	private Map map;
	private Dir direction;
	private boolean takingStep;
	private boolean loadedFirst;
	private boolean moving;
	private int count;
	
	//images of the character, ground, items and rocks
	private BufferedImage ground, character, hm, rock, moveOne, moveTwo;
	
	/**
	 * sets the GraphicPanel. calls the function to buid the panel and initializes the required variables
	 * @param map
	 */

	public GraphicPanel(Map map) {
		this.map = map;
		count = 0;
		moving = false;
		this.setPreferredSize(new Dimension(352, 352));
		loadImages(Dir.DOWN, "Down");
		registerListeners();
		map.addObserver(this);
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	/**
	 * This method loads the images for later use.
	 */
	public void loadImages(Dir d, String dir) {
		try {
		    direction = d;
			moveOne = ImageIO.read(new File("Images/Trainer/" + dir + "One.png"));
			moveTwo = ImageIO.read(new File("Images/Trainer/" + dir + "Two.png"));
			character = ImageIO.read(new File("Images/Trainer/Trainer" + dir + ".png"));
			ground = ImageIO.read(new File("Images/Tiles/TallGrass.png"));
			hm = ImageIO.read(new File("Images/Tiles/HMTile.png"));
			rock = ImageIO.read(new File("Images/Tiles/Rock.png"));
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
		count = 0;
		for (int i = 0; i < map.getHeight(); i++) {
			for (int j = 0; j < map.getWidth(); j++) {
				drawTile(g, map.tileAt(i, j), j * 32, i * 32);
			}
		}

	}
	
	public boolean getMoving(){
		return moving;
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
		
		if(tile.hasCharacter()){
			if(moving){
			    if(count == 1){
				    g.drawImage(moveTwo, x, y, null);
			    }
			
			    if(count == 0){
			    	g.drawImage(moveOne, x, y, null);
				    count++;
				    takingStep = false;
			    }
			}
			if(!moving){
				
				g.drawImage(character, x, y, null);
				takingStep = true;
			}
	    }
		if(tile.getHasRockSmash() || tile.getHasSurf() && !tile.getHasRock())
			g.drawImage(hm, x, y, null);
		if(tile.getHasRock())
			g.drawImage(rock, x, y, null);

	}
	
	/**
	 * returns the map
	 * @return map
	 */
	public Map getMap(){
		return map;
	}
	
	/**
	 * adds KeyListener
	 */
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
		moving = !moving;
		    if(e.getKeyCode() == KeyEvent.VK_UP)
			    map.move(Dir.UP,  this);
		    if(e.getKeyCode() == KeyEvent.VK_LEFT)
			    map.move(Dir.LEFT,  this);
		    if(e.getKeyCode() == KeyEvent.VK_DOWN)
		        map.move(Dir.DOWN, this);
		    if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			    map.move(Dir.RIGHT,  this);
		    if(e.getKeyCode() == KeyEvent.VK_ENTER){
		    	map.interact();
		    }
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
