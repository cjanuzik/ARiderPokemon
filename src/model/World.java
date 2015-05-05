package model;

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
    
    public Tile[][] getWorld(){
    	return world;
    }
}
