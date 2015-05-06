package model;
/**
 * Designs the world of the map. creates a map having meadow on the left and desert on the right. 
 * Basically, this class concatenates the two maps into one
 * @author Chris
 *
 */
public class World {
	
	private Tile[][] world;
	private Tile[][] meadow;
	private Tile[][] desert;
	
    public World(){
    	world = new Tile[32][64];
    	meadow = new Meadow().getMeadow();
    	desert = new Desert().getDesert();
    	
    	for(int i = 0; i < 32; i++){
    		for(int j = 0; j < 32; j++){
    			world[i][j] = meadow[i][j];
    			world[i][j + 32] = desert[i][j];
    		}
    	}
    	
    }
    /**
     * returns the world, i.e. the concatenated version of the map
     * @return Tile[][]
     */
    public Tile[][] getWorld(){
    	return world;
    }
    
    /**
     * Makes water passable, called when surf is unlocked
     */
    public void addWaterPassable(){
    	for(int i = 8; i <= 12; i++){
    		for(int j = 8; j <= 15; j++){
    			world[i][j].setSolid(false);
    		}
    	}
    	
    	for(int i = 4; i <= 5; i++){
    		for(int j = 20; j <= 24; j++){
    			world[i][j].setSolid(false);
    		}
    	}
    	
    	for(int i = 12; i <= 14; i++){
    		for(int j = 20; j <= 25; j++){
    			world[i][j].setSolid(false);
    		}
    	}
    	
    	for(int i = 15; i <= 18; i++){
    		for(int j = 18; j <= 23; j++){
    			world[i][j].setSolid(false);
    		}
    	}
    	
    	for(int i = 18; i <= 19; i++){
    		for(int j = 8; j <= 15; j++){
    			world[i][j].setSolid(false);
    		}
    	}
    }
}
