package model;




import java.util.Observable;

import javax.swing.JPanel;

import controller.GameView;
import model.Tiles.FenceBottom;
import model.Tiles.FenceBottomLeft;
import model.Tiles.FenceBottomRight;
import model.Tiles.FenceLeft;
import model.Tiles.FenceRight;
import model.Tiles.FenceTopLeft;
import model.Tiles.FenceTopRight;
import model.Tiles.MeadowGrass;
import model.Tiles.TallGrass;
import model.Tiles.TreeBottomLeft;
import model.Tiles.TreeBottomRight;
import model.Tiles.TreeLeft;
import model.Tiles.TreeRight;
import model.Tiles.TreeTopLeft;
import model.Tiles.TreeTopRight;
import model.Tiles.Water;
import model.Tiles.WaterBottom;
import model.Tiles.WaterBottomLeft;
import model.Tiles.WaterBottomRight;
import model.Tiles.WaterLeft;
import model.Tiles.WaterRight;
import model.Tiles.WaterTop;
import model.Tiles.WaterTopLeft;
import model.Tiles.WaterTopRight;
import view.GraphicPanel;

public class Map extends Observable{
	private Tile[][] map; // tiles of the map
	public final static int height = 12; 
	public final static int width = 12;
	private Tile[][] meadow = new Meadow().getMeadow();
	// the row and column of the current location of the Trainer
	private int c;
	private int r;
	private boolean hasMoved;
	private char direction = 'd'; //direction facing, u,l,d,r


	/**
	 * Constructs a new instance of map
	 */
	public Map() {
		
		
		// place the hunter randomly
		this.c = 15;
		this.r = 0;
		
		meadow[r][c].setHasCharacter(true);
		
		map = new Tile[12][12];
		makeMap();
	}
	
	/**
	 * instantiates each tile/
	 */
	private void makeMap() {
		
		int iStart = r - 5;
		int jStart = c - 5;
		
		if(iStart < 0)
			iStart = 0;
	    if(iStart > 20)
	    	iStart = 20;
	    if(jStart < 0)
			jStart = 0;
	    if(jStart > 20)
	    	jStart = 20;
		
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 12; j++){
				map[i][j] = meadow[i + iStart][j + jStart];
			}
		}
		setChanged();
		notifyObservers();
		//map = meadow.getMeadow();
		
	}
	/**
	 * Moves the hunter in the direction specified with wrap around 
	 * @param d The direction of movement
	 */
	public void move(Dir d, GraphicPanel g) {
		hasMoved = false;
		switch (d) {
		case DOWN:
			/*if(direction != 'd'){
				direction = 'd';
				g.loadImages("Down");
				break;
			}*/
			if(r < 30)
			    moveDown();
			g.loadImages("Down");
			break;
		case LEFT:
			/*if(direction != 'l'){
				direction = 'l';
				g.loadImages("Left");
				break;
			}*/
			if(c > 0)
			    moveLeft();
			g.loadImages("Left");
			break;
		case RIGHT:
			/*if(direction != 'r'){
				direction = 'r';
				g.loadImages("Right");
				break;
			}*/
			if(c < 30)
			    moveRight();
			g.loadImages("Right");
			break;
		case UP:
			/*if(direction != 'u'){
				direction = 'u';
				g.loadImages("Up");
				break;
			}*/
			if(r > 0)
			    moveUp();
			g.loadImages("Up");
			break;
		default:
			break;

		}
		
		makeMap();
		
		Tile nextTile = tileAtMeadow(r,c);
		boolean canEncounter = nextTile.getCanEncounter();
		
		if(canEncounter == true && hasMoved){
		    int encountered = (int) (Math.random() * 10);
		
		    if(encountered == 1){
			    System.out.println("You have encountered a wild Pokemon!");
		    }
		}
		
	}
	/**
	 * moves character up
	 */
	private void moveUp() {
		if(!tileAtMeadow(r - 1, c).getSolid()){
    		meadow[r][c].setHasCharacter(false);
	    	r--;
		    meadow[r][c].setHasCharacter(true);
		    hasMoved = true;
		}
	}
	/**
	 * moves character down
	 */
	private void moveDown() {
		if(!tileAtMeadow(r + 1, c).getSolid()){
		    meadow[r][c].setHasCharacter(false);
		    r++;
		    meadow[r][c].setHasCharacter(true);
		    hasMoved = true;
		}
	}
	/**
	 * moves character right
	 */
	private void moveRight() {
		if(!tileAtMeadow(r,c + 1).getSolid()){
		    meadow[r][c].setHasCharacter(false);
		    c++;
		    meadow[r][c].setHasCharacter(true);
		    hasMoved = true;
		}
	}
	/**
	 * moves character left
	 */
	private void moveLeft() {
		if(!tileAtMeadow(r,c - 1).getSolid()){
		    meadow[r][c].setHasCharacter(false);
		    c--;
		    meadow[r][c].setHasCharacter(true);
		    hasMoved = true;
		}
	}

	/**
	 * returns the tile at the coordinates passed
	 * @param x
	 * @param y
	 * @return Tile
	 */
	public Tile tileAt(int x, int y) {
		return map[x][y];

	}
	
	public Tile tileAtMeadow(int x, int y){
		return meadow[x][y];
	}
	
	public int getC(){
		return c;
	}
	
	public int getR(){
		return r;
	}
	/**
	 * returns a String representation of the hunter 
	 * 
	 * @see Object#toString()
	 */
	public String toString() {
		return "The Width of the map is :"+width +"\nThe height of the map is: "+height +"\nThe hunter is at:\n" + "Row: " + r + "\nCol: " + c + "\n";
	}

	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
}
