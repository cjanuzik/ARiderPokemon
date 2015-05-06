package model;
/**
 * Designs the world of the map. creates a map having meadow on the left and desert on the right. 
 * Basically, this class concatenates the two maps into one
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
     * @return wold
     */
    public Tile[][] getWorld(){
    	return world;
    }
}
