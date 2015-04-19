package model;



/**
 * This is the main class for each tile in the map. The map will contain an
 * array of these tiles
 * 
 * @author Hasanain Jamal
 *
 */
public class Tile {

	private boolean hasCharacter = false;
	private boolean canEncounter = true;
	
	public boolean hasCharacter()
	{
		return hasCharacter;
	}
	
	public void setHasCharacter(boolean hasCharacter)
	{
		this.hasCharacter = hasCharacter;
	}
	
	public boolean getCanEncounter(){
		return canEncounter;
	}
}
