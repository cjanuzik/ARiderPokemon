package model;



import java.util.Observable;
import java.util.Random;

public class Map extends Observable{
	private Tile[][] map; // tiles of the map
	public final static int height = 10; 
	public final static int width = 10;
	
	// the row and column of the current location of the Trainer
	private int c;
	private int r;



	/**
	 * Constructs a new instance of map
	 */
	public Map() {
		this.map = new Tile[width][height];
		makeMap();
		
		// place the hunter randomly
		this.c = new Random().nextInt(10);
		this.r = new Random().nextInt(10);
		
		this.map[r][c].setHasCharacter(true);
	}
	
	/**
	 * instantiates each tile/
	 */
	private void makeMap() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				map[i][j] = new Tile();
			}
		}
	}
	/**
	 * Moves the hunter in the direction specified with wrap around 
	 * @param d The direction of movement
	 */
	public void move(Dir d) {
		switch (d) {
		case DOWN:
			moveDown();
			break;
		case LEFT:
			moveLeft();
			break;
		case RIGHT:
			moveRight();
			break;
		case UP:
			moveUp();
			break;
		default:
			break;

		}
		
		setChanged();
		notifyObservers();
	}
	/**
	 * moves character up
	 */
	private void moveUp() {
		map[r][c].setHasCharacter(false);
		if (c - 1 < 0) {
			c += height;

		}
		this.c = (this.c - 1) % height;
		map[r][c].setHasCharacter(true);
	}
	/**
	 * moves character down
	 */
	private void moveDown() {
		map[r][c].setHasCharacter(false);
		this.c = (this.c + 1) % height;
		map[r][c].setHasCharacter(true);
	}
	/**
	 * moves character right
	 */
	private void moveRight() {
		map[r][c].setHasCharacter(false);
		this.r = (this.r + 1) % width;
		map[r][c].setHasCharacter(true);
	}
	/**
	 * moves character left
	 */
	private void moveLeft() {
		map[r][c].setHasCharacter(false);
		if (r - 1 < 0) {
			r += width;
		}
		this.r = (this.r - 1) % width;
		map[r][c].setHasCharacter(true);
	}

	/**
	 * returns the tile at the coordinates passed
	 * @param x
	 * @param y
	 * @return Tile
	 */
	public Tile tileAt(int x, int y) {
		return map[Math.abs(x) % width][Math.abs(y) % height];

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
