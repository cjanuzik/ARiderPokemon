package model;

import java.util.Observable;

import model.Tiles.Sand;
import view.GraphicPanel;
import controller.ARiderPokemonController;
import exceptions.OutOfStepsException;

/**
 * this is the main map class for the program which extends observable. This class controls the movement of the character and designing the view for the game. The functions like moveUp and moveDown decides the direction of movement of the player when the buttons are pressed in the controller
 *
 */
public class Map extends Observable{
	/**
	 * tiles of the current viewing map
	 */
	private Tile[][] map; // tiles of the current viewing map
	/**
	 * height of viewing map
	 */
	public final static int height = 12;  // height of viewing map
	/**
	 * width of viewing map
	 */
	public final static int width = 12; // width of viewing map
	private World world; // tiles of the entire map
	
	// the row and column of the current location of the Trainer
	private int c;
	private int r;
	
	//Keeps track of if the trainer has moved/ran into a solid
	//and which direction they are facing
	private boolean hasMoved;
	private char direction;
	
	/**
	 * Initializes a new world.getWorld() and sets viewing area
	 */
	//Initializes a new world.getWorld() and sets viewing area
	public Map() {
		world = new World();
		//Places the trainer at the top of the left map
		this.c = 15;
		this.r = 0;
		world.getWorld()[r][c].setHasCharacter(true);
		map = new Tile[12][12];
		makeMap();
	}
	/**
	 * Draws an 11x11 grid of tiles around the trainer
	 */
	//Draws an 11x11 grid of tiles around the trainer
	private void makeMap() {
		
		int iStart = r - 5;
		int jStart = c - 5;
		
		if(iStart < 0)
			iStart = 0;
	    if(iStart > 20)
	    	iStart = 20;
	    if(jStart < 0)
			jStart = 0;
	    if(jStart > 52)
	    	jStart = 52;
		
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 12; j++){
				map[i][j] = world.getWorld()[i + iStart][j + jStart];
			}
		}
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Moves the trainer and changes direction if needed
	 * Also acts as trainer move limitation
	 * @param d
	 * @param g
	 * @throws OutofStepsException
	 */
	//Moves the trainer and changes direction if needed
	//Also acts as trainer move limitation
	public void move(Dir d, GraphicPanel g) throws OutOfStepsException{
		hasMoved = false;
		switch (d) {
		case DOWN:
			g.loadImages(d, "Down");
			direction = 'd';
			if(r < 30 && !g.getMoving())
			    moveDown();
			if(r < 30 && g.getMoving())
				stepDown();
			break;
		case LEFT:
			g.loadImages(d, "Left");
			direction = 'l';
			if(c > 0 && !g.getMoving())
			    moveLeft();
			if(c > 0 && g.getMoving())
				stepLeft();
			break;
		case RIGHT:
			g.loadImages(d, "Right");
			direction = 'r';
			if(c < 62 && !g.getMoving())
			    moveRight();
			if(c < 62 && g.getMoving())
				stepRight();
			break;
		case UP:
			g.loadImages(d, "Up");
			direction = 'u';
			if(r > 0 && !g.getMoving())
			    moveUp();
			if(r > 0 && g.getMoving())
				stepUp();
			break;
		default:
			break;

		}
		
		//Redraws the map
		makeMap();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Deducts a step from the trainer's step count
		if(hasMoved){
			try{
		        Inventory.takeAStep();
			} catch(OutOfStepsException oose){
				ARiderPokemonController.addSummaryPanel();
			}
		}
		
		//Checks if a wild Pokemon was encountered, if so swap panels
		Tile nextTile = tileAtMeadow(r,c);
		boolean canEncounter = nextTile.getCanEncounter();
		
		if(canEncounter == true && hasMoved){
		    int encountered = (int) (Math.random() * 20);
		
		    if(encountered == 1){
			    ARiderPokemonController.addBattlePanel();
		    }
		}
		
	}
	
	//Interact with rocks and items on map
	/**
	 * Interact with rocks and other items on the map
	 */
	public void interact(){
		Tile tileFacing = new Sand();
		//Check which tile trainer
		switch(direction) {
		    case 'd':
		    	//Gets tile below character
		    	tileFacing = tileAtMeadow(r + 1, c);
		        break;
		
	        case 'u':
	        	//Gets tile above character
		        tileFacing = tileAtMeadow(r - 1, c);
	            break;
	            
	        case 'l':
	        	//Gets tile to left of character
		        tileFacing = tileAtMeadow(r, c - 1);
	            break;
	            
	        case 'r':
	        	//Gets tile to right of character
		        tileFacing = tileAtMeadow(r, c + 1);
	            break;
	            
	        default:
	        	break;
	    }
		//Checks if tile trainer is facing has HM Rock Smash
        if(tileFacing.getHasRockSmash()){
    	    Inventory.setRockSmashUnlocked(true);
    	    tileFacing.setHasRockSmash(false);
        }
        
        //Checks if tile below contains HM Surf
        if(tileFacing.getHasSurf()){
    	    Inventory.setSurfUnlocked(true);
    	    tileFacing.setHasSurf(false);
    	    world.addWaterPassable();
        }
        
        //Checks if tile below contains a rock and if trainer has rock smash
        if(Inventory.getRockSmashUnlocked() && tileFacing.getHasRock()){
        	Inventory.updateBallCount(1);
        	tileFacing.setHasRock(false);
        }
        
        //Notify observers so item disappears
		setChanged();
		notifyObservers();	
	}
	
	//Moves character up if tile above is not solid
	private void moveUp() {
	    world.clearWorld();
		world.getWorld()[r][c].setHasCharacter(true);
		hasMoved = true;
	}
	
	//Makes he character step up
	public void stepUp(){
		if(!tileAtMeadow(r - 1,c).getSolid()){
			world.clearWorld();
			world.getWorld()[r][c].setHasCharacter(true);
			r--;
			world.getWorld()[r][c].setHasCharacter(true);
		}
	}
	
	//Moves character down if tile below is not solid
	public void moveDown() {
	    world.clearWorld();
		world.getWorld()[r][c].setHasCharacter(true);
		hasMoved = true;
	}
	
	//Makes the character step down
	public void stepDown(){
		if(!tileAtMeadow(r + 1, c).getSolid()){
			world.clearWorld();
			world.getWorld()[r][c].setHasCharacter(true);
			r++;
			world.getWorld()[r][c].setHasCharacter(true);
		}
	}
	//Moves character right if tile to the right is not solid
	private void moveRight() {
		world.clearWorld();
		world.getWorld()[r][c].setHasCharacter(true);
		hasMoved = true;
	}
	
	//Makes the character step right
	private void stepRight(){
		world.clearWorld();
		if(!tileAtMeadow(r, c + 1).getSolid()){
			world.getWorld()[r][c].setHasCharacter(true);
			c++;
			world.getWorld()[r][c].setHasCharacter(true);
			hasMoved = true;
		}
	}
	
	//Moves character left if tile to the left is not solid
	private void moveLeft() {

		world.clearWorld();
		world.getWorld()[r][c].setHasCharacter(true);
		hasMoved = true;
	}
    
	private void stepLeft(){
		if(!tileAtMeadow(r,c - 1).getSolid()){
			world.clearWorld();
			world.getWorld()[r][c].setHasCharacter(true);
			c--;
			world.getWorld()[r][c].setHasCharacter(true);
			hasMoved = true;
		}
	}
	//Returns the tile at viewing area (x,y)
	/**
	 * Returns the tile at viewing area (x,y)
	 * @param x
	 * @param y
	 * @return map[x][y]
	 */
	public Tile tileAt(int x, int y) {
		return map[x][y];

	}
	
	//Returns the tile on the world.getWorld() at (x,y)
	/**
	 * Returns the tile on the world.getWorld() at (x,y)
	 * @param x
	 * @param y
	 * @return world.getWorld()[x][y]
	 */
	public Tile tileAtMeadow(int x, int y){
		return world.getWorld()[x][y];
	}
	
	//Returns column the trainer is on in the world.getWorld()
	/**
	 * Returns column the trainer is on in the world.getWorld()
	 * @return c
	 */
	public int getC(){
		return c;
	}
	
	//Returns row the trainer is on in the world.getWorld()
	/**
	 * Returns row the trainer is on in the world.getWorld()
	 * @return r
	 */
	public int getR(){
		return r;
	}
	
	//Returns a string version of the world.getWorld()
	/**
	 * Returns a string version of the world.getWorld()
	 */
	public String toString() {
		return "The Width of the map is :"+width +"\nThe height of the map is: "+height +"\nThe hunter is at:\n" + "Row: " + r + "\nCol: " + c + "\n";
	}
    
	//Returns map viewing area height
	/**
	 * Returns map viewing area height
	 * @return height
	 */
	public int getHeight() {
		return height;
	}
	
	//Returns map viewing area width
	/**
	 * Returns map viewing area width
	 * @return width
	 */
	public int getWidth() {
		return width;
	}
}
