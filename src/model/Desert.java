package model;

/**
 * This class designs the desert map for the game
 */
import java.util.Random;

import model.Tiles.DesertGrass;
import model.Tiles.HillBot;
import model.Tiles.HillBotLeft;
import model.Tiles.HillBotRight;
import model.Tiles.HillCenter;
import model.Tiles.HillLeft;
import model.Tiles.HillRight;
import model.Tiles.HillTop;
import model.Tiles.HillTopLeft;
import model.Tiles.HillTopRight;
import model.Tiles.Sand;

public class Desert {
	private Tile[][] desert;
	
	/**
	 * calls the required functions (makeDesert(), addHasSurf() and addRocks();)
	 */
	public Desert(){
		makeDesert();
		addHasSurf();
		addRocks();
	}
	/**
	 * designs the desert map using a 2-D array
	 */
	public void makeDesert(){
		desert = new Tile[][] {
				{new HillTopLeft(), 	new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTopRight(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillTopLeft(), 	new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillRight(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillRight(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBotRight(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillBotLeft(), 	new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},	
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillRight(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillRight(), 	new Sand(), 		new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 			new HillTopLeft(), 	new HillTopRight(), new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillRight(), 	new Sand(), 		new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 			new HillBotLeft(), 	new HillBotRight(), new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillRight(), 	new Sand(), 		new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillTopLeft(), 	new HillTopRight(), new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillRight(), 	new Sand(), 		new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new HillTopLeft(), 	new HillTopRight(), new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillBotLeft(), 	new HillBotRight(), new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillRight(), 	new Sand(), 		new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new HillBotLeft(), 	new HillBotRight(), new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillTopLeft(), 	new HillTopRight(), new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillRight(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new HillTopLeft(), 	new HillTop(), 		new HillTopRight(), new Sand(), 		new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new HillBotLeft(), 	new HillBotRight(), new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillBotLeft(), 	new HillBot(), 		new HillBot(), 		new HillBotRight(), new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new HillLeft(), 	new HillCenter(), 	new HillRight(), 	new Sand(), 		new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillBotLeft(), 	new HillBot(), 		new HillBot(), 		new HillBotRight()},
				{new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillTopLeft(), 	new HillTop(), 		new HillTopRight(), new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 		new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 	new HillBotLeft(), 	new HillBot(), 		new HillBotRight(), new Sand(), 		new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand()},
				{new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillRight(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 		new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand()},
				{new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillBotLeft(), 	new HillBot(), 		new HillBotRight(), new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 		new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand()},
				{new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new DesertGrass(), 		new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillTopLeft(), 	new HillTop(), 		new HillTopRight(), new HillTopLeft(), 	new HillTopRight(), new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand()},
				{new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new DesertGrass(), 		new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 	new Sand(), 		new HillTopLeft(), 	new HillTopRight(), new Sand(), 		new Sand(), 		new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillRight(), 	new HillBotLeft(), 	new HillBotRight(), new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand()},
				{new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new DesertGrass(), 		new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 	new Sand(), 		new HillBotLeft(), 	new HillBotRight(), new Sand(), 		new Sand(), 		new Sand(), 		new HillBotLeft(), 	new HillBot(), 		new HillBotRight(), new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand()},
				{new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillTopLeft(), 	new HillTopRight(), new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand()},
				{new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillBotLeft(), 	new HillBotRight(), new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand()},
				{new HillTopLeft(), 	new HillTop(), 		new HillTop(), 		new HillTopRight(), new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 		new Sand(), 			new Sand(), 		new HillTopLeft(), 	new HillTopRight(), new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillTopLeft(), 	new HillTop(), 		new HillTop(), 		new HillTopRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillRight(), 	new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 		new Sand(), 			new Sand(), 		new HillBotLeft(), 	new HillBotRight(), new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillRight(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillTopLeft(), 	new HillTopRight(), new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillRight(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillBotLeft(), 	new HillBotRight(), new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillRight(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillTopLeft(), 	new HillTop(), 		new HillTopRight(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillRight(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillRight(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillRight(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillBotLeft(), 	new HillBot(), 		new HillBotRight(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new DesertGrass(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillRight(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 			new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTopRight(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillTopLeft(), 	new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillTop(), 		new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillRight(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillLeft(), 		new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillRight(), 		new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillLeft(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillCenter(), 	new HillRight()},
				{new HillBotLeft(), 	new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBotRight(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 	new Sand(), 		new Sand(), 		new Sand(), 		new Sand(), 		new HillBotLeft(), 	new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBot(), 		new HillBotRight()},	
		};
	}
	
	/**
	 * returns the desert array of tiles
	 * @return desert
	 */
	public Tile[][] getDesert(){
    	return desert;
    }
	
	/**
	 * sets the surf ability of the character
	 */
	private void addHasSurf(){
    	Random randomGenerator = new Random();
		   
   	    int surfC = randomGenerator.nextInt(4) + 24;
   	    int surfR = randomGenerator.nextInt(10) + 18;
   	    
   	    desert[surfR][surfC].setHasSurf(true);
   	    
    }
	
/**
 * adds rock to the desert Map
 */
	private void addRocks(){
		desert[4][20].setHasRock(true);
		desert[7][17].setHasRock(true);
		desert[15][8].setHasRock(true);
		desert[23][27].setHasRock(true);
	}
}
