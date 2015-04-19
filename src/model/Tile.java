package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Tile {
	private boolean passable;
	private boolean encounterTrigger;
    private boolean hasCharacter = false;
    private BufferedImage ground;
    
    public Tile(String tileName, boolean triggerEncounter, boolean canPass){
    	encounterTrigger = triggerEncounter;
    	passable = canPass;
    	loadGround(tileName);
    }
    
	public boolean hasCharacter()
	{
		return hasCharacter;
	}
	
	public void setHasCharacter(boolean hasCharacter)
	{
		this.hasCharacter = hasCharacter;
	}
	
	private void loadGround(String tileName){
		try {
			
			ground = ImageIO.read(new File("Images/Tiles/"+ tileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
